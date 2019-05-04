package com.projetox.web.model;

import java.sql.Date;

/**
 *
 * @author Fabio
 */
public class Usuario {

    private int id;
    private String nome;
    private String filial;
    private String cargo;
    private String setor;
    private String CPF;
    private String RG;
    private String data;
    private String endereco;
    private String numero;
    private String complemento;
    private String estado;
    private String cidade;
    private String bairro;
    private String cep;
    private String telefone;
    private String celular;
    private String email;
    private String infoAdcionais;

    public Usuario(String nome, String filial, String cargo, String setor, String CPF, String RG, String data, String endereco, String numero, String complemento, String estado, String cidade, String bairro, String cep, String telefone, String celular, String email, String infoAdcionais) {
        this.nome = nome;
        this.filial = filial;
        this.cargo = cargo;
        this.setor = setor;
        this.CPF = CPF;
        this.RG = RG;
        this.data = data;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.infoAdcionais = infoAdcionais;
    }

    public Usuario(int id, String nome, String filial, String cargo, String setor, String CPF, String RG, String data, String endereco, String numero, String complemento, String estado, String cidade, String bairro, String cep, String telefone, String celular, String email, String infoAdcionais) {
        this.id = id;
        this.nome = nome;
        this.filial = filial;
        this.cargo = cargo;
        this.setor = setor;
        this.CPF = CPF;
        this.RG = RG;
        this.data = data;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.infoAdcionais = infoAdcionais;
    }

    public Usuario() {
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

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfoAdcionais() {
        return infoAdcionais;
    }

    public void setInfoAdcionais(String infoAdcionais) {
        this.infoAdcionais = infoAdcionais;
    }

}
