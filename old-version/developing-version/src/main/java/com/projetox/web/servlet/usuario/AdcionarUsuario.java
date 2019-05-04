package com.projetox.web.servlet.usuario;


import com.projetox.web.controller.UsuarioController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UsuarioServlet", urlPatterns = {"/incluir-usuario"})
public class AdcionarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("AdcionarUsuario.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        
        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("nome", nome);
        request.setAttribute("email", email);
        
        
        UsuarioController.Salvar(nome,email);
        
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaUsuario.jsp");
        dispatcher.forward(request, response);
    }

}
