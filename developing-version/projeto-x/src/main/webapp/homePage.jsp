<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:choose>
            <c:when test="${sessionScope.usuario != null}">
                <div class="barra">
                    <nav>
                        <div class="item">
                            <input type="checkbox" id="check1">
                            <label for="check1">Cadastros</label>
                            <ul>
                                <li><a href="adicionarUsuario.jsp" >Cadastrar Usuário</a></li>
                                <li><a href="adicionarCliente.jsp">Cadastrar Cliente</a></li>
                                <li><a href="adicionarFornecedor.jsp">Cadastrar Fornecedor</a></li>
                            </ul>
                        </div>
                        <div class="item">
                            <input type="checkbox" id="check2">
                            <label for="check2">Consultas</label>
                            <ul>
                                <li><a href="protegido/consultar-usuario">Consultar Usuário</a></li>
                                <li><a href="consultar-cliente">Consultar Cliente</a></li>
                                <li><a href="consultar-fornecedor">Consultar Fornecedor</a></li>
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
                        <div class="item">
                            <label><a class="sair" href="${pageContext.request.contextPath}/logout">Sair</a></label>
                        </div>
                    </nav>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <p>Usuário não fez login</p>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
