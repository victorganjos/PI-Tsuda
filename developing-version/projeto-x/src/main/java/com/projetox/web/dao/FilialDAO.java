package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.Filial;
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
public class FilialDAO {
      public void salvar(Filial f) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO DADOSCLIENTE(nome,email,cnpj,telefone,endereco,numero,complemento,estado,cidade,bairro,cep,tipo) VALUE (?,?,?,?,?,?,?,?,?,?,?,?);");
            stmt.setString(1, f.getNome());
            stmt.setString(2,f.getEmail());
            stmt.setLong(3, f.getCnpj());
            stmt.setString(4,f.getTelefone());
            stmt.setString(5,f.getEndereco());
            stmt.setInt(6,f.getNumero());
            stmt.setString(7,f.getComplemento());
            stmt.setString(8,f.getEstado());
            stmt.setString(9,f.getCidade());
            stmt.setString(10,f.getBairro());
            stmt.setString(11,f.getCep());
            stmt.setString(12,f.getTipo());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }
    
    public List<Filial> consultar(){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Filial> filiais = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM DADOSCLIENTE WHERE tipo = 'fi'");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Filial f = new Filial();
                
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setCnpj(rs.getLong("cnpj"));
                f.setTelefone(rs.getString("telefone"));
                f.setEndereco(rs.getString("endereco"));
                f.setNumero(rs.getInt("numero"));
                f.setComplemento(rs.getString("complemento"));
                f.setEstado(rs.getString("estado"));
                f.setCidade(rs.getString("cidade"));
                f.setBairro(rs.getString("bairro"));
                f.setCep(rs.getString("cep"));
                f.setTipo(rs.getString("tipo"));

                filiais.add(f);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return filiais; 
    }
    
    public List<Filial> consultarPorNome(String nome){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Filial> fornecedores = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM DADOSCLIENTE WHERE nome LIKE ? AND tipo = 'f';");
            stmt.setString(1,"%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Filial f = new Filial();           
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setCnpj(rs.getLong("cnpj"));
                f.setTelefone(rs.getString("telefone"));
                f.setEndereco(rs.getString("endereco"));
                f.setNumero(rs.getInt("numero"));
                f.setComplemento(rs.getString("complemento"));
                f.setEstado(rs.getString("estado"));
                f.setCidade(rs.getString("cidade"));
                f.setBairro(rs.getString("bairro"));
                f.setCep(rs.getString("cep"));
                f.setTipo(rs.getString("tipo"));
                
                fornecedores.add(f);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return fornecedores; 
    }
    
    public List<Filial> consultarPorId(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Filial> fornecedores = new ArrayList<>();
        
        
        try{
            stmt = con.prepareStatement("SELECT * FROM DADOSCLIENTE WHERE id LIKE ?;");
            stmt.setString(1,"%"+id+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Filial f = new Filial();           
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setCnpj(rs.getLong("cnpj"));
                f.setTelefone(rs.getString("telefone"));
                f.setEndereco(rs.getString("endereco"));
                f.setNumero(rs.getInt("numero"));
                f.setComplemento(rs.getString("complemento"));
                f.setEstado(rs.getString("estado"));
                f.setCidade(rs.getString("cidade"));
                f.setBairro(rs.getString("bairro"));
                f.setCep(rs.getString("cep"));
                f.setTipo(rs.getString("tipo"));
                
                fornecedores.add(f);
            }
            
        }
        catch(SQLException ex){
           Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt,rs);
        }
       return fornecedores; 
    }
    
    public void atualizar(Filial f){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE DADOSCLIENTE SET nome = ?,email=?, cnpj = ?,telefone = ?,endereco = ?,numero = ?,complemento = ?,estado = ?,cidade = ?,bairro = ?,cep = ?,tipo = ? WHERE id = ?");
            
            stmt.setString(1, f.getNome());
            stmt.setString(2,f.getEmail());
            stmt.setLong(3, f.getCnpj());
            stmt.setString(4,f.getTelefone());
            stmt.setString(5,f.getEndereco());
            stmt.setInt(6,f.getNumero());
            stmt.setString(7,f.getComplemento());
            stmt.setString(8,f.getEstado());
            stmt.setString(9,f.getCidade());
            stmt.setString(10,f.getBairro());
            stmt.setString(11,f.getCep());
            stmt.setString(12,f.getTipo());
            stmt.setInt(13,f.getId());
            
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt);
        }
    }
    
    public void deletar(int id){
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        
        try{
           stmt = con.prepareStatement("Delete from DADOSCLIENTE WHERE id = ?;");
           
           stmt.setInt(1, id);
           
           stmt.executeUpdate();
        }
        catch(SQLException ex){
            Logger.getLogger(FilialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.fecharConexao(con,stmt);
        }
    }
}
