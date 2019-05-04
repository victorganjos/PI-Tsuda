package com.projetox.web.servlet.produto;

import com.projetox.web.controller.ProdutoController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    @WebServlet(name = "AtualizarServletProduto", urlPatterns = {"/atualizar-servlet-produto"})
public class AtualizarServletProduto extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String nomeProduto = request.getParameter("nomeProduto");
        String categoria = request.getParameter("categoria");
        String id = request.getParameter("id");
        
        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("nomeProduto", nomeProduto);
        request.setAttribute("categoria", categoria);
        request.setAttribute("id", id);
        
        ProdutoController.atualizar(Integer.parseInt(id),nomeProduto,categoria);
 
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultadoProduto.jsp");
        dispatcher.forward(request, response);
    }
    }
