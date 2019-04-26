package com.projetox.web.servlet.usuario;

import com.projetox.web.controller.UsuarioController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ExcluirServletUsuario", urlPatterns = {"/excluir-servlet-usuario"})
public class ExcluirUsuario extends HttpServlet{
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        request.setAttribute("id", id);
        request.setAttribute("nome", nome);
        
        UsuarioController.Excluir(Integer.parseInt(id));
 
       RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaUsuario.jsp");
        dispatcher.forward(request, response);
    }
}
    
