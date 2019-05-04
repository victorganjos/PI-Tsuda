package com.projetox.web;

import com.projetox.web.controller.EstoqueController;
import com.projetox.web.model.Estoque;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirEstoque", urlPatterns = {"/excluir-estoque"})
public class ExcluirEstoque extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
        String id = request.getParameter("id");
        String descricao = request.getParameter("descricao");

        request.setAttribute("id", id);
        request.setAttribute("descricao", descricao);

        EstoqueController.Excluir(Integer.parseInt(id));

        List<Estoque> lista = EstoqueController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaEstoque.jsp");
        dispatcher.forward(request, response);
    }
}
