/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web;

import com.projetox.web.controller.EstoqueController;
import com.projetox.web.model.Estoque;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "IncluirEstoque", urlPatterns = {"/incluir-estoque"})
public class IncluirEstoque extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("adicionarEstoque.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
        String descricao = request.getParameter("descricao");
        String filial = request.getParameter("filial");

    if (!descricao.isEmpty() && !filial.isEmpty()) {
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("descricao", descricao);
        request.setAttribute("filial", filial);
        
        request.setAttribute("msgSucess", true);

        EstoqueController.Salvar(descricao, filial);

        List<Estoque> lista = EstoqueController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaEstoque.jsp");
        dispatcher.forward(request, response);
        
        } else {
            request.setAttribute("msgErro", true);
            request.getRequestDispatcher("/adicionarEstoque.jsp")
                    .forward(request, response);
        }
    }

}
