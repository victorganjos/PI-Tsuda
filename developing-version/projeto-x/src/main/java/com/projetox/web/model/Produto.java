package com.projetox.web.model;

public class Produto {

    private int id;
    private String nomeProd;
    private String categoria;
    private String descricao;
    private float valorVenda;
    private int estoqueDisp;
    private String situacao;

    public Produto() {
    }

    public Produto(int id, String nomeProd, String categoria, String descricao, float valorVenda, int estoqueDisp, String situacao) {
        this.id = id;
        this.nomeProd = nomeProd;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.estoqueDisp = estoqueDisp;
        this.situacao = situacao;
    }

    public Produto(String nomeProd, String categoria, String descricao, float valorVenda, int estoqueDisp, String situacao) {
        this.nomeProd = nomeProd;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.estoqueDisp = estoqueDisp;
        this.situacao = situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getEstoqueDisp() {
        return estoqueDisp;
    }

    public void setEstoqueDisp(int estoqueDisp) {
        this.estoqueDisp = estoqueDisp;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Produto(String nomeProd, String categoria) {
        this.nomeProd = nomeProd;
        this.categoria = categoria;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
