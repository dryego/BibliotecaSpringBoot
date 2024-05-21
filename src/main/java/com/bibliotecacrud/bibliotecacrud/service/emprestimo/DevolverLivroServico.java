package com.bibliotecacrud.bibliotecacrud.service.emprestimo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecacrud.bibliotecacrud.model.EmprestimoLivro;
import com.bibliotecacrud.bibliotecacrud.repository.emprestimo.EmprestimoRespository;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@Service
public class DevolverLivroServico {
    @Autowired
    private EmprestimoRespository emprestimoRespository;

    public Resposta<EmprestimoLivro> devolverLivro(Long idEmprestimo){
        Optional<EmprestimoLivro> emprestimoExiste = emprestimoRespository.findById(idEmprestimo);

        if(emprestimoExiste.isPresent()){
            EmprestimoLivro emprestimo = emprestimoExiste.get();
            emprestimo.setEntregaRealizada(true);

            emprestimoRespository.save(emprestimo);
            return new Resposta<>(200, "Livro devolvido com sucesso.", emprestimo);
        }else{
            return new Resposta<>(404, "Emprestimo Não encontrado.", null);
        }
        
    }
}
