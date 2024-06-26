package com.bibliotecacrud.bibliotecacrud.dto;

public class EmprestimoRequest {
    private Long idUsuario;
    private Long idLivro;
    private String titulo;
    
    public EmprestimoRequest(Long idUsuario, Long idLivro, String titulo) {
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        this.titulo = titulo;
    }
    
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Long getIdLivro() {
        return idLivro;
    }
    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
}
