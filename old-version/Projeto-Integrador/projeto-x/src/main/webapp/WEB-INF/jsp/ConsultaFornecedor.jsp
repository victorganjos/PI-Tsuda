<%@page import="java.util.ArrayList"%>
<%@page import="com.projetox.web.controller.FornecedorController"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.projetox.web.model.Fornecedor"%>
<%@page import="com.projetox.web.dao.FornecedorDAO"%>
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
        <h1>Consulta Fornecedor</h1>
        <hr>

        <table class="table table-bordered">
            <tr>
                <th class="text-center">Id</th><th class="text-center">Nome Fantasia</th><th class="text-center">CNPJ</th><th class="text-center" colspan="2">Ação</th>
            </tr>

            <c:forEach var="cat" items="${consulta}" >
                <tr>
                    <td class="text-center"><c:out value="${cat.id}"/></td>
                    <td class="text-center"><c:out value="${cat.nomeFantasia}"/></td>
                    <td class="text-center"><c:out value="${cat.cnpj}"/></td>
                    <td class="text-center"><a class="btn btn-warning btn-sm" href=atualizarFornecedor.jsp?id=${cat.id}&nomeFantasia=${cat.nomeFantasia}&cnpj=${cat.cnpj}>Atualizar</td>
                    <td class="text-center"><a class="btn btn-danger btn-sm" href="excluirFornecedor.jsp?id=${cat.id}&nomeFantasia=${cat.nomeFantasia}">Excluir</td>
                </tr>
            </c:forEach>
        </table>
        <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href='index.jsp'">
        </div>
    </body>
</html>
