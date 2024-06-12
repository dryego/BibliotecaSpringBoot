package com.bibliotecacrud.bibliotecacrud.model;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
@NamedEntityGraph(
        name = "Usuario.emprestimos",
        attributeNodes = @NamedAttributeNode("emprestimosLivros")
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String cpf;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<EmprestimoLivro> emprestimosLivros;

    public Usuario(){

    }

    public Usuario( String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
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

    public List<EmprestimoLivro> getEmprestimosLivros() {
        return emprestimosLivros;
    }

    public List<EmprestimoLivro> getEmprestimosNaoEntregues(){
        return emprestimosLivros.stream().filter(emprestimo -> emprestimo.getEntregaRealizada() == false).collect(Collectors.toList());
    }

    public void setEmprestimosLivros(List<EmprestimoLivro> emprestimosNaoEntregues) {
    }
}
