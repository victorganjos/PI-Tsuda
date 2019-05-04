package com.projetox.web;

import com.projetox.web.controller.ClienteController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fabio
 */
@WebServlet(name = "excluirServlet", urlPatterns = {"/excluir-servlet"})
public class ExcluirServlet extends HttpServlet{
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        request.setAttribute("id", id);
        request.setAttribute("nome", nome);
        
        ClienteController.Excluir(Integer.parseInt(id));
 
       RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp");
        dispatcher.forward(request, response);
    }
}
    
