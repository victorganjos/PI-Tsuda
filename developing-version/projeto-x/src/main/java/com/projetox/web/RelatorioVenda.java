package com.projetox.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.controller.VendaController;
import com.projetox.web.model.Venda;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RelatorioVenda", urlPatterns = {"/relatorio-venda"})
public class RelatorioVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario

        VendaController.consultar();

        String teste = "";
        List<Venda> lista = VendaController.consultar();
        request.setAttribute("consulta", lista);

        for (Venda c : lista) {
            teste = c.getFormaPagamento();
            System.out.println(teste);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/relatorioVenda.jsp");
        dispatcher.forward(request, response);
    }/*

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/relatorioVenda.jsp");
        dispatcher.forward(request, response);
    }
     */
}
