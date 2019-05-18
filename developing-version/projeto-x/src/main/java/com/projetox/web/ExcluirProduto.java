package com.projetox.web;

import com.projetox.web.controller.ProdutoController;
import com.projetox.web.model.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "excluirProduto", urlPatterns = {"/excluir-produto"})
public class ExcluirProduto extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
        String id = request.getParameter("id");  
        request.setAttribute("id", id);

        ProdutoController.excluir(Integer.parseInt(id));

        List<Produto> lista = ProdutoController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaProduto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        List<Produto> lista = ProdutoController.consultarPorId(id);
        request.setAttribute("id", id);
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/excluirProduto.jsp");
        dispatcher.forward(request, response);
    }
    
}
