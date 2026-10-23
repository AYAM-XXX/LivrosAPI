package com.ayamxxx.calcularfrete.configuration;

import com.ayamxxx.calcularfrete.model.Livro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class LivrosConfiguration {
    @Bean
    public Livro LivroTeste(){
        var livro = new Livro();
        livro.setTitulo("Vidas Secas");
        livro.setAutor("Graciliano Ramos");
        livro.setPreco(15.50);
        livro.setDisponivel(true);
        return livro;
    }
}
