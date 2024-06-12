package com.bibliotecacrud.bibliotecacrud.repository.livro;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliotecacrud.bibliotecacrud.model.Livro;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    @EntityGraph(value = "Livro.emprestimos", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Livro> findByTitulo(String titulo);
    
}
