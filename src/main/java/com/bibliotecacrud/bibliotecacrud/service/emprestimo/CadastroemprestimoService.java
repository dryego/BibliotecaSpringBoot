package com.bibliotecacrud.bibliotecacrud.service.emprestimo;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bibliotecacrud.bibliotecacrud.model.EmprestimoLivro;
import com.bibliotecacrud.bibliotecacrud.model.Livro;
import com.bibliotecacrud.bibliotecacrud.model.Usuario;
import com.bibliotecacrud.bibliotecacrud.repository.emprestimo.EmprestimoRespository;
import com.bibliotecacrud.bibliotecacrud.repository.livro.LivroRepository;
import com.bibliotecacrud.bibliotecacrud.repository.usuario.BuscaUsuarioRepository;
import com.bibliotecacrud.bibliotecacrud.util.DataUtil;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@Service
public class CadastroemprestimoService {
    @Autowired
    private BuscaUsuarioRepository buscaUsuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EmprestimoRespository emprestimoRespository;

    public Resposta<EmprestimoLivro> cadastroEmprestimo(Long idUsuario, Long idLivro){
        Optional<Usuario> usuarioExiste = buscaUsuarioRepository.findById(idUsuario);
        System.out.print(usuarioExiste);
        if(usuarioExiste.isEmpty()){
            return new Resposta<>(404, "Usuario não encontrado.", null);
        }

        Usuario usuario = usuarioExiste.get();
        if(usuario.getEmprestimosLivros().stream().filter(e -> !e.isEntregaRealizada()).count() >= 3){
            return new Resposta<>(404, "O Usuario Nao pode realizar novos emprestimos.", null);
        }
        // if(usuario.getEmprestimosLivros().size() >=3){
        //     return new Resposta<>(404, "O Usuario Nao pode realizar novos emprestimos.", null);
        // }

        Optional<Livro> livroExistent = livroRepository.findById(idLivro);
        if(livroExistent.isEmpty()){
            return new Resposta<>(404, "Livro não encontrado.", null);
        }

        Livro livro = livroExistent.get();
        boolean livroDisponivel = livro.getEmprestimosLivros().stream().noneMatch(e -> e.isEntregaRealizada());
        // if(livro.getEmprestimosLivros().size() >= 1){
        if(!livroDisponivel){
            return new Resposta<>(404, "Livro não disponivel para emprestimo", null);
        }

        Date dataEntrega = DataUtil.dataParaEntrega();
        boolean entrega = false; 

        EmprestimoLivro novoEmprestimo = new EmprestimoLivro();
        novoEmprestimo.setUsuario(usuario);
        novoEmprestimo.setLivro(livro);
        novoEmprestimo.setDataEntrega(dataEntrega);
        novoEmprestimo.setEntregaRealizada(entrega);

        emprestimoRespository.save(novoEmprestimo);
        return new Resposta<>(200, "Emprestimo cadastrado com sucesso.", novoEmprestimo);
    }
}
