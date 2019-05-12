<%-- 
    Document   : homePage
    Created on : 11/05/2019, 23:27:39
    Author     : Fabio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styleMenu.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>
    </head>
    <body>
        <div class="barraSup" style="background:#4072A6 !important">
            <div>
                <h1 style="color: #FCFCFC">Livraria Tades</h1>
            </div>
        </div>
        <div class="barra">
            <nav>
                <div class="item">
                    <input type="checkbox" id="check1">
                    <label for="check1">Cadastros</label>
                    <ul>
                        <li><a href="adcionarUsuario.jsp" >Cadastrar Usuário</a></li>
                        <li><a href="formulario.jsp">Cadastrar Cliente</a></li>
                        <li><a href="adicionarFornecedor.jsp">Cadastrar Fornecedor</a></li>
                    </ul>
                </div>
                <div class="item">
                    <input type="checkbox" id="check2">
                    <label for="check2">Consultas</label>
                    <ul>
                        <li><a href="/WEB-INF/jsp/ConsultaUsuario.jsp">Consultar Usuário</a></li>
                        <li><a href="/WEB-INF/jsp/Consulta.jsp">Consultar Cliente</a></li>
                        <li><a href="/WEB-INF/jsp/ConsultaFornecedor.jsp">Consultar Fornecedor</a></li>
                    </ul>
                </div>
                <div class="item">
                    <input type="checkbox" id="check3">
                    <label for="check3">Estoque</label>
                    <ul>
                        <li><a href="adicionarEstoque.jsp">Incluir Estoque</a></li>
                        <li><a href="/WEB-IN/jsp/ConsultaEstoque.jsp">Consultar Estoque</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </body>
</html>
