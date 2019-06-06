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
 *
 * @author layssa.fodias
 */
public class ProdutoDAO {

    public void salvar(Produto p) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO PRODUTO(nomeprod, categoria, descricao, valorVenda, estoquedisp, situacao) VALUE (?,?,?,?,?,?);");
            stmt.setString(1, p.getNomeProd());
            stmt.setString(2, p.getCategoria());
            stmt.setString(3, p.getDescricao());
            stmt.setFloat(4, p.getValorVenda());
            stmt.setInt(5, p.getEstoqueDisp());
            stmt.setString(6, p.getSituacao());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }

    public List<Produto> consultar() {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PRODUTO");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNomeProd(rs.getString("nomeprod"));
                p.setCategoria(rs.getString("categoria"));
                p.setDescricao(rs.getString("descricao"));
                p.setValorVenda(rs.getFloat("valorvenda"));
                p.setEstoqueDisp(rs.getInt("estoquedisp"));
                p.setSituacao(rs.getString("situacao"));

                produtos.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return produtos;
    }

    public List<Produto> consultarPorNomeProduto(String nomeProd) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PRODUTO WHERE nomeprod LIKE ?;");
            stmt.setString(1, "%" + nomeProd + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNomeProd(rs.getString("nomeprod"));
                p.setCategoria(rs.getString("categoria"));
                p.setDescricao(rs.getString("descricao"));
                p.setValorVenda(rs.getFloat("valorvenda"));
                p.setEstoqueDisp(rs.getInt("estoquedisp"));
                p.setSituacao(rs.getString("situacao"));

                produtos.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return produtos;
    }

    public List<Produto> consultarPorId(int id) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PRODUTO WHERE id LIKE ?;");
            stmt.setString(1, "" + id + "");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNomeProd(rs.getString("nomeprod"));
                p.setCategoria(rs.getString("categoria"));
                p.setDescricao(rs.getString("descricao"));
                p.setValorVenda(rs.getFloat("valorvenda"));
                p.setEstoqueDisp(rs.getInt("estoquedisp"));
                p.setSituacao(rs.getString("situacao"));

                produtos.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return produtos;
    }

    public Produto consultarPorIdVenda(int id) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto produtos = new Produto();

        try {
            stmt = con.prepareStatement("SELECT * FROM PRODUTO WHERE id LIKE ?;");
            stmt.setString(1, "" + id + "");
            rs = stmt.executeQuery();

            Produto p = new Produto();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNomeProd(rs.getString("nomeprod"));
                p.setCategoria(rs.getString("categoria"));
                p.setDescricao(rs.getString("descricao"));
                p.setValorVenda(rs.getFloat("valorvenda"));
                p.setEstoqueDisp(rs.getInt("estoquedisp"));
                p.setSituacao(rs.getString("situacao"));
                produtos = p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return produtos;
    }

    public static List<Produto> pesquisar(int id) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PRODUTO WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto P = new Produto();

                P.setId(rs.getInt("id"));
                P.setNomeProd(rs.getString("nomeprod"));
                P.setCategoria(rs.getString("categoria"));
                P.setDescricao(rs.getString("descricao"));
                P.setValorVenda(rs.getFloat("valorvenda"));
                P.setEstoqueDisp(rs.getInt("estoquedisp"));
                P.setSituacao(rs.getString("situacao"));

                produto.add(P);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt, rs);
        }
        return produto;

    }

    public void atualizar(Produto p) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE PRODUTO SET nomeprod = ?, categoria = ?, descricao = ?, valorvenda = ?, estoquedisp = ?, situacao = ? WHERE id = ?");

            stmt.setString(1, p.getNomeProd());
            stmt.setString(2, p.getCategoria());
            stmt.setString(3, p.getDescricao());
            stmt.setFloat(4, p.getValorVenda());
            stmt.setInt(5, p.getEstoqueDisp());
            stmt.setString(6, p.getSituacao());
            stmt.setInt(7, p.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }

    public void deletar(int id) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("Delete from PRODUTO WHERE id = ?;");

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }
}
