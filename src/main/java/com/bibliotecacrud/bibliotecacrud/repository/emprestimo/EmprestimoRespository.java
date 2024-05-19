package com.bibliotecacrud.bibliotecacrud.repository.emprestimo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotecacrud.bibliotecacrud.model.EmprestimoLivro;

public interface EmprestimoRespository extends JpaRepository<EmprestimoLivro, Long> {
    Optional<EmprestimoLivro> findById(Long id);
}
