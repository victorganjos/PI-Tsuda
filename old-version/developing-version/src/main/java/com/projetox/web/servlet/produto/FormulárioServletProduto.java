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

 @WebServlet(name = "FormularioServletProduto", urlPatterns = {"/formulario-servlet-produto"})
public class FormulárioServletProduto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("formularioProduto.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String nomeProduto = request.getParameter("nomeProduto");
        String categoria = request.getParameter("categoria");
        
        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("nomeProduto", nomeProduto);
        request.setAttribute("categoria", categoria);
        
        
        ProdutoController.salvar(nomeProduto,categoria);
        
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultadoProduto.jsp");
        dispatcher.forward(request, response);   
}
 }