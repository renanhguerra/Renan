package com.example.renan.senacposapp;

import java.io.Serializable;

public class Despesa implements Serializable{
    private String descricao;
    private String categoria;
    private String valor;
    private int id;


    public Despesa(String descricao, String categoria, String valor) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;

    }


    public Despesa(String descricao, String categoria, String valor, int id) {
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }


    public String getCategoria() {
        return categoria;
    }

    public String getValor() {
        return valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setId (int id) { this.id = id;}
}
