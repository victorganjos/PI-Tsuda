package com.projetox.web.model;

public class Produto {
    private String nomeProduto;
    private String categoria;
    private int id;
    
    public Produto(){
    }
    public Produto(int id,String nomeProduto,String categoria){
        this.nomeProduto=nomeProduto;
        this.categoria=categoria;
        this.id=id;
    }
    
      public Produto(String nomeProduto,String categoria){
        this.nomeProduto=nomeProduto;
        this.categoria=categoria;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
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
