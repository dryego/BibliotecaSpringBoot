package com.bibliotecacrud.bibliotecacrud.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecacrud.bibliotecacrud.model.Usuario;
import com.bibliotecacrud.bibliotecacrud.repository.usuario.CadastroUsuarioRepository;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@Service
public class CadastroUsuarioService {
    
    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;

    public Resposta<Usuario> cadastoUsuario(String nome, String cpf){
        Usuario usuarioExistente = buscaUsuarioPorCpf(cpf);
        
        if(usuarioExistente != null){
            return new Resposta<>(200,"Usuario já cadastrado.",null);
        }else{
            Usuario novoUsuario = new Usuario(nome,cpf);
            cadastroUsuarioRepository.save(novoUsuario);

            return new Resposta<>(200, "Usuario cadastrado com sucesso.",novoUsuario);
        }
    }

     public Usuario buscaUsuarioPorCpf(String cpf) {
        return cadastroUsuarioRepository.findByCpf(cpf).orElse(null);
    }

}
