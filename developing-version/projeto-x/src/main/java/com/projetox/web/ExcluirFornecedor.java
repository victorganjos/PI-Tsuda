package com.projetox.web;

import com.projetox.web.controller.FornecedorController;
import com.projetox.web.model.Fornecedor;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirFornecedor", urlPatterns = {"/excluir-fornecedor"})
public class ExcluirFornecedor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
        String id = request.getParameter("id");  
        request.setAttribute("id", id);

        FornecedorController.excluir(Integer.parseInt(id));

        List<Fornecedor> lista = FornecedorController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaFornecedor.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        List<Fornecedor> lista = FornecedorController.consultarPorId(id);
        request.setAttribute("id", id);
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/excluirFornecedor.jsp");
        dispatcher.forward(request, response);
    }
    
}
