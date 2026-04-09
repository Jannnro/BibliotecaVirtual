package com.janelson.biblioteca.service;

import com.janelson.biblioteca.exception.RecursoNaoEncontradoException;
import com.janelson.biblioteca.model.Autor;
import com.janelson.biblioteca.repository.AutorRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> listarTodos() {
        return repository.findAll();
    }

    public Autor buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Autor não encontrado"));
    }

    public Autor salvar(Autor autor) {
        return repository.save(autor);
    }

    public Autor atualizar(Integer id, Autor nova) {
        Autor existente = buscarPorId(id);
        existente.setNome(nova.getNome());
        return repository.save(existente);
    }

    public void deletar(Integer id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}