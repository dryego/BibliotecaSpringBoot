package com.bibliotecacrud.bibliotecacrud.service.usuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecacrud.bibliotecacrud.model.Usuario;
import com.bibliotecacrud.bibliotecacrud.repository.usuario.BuscaUsuarioRepository;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@Service
public class BuscaUsuarioService {

    @Autowired
    private BuscaUsuarioRepository buscaUsuarioRepository;

    public Resposta<Usuario> buscaUsuario(Long idUsuario){
        Optional<Usuario> usuario = buscaUsuarioRepository.findById(idUsuario);
        if(usuario.isPresent()){
            return new Resposta<>(200,"Usuario localizado",usuario.get());
        }else{
            return new Resposta<>(404,"Usuario não encontrado.", null);
        }

    }

    
}
