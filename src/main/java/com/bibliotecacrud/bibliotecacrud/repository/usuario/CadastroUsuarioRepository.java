package com.bibliotecacrud.bibliotecacrud.repository.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bibliotecacrud.bibliotecacrud.model.Usuario;


public interface CadastroUsuarioRepository extends JpaRepository<Usuario, Long> {
    @EntityGraph(attributePaths = {"emprestimosLivros","emprestimosLivors.livro"})
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByCpf(String cpf);
    
}