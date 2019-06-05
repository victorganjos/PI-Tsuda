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
import com.projetox.web.model.ItemVenda;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RelatorioVenda", urlPatterns = {"/relatorio-venda"})
public class RelatorioVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/relatorioVenda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Venda venda = new Venda();
        VendaDAO vendaDAO = new VendaDAO();
        
        List<Venda> lista = new ArrayList();
        List<ItemVenda> listaItem = new ArrayList();
        
        try {
            String cliente = request.getParameter("codigo");
            String dataIni = request.getParameter("dataIni");
            String dataFim = request.getParameter("dataFim");

            if (cliente == null) {
                cliente = "";
            }

            if (dataIni == null) {
                dataIni = "";
            }

            if (dataFim == null) {
                dataFim = "";
            }

            lista = VendaController.consultar(cliente, dataIni, dataFim);
            listaItem = vendaDAO.consultarItemMaisVendido(dataIni, dataFim, cliente);
        } catch (Exception ex) {
            Logger.getLogger(RelatorioVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("venda", lista);
        request.setAttribute("itemVendaVendido", listaItem);
        
        HttpSession sessao = request.getSession();
        double somaRelatorio = 0;
        for (Venda li : lista) {
            somaRelatorio += li.getValorTotal();
        }
        
        request.setAttribute("somaRelatorio", somaRelatorio);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/relatorioVenda.jsp");
        dispatcher.forward(request, response);
    }

}
