package com.janelson.biblioteca.controller;

import com.janelson.biblioteca.model.Obra;
import com.janelson.biblioteca.service.ObraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
@RequiredArgsConstructor
public class ObraController {

    private final ObraService service;

    @GetMapping
    public List<Obra> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Obra> salvar(@RequestBody Obra obra) {
        return ResponseEntity.ok(service.salvar(obra));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Obra> atualizar(@PathVariable String id, @RequestBody Obra obra) {
        return ResponseEntity.ok(service.atualizar(id, obra));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}