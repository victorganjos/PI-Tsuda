package com.projetox.web.controller;

import com.projetox.web.dao.FornecedorDAO;
import com.projetox.web.model.Fornecedor;
import java.util.List;

/**
 * @author victor.ganjos
 */
public class FornecedorController {
    
    public static void salvar(String nome, String email, long cnpj, String telefone, String endereco, int numero, String complemento, String estado, String cidade, String bairro, String cep, String tipo){
    Fornecedor f = new Fornecedor(nome,email,cnpj,telefone,endereco,numero,complemento,estado,cidade,bairro,cep,tipo);
    FornecedorDAO fDao = new FornecedorDAO();
    fDao.salvar(f);    
    }
    
    public static void atualizar(int id,String nome, String email, long cnpj, String telefone, String endereco, int numero, String complemento, String estado, String cidade, String bairro, String cep, String tipo){
    Fornecedor f = new Fornecedor(id,nome,email,cnpj,telefone,endereco,numero,complemento,estado,cidade,bairro,cep,tipo);
    FornecedorDAO fDao = new FornecedorDAO();
    fDao.atualizar(f);    
    }
    
     public static void excluir (int id){
        FornecedorDAO fDao = new FornecedorDAO();
        fDao.deletar(id);
    }
    public static List<Fornecedor> consultarPorNome(String nome){
        FornecedorDAO fDao = new FornecedorDAO();
        return fDao.consultarPorNome(nome);
    }
    
     public static List<Fornecedor> consultarPorId(int id){
        FornecedorDAO fDao = new FornecedorDAO();
        return fDao.consultarPorId(id);
    }
    
    public static List<Fornecedor> consultar(){
    FornecedorDAO fDao = new FornecedorDAO();
    return fDao.consultar();
    }
    
}
