package com.janelson.biblioteca.controller;

import com.janelson.biblioteca.model.Categoria;
import com.janelson.biblioteca.model.Genero;
import com.janelson.biblioteca.service.CategoriaService;
import com.janelson.biblioteca.service.GeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
@RequiredArgsConstructor
public class GeneroController {

    private final GeneroService service;

    @GetMapping
    public List<Genero> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Genero> salvar(@RequestBody Genero genero) {
        return ResponseEntity.ok(service.salvar(genero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> atualizar(@PathVariable Integer id, @RequestBody Genero genero) {
        return ResponseEntity.ok(service.atualizar(id, genero));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}