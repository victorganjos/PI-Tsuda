/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web;

import com.projetox.web.controller.ItemVendaController;
import com.projetox.web.controller.ProdutoController;
import com.projetox.web.controller.VendaController;
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
    List<Produto> lista;
    List<Produto> acesso;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String as = request.getParameter("id");
        
        for (int i = 0; i < as.length(); i++) {
            if (as.charAt(i) == 'a') {
                String aux = as.replaceAll("a", "");

                int id = Integer.parseInt(aux);

                soma = 0;
                lista = ProdutoController.consultarPorId(id);
                if (sessao.getAttribute("consultaProduto") == null) {
                    sessao.setAttribute("consultaProduto", lista);
                    for (Produto li : lista) {
                        soma += li.getValorVenda();
                    }
                    sessao.setAttribute("somaVenda", soma);

                } else {
                    acesso = (List<Produto>) sessao.getAttribute("consultaProduto");
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

                acesso = (List<Produto>) sessao.getAttribute("consultaProduto");
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

                sessao.setAttribute("id", id);
                sessao.setAttribute("consultaProduto", acesso);
                sessao.removeAttribute("consulta");
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("/venda.jsp");
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

        String disponivelStr = request.getParameter("opcao");

        String tipoPagamento;

        if (disponivelStr.equals("1")) {
            tipoPagamento = "Debito";
        } else {
            tipoPagamento = "Credito";
        }
        VendaController.salvar(Integer.parseInt(id), tipoPagamento, (float) soma, formatarDate.format(data));

        HttpSession sessao = request.getSession();
        List<Produto> teste = (List<Produto>) sessao.getAttribute("consultaProduto");
        int ultimoId = ItemVendaController.consultId();

        for (Produto ac : teste) {
            ItemVendaController.salvar(ultimoId, ac.getId(), ac.getValorVenda());
        }

        /*  teste.clear();
        lista.clear();
        sessao.setAttribute("consulta", lista);
        acesso.clear();
        soma = 0;
        sessao.setAttribute("somaVenda", soma);*/
        sessao.removeAttribute("consultaProduto"); //Limpar o formulário
        sessao.removeAttribute("somaVenda");//Limpar o formulário
        sessao.removeAttribute("consultaCliente");//Limpar o formulário

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/VendaFinalizada.jsp");
        dispatcher.forward(request, response);
    }

}
