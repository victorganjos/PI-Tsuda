/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web;

import com.projetox.web.controller.FornecedorController;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.model.Fornecedor;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ConsultarFornecedor", urlPatterns = {"/consultar-fornecedor"})
public class ConsultarFornecedor extends HttpServlet{
    
    
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         
        List<Fornecedor> lista = FornecedorController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaFornecedor.jsp");
        dispatcher.forward(request, response);
    }

}
