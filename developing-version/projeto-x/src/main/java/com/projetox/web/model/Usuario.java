package com.projetox.web.model;

import java.sql.Date;

/**
 *
 * @author Fabio
 */
public class Usuario {

    private int id;
    private String nome;
    private String username;
    private String senha;
    private String cargo;
    private String filial;

    public Usuario(String nome, String username, String senha, String cargo, String filial) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.cargo = cargo;
        this.filial = filial;
    }

    public Usuario() {
    }

    public Usuario(int id, String nome, String username, String senha, String cargo, String filial) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.cargo = cargo;
        this.filial = filial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }
    

}
