/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.controller;

import com.projetox.web.dao.VendaDAO;
import com.projetox.web.model.Venda;
import java.util.Date;
import java.util.List;

/**
 *
 * @author caio.hcpereira
 */
public class VendaController {

    public static void salvar(int cliente, String formaPagamento, float valorTotal, String dataVenda) {
        Venda v = new Venda(cliente, formaPagamento, valorTotal, dataVenda);
        VendaDAO venda = new VendaDAO();
        venda.salvar(v);
    }

    public static List<Venda> consultar(String cliente, String dataIni, String dataFim) {
        VendaDAO Venda = new VendaDAO();
        return Venda.consultar(cliente, dataIni, dataFim);
    }
    public static void excluir (int id){
        VendaDAO venda = new VendaDAO();
        venda.deletar(id);
    }
}
