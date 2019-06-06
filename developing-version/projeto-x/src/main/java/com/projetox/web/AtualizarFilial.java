package com.projetox.web;

import com.projetox.web.controller.FilialController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.model.Filial;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AtualizarFilial", urlPatterns = {"/atualizar-filial"})
public class AtualizarFilial extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recupera as informações do formulario
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cnpj = request.getParameter("cnpj");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String tipo = request.getParameter("tipo");

        if (!nome.isEmpty() && !cnpj.isEmpty() && !telefone.isEmpty() && !endereco.isEmpty() && !numero.isEmpty() && !estado.isEmpty() && !cidade.isEmpty() && !cep.isEmpty()) {

            //Armazena valores como atributos 
            request.setAttribute("metodoHttp", "POST");
            request.setAttribute("id", id);
            request.setAttribute("nome", nome);
            request.setAttribute("email", email);
            request.setAttribute("cnpj", cnpj);
            request.setAttribute("telefone", telefone);
            request.setAttribute("endereco", endereco);
            request.setAttribute("numero", numero);
            request.setAttribute("complemento", complemento);
            request.setAttribute("estado", estado);
            request.setAttribute("cidade", cidade);
            request.setAttribute("bairro", bairro);
            request.setAttribute("cep", cep);
            request.setAttribute("tipo", tipo);

            FilialController.atualizar(Integer.parseInt(id), nome, email, Long.parseLong(cnpj), telefone, endereco, Integer.parseInt(numero), complemento, estado, cidade, bairro, cep, tipo);

            List<Filial> lista = FilialController.consultar();
            request.setAttribute("consulta", lista);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaFilial.jsp");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("msgErro", "Preencha todos os campos obrigatórios");
            request.getRequestDispatcher("/atualizarFilial.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession sessao = request.getSession();

        List<Filial> lista = FilialController.consultarPorId(id);
        sessao.setAttribute("acesso", lista);

        List<Filial> acesso = (List<Filial>) sessao.getAttribute("acesso");
        request.setAttribute("id", id);
        request.setAttribute("acesso", acesso);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/atualizarFilial.jsp");
        dispatcher.forward(request, response);
    }
}
