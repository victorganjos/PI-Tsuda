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

@WebServlet(name = "ProdutoServlet", urlPatterns = {"/incluir-produto"})
public class AdicionarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("adicionarProduto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informacoes do formulario
        String escondido = request.getParameter("escondido");
        String nomeProd = request.getParameter("nomeProd");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        String valorVenda = request.getParameter("valorVenda");
        String estoqueDisp = request.getParameter("estoqueDisp");
        String situacao = request.getParameter("situacao");

        //Armazena valores como atributos 
        if (!nomeProd.isEmpty() && !categoria.isEmpty() && !valorVenda.isEmpty() && !estoqueDisp.isEmpty() && !situacao.isEmpty()) {
            request.setAttribute("metodoHttp", "POST");
            request.setAttribute("escondido", escondido);
            request.setAttribute("nomeProd", nomeProd);
            request.setAttribute("categoria", categoria);
            request.setAttribute("descricao", descricao);
            request.setAttribute("valorVenda", valorVenda);
            request.setAttribute("estoqueDisp", estoqueDisp);
            request.setAttribute("situacao", situacao);

            request.setAttribute("msgSucess", true);

            ProdutoController.salvar(nomeProd, categoria, descricao, Float.parseFloat(valorVenda), Integer.parseInt(estoqueDisp), situacao);

            List<Produto> lista = ProdutoController.consultar();
            request.setAttribute("consulta", lista);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaProduto.jsp");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("msgErro", true);
            request.getRequestDispatcher("/adicionarProduto.jsp")
                    .forward(request, response);
        }

    }
}
