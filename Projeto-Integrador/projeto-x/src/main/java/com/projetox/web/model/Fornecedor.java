package com.projetox.web.model;

/**
 * @author victor.ganjos
 */
public class Fornecedor {
private int id;
private String nomeFantasia;
private long cnpj;

public Fornecedor(){}

public Fornecedor(String nomeFantasia, long cnpj){
this.nomeFantasia=nomeFantasia;
this.cnpj=cnpj;
}

public Fornecedor(int id, String nomeFantasia, long cnpj){
this.id=id;
this.nomeFantasia=nomeFantasia;
this.cnpj=cnpj;
}

public void setId(int id){
this.id=id;
}

public void setNomeFantasia(String nomeFantasia){
this.nomeFantasia=nomeFantasia;
}

public void setCnpj(long cnpj){
this.cnpj=cnpj;
}

public int getId(){
return this.id;
}

public String getNomeFantasia(){
return this.nomeFantasia;
}

public long getCnpj(){
return this.cnpj;
}

}
