package com.bibliotecacrud.bibliotecacrud.util;


public class Resposta <T>{

    private int status;
    private String mensagem;
    private T data;

    public Resposta(int status, String mensagem, T data) {
        this.status = status;
        this.mensagem = mensagem;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

