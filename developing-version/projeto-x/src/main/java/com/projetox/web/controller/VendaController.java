/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.controller;

import com.projetox.web.dao.VendaDAO;
import com.projetox.web.model.Venda;
import java.util.List;

/**
 *
 * @author caio.hcpereira
 */
public class VendaController {
        public static List<Venda> consultar(){
        VendaDAO Venda = new VendaDAO();
        return Venda.consultar();
    }
}
