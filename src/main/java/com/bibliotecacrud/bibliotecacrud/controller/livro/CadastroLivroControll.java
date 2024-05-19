package com.bibliotecacrud.bibliotecacrud.controller.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bibliotecacrud.bibliotecacrud.model.Livro;
import com.bibliotecacrud.bibliotecacrud.service.livro.CadastroLivroService;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("livro/cadastro")
public class CadastroLivroControll {
    
    @Autowired
    private CadastroLivroService cadastroLivroService;

    @PostMapping
    public ResponseEntity<Object> cadastroLivro(@RequestBody Livro livro) {
        try {
        Resposta<Livro> novoLivro = cadastroLivroService.cadastroLivro(livro.getId(), livro.getTitulo(), livro.getAnoPublicacao());

        if (novoLivro.getData() == null) {
            return ResponseEntity.status(novoLivro.getStatus()).body(novoLivro.getMensagem());
        }

        return ResponseEntity.status(novoLivro.getStatus()).body(novoLivro.getMensagem());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
        
    }
    
}
