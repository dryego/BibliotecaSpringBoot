package com.bibliotecacrud.bibliotecacrud.controller.emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bibliotecacrud.bibliotecacrud.model.EmprestimoLivro;
import com.bibliotecacrud.bibliotecacrud.service.emprestimo.BuscaEmprestimoService;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/emprestimo/busca")
public class BuscaEmprestimoController {
    @Autowired
    private BuscaEmprestimoService buscaEmprestimoService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> BuscaEmprestimo(@PathVariable Long id) {

        Resposta<EmprestimoLivro> emprestimo = buscaEmprestimoService.buscaEmprestimoLivro(id);

        if(emprestimo.getData() == null){
            return ResponseEntity.status(emprestimo.getStatus()).body(emprestimo.getMensagem());
        }
        return ResponseEntity.status(emprestimo.getStatus()).body(emprestimo.getData());
    }
    
}
