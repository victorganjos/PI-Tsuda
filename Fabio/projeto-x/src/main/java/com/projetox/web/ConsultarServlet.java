/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web;

import com.projetox.web.controller.ClienteController;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.model.Cliente;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author fabio.msilva21
 */
@WebServlet(name = "ConsultarServlet", urlPatterns = {"/consultar-servlet"})
public class ConsultarServlet extends HttpServlet{
    
    
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         
        List<Cliente> lista = ClienteController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/Consulta.jsp");
        dispatcher.forward(request, response);
    }

}
