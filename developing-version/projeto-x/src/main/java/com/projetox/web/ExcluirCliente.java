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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fabio
 */
@WebServlet(name = "ExcluirCliente", urlPatterns = {"/excluir-cliente"})
public class ExcluirCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        String id = request.getParameter("id");
        request.setAttribute("id", id);

        ClienteController.excluir(Integer.parseInt(id));

        List<Cliente> lista = ClienteController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaCliente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        List<Cliente> lista = ClienteController.consultarPorId(id);
        request.setAttribute("id", id);
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/excluirCliente.jsp");
        dispatcher.forward(request, response);
    }
}
