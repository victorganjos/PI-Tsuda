/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web;

import com.projetox.web.controller.UsuarioController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.projetox.web.model.Usuario;
import java.util.List;
/**
 *
 * @author fabio.msilva21
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/loginPage.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String senhaAberta = request.getParameter("senha");

        String teste = null;
        String senhaTeste = "";
        List<Usuario> lista = UsuarioController.consultarPorUsername(username);
        
        for(Usuario c: lista) {
            teste = c.getUsername();
            senhaTeste = c.getSenha();
        }
        
        if(teste != null && senhaTeste.equals(senhaAberta)){
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", teste);
            //response.sendRedirect("adicionarFornecedor");
            request.getRequestDispatcher("/homePage.jsp")
                    .forward(request, response);
        }else {
            request.setAttribute("msgErro", "Usuario ou senha inválido");
            request.getRequestDispatcher("/loginPage.jsp")
                    .forward(request, response);
        }

    }

}
