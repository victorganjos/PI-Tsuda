package com.projetox.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.controller.EstoqueController;
import com.projetox.web.model.Estoque;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AtualizarEstoque", urlPatterns = {"/atualizar-estoque"})
public class AtualizarEstoque extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String id = request.getParameter("id");
        String descricao = request.getParameter("descricao");
        String filial = request.getParameter("filial");
        
        if (!descricao.isEmpty() && !filial.isEmpty()){
        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("id", id);
        request.setAttribute("descricao", descricao);
        request.setAttribute("filial", filial);
        
        request.setAttribute("msgAtualiza", true);
        

        EstoqueController.Atualizar(Integer.parseInt(id), descricao, filial);

        List<Estoque> lista = EstoqueController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaEstoque.jsp");
        dispatcher.forward(request, response);
    } else {
            request.setAttribute("msgErro", true);
            request.getRequestDispatcher("/atualizarEstoque.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession sessao = request.getSession();

        List<Estoque> lista = EstoqueController.pesquisar(id);
        sessao.setAttribute("acesso", lista);

        List<Estoque> acesso = (List<Estoque>) sessao.getAttribute("acesso");
        request.setAttribute("id", id);
        request.setAttribute("acesso", acesso);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/atualizarEstoque.jsp");
        dispatcher.forward(request, response);
    }
}
