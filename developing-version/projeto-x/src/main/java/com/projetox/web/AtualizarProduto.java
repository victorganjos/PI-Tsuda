package com.projetox.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.controller.ProdutoController;
import com.projetox.web.model.Produto;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AtualizarProduto", urlPatterns = {"/atualizar-produto"})
public class AtualizarProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recupera as informações do formulario
        String nomeProd = request.getParameter("nomeProd");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        String valorVenda = request.getParameter("valorVenda");
        String estoqueDisp = request.getParameter("estoqueDisp");
        String situacao = request.getParameter("situacao");
        String id = request.getParameter("id");

        //Armazena valores como atributos 
        if (!nomeProd.isEmpty() && !categoria.isEmpty() && !valorVenda.isEmpty() && !estoqueDisp.isEmpty() && !situacao.isEmpty()) {
            request.setAttribute("metodoHttp", "POST");
            request.setAttribute("id", id);
            request.setAttribute("nomeProd", nomeProd);
            request.setAttribute("categoria", categoria);
            request.setAttribute("descricao", descricao);
            request.setAttribute("valorVenda", valorVenda);
            request.setAttribute("estoqueDisp", estoqueDisp);
            request.setAttribute("situacao", situacao);

            request.setAttribute("msgAtualiza", true);

            ProdutoController.atualizar(Integer.parseInt(id), nomeProd, categoria, descricao, Float.parseFloat(valorVenda), Integer.parseInt(estoqueDisp), situacao);

            List<Produto> lista = ProdutoController.consultar();
            request.setAttribute("consulta", lista);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaProduto.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("msgErro", true);
            request.getRequestDispatcher("/atualizarProduto.jsp")
                    .forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession sessao = request.getSession();

        List<Produto> lista = ProdutoController.consultarPorId(id);

            sessao.setAttribute("acesso", lista);
        

        List<Produto> acessoProd = (List<Produto>) sessao.getAttribute("acesso");
        request.setAttribute("id", id);
        request.setAttribute("acesso", acessoProd);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/atualizarProduto.jsp");
        dispatcher.forward(request, response);
    }

}
