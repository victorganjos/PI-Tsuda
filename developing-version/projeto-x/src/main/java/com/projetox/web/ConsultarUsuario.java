package com.projetox.web;

import com.projetox.web.controller.UsuarioController;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.model.Usuario;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "ConsultarUsuario", urlPatterns = {"/consultar-usuario"})
public class ConsultarUsuario extends HttpServlet{
    
    
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         
        List<Usuario> lista = UsuarioController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaUsuario.jsp");
        dispatcher.forward(request, response);
    }

}
