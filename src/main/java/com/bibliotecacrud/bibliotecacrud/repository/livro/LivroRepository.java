package com.bibliotecacrud.bibliotecacrud.repository.livro;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotecacrud.bibliotecacrud.model.Livro;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByTitulo(String titulo);
    
}
