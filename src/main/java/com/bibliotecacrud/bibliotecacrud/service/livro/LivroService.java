package com.bibliotecacrud.bibliotecacrud.service.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecacrud.bibliotecacrud.model.Livro;
import com.bibliotecacrud.bibliotecacrud.repository.livro.LivroRepository;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

import java.util.Optional;
import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Resposta<Livro> buscaLivroId(Long idLivro){
        Optional<Livro> livro = livroRepository.findById(idLivro);

        if(livro.isPresent()){
            return new Resposta<>(200,"Livro Localizado.",livro.get());
        }else{
            return new Resposta<>(404, "Livro não encontrado.", null);
        }
    }

    public Resposta<List<Livro>> listarLivros(){
        List<Livro> livros = livroRepository.findAll();

        if(!livros.isEmpty()){
            return new Resposta<>(200,"Livros Localizado.",livros.stream().toList());
        }else{
            return new Resposta<>(404, "Livro não encontrado.", null);
        }
    }

    public Resposta<Livro> cadastraLivro(Long id, String titulo, int anoPublicacao){
        Livro livroExistente = livroRepository.findById(id).orElse(null);

        if(livroExistente != null){
            return new Resposta<>(404,"Livro ja cadastrado.", null);
        }
        
        Livro novoLivro = new Livro(id,titulo,anoPublicacao);
        livroRepository.save(novoLivro);

        return new Resposta<>(404,"Livro ja cadastrado.", null);
    }
}
