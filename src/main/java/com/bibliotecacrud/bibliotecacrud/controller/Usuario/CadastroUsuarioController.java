package com.bibliotecacrud.bibliotecacrud.controller.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecacrud.bibliotecacrud.model.Usuario;
import com.bibliotecacrud.bibliotecacrud.service.usuario.CadastroUsuarioService;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/usuario/cadastro")
public class CadastroUsuarioController {
    
    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @PostMapping
    public ResponseEntity<Object> cadastroUsuario(@RequestBody Usuario usuario) {
        try {
            
        Resposta<Usuario> novoUsuario = cadastroUsuarioService.cadastoUsuario(usuario.getNome(), usuario.getCpf());

        if(novoUsuario.getData() == null){
            return ResponseEntity.status(novoUsuario.getStatus()).body(novoUsuario.getMensagem());
        }                
        return ResponseEntity.status(novoUsuario.getStatus()).body(novoUsuario.getMensagem());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno.");
        }
    }
    
}
