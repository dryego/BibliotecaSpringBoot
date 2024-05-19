package com.bibliotecacrud.bibliotecacrud.repository.usuario;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotecacrud.bibliotecacrud.model.Usuario;

public interface BuscaUsuarioRepository extends JpaRepository<Usuario, Long> {
    
    
}

