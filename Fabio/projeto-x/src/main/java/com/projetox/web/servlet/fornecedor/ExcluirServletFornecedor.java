package com.projetox.web.servlet.fornecedor;

import com.projetox.web.controller.FornecedorController;
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

    @WebServlet(name = "ExcluirServletFornecedor", urlPatterns = {"/excluir-servlet-fornecedor"})
public class ExcluirServletFornecedor extends HttpServlet{
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String id = request.getParameter("id");
        String nomeFantasia = request.getParameter("nomeFantasia");
        request.setAttribute("id", id);
        request.setAttribute("nomeFantasia", nomeFantasia);
        
       FornecedorController.excluir(Integer.parseInt(id));
 
       RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp");
        dispatcher.forward(request, response);
    }
}

