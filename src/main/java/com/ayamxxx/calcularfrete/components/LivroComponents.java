package com.ayamxxx.calcularfrete.components;

import com.ayamxxx.calcularfrete.dto.LivroRequestDTO;
import com.ayamxxx.calcularfrete.model.Livro;
import org.springframework.stereotype.Component;
@Component
public class LivroComponents {
    public Boolean validarTitulo(LivroRequestDTO livro){
        if (livro.titulo() == null || livro.titulo().isBlank()){
            return false;
        }else{
            return true;
        }
    }
    public Boolean validarAutor(LivroRequestDTO livro){
        if (livro.autor() == null || livro.autor().isBlank()){
            return false;
        }else{
            return true;
        }
    }

    public Boolean validarPreco(LivroRequestDTO livro){
        if (livro.preco() == null || livro.preco() <= 0){
            return false;
        }else{
            return true;
        }
    }
}
