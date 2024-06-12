package com.bibliotecacrud.bibliotecacrud.dto;

import java.util.Date;

public class EmprestimoDTO {
    private Long Id;
    private boolean entregaRealizada;
    private Date dataEntrega;
    private Long idUsuario;
    private Long idLivro;

    public EmprestimoDTO(Long id, boolean entregaRealizada, Date dataEntrega, Long idUsuario, Long idLivro) {
        Id = id;
        this.entregaRealizada = entregaRealizada;
        this.dataEntrega = dataEntrega;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public boolean isEntregaRealizada() {
        return entregaRealizada;
    }

    public void setEntregaRealizada(boolean entregaRealizada) {
        this.entregaRealizada = entregaRealizada;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
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
}
