package com.projetox.web.servlet.estoque;

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

@WebServlet(name = "AtualizarEstoque", urlPatterns = {"/atualizar-estoque"})
public class AtualizarEstoque extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recupera as informações do formulario
        String descricao = request.getParameter("descricao");
        String filial = request.getParameter("filial");
        String id = request.getParameter("id");

        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("descricao", descricao);
        request.setAttribute("filial", filial);
        request.setAttribute("id", id);

        EstoqueController.Atualizar(Integer.parseInt(id), descricao, filial);

        List<Estoque> lista = EstoqueController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaEstoque.jsp");
        dispatcher.forward(request, response);
    }

}
