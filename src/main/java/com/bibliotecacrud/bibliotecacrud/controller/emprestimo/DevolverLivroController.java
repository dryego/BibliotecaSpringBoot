package com.bibliotecacrud.bibliotecacrud.controller.emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bibliotecacrud.bibliotecacrud.model.EmprestimoLivro;
import com.bibliotecacrud.bibliotecacrud.service.emprestimo.DevolverLivroServico;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/emprestimo")
public class DevolverLivroController {
    @Autowired
    private DevolverLivroServico devolverLivroServico;

    @PutMapping("/devolucao/{id}")
    public ResponseEntity<Object> devoverLivro(@PathVariable Long id) {
        try {
            Resposta<EmprestimoLivro> devolucao = devolverLivroServico.devolverLivro(id);

            if(devolucao.getData() == null){
                return ResponseEntity.status(devolucao.getStatus()).body(devolucao.getMensagem());
            }
            return ResponseEntity.status(devolucao.getStatus()).body(devolucao.getMensagem());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }
}
