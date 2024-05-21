package com.bibliotecacrud.bibliotecacrud.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private int anoPublicacao;

    @OneToMany(mappedBy = "livro",cascade = CascadeType.ALL,orphanRemoval = true)
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

