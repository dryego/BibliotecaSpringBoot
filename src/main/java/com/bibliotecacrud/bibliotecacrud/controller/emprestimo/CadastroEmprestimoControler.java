package com.bibliotecacrud.bibliotecacrud.controller.emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bibliotecacrud.bibliotecacrud.dto.EmprestimoRequest;
import com.bibliotecacrud.bibliotecacrud.model.EmprestimoLivro;
import com.bibliotecacrud.bibliotecacrud.service.emprestimo.CadastroemprestimoService;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@Controller
@RequestMapping("/emprestimo/cadastro")
public class CadastroEmprestimoControler {
    @Autowired
    private CadastroemprestimoService cadastroemprestimoService;

    @PostMapping
    public ResponseEntity<Object> cadastroEmprestimo(@RequestBody EmprestimoRequest emprestimoRequest) {
        try {
         Resposta<EmprestimoLivro> novoEmprestimo = cadastroemprestimoService.cadastroEmprestimo(
            emprestimoRequest.getIdUsuario(),
             emprestimoRequest.getIdLivro()
            );
         
         if(novoEmprestimo.getData() == null){
            return ResponseEntity.status(novoEmprestimo.getStatus()).body(novoEmprestimo.getMensagem());
         }
         return ResponseEntity.status(novoEmprestimo.getStatus()).body(novoEmprestimo.getData());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }
    
}
