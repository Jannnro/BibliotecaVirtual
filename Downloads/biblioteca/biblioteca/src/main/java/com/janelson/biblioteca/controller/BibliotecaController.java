package com.janelson.biblioteca.controller;

import com.janelson.biblioteca.model.Biblioteca;
import com.janelson.biblioteca.service.BibliotecaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/biblioteca")
@RequiredArgsConstructor
public class BibliotecaController {

    private final BibliotecaService service;

    @GetMapping
    public List<Biblioteca> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Biblioteca> listarPorUsuario(@PathVariable String idUsuario) {
        return service.listarPorUsuario(idUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Biblioteca> salvar(@RequestBody Biblioteca biblioteca) {
        return ResponseEntity.ok(service.salvar(biblioteca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Biblioteca> atualizar(@PathVariable Integer id, @RequestBody Biblioteca biblioteca) {
        return ResponseEntity.ok(service.atualizar(id, biblioteca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}