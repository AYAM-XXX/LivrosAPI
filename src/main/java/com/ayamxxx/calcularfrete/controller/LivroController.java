package com.ayamxxx.calcularfrete.controller;
import java.util.List;
import com.ayamxxx.calcularfrete.dto.LivroRequestDTO;
import com.ayamxxx.calcularfrete.dto.LivroResponseDTO;
import com.ayamxxx.calcularfrete.model.Livro;
import com.ayamxxx.calcularfrete.repository.LivroRepository;
import com.ayamxxx.calcularfrete.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController{
    private final LivroService livroService;
    private  final Livro livroTeste;
    private final LivroRepository livroRepository;

    public LivroController(LivroService livroService, Livro livro, Livro livroTeste, LivroRepository livroRepository) {
        this.livroService = livroService;
        this.livroTeste = livroTeste;
        this.livroRepository = livroRepository;
    }
    @PostMapping
    public LivroResponseDTO salvar(@RequestBody LivroRequestDTO dto){
        return  livroService.salvar(dto);

    }

    @GetMapping("/teste")
    public Livro testeLivro(){
        return livroTeste;
    }


    @GetMapping
    public List<Livro> listarTodos(){
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livro procurarPorId(@PathVariable String id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }
    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable String id) {
        livroRepository.deleteById(id);
    }

}


