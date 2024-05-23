package com.bibliotecacrud.bibliotecacrud.repository.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bibliotecacrud.bibliotecacrud.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByCpf(String cpf);
    
}