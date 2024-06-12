package com.bibliotecacrud.bibliotecacrud.service.emprestimo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;
import java.util.Optional;


import com.bibliotecacrud.bibliotecacrud.model.EmprestimoLivro;
import com.bibliotecacrud.bibliotecacrud.model.Livro;
import com.bibliotecacrud.bibliotecacrud.model.Usuario;
import com.bibliotecacrud.bibliotecacrud.repository.emprestimo.EmprestimoRespository;
import com.bibliotecacrud.bibliotecacrud.repository.livro.LivroRepository;
import com.bibliotecacrud.bibliotecacrud.repository.usuario.UsuarioRepository;
import com.bibliotecacrud.bibliotecacrud.util.DataUtil;
import com.bibliotecacrud.bibliotecacrud.util.Resposta;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRespository emprestimoRespository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Resposta<EmprestimoLivro> buscaEmprestimoLivro(Long id){
        Optional<EmprestimoLivro> emprestimo = emprestimoRespository.findById(id);

        if(emprestimo.isPresent()){
            EmprestimoLivro emprestimoLivro = emprestimo.get();

            return new Resposta<>(200, "Emprestimo localizado.", emprestimoLivro);
        }else{
            return new Resposta<>(404,"emprestimo não encontrado." , null);
        }
    }

    public Resposta<List<EmprestimoLivro>> listarEmprestimos(){
        List<EmprestimoLivro> emprestimos = emprestimoRespository.findAll();

        if(!emprestimos.isEmpty()){

            return new Resposta<>(200,"Emprestimos Localizado.",emprestimos.stream().toList());
        }else{
            return new Resposta<>(404, "Emprestimos não encontrado.", null);
        }
    }

    public Resposta<EmprestimoLivro> cadastroEmprestimo(Long idUsuario, Long idLivro){
        Optional<Usuario> usuarioExiste = usuarioRepository.findById(idUsuario);
        
        if(usuarioExiste.isEmpty()){
            return new Resposta<>(404, "Usuario não encontrado.", null);
        }

        Usuario usuario = usuarioExiste.get();
        if(usuario.getEmprestimosLivros().stream().filter(e -> !e.getEntregaRealizada()).count() >= 3){
            return new Resposta<>(404, "O Usuario Nao pode realizar novos emprestimos.", null);
        }

        Optional<Livro> livroExistent = livroRepository.findById(idLivro);
        if(livroExistent.isEmpty()){
            return new Resposta<>(404, "Livro não encontrado.", null);
        }

        Livro livro = livroExistent.get();
        boolean livroDisponivel = livro.getEmprestimosLivros().stream().noneMatch(e -> !e.getEntregaRealizada());
        
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

    public Resposta<EmprestimoLivro> devolverLivro(Long idEmprestimo){
        Optional<EmprestimoLivro> emprestimoExiste = emprestimoRespository.findById(idEmprestimo);

        if(emprestimoExiste.isPresent()){
            EmprestimoLivro emprestimo = emprestimoExiste.get();
            emprestimo.setEntregaRealizada(true);

            emprestimoRespository.save(emprestimo);
            return new Resposta<>(200, "Livro devolvido com sucesso.", emprestimo);
        }else{
            return new Resposta<>(404, "Emprestimo Não encontrado.", null);
        }
        
    }
}
