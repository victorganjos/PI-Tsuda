package com.projetox.web;

import com.projetox.web.controller.UsuarioController;
import com.projetox.web.model.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "excluirUsuario", urlPatterns = {"/excluir-usuario"})
public class ExcluirUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        request.setAttribute("id", id);
        request.setAttribute("nome", nome);

        UsuarioController.Excluir(Integer.parseInt(id));

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

        List<Usuario> lista = UsuarioController.pesquisar(id);
        request.setAttribute("id", id);
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/excluirUsuario.jsp");
        dispatcher.forward(request, response);
    }
}
