/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.Venda;
import com.projetox.web.model.Cliente;
import com.projetox.web.model.ItemVenda;
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
            stmt = con.prepareStatement("INSERT INTO VENDA(cliente,formapagamento,valortotal,datavenda) value (?,?,?,?);");
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
            condicao = condicao + " AND CLI.nome = " + cliente;
        }

        if (!dataIni.equals("")) {
            dataIni = "'" + dataIni + "'";
            condicao = condicao + " AND VEN.datavenda >=" + dataIni;
        }

        if (!dataFim.equals("")) {
            dataFim = "'" + dataFim + "'";
            condicao = condicao + " AND VEN.datavenda <=" + dataFim;
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
            stmt = con.prepareStatement("SELECT VEN.*, CLI.nome AS ds_nomecliente FROM VENDA VEN LEFT JOIN DADOSCLIENTE CLI ON CLI.id = VEN.cliente " + condicao);
            rs = stmt.executeQuery();

            List<Cliente> listaCliente = new ArrayList();

            while (rs.next()) {
                Venda e = new Venda();

                e.setId(rs.getInt("id"));
                e.setNomeCliente(rs.getString("ds_nomecliente"));
                e.setFormaPagamento(rs.getString("formapagamento"));
                e.setDataVenda(rs.getString("datavenda"));
                e.setValorTotal(rs.getFloat("valortotal"));

                Venda.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return Venda;
    }

    public List<ItemVenda> consultarItemMaisVendido(String dataIni, String dataFim, String cliente) {
        String condicao = "";

        if (!dataIni.equals("")) {
            dataIni = "'" + dataIni + "'";
            condicao = condicao + " AND VEN.datavenda >=" + dataIni;
        }

        if (!dataFim.equals("")) {
            dataFim = "'" + dataFim + "'";
            condicao = condicao + " AND VEN.datavenda <=" + dataFim;
        }

        if (!cliente.equals("")) {
            cliente = "'" + cliente + "'";
            condicao = condicao + " AND CLI.nome = " + cliente;
        }

        if (!condicao.equals("")) {
            condicao = condicao.substring(5);
            condicao = "WHERE " + condicao;
        }

        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ItemVenda> item = new ArrayList<>();

        String comando = "SELECT \n"
                + "	COUNT(*) AS qt_produto,\n"
                + "    PRO.nomeprod AS nomeprod\n"
                + "FROM\n"
                + "	ITEMVENDA ITE\n"
                + "LEFT JOIN VENDA VEN ON VEN.id = ITE.idvenda\n"
                + "LEFT JOIN PRODUTO PRO ON PRO.id = ITE.idproduto\n"
                + "LEFT JOIN DADOSCLIENTE CLI ON CLI.id = VEN.cliente\n"
                + condicao + "\n"
                + "GROUP BY\n"
                + "PRO.nomeprod\n"
                + "ORDER BY\n"
                + "qt_produto DESC\n"
                + "LIMIT 5;";
        try {
            stmt = con.prepareStatement(comando);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ItemVenda e = new ItemVenda();

                e.setQtdVendida(rs.getInt("qt_produto"));
                e.setNomeProduto(rs.getString("nomeprod"));

                item.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return item;
    }

    public void deletar(int id) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("Delete from VENDA WHERE id = ?;");

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }
}
