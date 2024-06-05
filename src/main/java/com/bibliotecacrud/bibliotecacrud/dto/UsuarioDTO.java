package com.bibliotecacrud.bibliotecacrud.dto;

import java.util.List;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private List<EmprestimoLivroDTO> emprestimosLivros;

    public UsuarioDTO(){}

    public UsuarioDTO(Long id, String nome, String cpf, List<EmprestimoLivroDTO> emprestimosLivros) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.emprestimosLivros = emprestimosLivros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<EmprestimoLivroDTO> getEmprestimosLivros() {
        return emprestimosLivros;
    }

    public void setEmprestimosLivros(List<EmprestimoLivroDTO> emprestimosLivros) {
        this.emprestimosLivros = emprestimosLivros;
    }        
    
}
