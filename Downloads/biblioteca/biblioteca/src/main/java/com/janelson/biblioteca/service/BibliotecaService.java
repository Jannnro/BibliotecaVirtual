package com.janelson.biblioteca.service;

import com.janelson.biblioteca.exception.RecursoNaoEncontradoException;
import com.janelson.biblioteca.model.Biblioteca;
import com.janelson.biblioteca.repository.BibliotecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository repository;

    public List<Biblioteca> listarTodos() {
        return repository.findAll();
    }

    public List<Biblioteca> listarPorUsuario(String idUsuario) {
        return repository.findByUsuarioIdUsuario(idUsuario);
    }

    public Biblioteca buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Entrada não encontrada na biblioteca"));
    }

    public Biblioteca salvar(Biblioteca biblioteca) {
        return repository.save(biblioteca);
    }

    public Biblioteca atualizar(Integer id, Biblioteca nova) {
        Biblioteca existente = buscarPorId(id);
        existente.setStatus(nova.getStatus());
        existente.setNota(nova.getNota());
        existente.setProgresso(nova.getProgresso());
        existente.setComentario(nova.getComentario());
        existente.setDtInicio(nova.getDtInicio());
        existente.setDtTermino(nova.getDtTermino());
        return repository.save(existente);
    }

    public void deletar(Integer id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}