package com.bibliotecacrud.bibliotecacrud.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "livro")
@NamedEntityGraph(name = "Livro.emprestimos", attributeNodes = @NamedAttributeNode("emprestimosLivros"))
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String titulo;
    
    @Column(name="ano_publicacao", nullable = false)
    private int anoPublicacao;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<EmprestimoLivro> emprestimosLivros;

    
    public Livro() {
    }

    public Livro(Long id, String titulo, int anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public List<EmprestimoLivro> getEmprestimosLivros() {
        return emprestimosLivros;
    }

    public void setEmprestimosLivros(List<EmprestimoLivro> emprestimosLivros) {
        this.emprestimosLivros = emprestimosLivros;
    }
}

