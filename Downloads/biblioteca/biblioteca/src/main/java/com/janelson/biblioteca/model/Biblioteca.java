package com.janelson.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "biblioteca")
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_biblioteca")
    private Integer idBiblioteca;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @NotNull(message = "Usuário é obrigatório")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_obra")
    @NotNull(message = "Obra é obrigatória")
    private Obra obra;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @NotNull(message = "Status é obrigatório")
    private Status status;

    @Min(value = 1, message = "Nota mínima é 1")
    @Max(value = 10, message = "Nota máxima é 10")
    @Column(name = "nota")
    private Integer nota;

    @Column(name = "progresso")
    private Integer progresso;

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "dt_inicio")
    private LocalDate dtInicio;

    @Column(name = "dt_termino")
    private LocalDate dtTermino;

    @Column(name = "dt_criacao")
    private LocalDateTime dtCriacao;

    @PrePersist
    public void prePersist() {
        this.dtCriacao = LocalDateTime.now();
        if (this.progresso == null) this.progresso = 0;
    }

    public enum Status {
        vou_ler, lendo, lido, abandonei
    }
}