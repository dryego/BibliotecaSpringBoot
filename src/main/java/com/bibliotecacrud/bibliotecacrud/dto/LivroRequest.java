package com.bibliotecacrud.bibliotecacrud.dto;

public class LivroRequest {
    private Long id;
    private String titulo;
    private int anoPublicacao;

    public LivroRequest(Long id, String titulo, int anoPublicacao) {
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
}
