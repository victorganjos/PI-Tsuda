/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.VendaDois;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Fabio
 */
public class VendaDoisDAO {
    
    public void salvar(VendaDois v) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
          
        try {
            stmt = con.prepareStatement("INSERT INTO VENDADOIS(idCliente,valorTotal,dataVenda) VALUE (?,?,?);");
            stmt.setInt(1, v.getIdCliente());
            stmt.setDouble(2, v.getValorTotal());
            stmt.setString(3, v.getDataVenda());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }
}
