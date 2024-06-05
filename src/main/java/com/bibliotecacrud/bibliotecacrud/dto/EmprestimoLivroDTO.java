package com.bibliotecacrud.bibliotecacrud.dto;

public class EmprestimoLivroDTO {
    private Long id;
    private Long idUsuario;
    private Long idLivro;
        
    public EmprestimoLivroDTO(Long id,Long idUsuario, Long idLivro) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
    }

    public EmprestimoLivroDTO(){}
    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
       
}


