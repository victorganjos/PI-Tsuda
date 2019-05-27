/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.model;

/**
 *
 * Caio Henrique Cordeiro Pereira
 */
public class Estoque {

    private int id;
    private String descricao;
    private String filial;

    public Estoque(int id, String descricao, String filial){
        this.id         = id;
        this.descricao  = descricao;
        this.filial     = filial;
    }
    
    public Estoque(String descricao, String filial){
        this.descricao  = descricao;
        this.filial     = filial;
    }
    
    public Estoque(){
        
    }
    
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getFilial() {
        return filial;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

}
