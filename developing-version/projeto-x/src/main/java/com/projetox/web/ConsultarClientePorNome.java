/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web;

import com.projetox.web.controller.ClienteController;
import com.projetox.web.model.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabio.msilva21
 */
@WebServlet(name = "ConsultarClientePorNome", urlPatterns = {"/consultar-cliente-por-nome"})
public class ConsultarClientePorNome extends HttpServlet{
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         
         String cpf = request.getParameter("cliente");
         
        HttpSession sessao = request.getSession();
        List<Cliente> lista = ClienteController.consultarPorCpf(Long.parseLong(cpf));
        sessao.setAttribute("consultaCliente", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/venda.jsp");
        dispatcher.forward(request, response);
    }
}
