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


public class UsuarioDAO {

    public void salvar(Usuario c) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO DADOSUSUARIO(nome,username,senha,cargo,filial) VALUE (?,?,?,?,?);");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getUsername());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, c.getCargo());
            stmt.setString(5, c.getFilial());

            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            stmt = con.prepareStatement("SELECT * FROM PROJETO_X.dadosusuario;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario c = new Usuario();
                
                c.setId(rs.getInt("id"));                
                c.setNome(rs.getString("nome"));
                c.setUsername(rs.getString("username"));
                c.setSenha(rs.getString("senha"));
                c.setCargo(rs.getString("cargo"));
                c.setFilial(rs.getString("filial"));
                
                
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
            stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE nome LIKE ?;");
            stmt.setString(1,"%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario c = new Usuario();
                
                c.setNome(rs.getString("nome"));
                c.setUsername(rs.getString("username"));
                
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
    public List<Usuario> consultarPorUsername(String username){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        String usuario = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM dadosusuario WHERE username LIKE ?;");
            stmt.setString(1,"%"+username+"%");
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Usuario c = new Usuario();
                
                c.setNome(rs.getString("nome"));
                c.setUsername(rs.getString("username"));
                c.setSenha(rs.getString("senha"));
                c.setCargo(rs.getString("cargo"));
                c.setFilial(rs.getString("filial"));
                
                
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
    
    public static List <Usuario> pesquisar (int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM PROJETO_X.DADOSUSUARIO WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario c = new Usuario();
                
                c.setId(rs.getInt("id"));                
                c.setNome(rs.getString("nome"));
                c.setUsername(rs.getString("username"));
                c.setSenha(rs.getString("senha"));
                c.setCargo(rs.getString("cargo"));
                c.setFilial(rs.getString("filial"));
                
                
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
    
    public void atualizar(Usuario c){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE PROJETO_X.dadosUsuario SET nome = ?, username = ?, senha = ?, cargo = ?, filial = ?  WHERE id = ?");
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getUsername());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, c.getCargo());
            stmt.setString(5, c.getFilial());
            stmt.setInt(6,c.getId());
            
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

