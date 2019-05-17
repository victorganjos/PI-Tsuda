/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
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
 * @author Fabio
 */
public class ClienteDAO {

    public void salvar(Cliente c) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
          
        try {
            stmt = con.prepareStatement("INSERT INTO DADOSCLIENTE(nome,email,CPF,telefone,endereco,"
                    + "numero,complemento,estado,cidade,bairro,cep,tipo) VALUE (?,?,?,?,?,?,?,?,?,?,?,?);");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setLong(3, c.getCpf());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getEndereco());
            stmt.setInt(6, c.getNumero());
            stmt.setString(7, c.getComplemento());
            stmt.setString(8, c.getEstado());
            stmt.setString(9, c.getCidade());
            stmt.setString(10, c.getBairro());
            stmt.setString(11, c.getCep());
            stmt.setString(12, c.getTipo());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }
    
    public List<Cliente> consultar(){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM dadosCLIENTE WHERE TIPO = 'c'");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCpf(rs.getLong("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setComplemento(rs.getString("complemento"));
                c.setEstado(rs.getString("estado"));
                c.setCidade(rs.getString("cidade"));
                c.setBairro(rs.getString("bairro"));
                c.setCep(rs.getString("cep"));
                c.setTipo(rs.getString("tipo"));
                
                clientes.add(c);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return clientes; 
    }
    
    public List<Cliente> consultarPorNome(String nome){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE nome LIKE ? AND TIPO = 'c';");
            stmt.setString(1,"%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCpf(rs.getLong("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setComplemento(rs.getString("complemento"));
                c.setEstado(rs.getString("estado"));
                c.setCidade(rs.getString("cidade"));
                c.setBairro(rs.getString("bairro"));
                c.setCep(rs.getString("cep"));
                c.setTipo(rs.getString("tipo"));
                
                clientes.add(c);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return clientes; 
    }
    
    public List<Cliente> consultarPorId(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM DADOSCLIENTE WHERE id LIKE ?;");
            stmt.setString(1,"%"+id+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();           
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setCpf(rs.getLong("cpf"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                c.setNumero(rs.getInt("numero"));
                c.setComplemento(rs.getString("complemento"));
                c.setEstado(rs.getString("estado"));
                c.setCidade(rs.getString("cidade"));
                c.setBairro(rs.getString("bairro"));
                c.setCep(rs.getString("cep"));
                c.setTipo(rs.getString("tipo"));
                
                clientes.add(c);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return clientes; 
    }
    
    public void atualizar(Cliente c){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE DADOSCLIENTE SET nome = ?,email=?, cpf = ?,telefone = ?,endereco = ?,numero = ?,complemento = ?,estado = ?,cidade = ?,bairro = ?,cep = ?,tipo = ? WHERE id = ?");
            
            stmt.setString(1, c.getNome());
            stmt.setString(2,c.getEmail());
            stmt.setLong(3, c.getCpf());
            stmt.setString(4,c.getTelefone());
            stmt.setString(5,c.getEndereco());
            stmt.setInt(6,c.getNumero());
            stmt.setString(7,c.getComplemento());
            stmt.setString(8,c.getEstado());
            stmt.setString(9,c.getCidade());
            stmt.setString(10,c.getBairro());
            stmt.setString(11,c.getCep());
            stmt.setString(12,c.getTipo());
            stmt.setInt(13,c.getId());
            
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
           stmt = con.prepareStatement("Delete from dadosCliente WHERE id = ?;");
           
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
