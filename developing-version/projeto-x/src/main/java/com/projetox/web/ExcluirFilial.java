package com.projetox.web;

import com.projetox.web.controller.FilialController;
import com.projetox.web.model.Filial;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirFilial", urlPatterns = {"/excluir-filial"})
public class ExcluirFilial extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
        String id = request.getParameter("id");  
        request.setAttribute("id", id);

        FilialController.excluir(Integer.parseInt(id));

        List<Filial> lista = FilialController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaFilial.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        List<Filial> lista = FilialController.consultarPorId(id);
        request.setAttribute("id", id);
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/excluirFilial.jsp");
        dispatcher.forward(request, response);
    }
    
}
