package com.janelson.biblioteca.service;

import com.janelson.biblioteca.model.Obra;
import com.janelson.biblioteca.repository.ObraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObraService {

    private final ObraRepository repository;

    public List<Obra> listarTodos() {
        return repository.findAll();
    }

    public Obra buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Obra não encontrada"));
    }

    public Obra salvar(Obra obra) {
        return repository.save(obra);
    }

    public Obra atualizar(String id, Obra nova) {
        Obra existente = buscarPorId(id);
        existente.setTitulo(nova.getTitulo());
        existente.setCategoria(nova.getCategoria());
        existente.setAnoPublicacao(nova.getAnoPublicacao());
        existente.setSinopse(nova.getSinopse());
        existente.setCapaUrl(nova.getCapaUrl());
        existente.setGeneros(nova.getGeneros());
        existente.setAutores(nova.getAutores());
        return repository.save(existente);
    }

    public void deletar(String id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}