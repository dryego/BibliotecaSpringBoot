package com.bibliotecacrud.bibliotecacrud.repository.emprestimo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliotecacrud.bibliotecacrud.model.EmprestimoLivro;
import com.bibliotecacrud.bibliotecacrud.model.Usuario;



@Repository
public interface EmprestimoRespository extends JpaRepository<EmprestimoLivro, Long> {
    Optional<EmprestimoLivro> findById(Long id);
    Optional<EmprestimoLivro> findByUsuario(Usuario usuario);
}
