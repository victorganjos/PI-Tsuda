package com.projetox.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.controller.UsuarioController;
import com.projetox.web.model.Usuario;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AtualizarUsuario", urlPatterns = {"/atualizar-usuario"})
public class AtualizarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        String cargo = request.getParameter("cargo");
        String filial = request.getParameter("filial");

        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("id", id);
        request.setAttribute("nome", nome);
        request.setAttribute("username", username);
        request.setAttribute("senha", senha);
        request.setAttribute("cargo", cargo);
        request.setAttribute("filial", filial);

        UsuarioController.Atualizar(Integer.parseInt(id), nome, username, senha, cargo, filial);

        List<Usuario> lista = UsuarioController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaUsuario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession sessao = request.getSession();

        List<Usuario> lista = UsuarioController.pesquisar(id);
        sessao.setAttribute("acesso", lista);

        List<Usuario> acesso = (List<Usuario>) sessao.getAttribute("acesso");
        request.setAttribute("id", id);
        request.setAttribute("acesso", acesso);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/atualizarUsuario.jsp");
        dispatcher.forward(request, response);
    }
}
