/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web;

import com.projetox.web.controller.ProdutoController;
import com.projetox.web.controller.VendaController;
import com.projetox.web.controller.VendaDoisController;
import com.projetox.web.model.Produto;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabio.msilva21
 */
@WebServlet(name = "AdicionarItemVenda", urlPatterns = {"/adicionar-item-venda"})
public class AdicionarItemVenda extends HttpServlet {

    double soma;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String as = request.getParameter("id");
        for (int i = 0; i < as.length(); i++) {
            if (as.charAt(i) == 'a') {
                String aux = as.replaceAll("a", "");

                int id = Integer.parseInt(aux);

                HttpSession sessao = request.getSession();
                soma = 0;
                List<Produto> lista = ProdutoController.consultarPorId(id);
                if (sessao.getAttribute("consultaProduto") == null) {
                    sessao.setAttribute("consultaProduto", lista);
                    for (Produto li : lista) {
                        soma += li.getValorVenda();
                    }
                    sessao.setAttribute("somaVenda", soma);

                } else {
                    List<Produto> acesso = (List<Produto>) sessao.getAttribute("consultaProduto");
                    acesso.add(lista.get(0));
                    request.setAttribute("id", id);
                    request.setAttribute("consultaProduto", acesso);
                    for (Produto li : acesso) {
                        soma += li.getValorVenda();
                    }
                    sessao.setAttribute("somaVenda", soma);
                }

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/venda.jsp");
                dispatcher.forward(request, response);
            } else if (as.charAt(i) == 'b') {

                String aux = as.replaceAll("b", "");
                int id = Integer.parseInt(aux);
                HttpSession sessao = request.getSession();
                List<Produto> acesso = (List<Produto>) sessao.getAttribute("consultaProduto");
                int aux2 = 0;
                for (int j = 0; j < acesso.size(); j++) {
                    if (id == acesso.get(aux2).getId()) {
                        soma -= acesso.get(aux2).getValorVenda();

                    }
                    sessao.setAttribute("somaVenda", soma);
                    if (id == acesso.get(aux2).getId()) {
                        acesso.remove(aux2);
                        break;
                    }
                    aux2++;
                }

                request.setAttribute("id", id);
                request.setAttribute("consultaProduto", acesso);

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/venda.jsp");
                dispatcher.forward(request, response);

            } else if (as.charAt(i) == 'c') {
                
                String aux = as.replaceAll("c", "");
                int id = Integer.parseInt(aux);
                Date data = new Date(System.currentTimeMillis());
                
                
                SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
                
                float somaVendaFinal = (float) soma;
                VendaController.salvar(id, "credito",somaVendaFinal, formatarDate.format(data));
                VendaController.salvar(id, "credito", (float) 10.0, formatarDate.format(data));
                VendaDoisController.salvar(id, soma, formatarDate.format(data));

                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/homePage.jsp");
                dispatcher.forward(request, response);

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        String id = request.getParameter("id");

        VendaController.salvar(Integer.parseInt(id), "credito", (float) 30.31, formatarDate.format(data));

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/homePage.jsp");
        dispatcher.forward(request, response);
    }

}
