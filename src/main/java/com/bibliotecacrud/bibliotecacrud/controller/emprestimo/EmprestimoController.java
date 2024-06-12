package com.bibliotecacrud.bibliotecacrud.controller.emprestimo;

import com.bibliotecacrud.bibliotecacrud.dto.EmprestimoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecacrud.bibliotecacrud.dto.EmprestimoRequest;
import com.bibliotecacrud.bibliotecacrud.model.EmprestimoLivro;
import com.bibliotecacrud.bibliotecacrud.service.emprestimo.EmprestimoService;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping("/busca/{id}")
    public ResponseEntity<Object> getBuscaEmprestimo(@PathVariable Long id) {
        try {
            
        Resposta<EmprestimoDTO> emprestimo = emprestimoService.buscaEmprestimoLivro(id);

        if(emprestimo.getData() == null){
            return ResponseEntity.status(emprestimo.getStatus()).body(emprestimo.getMensagem());
        }
        return ResponseEntity.status(emprestimo.getStatus()).body(emprestimo.getData());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> getListarEmprestimos() {
        try {   

        Resposta<List<EmprestimoLivro>> emprestimos = emprestimoService.listarEmprestimos();

        if(emprestimos.getData() == null){
            return ResponseEntity.status(emprestimos.getStatus()).body(emprestimos.getMensagem());
        }
        return ResponseEntity.status(emprestimos.getStatus()).body(emprestimos.getData());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Object> cadastroEmprestimo(@RequestBody EmprestimoRequest emprestimoRequest) {
        try {
         Resposta<EmprestimoDTO> novoEmprestimo = emprestimoService.cadastroEmprestimo(emprestimoRequest.getIdUsuario(), emprestimoRequest.getIdLivro());
         
         if(novoEmprestimo.getData() == null){
            return ResponseEntity.status(novoEmprestimo.getStatus()).body(novoEmprestimo.getMensagem());
         }
         return ResponseEntity.status(novoEmprestimo.getStatus()).body(novoEmprestimo.getMensagem());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }
    
    @PutMapping("/devolucao/{id}")
    public ResponseEntity<Object> devoverLivro(@PathVariable Long id) {
        try {
            Resposta<EmprestimoLivro> devolucao = emprestimoService.devolverLivro(id);

            if(devolucao.getData() == null){
                return ResponseEntity.status(devolucao.getStatus()).body(devolucao.getMensagem());
            }
            return ResponseEntity.status(devolucao.getStatus()).body(devolucao.getMensagem());
            
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }
}
