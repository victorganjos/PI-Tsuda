<%-- 
    Document   : venda
    Created on : 22/05/2019, 15:34:44
    Author     : fabio.msilva21
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Venda</h2>
        <div>

            <div class="container" style="width: 400px">
                <form action="${pageContext.request.contextPath}/consultar-produto-por-nome" method="post">
                    <div class="form-row">
                        <label>Produto</label>
                        <input type="text" name="produto" class="form-control is-valid" placeholder="Produto" required>
                    </div>
                    <button class="btn btn-primary" type="submit">Enviar</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/consultar-produto-por-nome" method="get">
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
                    </form>
                
            </div>	

        </div>

    </body>
</html>
