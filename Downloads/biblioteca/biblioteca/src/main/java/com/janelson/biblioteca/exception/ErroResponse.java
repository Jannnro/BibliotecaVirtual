package com.janelson.biblioteca.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroResponse {
    private int status;
    private String mensagem;
    private String caminho;
}