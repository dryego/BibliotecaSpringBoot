package com.bibliotecacrud.bibliotecacrud.service.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecacrud.bibliotecacrud.model.Usuario;
import com.bibliotecacrud.bibliotecacrud.repository.usuario.UsuarioRepository;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Resposta<Usuario> cadastoUsuario(String nome, String cpf) {
        Usuario usuarioExistente = this.buscaUsuarioPorCpf(cpf);

        if (usuarioExistente != null) {
            return new Resposta<>(200, "Usuario já cadastrado.", null);
        } else {
            Usuario novoUsuario = new Usuario(nome, cpf);
            usuarioRepository.save(novoUsuario);

            return new Resposta<>(200, "Usuario cadastrado com sucesso.", novoUsuario);
        }
    }

    private Usuario buscaUsuarioPorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf).orElse(null);
    }

    public Resposta<Usuario> buscaUsuario(Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        return usuario.map(valor -> {
            valor.setEmprestimosLivros(valor.getEmprestimosNaoEntregues());
            return new Resposta<>(200, "Usuario localizado", valor);
        }).orElseGet(() -> new Resposta<>(404, "Usuario não Localizado.", null));
    }

    public Resposta<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (!usuarios.isEmpty()) {
            return new Resposta<>(200, "Usuarios localizados", usuarios.stream().toList());
        } else {
            return new Resposta<>(404, "Usuarios não encontrados.", null);
        }
    }

    
}



