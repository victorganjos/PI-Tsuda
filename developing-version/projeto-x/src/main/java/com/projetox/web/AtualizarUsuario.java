package com.projetox.web;

import com.projetox.web.controller.ClienteController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.projetox.web.controller.UsuarioController;
import com.projetox.web.model.Usuario;
import java.util.List;




@WebServlet(name = "AtualizarUsuario", urlPatterns = {"/atualizar-usuario"})
public class AtualizarUsuario extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String filial = request.getParameter("filial");
        String cargo = request.getParameter("cargo");
        String setor = request.getParameter("setor");
        String CPF = request.getParameter("CPF");
        String RG = request.getParameter("RG");
        String data = request.getParameter("data");
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String infoAdcionais = request.getParameter("infoAdcionais");
        
        
        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("id", id);
        request.setAttribute("nome", nome);
        request.setAttribute("filial", filial);
        request.setAttribute("cargo", cargo);
        request.setAttribute("setor", setor);
        request.setAttribute("CPF", CPF);
        request.setAttribute("RG", RG);
        request.setAttribute("data", data);
        request.setAttribute("endereco", endereco);
        request.setAttribute("numero", numero);
        request.setAttribute("complemento", complemento);
        request.setAttribute("estado", estado);
        request.setAttribute("cidade", cidade);
        request.setAttribute("bairro", bairro);
        request.setAttribute("cep", cep);
        request.setAttribute("telefone", telefone);
        request.setAttribute("celular", celular);
        request.setAttribute("email", email);
        request.setAttribute("infoAdcionais", infoAdcionais);
        
        UsuarioController.Atualizar(Integer.parseInt(id), nome,filial, cargo, setor, CPF, RG, data, endereco, numero, complemento, estado, cidade, bairro, cep, telefone, celular, email, infoAdcionais);
 
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

        @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         
        int id = Integer.parseInt(request.getParameter("id"));
         
        List<Usuario> lista = UsuarioController.pesquisar(id);
        request.setAttribute("id", id);
        request.setAttribute("consulta", lista);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/AtualizarUsuario.jsp");
        dispatcher.forward(request, response);
    }
}
