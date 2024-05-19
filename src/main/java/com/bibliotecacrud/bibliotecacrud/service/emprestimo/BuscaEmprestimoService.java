package com.bibliotecacrud.bibliotecacrud.service.emprestimo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecacrud.bibliotecacrud.model.EmprestimoLivro;
import com.bibliotecacrud.bibliotecacrud.repository.emprestimo.EmprestimoRespository;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@Service
public class BuscaEmprestimoService {
    @Autowired
    private EmprestimoRespository emprestimoRespository;

    public Resposta<EmprestimoLivro> buscaEmprestimoLivro(Long id){
        Optional<EmprestimoLivro> emprestimo = emprestimoRespository.findById(id);

        if(emprestimo.isPresent()){
            return new Resposta<>(200, "Emprestimo localizado.", emprestimo.get());
        }else{
            return new Resposta<>(404,"emprestimo não encontrado." , null);
        }
    }
}
