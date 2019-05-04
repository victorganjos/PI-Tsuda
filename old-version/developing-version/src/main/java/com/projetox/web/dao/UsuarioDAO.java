/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.Usuario;
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
public class UsuarioDAO {

    public void salvar(Usuario c) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO dadosUsuario(nome,email) VALUE (?,?);");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }
    
    public List<Usuario> consultar(){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM dadosUsuario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario c = new Usuario();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                
                usuarios.add(c);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return usuarios; 
    }
    
    public List<Usuario> consultarPorNome(String nome){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM dadosUsuario WHERE nome LIKE ?;");
            stmt.setString(1,"%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario c = new Usuario();
                
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                
                usuarios.add(c);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return usuarios; 
    }
    
    public void atualizar(Usuario c){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE dadosUsuario SET nome = ?, email = ? WHERE id = ?");
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setInt(3,c.getId());
            
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt);
        }
    }
    
    public void deletar(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
           stmt = con.prepareStatement("Delete from dadosUsuario WHERE id = ?;");
           
           stmt.setInt(1, id);
           
           stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt);
        }
    }
}

