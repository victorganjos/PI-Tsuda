package com.projetox.web.servlet.fornecedor;

import com.projetox.web.controller.FornecedorController;
import com.projetox.web.model.Fornecedor;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultarServletFornecedor", urlPatterns = {"/consultar-servlet-fornecedor"})
public class ConsultarServletFornecedor extends HttpServlet{
    
    
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         
        List<Fornecedor> lista = FornecedorController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaFornecedor.jsp");
        dispatcher.forward(request, response);
    }
}