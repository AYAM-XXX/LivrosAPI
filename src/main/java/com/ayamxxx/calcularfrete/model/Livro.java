package com.ayamxxx.calcularfrete.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Livro {
    @Id
    private String id_livro;
    private String titulo;
    private String autor;
    private  Double preco;
    private Boolean disponivel;
    @PrePersist
    public void gerarID(){
        if (id_livro == null || id_livro.isBlank()){
            id_livro= UUID.randomUUID().toString();
        }
    }

}
