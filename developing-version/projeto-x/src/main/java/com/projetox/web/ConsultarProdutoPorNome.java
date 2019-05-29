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
@WebServlet(name = "ConsultarProdutoPorNome", urlPatterns = {"/consultar-produto-por-nome"})
public class ConsultarProdutoPorNome extends HttpServlet{
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         
         String nome = request.getParameter("produto");
         HttpSession sessao = request.getSession();
        List<Produto> lista = ProdutoController.consultarPorNome(nome);
        sessao.setAttribute("consulta", lista);
        

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/venda.jsp");
        dispatcher.forward(request, response);
    }
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         HttpSession sessao = request.getSession();
         String nome = request.getParameter("produto");
         
         
         sessao.setAttribute("produto", nome);
        List<Produto> lista = ProdutoController.consultarPorNome(nome);
        sessao.setAttribute("consulta", lista);
        
        int teste2 = 99;
        for(Produto c: lista){
            teste2 = c.getId();
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/venda.jsp");
        dispatcher.forward(request, response);
    }

}
