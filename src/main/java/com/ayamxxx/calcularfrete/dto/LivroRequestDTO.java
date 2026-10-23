package com.ayamxxx.calcularfrete.dto;

public record LivroRequestDTO(
            String titulo,
            String autor,
            Double preco,
            Boolean disponivel) {
    }