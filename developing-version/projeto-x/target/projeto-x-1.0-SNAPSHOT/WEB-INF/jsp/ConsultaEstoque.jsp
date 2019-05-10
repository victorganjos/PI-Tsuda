<%@page import="java.util.ArrayList"%>
<%@page import="com.projetox.web.controller.EstoqueController"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.projetox.web.model.Estoque"%>
<%@page import="com.projetox.web.dao.EstoqueDAO"%>
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
            <h1>Consulta de Estoques</h1>
            <hr>

            <table class="table table-bordered">
                <tr>
                    <th class="text-center">Id</th><th class="text-center">Descrição</th><th class="text-center">Filial</th><th class="text-center" colspan="2">Ação</th>
                </tr>

                <c:forEach var="cat" items="${consulta}" >
                    <tr>
                        <td class="text-center"><c:out value="${cat.id}"/></td>
                        <td class="text-center"><c:out value="${cat.descricao}"/></td>
                        <td class="text-center"><c:out value="${cat.filial}"/></td>
                    <form method="get" action="${pageContext.request.contextPath}/atualizar-estoque">
                        <td class="text-center"><button class="btn btn-warning btn-sm" type="submit" value="${cat.id}" name="id">Atualizar</td>
                    </form>
                    <form method="get" action="${pageContext.request.contextPath}/excluir-estoque">
                        <td class="text-center"><button class="btn btn-danger btn-sm" type="submit" value="${cat.id}" name="id">Excluir</td>
                    </form>   
                    </tr>
                </c:forEach>
            </table>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'index.jsp'">
        </div>
    </body>
</html>
