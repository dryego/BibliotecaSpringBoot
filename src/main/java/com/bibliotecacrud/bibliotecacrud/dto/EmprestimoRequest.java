package com.bibliotecacrud.bibliotecacrud.dto;

public class EmprestimoRequest {
    private Long idUsuario;
    private Long idLivro;
    
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

    
}
