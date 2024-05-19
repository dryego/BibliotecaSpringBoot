package com.bibliotecacrud.bibliotecacrud.controller.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecacrud.bibliotecacrud.model.Livro;
import com.bibliotecacrud.bibliotecacrud.service.livro.BuscarLivroService;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("livro/busca")
public class BuscaLivroController {
    
    @Autowired
    private BuscarLivroService buscarLivroService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaLivro(@PathVariable Long id) {
        try {
            
        Resposta<Livro> livro = buscarLivroService.buscaLivro(id);

        if(livro.getData() == null){
           return ResponseEntity.status(livro.getStatus()).body(livro.getMensagem());
        }
        return ResponseEntity.status(livro.getStatus()).body(livro.getData());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }
    
}
