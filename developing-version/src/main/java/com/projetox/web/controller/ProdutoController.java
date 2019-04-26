package com.projetox.web.controller;

import com.projetox.web.dao.ProdutoDAO;
import com.projetox.web.model.Produto;
import java.util.List;

/**
 * @author victor.ganjos
 */
public class ProdutoController {
    
    public static void salvar(String nomeProduto, String categoria){
    Produto p = new Produto(nomeProduto, categoria);
    ProdutoDAO pDao = new ProdutoDAO();
    pDao.salvar(p);    
    }
    
    public static void atualizar(int id,String nomeProduto, String categoria){
    Produto p = new Produto(id,nomeProduto, categoria);
    ProdutoDAO pDao = new ProdutoDAO();
    pDao.atualizar(p);    
    }
    
     public static void excluir (int id){
        ProdutoDAO pDao = new ProdutoDAO();
        pDao.deletar(id);
    }
    public static List<Produto> consultarPorNome(String nomeProduto){
        ProdutoDAO pDao = new ProdutoDAO();
        return pDao.consultarPorNomeProduto(nomeProduto);
    }
    
    public static List<Produto> consultar(){
    ProdutoDAO pDao = new ProdutoDAO();
    return pDao.consultar();
    }
    
}
