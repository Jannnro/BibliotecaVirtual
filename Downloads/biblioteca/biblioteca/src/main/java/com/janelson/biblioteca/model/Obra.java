package com.janelson.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "obra")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_obra")
    private String idObra;

    @Column(name = "titulo", nullable = false, length = 200)
    @NotBlank(message = "Título é obrigatório")
    @Size(max = 200, message = "Título deve ter no máximo 200 caracteres")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @NotNull(message = "Categoria é obrigatória")
    private Categoria categoria;

    @Column(name = "ano_publicacao")
    private Short anoPublicacao;

    @Column(name = "sinopse", columnDefinition = "TEXT")
    private String sinopse;

    @Column(name = "capa_url", length = 300)
    private String capaUrl;

    @ManyToMany
    @JoinTable(
            name = "obra_genero",
            joinColumns = @JoinColumn(name = "id_obra"),
            inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private List<Genero> generos;

    @ManyToMany
    @JoinTable(
            name = "obra_autor",
            joinColumns = @JoinColumn(name = "id_obra"),
            inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
    private List<Autor> autores;
}