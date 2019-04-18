package com.projetox.web.servlet.fornecedor;

import com.projetox.web.controller.FornecedorController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    @WebServlet(name = "AtualizarServletFornecedor", urlPatterns = {"/atualizar-servlet-fornecedor"})
public class AtualizarServletFornecedor extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String nomeFantasia = request.getParameter("nomeFantasia");
        String cnpj = request.getParameter("cnpj");
        String id = request.getParameter("id");
        
        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("nomeFantasia", nomeFantasia);
        request.setAttribute("cnpj", cnpj);
        request.setAttribute("id", id);
        
        FornecedorController.atualizar(Integer.parseInt(id),nomeFantasia,Long.parseLong(cnpj));
 
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp");
        dispatcher.forward(request, response);
    }
    }
