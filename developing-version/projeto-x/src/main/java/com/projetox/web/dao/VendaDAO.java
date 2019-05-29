/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.Venda;
import com.projetox.web.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author caio.hcpereira
 */
public class VendaDAO {

    //(int cliente, String formaPagamento, float valorTotal, Date dataVenda)
    public void salvar(Venda v) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO VENDA(cliente,formaPagamento,valorTotal,dataVenda) value (?,?,?,?);");
            stmt.setInt(1, v.getCliente());
            stmt.setString(2, v.getFormaPagamento());
            stmt.setDouble(3, v.getValorTotal());
            stmt.setString(4, v.getDataVenda());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }

    public List<Venda> consultar(String cliente, String dataIni, String dataFim) {
        String condicao = "";

        if (!cliente.equals("")) {
            cliente = "'" + cliente + "'";
            condicao = condicao + " AND CLI.NOME = " + cliente;
        }

        if (!dataIni.equals("")) {
            dataIni = "'" + dataIni + "'";
            condicao = condicao + " AND VEN.DATAVENDA >=" + dataIni;
        }

        if (!dataFim.equals("")) {
            dataFim = "'" + dataFim + "'";
            condicao = condicao + " AND VEN.DATAVENDA <=" + dataFim;
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
            stmt = con.prepareStatement("SELECT VEN.*, CLI.NOME AS DS_NOMECLIENTE FROM VENDA VEN LEFT JOIN DADOSCLIENTE CLI ON CLI.ID = VEN.CLIENTE " + condicao);
            rs = stmt.executeQuery();

            List<Cliente> listaCliente = new ArrayList();

            while (rs.next()) {
                Venda e = new Venda();

                e.setId(rs.getInt("ID"));
                e.setNomeCliente(rs.getString("DS_NOMECLIENTE"));
                e.setFormaPagamento(rs.getString("FORMAPAGAMENTO"));
                e.setValorTotal(rs.getFloat("VALORTOTAL"));
                e.setDataVenda(rs.getString("DATAVENDA"));

                Venda.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return Venda;
    }

    public void deletar(int id) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("Delete from venda WHERE id = ?;");

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }
}
