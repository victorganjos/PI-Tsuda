package com.projetox.web;

import com.projetox.web.controller.ProdutoController;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.model.Produto;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ConsultarProduto", urlPatterns = {"/consultar-produto"})
public class ConsultarProduto extends HttpServlet{
    
    
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         
        List<Produto> lista = ProdutoController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaProduto.jsp");
        dispatcher.forward(request, response);
    }

}

