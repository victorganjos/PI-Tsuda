package com.projetox.web.controller;

import com.projetox.web.dao.FornecedorDAO;
import com.projetox.web.model.Fornecedor;
import java.util.List;

/**
 * @author victor.ganjos
 */
public class FornecedorController {
    
    public static void salvar(String nomeFantasia, long cnpj){
    Fornecedor f = new Fornecedor(nomeFantasia, cnpj);
    FornecedorDAO fDao = new FornecedorDAO();
    fDao.salvar(f);    
    }
    
    public static void atualizar(int id,String nomeFantasia, long cnpj){
    Fornecedor f = new Fornecedor(id,nomeFantasia, cnpj);
    FornecedorDAO fDao = new FornecedorDAO();
    fDao.atualizar(f);    
    }
    
     public static void excluir (int id){
        FornecedorDAO fDao = new FornecedorDAO();
        fDao.deletar(id);
    }
    public static List<Fornecedor> consultarPorNome(String nomeFantasia){
        FornecedorDAO fDao = new FornecedorDAO();
        return fDao.consultarPorNomeFantasia(nomeFantasia);
    }
    
    public static List<Fornecedor> consultar(){
    FornecedorDAO fDao = new FornecedorDAO();
    return fDao.consultar();
    }
    
}
