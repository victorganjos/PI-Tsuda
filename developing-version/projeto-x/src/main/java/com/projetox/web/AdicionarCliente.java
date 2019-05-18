/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetox.web;


import com.projetox.web.controller.ClienteController;
import com.projetox.web.model.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/cliente-servlet"})
public class AdicionarCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("adicionarCliente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String tipo = request.getParameter("tipo");
        
        
           if (!nome.isEmpty() && !cpf.isEmpty() && !telefone.isEmpty() && !endereco.isEmpty() && !numero.isEmpty() && !estado.isEmpty()&& !cidade.isEmpty() && !cep.isEmpty()) {
        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("nome", nome);
        request.setAttribute("email", email);
        request.setAttribute("cpf", cpf);
        request.setAttribute("telefone", telefone);
        request.setAttribute("endereco", endereco);
        request.setAttribute("numero", numero);
        request.setAttribute("complemento", complemento);
        request.setAttribute("estado", estado);
        request.setAttribute("cidade", cidade);
        request.setAttribute("bairro", bairro);
        request.setAttribute("cep", cep);
        request.setAttribute("tipo", tipo);
    
        request.setAttribute("msgSucess", true);
        
        ClienteController.salvar(nome,email,Long.parseLong(cpf),telefone,endereco,Integer.parseInt(numero),complemento,estado,cidade,bairro,cep, tipo);
        
        
        List<Cliente> lista = ClienteController.consultar();
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/ConsultaCliente.jsp");
        dispatcher.forward(request, response);
        
         } else {
            request.setAttribute("msgErro", true);
            request.getRequestDispatcher("/adicionarCliente.jsp")
                    .forward(request, response);
        }
    }

}
