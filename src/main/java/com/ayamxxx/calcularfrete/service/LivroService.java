package com.ayamxxx.calcularfrete.service;

import com.ayamxxx.calcularfrete.components.LivroComponents;
import com.ayamxxx.calcularfrete.dto.LivroRequestDTO;
import com.ayamxxx.calcularfrete.dto.LivroResponseDTO;
import com.ayamxxx.calcularfrete.model.Livro;
import com.ayamxxx.calcularfrete.repository.LivroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LivroService {
    private final LivroComponents livroComponents;
    private final LivroRepository livroRepository;

    public LivroService(LivroComponents livroComponents, LivroRepository livroRepository) {
        this.livroComponents = livroComponents;
        this.livroRepository = livroRepository;
    }


    public LivroResponseDTO salvar(LivroRequestDTO dto){
        if (!livroComponents.validarAutor(dto)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Autor incorreto");
        }
        if (!livroComponents.validarTitulo(dto)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Titulo incorreto");
        }
        if (!livroComponents.validarPreco(dto)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor incorreto");
        }
        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setAutor(dto.autor());
        livro.setPreco(dto.preco());
        livro.setDisponivel(dto.disponivel());

        Livro salvo = livroRepository.save(livro);

        return new LivroResponseDTO(
                salvo.getId_livro(),
                salvo.getTitulo(),
                salvo.getAutor(),
                salvo.getPreco(),
                salvo.getDisponivel()

        );


    }

    public Optional<Livro> procurarId(String id){
        return livroRepository.findById(id);
    }
}
