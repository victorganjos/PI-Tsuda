<%-- 
    Document   : ConsultaProdutoPorNome
    Created on : 22/05/2019, 16:13:43
    Author     : fabio.msilva21
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    </tr>
                </c:forEach>
            </table>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'homePage.jsp'">
        </div>
    </body>
</html>
