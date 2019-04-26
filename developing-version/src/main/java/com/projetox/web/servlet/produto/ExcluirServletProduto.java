package com.projetox.web.servlet.produto;

import com.projetox.web.controller.ProdutoController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author victor.ganjos
 */

    @WebServlet(name = "ExcluirServletProduto", urlPatterns = {"/excluir-servlet-produto"})
public class ExcluirServletProduto extends HttpServlet{
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String id = request.getParameter("id");
        String nomeProduto = request.getParameter("nomeProduto");
        request.setAttribute("id", id);
        request.setAttribute("nomeProduto", nomeProduto);
        
       ProdutoController.excluir(Integer.parseInt(id));
 
       RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultadoProduto.jsp");
        dispatcher.forward(request, response);
    }
}

