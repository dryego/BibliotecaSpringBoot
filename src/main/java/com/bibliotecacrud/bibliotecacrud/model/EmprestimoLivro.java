package com.bibliotecacrud.bibliotecacrud.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "emprestimo_livro")
public class EmprestimoLivro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "data_entrega",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Column(name = "Entrega_realizada", nullable = false)
    private boolean entregaRealizada = false;

    public EmprestimoLivro() {
    }

    public EmprestimoLivro(Livro livro, Usuario usuario, Date dataEntrega, boolean entregaRealizada) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEntrega = dataEntrega;
        this.entregaRealizada = entregaRealizada;
    }

    public Long getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isEntregaRealizada() {
        return entregaRealizada;
    }

    public void setEntregaRealizada(boolean entregaRealizada) {
        this.entregaRealizada = entregaRealizada;
    }
}

