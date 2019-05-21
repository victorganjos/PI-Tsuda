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
import com.projetox.web.dao.VendaDAO;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.swing.*;

@WebServlet(name = "RelatorioVenda", urlPatterns = {"/relatorio-venda"})
public class RelatorioVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
/*
        String cliente = request.getParameter("codigo");
        JOptionPane.showMessageDialog(null, request.getParameter("codigo"));

        if (cliente == null) {
            cliente = "";
        }

        List<Venda> lista = VendaController.consultar(cliente);
        request.setAttribute("consulta", lista);
         */
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/relatorioVenda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Venda venda = new Venda();
        List<Venda> lista = new ArrayList();
        
        try {
            String cliente = request.getParameter("codigo");
            
            if (cliente == null) {
                cliente = "";
            }
            
            lista = VendaController.consultar(cliente);
        } catch (Exception ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        venda.setId(Integer.parseInt(lista.("id")));
        venda.setCliente(Integer.parseInt(request.getParameter("cliente")));
        venda.setFormaPagamento(request.getParameter("formaPagamento"));

        String dataVenda = request.getParameter("dataVenda");
        try {
            dateVenda = (Date) formatter.parse(dataVenda);
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        venda.setDataVenda(dateVenda);

        venda.setValorTotal(Float.parseFloat(request.getParameter("valorTotal")));

        VendaDAO daoVenda = new VendaDAO();
         */
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/relatorioVenda.jsp");
        dispatcher.forward(request, response);
    }

}
