/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio.hcpereira
 */
public class VendaDAO {

    public List<Venda> consultar(String cliente) {
        String condicao = "";

        if (!cliente.equals("")) {
            condicao = condicao + " AND FK_CLIENTE = " + cliente;
        }

        if (!condicao.equals("")) {
            condicao = condicao.substring(5);
            condicao = "WHERE " + condicao;
        }

        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Venda> Venda = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM VENDA " + condicao);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda e = new Venda();

                e.setId(rs.getInt("PK_ID"));
                e.setCliente(rs.getInt("FK_CLIENTE"));
                e.setFormaPagamento(rs.getString("DS_FORMAPAGAMENTO"));
                e.setDataVenda(rs.getDate("DT_VENDA"));
                e.setValorTotal(rs.getFloat("VL_PRETOT"));

                Venda.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return Venda;
    }
}
