package com.projetox.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.controller.ClienteController;
import com.projetox.web.model.Cliente;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabio.msilva21
 */
@WebServlet(name = "atualizarServlet", urlPatterns = {"/atualizar-cliente"})
public class AtualizarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String tipo = request.getParameter("tipo");
        String id = request.getParameter("id");
        if (!nome.isEmpty() && !cpf.isEmpty() && !telefone.isEmpty() && !endereco.isEmpty() && !numero.isEmpty() && !estado.isEmpty() && !cidade.isEmpty() && !cep.isEmpty()) {
            //Armazena valores como atributos 
            request.setAttribute("metodoHttp", "POST");
            request.setAttribute("nome", nome);
            request.setAttribute("email", email);
            request.setAttribute("cpf", cpf);
            request.setAttribute("telefone", telefone);
            request.setAttribute("endereco", endereco);
            request.setAttribute("numero", numero);
            request.setAttribute("complemento", complemento);
            request.setAttribute("estado", estado);
            request.setAttribute("cidade", cidade);
            request.setAttribute("bairro", bairro);
            request.setAttribute("cep", cep);
            request.setAttribute("tipo", tipo);
            request.setAttribute("id", id);
            
            request.setAttribute("msgAtualiza", true);

            ClienteController.atualizar(Integer.parseInt(id), nome, email, Long.parseLong(cpf), telefone, endereco, Integer.parseInt(numero),
                    complemento, estado, cidade, bairro, cep, tipo);

            List<Cliente> lista = ClienteController.consultar();
            request.setAttribute("consulta", lista);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaCliente.jsp");
            dispatcher.forward(request, response);

        } else {
            request.setAttribute("msgErro", true);
            request.getRequestDispatcher("/atualizarCliente.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession sessao = request.getSession();

        List<Cliente> lista = ClienteController.consultarPorId(id);
        sessao.setAttribute("acesso", lista);

        List<Cliente> acesso = (List<Cliente>) sessao.getAttribute("acesso");
        request.setAttribute("id", id);
        request.setAttribute("acesso", acesso);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/atualizarCliente.jsp");
        dispatcher.forward(request, response);
    }

}
