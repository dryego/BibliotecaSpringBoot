package com.bibliotecacrud.bibliotecacrud.controller.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bibliotecacrud.bibliotecacrud.model.Usuario;
import com.bibliotecacrud.bibliotecacrud.service.usuario.UsuarioService;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/busca/{id}")
    public ResponseEntity<Object> getBuscaUsuarioId(@PathVariable Long id) {
        try {            
        Resposta<Usuario> usuario = usuarioService.buscaUsuario(id);
        if(usuario.getData() == null){
            return ResponseEntity.status(usuario.getStatus()).body(usuario.getMensagem());
        }
        return ResponseEntity.status(usuario.getStatus()).body(usuario.getData());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> getTodosUsuarios() {
        try {            
        Resposta<List<Usuario>> usuarios = usuarioService.listarUsuarios();
        if(usuarios.getData() == null){
            return ResponseEntity.status(usuarios.getStatus()).body(usuarios.getMensagem());
        }

        return ResponseEntity.status(usuarios.getStatus()).body(usuarios.getData());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Object> postCadastroUsuario(@RequestBody Usuario usuario) {
        try {
            Resposta<Usuario> novoUsuario = usuarioService.cadastoUsuario(usuario.getNome(), usuario.getCpf());

            if(novoUsuario.getData() == null){
                return ResponseEntity.status(novoUsuario.getStatus()).body(novoUsuario.getMensagem());
            }
            return ResponseEntity.status(novoUsuario.getStatus()).body(novoUsuario.getMensagem());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }
    
    
    
}
