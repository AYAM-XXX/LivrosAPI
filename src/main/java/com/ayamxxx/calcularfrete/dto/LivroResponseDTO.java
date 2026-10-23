package com.ayamxxx.calcularfrete.dto;

import com.ayamxxx.calcularfrete.model.Livro;

public record LivroResponseDTO(
        String idLivro,
        String titulo,
        String autor,
        Double preco,
        Boolean disponivel
) {
    // Construtor utilitário para converter a Entidade diretamente num ResponseDTO
    public LivroResponseDTO(Livro livro) {
        this(
                livro.getId_livro(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getPreco(),
                livro.getDisponivel()
        );
    }
}