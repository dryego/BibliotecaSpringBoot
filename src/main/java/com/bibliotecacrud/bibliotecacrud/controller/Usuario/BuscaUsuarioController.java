package com.bibliotecacrud.bibliotecacrud.controller.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecacrud.bibliotecacrud.model.Usuario;
import com.bibliotecacrud.bibliotecacrud.service.usuario.BuscaUsuarioService;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/usuario/busca")
public class BuscaUsuarioController {
    @Autowired
    private BuscaUsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscaUsuario(@PathVariable Long id){
        Resposta<Usuario> resposta = usuarioService.buscaUsuario(id);

        if(resposta.getData() == null){
            return ResponseEntity.status(resposta.getStatus()).body(resposta.getMensagem());
        }

        return ResponseEntity.status(resposta.getStatus()).body(resposta.getData());
    }
}

