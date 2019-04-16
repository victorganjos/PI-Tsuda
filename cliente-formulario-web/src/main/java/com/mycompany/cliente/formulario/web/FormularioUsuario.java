package com.mycompany.cliente.formulario.web;
/*
import com.mycompany.cliente.formulario.web.dao.UsuarioDAO;
import com.mycompany.cliente.formulario.web.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author johnnys.dsantos
 
@WebServlet(name = "FormularioUsuario", urlPatterns = {"/FormularioUsuario"})
public class FormularioUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("formulario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");

        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("nome", nome);
        request.setAttribute("email", email);

        try {
            Usuario usuario = new Usuario();
            UsuarioDAO usuDao = new UsuarioDAO();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuDao.salvar(usuario);
        } catch (Exception erro) {
            throw new RuntimeException("Erro serio: " + erro);
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultado.jsp");
        dispatcher.forward(request, response);
    }

}
*/
