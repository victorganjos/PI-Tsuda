package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.Produto;
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
public class ProdutoDAO {
      public void salvar(Produto p) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO dadosProduto(nomeproduto,categoria) VALUE (?,?);");
            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getCategoria());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }
    
    public List<Produto> consultar(){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM dadosProduto");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto p = new Produto();
                
                p.setId(rs.getInt("id"));
                p.setNomeProduto(rs.getString("nomeProduto"));
                p.setCategoria(rs.getString("categoria"));
                
                produtos.add(p);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return produtos; 
    }
    
    public List<Produto> consultarPorNomeProduto(String nomeProduto){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM dadosProduto WHERE nome LIKE ?;");
            stmt.setString(1,"%"+nomeProduto+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto p = new Produto();
                
                p.setNomeProduto(rs.getString("nomeproduto"));
                 p.setCategoria(rs.getString("categoria"));
                
                produtos.add(p);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return produtos; 
    }
    
    public void atualizar(Produto p){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE dadosProduto SET nomeProduto = ?, categoria = ? WHERE id = ?");
            
            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getCategoria());
            stmt.setInt(3,p.getId());
            
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt);
        }
    }
    
    public void deletar(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
           stmt = con.prepareStatement("Delete from dadosProduto WHERE id = ?;");
           
           stmt.setInt(1, id);
           
           stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt);
        }
    }
}
