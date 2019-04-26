
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
        <div class="cotainer">
        <h1>Consulta</h1>
        <hr>

        <table class="table table-bordered">
            <tr>
                <th class="text-center">Id</th><th class="text-center">Nome</th><th class="text-center">Email</th><th class="text-center" colspan="2">Ação</th>
            </tr>

            <c:forEach var="cat" items="${consulta}" >
                <tr>
                    <td class="text-center"><c:out value="${cat.id}"/></td>
                    <td class="text-center"><c:out value="${cat.nome}"/></td>
                    <td class="text-center"><c:out value="${cat.email}"/></td>
                    <td class="text-center"><a class="btn btn-warning btn-sm" href=atualizar.jsp?id=${cat.id}&nome=${cat.nome}&email=${cat.email}>Atualizar</td>
                    <td class="text-center"><a class="btn btn-danger btn-sm" href="excluir.jsp?id=${cat.id}&nome=${cat.nome}">Excluir</td>
                </tr>
            </c:forEach>
        </table>
        <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href='index.jsp'">
        </div>
    </body>
</html>
