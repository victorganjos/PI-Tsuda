
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <th class="text-center">ID</th>
                    <th class="text-center">Nome Produto</th><th class="text-center">Categoria</th><th class="text-center">Descrição</th>
                    <th class="text-center">Valor Venda</th><th class="text-center">Estoque Disponível</th><th class="text-center">Situação</th>
                     <th class="text-center" colspan="2">Ação</th>
                </tr>

                <c:forEach var="cat" items="${consulta}" >
                    <tr>

                        <td class="text-center"><c:out value="${cat.id}"/></td>
                        <td class="text-center"><c:out value="${cat.nomeProd}"/></td>
                        <td class="text-center"><c:out value="${cat.categoria}"/></td>
                        <td class="text-center"><c:out value="${cat.descricao}"/></td>
                        <td class="text-center"><c:out value="${cat.valorVenda}"/></td>
                        <td class="text-center"><c:out value="${cat.estoqueDisp}"/></td>
                        <td class="text-center"><c:out value="${cat.situacao}"/></td>

                    <form method="get" action="${pageContext.request.contextPath}/atualizar-produto">
                        <td class="text-center"><button class="btn btn-warning btn-sm" type="submit" value="${cat.id}" name="id">Atualizar</td>
                    </form>
                    <form method="get" action="${pageContext.request.contextPath}/excluir-produto">
                        <td class="text-center"><button class="btn btn-danger btn-sm" type="submit" value="${cat.id}" name="id">Excluir</td>
                    </form>    
                    </tr>
                </c:forEach>
            </table>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'homePage.jsp'">
            <input class="btn btn-info btn-sm" type="submit" value="Cadastrar novo produto" OnClick="parent.location.href = 'adicionarProduto.jsp'">
        </div>
    </body>
</html>
