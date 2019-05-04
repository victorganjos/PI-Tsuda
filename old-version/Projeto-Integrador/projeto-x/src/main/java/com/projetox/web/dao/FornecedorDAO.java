package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author victor.ganjos
 */
public class FornecedorDAO {
      public void salvar(Fornecedor f) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO dadosFornecedor(nomefantasia,cnpj) VALUE (?,?);");
            stmt.setString(1, f.getNomeFantasia());
            stmt.setLong(2, f.getCnpj());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }
    
    public List<Fornecedor> consultar(){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Fornecedor> fornecedores = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM dadosFornecedor");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedor f = new Fornecedor();
                
                f.setId(rs.getInt("id"));
                f.setNomeFantasia(rs.getString("nomefantasia"));
                f.setCnpj(rs.getLong("cnpj"));
                
                fornecedores.add(f);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return fornecedores; 
    }
    
    public List<Fornecedor> consultarPorNomeFantasia(String nomeFantasia){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Fornecedor> fornecedores = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM dadosFornecedor WHERE nome LIKE ?;");
            stmt.setString(1,"%"+nomeFantasia+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedor f = new Fornecedor();
                
                f.setNomeFantasia(rs.getString("nomeFantasia"));
                 f.setCnpj(rs.getLong("cnpj"));
                
                fornecedores.add(f);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return fornecedores; 
    }
    
    public void atualizar(Fornecedor f){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE dadosFornecedor SET nomefantasia = ?, cnpj = ? WHERE id = ?");
            
            stmt.setString(1, f.getNomeFantasia());
            stmt.setLong(2, f.getCnpj());
            stmt.setInt(3,f.getId());
            
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt);
        }
    }
    
    public void deletar(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
           stmt = con.prepareStatement("Delete from dadosFornecedor WHERE id = ?;");
           
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
