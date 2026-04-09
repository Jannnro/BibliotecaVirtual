package com.janelson.biblioteca.repository;

import com.janelson.biblioteca.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer> {
    List<Biblioteca> findByUsuarioIdUsuario(String idUsuario);
}