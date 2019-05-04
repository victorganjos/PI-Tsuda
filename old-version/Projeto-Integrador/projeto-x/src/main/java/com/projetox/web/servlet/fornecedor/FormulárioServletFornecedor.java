package com.projetox.web.servlet.fornecedor;

import com.projetox.web.controller.FornecedorController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author victor.ganjos
 */

 @WebServlet(name = "FormularioServletFornecedor", urlPatterns = {"/formulario-servlet-fornecedor"})
public class FormulárioServletFornecedor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("formularioFornecedor.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String nomeFantasia = request.getParameter("nomeFantasia");
        String cnpj = request.getParameter("cnpj");
        
        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("nomeFantasia", nomeFantasia);
        request.setAttribute("cnpj", cnpj);
        
        
        FornecedorController.salvar(nomeFantasia,Long.parseLong(cnpj));
        
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp");
        dispatcher.forward(request, response);   
}
 }