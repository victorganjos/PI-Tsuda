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

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/incluir-usuario"})
public class AdicionarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("adicionarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario

        String escondido = request.getParameter("escondido");
        String nome = request.getParameter("nome");
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        String cargo = request.getParameter("cargo");
        String filial = request.getParameter("filial");

        if (!nome.isEmpty() && !username.isEmpty() && !senha.isEmpty() && !cargo.isEmpty() && !filial.isEmpty()) {
            //Armazena valores como atributos 
            request.setAttribute("metodoHttp", "POST");
            request.setAttribute("escondido", escondido);
            request.setAttribute("nome", nome);
            request.setAttribute("username", username);
            request.setAttribute("senha", senha);
            request.setAttribute("cargo", cargo);
            request.setAttribute("filial", filial);
            
            request.setAttribute("msgSucess", true);

            UsuarioController.Salvar(nome, username, senha, cargo, filial);

            List<Usuario> lista = UsuarioController.consultar();
            request.setAttribute("consulta", lista);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaUsuario.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("msgErro", true);
            request.getRequestDispatcher("/adicionarUsuario.jsp")
                    .forward(request, response);
        }

    }

}
