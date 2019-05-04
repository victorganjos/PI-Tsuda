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
            throws ServletException, IOException {
        //recupera as informações do formulario
        String escondido = request.getParameter("escondido");
        String nomeFantasia = request.getParameter("nomeFantasia");
        String cnpj = request.getParameter("cnpj");
        String razaoSocial = request.getParameter("razaoSocial");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String numeroEndereco = request.getParameter("numeroEndereco");
        String complementoEndereco = request.getParameter("complementoEndereco");
        String uf = request.getParameter("uf");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String inscricaoUF = request.getParameter("inscricaoUF");
        String inscricaoMunicipal = request.getParameter("inscricaoMunicipal");
        String ramoAtividade = request.getParameter("ramoAtividade");
        String contatoA = request.getParameter("contatoA");
        String contatoB = request.getParameter("contatoB");
        String site = request.getParameter("site");
        String infoAdicionais = request.getParameter("infoAdicionais");

        //Armazena valores como atributos 
        request.setAttribute("metodoHttp", "POST");
        request.setAttribute("escondido", escondido);
        request.setAttribute("nomeFantasia", nomeFantasia);
        request.setAttribute("cnpj", cnpj);
        request.setAttribute("razaoSocial", razaoSocial);
        request.setAttribute("email", email);
        request.setAttribute("endereco", endereco);
        request.setAttribute("numeroEndereco", numeroEndereco);
        request.setAttribute("complementoEndereco", complementoEndereco);
        request.setAttribute("uf", uf);
        request.setAttribute("cidade", cidade);
        request.setAttribute("bairro", bairro);
        request.setAttribute("cep", cep);
        request.setAttribute("inscricaoUF", inscricaoUF);
        request.setAttribute("inscricaoMunicipal", inscricaoMunicipal);
        request.setAttribute("ramoAtividade", ramoAtividade);
        request.setAttribute("contatoA", contatoA);
        request.setAttribute("contatoB", contatoB);
        request.setAttribute("site", site);
        request.setAttribute("infoAdicionais", infoAdicionais);

        FornecedorController.salvar(nomeFantasia, Long.parseLong(cnpj), razaoSocial, email, endereco, Integer.parseInt(numeroEndereco),
                complementoEndereco, uf, cidade, bairro, Long.parseLong(cep), Long.parseLong(inscricaoUF), Long.parseLong(inscricaoMunicipal),
                ramoAtividade, Long.parseLong(contatoA), Long.parseLong(contatoB), site, infoAdicionais);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/jsp/resultadoFornecedor.jsp");
        dispatcher.forward(request, response);
    }
}
