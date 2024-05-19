package com.bibliotecacrud.bibliotecacrud.service.livro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecacrud.bibliotecacrud.model.Livro;
import com.bibliotecacrud.bibliotecacrud.repository.livro.LivroRepository;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@Service
public class BuscarLivroService {
    
    @Autowired
    private LivroRepository livroRepository;

    public Resposta<Livro> buscaLivro(Long idLivro){
        Optional<Livro> livro = livroRepository.findById(idLivro);

        if(livro.isPresent()){
            return new Resposta<>(200,"Livro Localizado.",livro.get());
        }else{
            return new Resposta<>(404, "Livro não encontrado.", null);
        }
    }
}
