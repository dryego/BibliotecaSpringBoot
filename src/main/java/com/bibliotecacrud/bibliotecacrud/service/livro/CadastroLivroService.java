package com.bibliotecacrud.bibliotecacrud.service.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecacrud.bibliotecacrud.model.Livro;
import com.bibliotecacrud.bibliotecacrud.repository.livro.LivroRepository;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@Service
public class CadastroLivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Resposta<Livro> cadastroLivro(Long id, String titulo, int anoPublicacao){
        Livro livroExistente = livroRepository.findById(id).orElse(null);

        if(livroExistente != null){
            return new Resposta<>(404, "Livro já Cadastrado.", livroExistente);
        }

        Livro novoLivro = new Livro(id, titulo, anoPublicacao);
        livroRepository.save(novoLivro);
        return new Resposta<>(200, "Livro cadastrado com sucesso.", novoLivro);

    }

}

