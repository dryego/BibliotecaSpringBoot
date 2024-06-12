package com.bibliotecacrud.bibliotecacrud.repository.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliotecacrud.bibliotecacrud.model.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByCpf(String cpf);

    @EntityGraph(value = "Usuario.emprestimos", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Usuario> findById(Long id);



}