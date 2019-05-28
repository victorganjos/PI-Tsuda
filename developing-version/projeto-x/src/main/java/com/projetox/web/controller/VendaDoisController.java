/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.controller;

import com.projetox.web.dao.VendaDoisDAO;
import com.projetox.web.model.VendaDois;

/**
 *
 * @author Fabio
 */
public class VendaDoisController {

    public static void salvar(int idCliente, double valorTotal, String dataVenda) {
        VendaDois v = new VendaDois(idCliente, valorTotal, dataVenda);
        VendaDoisDAO venda = new VendaDoisDAO();
        venda.salvar(v);
    }
}
