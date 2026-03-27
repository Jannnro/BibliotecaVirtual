package com.janelson.biblioteca.service;

import com.janelson.biblioteca.model.Categoria;
import com.janelson.biblioteca.model.Genero;
import com.janelson.biblioteca.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneroService {

    private final GeneroRepository repository;

    public List<Genero> listarTodos() {
        return repository.findAll();
    }

    public Genero buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genero não encontrada"));
    }

    public Genero salvar(Genero genero) {
        return repository.save(genero);
    }

    public Genero atualizar(Integer id, Genero nova) {
        Genero existente = buscarPorId(id);
        existente.setNome(nova.getNome());
        return repository.save(existente);
    }

    public void deletar(Integer id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}