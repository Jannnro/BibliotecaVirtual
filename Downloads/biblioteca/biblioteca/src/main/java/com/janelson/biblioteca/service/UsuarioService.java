package com.janelson.biblioteca.service;

import com.janelson.biblioteca.exception.RecursoNaoEncontradoException;
import com.janelson.biblioteca.exception.RegraNegocioException;
import com.janelson.biblioteca.model.Usuario;
import com.janelson.biblioteca.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));
    }

    public Usuario salvar(Usuario usuario) {
        if (repository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RegraNegocioException("Email já cadastrado");
        }
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return repository.save(usuario);
    }


    public Usuario atualizar(String id, Usuario novo) {
        Usuario existente = buscarPorId(id);
        existente.setNome(novo.getNome());
        existente.setEmail(novo.getEmail());
        if (novo.getSenha() != null && !novo.getSenha().isEmpty()) {
            existente.setSenha(passwordEncoder.encode(novo.getSenha()));
        }
        return repository.save(existente);
    }

    public void deletar(String id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}