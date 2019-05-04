package com.projetox.web.controller;

import com.projetox.web.dao.EstoqueDAO;
import com.projetox.web.model.Estoque;
import java.util.List;

/**
 *
 * @author Fabio
 */
public class EstoqueController {
    
    public static void Salvar(String descricao, String filial){
        Estoque c = new Estoque(descricao, filial);
        EstoqueDAO estoque = new EstoqueDAO();
        estoque.salvar(c);
    }
    public static void Atualizar(int id, String descricao, String filial){
        Estoque e = new Estoque(id, descricao, filial);
        EstoqueDAO estoque = new EstoqueDAO();
        estoque.atualizar(e);
    }
    
    public static void Excluir (int id){
        EstoqueDAO estoque = new EstoqueDAO();
        estoque.deletar(id);
    }
    public static List<Estoque> consultarPorDescricao(String descricao){
        EstoqueDAO estoque = new EstoqueDAO();
        return estoque.consultarPorDescricao(descricao);
    }
    public static List<Estoque> consultar(){
        EstoqueDAO estoque = new EstoqueDAO();
        return estoque.consultar();
    }
}
