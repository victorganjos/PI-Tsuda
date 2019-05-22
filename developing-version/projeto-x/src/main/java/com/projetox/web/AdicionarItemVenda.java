/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web;

import com.projetox.web.controller.ProdutoController;
import com.projetox.web.model.Produto;
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
@WebServlet(name = "AdicionarItemVenda", urlPatterns = {"/adicionar-item-venda"})
public class AdicionarItemVenda extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession sessao = request.getSession();

        List<Produto> lista = ProdutoController.consultarPorId(id);
        sessao.setAttribute("consultaProduto", lista);
        
        List<Produto> acesso = (List<Produto>) sessao.getAttribute("acesso");
        request.setAttribute("id", id);
        request.setAttribute("acesso", acesso);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/venda.jsp");
        dispatcher.forward(request, response);
    }
}