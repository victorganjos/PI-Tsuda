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

        <div style="background:#4072A6 !important" class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4" style="color: #FCFCFC">Livraria Tades</h1>
            </div>
        </div>
        <div>
            <h2 style="text-align: center">Venda</h2>
            <div  style="width: 400px">
                <form action="${pageContext.request.contextPath}/consultar-produto-por-nome" method="get">
                    <div class="form-row">
                        <label>Produto</label>
                        <input type="text" name="produto" class="form-control is-valid" placeholder="Produto" required>
                    </div>
                    <button class="btn btn-primary" type="submit">Enviar</button>           
                </form>
                <table class="table table-bordered">
                    <tr>
                        <th class="text-center">Nome Produto</th><th class="text-center">Categoria</th><th class="text-center">Descrição</th>
                        <th class="text-center">Valor Venda</th><th class="text-center">Estoque Disponível</th><th class="text-center">Situação</th>
                        <th class="text-center" colspan="2">Ação</th>
                    </tr>     
                    <c:forEach var="cat" items="${consulta}" >
                        <tr>
                            <td class="text-center"><c:out value="${cat.nomeProd}"/></td>
                            <td class="text-center"><c:out value="${cat.categoria}"/></td>
                            <td class="text-center"><c:out value="${cat.descricao}"/></td>
                            <td class="text-center"><c:out value="${cat.valorVenda}"/></td>
                            <td class="text-center"><c:out value="${cat.estoqueDisp}"/></td>
                            <td class="text-center"><c:out value="${cat.situacao}"/></td>
                        <form method="get" action="${pageContext.request.contextPath}/adicionar-item-venda">
                        <td class="text-center"><button class="btn btn-warning btn-sm" type="submit" value="${cat.id}" name="id">Atualizar</td>
                    </form>                       
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div>
                <h3>Lista de Produtos</h3>
                <div  style="width: 400px">
                    
                    <table class="table table-bordered">
                        <tr>
                            <th class="text-center">Nome Produto</th><th class="text-center">Categoria</th><th class="text-center">Descrição</th>
                            <th class="text-center">Valor Venda</th><th class="text-center">Estoque Disponível</th><th class="text-center">Situação</th>
                            <th class="text-center" colspan="2">Ação</th>
                        </tr>     
                        <c:forEach var="cat" items="${consultaProduto}" >
                            <tr>
                                <td class="text-center"><c:out value="${cat.nomeProd}"/></td>
                                <td class="text-center"><c:out value="${cat.categoria}"/></td>
                                <td class="text-center"><c:out value="${cat.descricao}"/></td>
                                <td class="text-center"><c:out value="${cat.valorVenda}"/></td>
                                <td class="text-center"><c:out value="${cat.estoqueDisp}"/></td>
                                <td class="text-center"><c:out value="${cat.situacao}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                   
                </div>	
            </div>
            <div>
                <div  style="width: 400px">
                    <form action="${pageContext.request.contextPath}/consultar-cliente-por-nome" method="get">
                        <div class="form-row">
                            <label>Cliente</label>
                            <input type="text" name="cliente" class="form-control is-valid" placeholder="CPF" required>
                        </div>
                        <button class="btn btn-primary" type="submit">Enviar</button>           
                    </form>
                    <table class="table table-bordered">
                        <tr>
                            <th class="text-center">Nome CLIENTE</th>
                            <th class="text-center" colspan="2">Ação</th>
                        </tr>
                        <c:forEach var="cat" items="${consultaCliente}" >
                            <tr>
                                <td class="text-center"><c:out value="${cat.nome}"/></td>

                            </tr>
                        </c:forEach>
                    </table>
                </div>	
            </div>
    </body>
</html>
