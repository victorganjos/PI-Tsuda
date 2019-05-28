/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
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
 * @author Fabio
 */
public class ItemVendaDAO {
    /*create table itemVenda (
    id int not null primary key auto_increment,
    idVenda int,
    id_produto int,
    valorUnitario float,
    FOREIGN KEY (idVenda) REFERENCES venda(id)
);*/
    public void salvar(ItemVenda v) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
          
        try {
            stmt = con.prepareStatement("INSERT INTO ITEMVENDA(idVenda,idProduto,valorUnitario) VALUE (?,?,?);");
            stmt.setInt(1, v.getIdVenda());
            stmt.setInt(2, v.getIdProduto());
            stmt.setFloat(3, v.getValorUnitario());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }
    
    public List<ItemVenda> consultar(){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ItemVenda> itemVenda = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM itemVenda");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ItemVenda v = new ItemVenda();
                
                v.setId(rs.getInt("id"));
                v.setIdVenda(rs.getInt("idVenda"));
                v.setIdProduto(rs.getInt("idProduto"));
                v.setValorUnitario(rs.getFloat("valorUnitario"));
                
                itemVenda.add(v);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return itemVenda; 
    }
}
