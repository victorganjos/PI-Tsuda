package com.mycompany.cliente.formulario.web;

import com.mycompany.cliente.formulario.web.dao.ProdutoDAO;
import com.mycompany.cliente.formulario.web.model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author layssa.fodias
 */

    
@WebServlet(name = "FormularioProduto", urlPatterns = {"/FormularioProduto"})
public class FormularioProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("formulario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String subtitulo = request.getParameter("subtitulo");

        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("id", id);
        request.setAttribute("titulo", titulo);
        request.setAttribute("subtitulo", subtitulo);

        try {
            Produto produto = new Produto();
            ProdutoDAO prodDao = new ProdutoDAO();
            produto.setId(id);
            produto.setTitulo(titulo);
            produto.setSubtitulo(subtitulo);
            prodDao.salvar(produto);
        } catch (Exception erro) {
            throw new RuntimeException("Erro serio: " + erro);
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp");
        dispatcher.forward(request, response);
    }

}
