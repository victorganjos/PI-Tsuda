/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.Estoque;
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
public class EstoqueDAO {

    public void salvar(Estoque e) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ESTOQUE(DS_DESCRICAO,DS_FILIAL) VALUE (?,?);");
            stmt.setString(1, e.getDescricao());
            stmt.setString(2, e.getFilial());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }
    
    public List<Estoque> consultar(){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoques = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM ESTOQUE");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Estoque e = new Estoque();
                
                e.setId(rs.getInt("PK_ID"));
                e.setDescricao(rs.getString("DS_DESCRICAO"));
                e.setFilial(rs.getString("DS_FILIAL"));
                
                estoques.add(e);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return estoques; 
    }
    
    public List<Estoque> consultarPorDescricao(String descricao){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoques = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM ESTOQUE WHERE DS_DESCRICAO LIKE ?;");
            stmt.setString(1,"%"+descricao+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Estoque e = new Estoque();
                
                e.setDescricao(rs.getString("DS_DESCRICAO"));
                e.setFilial(rs.getString("DS_FILIAL"));
                
                estoques.add(e);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return estoques; 
    }
    
    public List<Estoque> consultarPorId(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoques = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM ESTOQUE WHERE PK_ID = ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Estoque e = new Estoque();
                
                e.setId(rs.getInt("PK_ID"));
                e.setDescricao(rs.getString("DS_DESCRICAO"));
                e.setFilial(rs.getString("DS_FILIAL"));
                
                estoques.add(e);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return estoques; 
    }
    
    public void atualizar(Estoque e){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE ESTOQUE SET DS_DESCRICAO = ?, DS_FILIAL = ? WHERE PK_ID = ?");
            
            stmt.setString(1, e.getDescricao());
            stmt.setString(2, e.getFilial());
            stmt.setInt(3,e.getId());
            
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt);
        }
    }
    
    public void deletar(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
           stmt = con.prepareStatement("DELETE FROM ESTOQUE WHERE PK_ID = ?;");
           
           stmt.setInt(1, id);
           
           stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt);
        }
    }
    
        public static List <Estoque> pesquisar (int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Estoque> estoque = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM ESTOQUE WHERE PK_ID = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Estoque c = new Estoque();
                
                
                c.setId(rs.getInt("PK_ID"));
                c.setDescricao(rs.getString("DS_DESCRICAO"));
                c.setFilial(rs.getString("DS_FILIAL"));
                
                
                estoque.add(c);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return estoque;
        
    }
}
