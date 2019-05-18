
<%@page import="java.util.ArrayList"%>
<%@page import="com.projetox.web.controller.ClienteController"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.projetox.web.model.Cliente"%>
<%@page import="com.projetox.web.dao.ClienteDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div style="background:#4072A6 !important" class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4" style="color: #FCFCFC">Livraria Tades</h1>
            </div>
        </div>
        <div class="cotainer">
            <h1>Consulta de Cliente</h1>
            <hr>
            <c:if test="${msgSucess == true}">
                <div class="alert-success" role="alert" style="font-size: 25px"><strong>Cliente Cadastrado com Sucesso</strong></div>
            </c:if>
            <c:if test="${msgAtualiza == true}">
                <div class="alert-success" role="alert" style="font-size: 25px"><strong>Cliente Atualizado com Sucesso</strong></div>
            </c:if>
            <br>
            <table class="table table-bordered">
                <tr>
                    <th class="text-center">Nome CLIENTE</th>
                    <th class="text-center">Email</th>
                    <th class="text-center">CPF</th>
                    <th class="text-center">Telefone</th>
                    <th class="text-center">Endereço</th>
                    <th class="text-center">Nº</th>
                    <th class="text-center" colspan="2">Ação</th>
                </tr>
                <c:forEach var="cat" items="${consulta}" >
                    <tr>
                        <td class="text-center"><c:out value="${cat.nome}"/></td>
                        <td class="text-center"><c:out value="${cat.email}"/></td>
                        <td class="text-center"><c:out value="${cat.cpf}"/></td>
                        <td class="text-center"><c:out value="${cat.telefone}"/></td>
                        <td class="text-center"><c:out value="${cat.endereco}"/></td>
                        <td class="text-center"><c:out value="${cat.numero}"/></td>
                    <form method="get" action="${pageContext.request.contextPath}/atualizar-cliente">
                        <td class="text-center"><button class="btn btn-warning btn-sm" type="submit" value="${cat.id}" name="id">Atualizar</td>
                    </form>
                    <form method="get" action="${pageContext.request.contextPath}/excluir-cliente">
                        <td class="text-center"><button class="btn btn-danger btn-sm" type="submit" value="${cat.id}" name="id">Excluir</td>
                    </form>   
                    </tr>
                </c:forEach>
            </table>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'homePage.jsp'">
        </div>
    </body>
</html>
