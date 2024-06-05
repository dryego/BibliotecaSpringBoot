package com.bibliotecacrud.bibliotecacrud.controller.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecacrud.bibliotecacrud.model.Livro;
import com.bibliotecacrud.bibliotecacrud.service.livro.LivroService;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
    
    @Autowired
    private LivroService livroService; 

    @GetMapping("/busca/{id}")
    public ResponseEntity<Object> getBuscaLivro(@PathVariable Long id) {
        try {
            
        Resposta<Livro> livro = livroService.buscaLivroId(id);

        if(livro.getData() == null){
           return ResponseEntity.status(livro.getStatus()).body(livro.getMensagem());
        }

        return ResponseEntity.status(livro.getStatus()).body(livro.getData());

        } catch (Exception e) {

            return ResponseEntity.status(500).body("Erro interno.");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> getTodosLivros() {
        try {   

        Resposta<List<Livro>> livros = livroService.listarLivros();

        if(livros.getData() == null){
            return ResponseEntity.status(livros.getStatus()).body(livros.getMensagem());
        }
        return ResponseEntity.status(livros.getStatus()).body(livros.getData());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Object> postCadastroLivro(@RequestBody Livro livro) {
        try {
        Resposta<Livro> novoLivro = livroService.cadastraLivro(livro.getId(), livro.getTitulo(), livro.getAnoPublicacao());

        if (novoLivro.getData() == null) {
            return ResponseEntity.status(novoLivro.getStatus()).body(novoLivro.getMensagem());
        }

        return ResponseEntity.status(novoLivro.getStatus()).body(novoLivro.getMensagem());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
        
    }

}
