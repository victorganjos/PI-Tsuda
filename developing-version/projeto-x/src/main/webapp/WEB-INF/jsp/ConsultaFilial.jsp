<%@page import="java.util.ArrayList"%>
<%@page import="com.projetox.web.controller.FilialController"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.projetox.web.model.Filial"%>
<%@page import="com.projetox.web.dao.FilialDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <title>Filial - Consulta</title>
</head>
<body>   
    <div style="background:#4072A6 !important" class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4" style="color: #FCFCFC">Livraria Tades</h1>
        </div>
    </div>
    <div class="cotainer">
        <h1>Consulta de Filial</h1>
        <hr>
        <table class="table table-bordered">
            <tr>
                <th class="text-center">Nome Filial</th>
                <th class="text-center">Email</th>
                <th class="text-center">CNPJ</th>
                <th class="text-center">Telefone</th>
                <th class="text-center">Endereço</th>
                <th class="text-center">Nº</th>
                <th class="text-center" colspan="2">Ação</th>
            </tr>
            <c:forEach var="cat" items="${consulta}" >
            <tr>
                <td class="text-center"><c:out value="${cat.nome}"/></td>
                <td class="text-center"><c:out value="${cat.email}"/></td>
                <td class="text-center"><c:out value="${cat.cnpj}"/></td>
                <td class="text-center"><c:out value="${cat.telefone}"/></td>
                <td class="text-center"><c:out value="${cat.endereco}"/></td>
                <td class="text-center"><c:out value="${cat.numero}"/></td>
                <form method="get" action="${pageContext.request.contextPath}/atualizar-filial">
                    <td class="text-center"><button class="btn btn-warning btn-sm" type="submit" value="${cat.id}" name="id">Atualizar</td>
                </form>
                <form method="get" action="${pageContext.request.contextPath}/excluir-filial">
                    <td class="text-center"><button class="btn btn-danger btn-sm" type="submit" value="${cat.id}" name="id">Excluir</td>
                </form>   
            </tr>
            </c:forEach>
        </table>
        <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'homePage.jsp'">
        <input class="btn btn-info btn-sm" type="submit" value="Cadastrar nova filial" OnClick="parent.location.href = 'adicionarFilial.jsp'">
    </div>
</body>
</html>
