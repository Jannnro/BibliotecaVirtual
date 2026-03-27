package com.janelson.biblioteca.service;

import com.janelson.biblioteca.model.Autor;
import com.janelson.biblioteca.model.Genero;
import com.janelson.biblioteca.repository.AutorRepository;
import com.janelson.biblioteca.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository repository;

    public List<Autor> listarTodos() {
        return repository.findAll();
    }

    public Autor buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genero não encontrada"));
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