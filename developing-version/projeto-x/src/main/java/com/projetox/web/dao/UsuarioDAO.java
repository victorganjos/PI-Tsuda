package com.projetox.web.dao;

import com.projetox.web.connection.ConnectionFactory;
import com.projetox.web.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {

    public void salvar(Usuario c) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO DADOSUSUARIO(nome,filial, cargo, setor, CPF, RG, data, endereco, numero, complemento, estado, cidade, bairro, cep, telefone, celular, email, infoadcionais) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getFilial());
            stmt.setString(3, c.getCargo());
            stmt.setString(4, c.getSetor());
            stmt.setString(5, c.getCPF());
            stmt.setString(6, c.getRG());
            stmt.setString(7, c.getData());
            stmt.setString(8, c.getEndereco());
            stmt.setString(9, c.getNumero());
            stmt.setString(10, c.getComplemento());
            stmt.setString(11, c.getEstado());
            stmt.setString(12, c.getCidade());
            stmt.setString(13, c.getBairro());
            stmt.setString(14, c.getCep());
            stmt.setString(15, c.getTelefone());
            stmt.setString(16, c.getCelular());
            stmt.setString(17, c.getEmail());
            stmt.setString(18, c.getInfoAdcionais());
            

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
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
                c.setFilial(rs.getString("filial"));
                c.setCargo(rs.getString("cargo"));
                c.setSetor(rs.getString("setor"));
                c.setCPF(rs.getString("CPF"));
                c.setRG(rs.getString("RG"));
                c.setData(rs.getString("data"));
                c.setEndereco(rs.getString("endereco"));
                c.setNumero(rs.getString("numero"));
                c.setComplemento(rs.getString("complemento"));
                c.setEstado(rs.getString("estado"));
                c.setCidade(rs.getString("cidade"));
                c.setBairro(rs.getString("bairro"));
                c.setCep(rs.getString("cep"));
                c.setTelefone(rs.getString("telefone"));
                c.setCelular(rs.getString("celular"));
                c.setEmail(rs.getString("email"));
                c.setInfoAdcionais(rs.getString("infoadcionais"));
                
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
                c.setFilial(rs.getString("filial"));
                c.setCargo(rs.getString("cargo"));
                c.setSetor(rs.getString("setor"));
                c.setCPF(rs.getString("CPF"));
                c.setRG(rs.getString("RG"));
                c.setData(rs.getString("data"));
                c.setEndereco(rs.getString("endereco"));
                c.setNumero(rs.getString("numero"));
                c.setComplemento(rs.getString("complemento"));
                c.setEstado(rs.getString("estado"));
                c.setCidade(rs.getString("cidade"));
                c.setBairro(rs.getString("bairro"));
                c.setCep(rs.getString("cep"));
                c.setTelefone(rs.getString("telefone"));
                c.setCelular(rs.getString("celular"));
                c.setEmail(rs.getString("email"));
                c.setInfoAdcionais(rs.getString("infoAdcionais"));
                
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
            stmt = con.prepareStatement("UPDATE PROJETO_X.dadosUsuario SET nome = ?, filial = ?, cargo = ?, setor = ?, cpf = ?, rg = ?, data = ?, endereco = ?, numero = ?, complemento = ?, estado = ?, cidade = ?, bairro = ?, cep = ?, telefone = ?, celular = ?, email = ?, infoadcionais = ? WHERE id = ?");
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getFilial());
            stmt.setString(3, c.getCargo());
            stmt.setString(4, c.getSetor());
            stmt.setString(5, c.getCPF());
            stmt.setString(6, c.getRG());
            stmt.setString(7, c.getData());
            stmt.setString(8, c.getEndereco());
            stmt.setString(9, c.getNumero());
            stmt.setString(10, c.getComplemento());
            stmt.setString(11, c.getEstado());
            stmt.setString(12, c.getCidade());
            stmt.setString(13, c.getBairro());
            stmt.setString(14, c.getCep());
            stmt.setString(15, c.getTelefone());
            stmt.setString(16, c.getCelular());
            stmt.setString(17, c.getEmail());
            stmt.setString(18, c.getInfoAdcionais());
            stmt.setInt(19,c.getId());
            
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

