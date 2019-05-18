package com.projetox.web.controller;

import com.projetox.web.dao.ProdutoDAO;
import com.projetox.web.model.Produto;
import java.util.List;

/**
 *
 * @author layssa.fodias
 */
public class ProdutoController {
    //
    public static void salvar(String nomeProd, String categoria, String descricao, float valorVenda, int estoqueDisp, String situacao){
    Produto p = new Produto(nomeProd, categoria, descricao, valorVenda, estoqueDisp, situacao);
    
    ProdutoDAO pDao = new ProdutoDAO();
    pDao.salvar(p);    
    }
    
    public static void atualizar(int id,String nomeProd, String categoria, String descricao, float valorVenda, int estoqueDisp, String situacao){
    Produto p = new Produto(id, nomeProd, categoria, descricao, valorVenda, estoqueDisp, situacao);
    ProdutoDAO pDao = new ProdutoDAO();
    pDao.atualizar(p);    
    }
    
     public static void excluir (int id){
        ProdutoDAO pDao = new ProdutoDAO();
        pDao.deletar(id);
    }
    public static List<Produto> consultarPorNome(String nomeProd){
        ProdutoDAO pDao = new ProdutoDAO();
        return pDao.consultarPorNomeProduto(nomeProd);
    }
    
    public static List<Produto> consultarPorId(int id){
        ProdutoDAO pDao = new ProdutoDAO();
        return pDao.consultarPorId(id);
    }
    
    public static List<Produto> consultar(){
    ProdutoDAO pDao = new ProdutoDAO();
    return pDao.consultar();
    }
    
    public static List<Produto> pesquisar(int id){
            ProdutoDAO produto = new ProdutoDAO();
            return produto.pesquisar(id);
    }
}
