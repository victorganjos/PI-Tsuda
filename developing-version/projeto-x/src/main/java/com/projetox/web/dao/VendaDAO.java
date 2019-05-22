/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.Venda;
import java.sql.Connection;
import java.sql.Date;
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
            stmt = con.prepareStatement("INSERT INTO venda(cliente,formaPagamento,valorTotal,dataVenda) value (?,?,?,?);");
            stmt.setInt(1, v.getCliente());
            stmt.setString(2, v.getFormaPagamento());
            stmt.setDouble(3, v.getValorTotal());
            stmt.setDate(4, (Date) v.getDataVenda());
            
            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }
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
    
    public void deletar(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
           stmt = con.prepareStatement("Delete from venda WHERE id = ?;");
           
           stmt.setInt(1, id);
           
           stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt);
        }
    }
}
