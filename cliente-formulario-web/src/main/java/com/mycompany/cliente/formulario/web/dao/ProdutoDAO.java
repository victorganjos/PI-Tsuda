package com.mycompany.cliente.formulario.web.dao;

import com.mycompany.cliente.formulario.web.connection.ConnectionFactory;
import com.mycompany.cliente.formulario.web.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author layssa.fodias
 */
public class ProdutoDAO {

    public void salvar(Produto p) {
        Connection con = ConnectionFactory.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO dadosProduto(id,titulo,subtitulo) VALUE (?,?);");
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getTitulo());
            stmt.setString(3, p.getSubtitulo());

            stmt.executeUpdate();
            System.out.println("Salvar com sucesso!");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao salvar");
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }

    }

}
