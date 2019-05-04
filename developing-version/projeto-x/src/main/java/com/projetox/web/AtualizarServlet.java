package com.projetox.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.controller.ClienteController;



/**
 *
 * @author fabio.msilva21
 */

@WebServlet(name = "atualizarServlet", urlPatterns = {"/atualizar-servlet"})
public class AtualizarServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        
        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("nome", nome);
        request.setAttribute("email", email);
        request.setAttribute("id", id);
        
        ClienteController.Atualizar(Integer.parseInt(id),nome,email);
 
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp");
        dispatcher.forward(request, response);
    }

}
