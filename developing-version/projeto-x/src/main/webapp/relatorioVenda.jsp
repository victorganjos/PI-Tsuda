<%-- 
    Document   : relatorioVenda
    Created on : 17/05/2019, 19:46:01
    Author     : caio.hcpereira
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.projetox.web.controller.VendaController"%>
<%@page import="java.util.List"%>
<%@page import="com.projetox.web.model.Venda"%>
<%@page import="com.projetox.web.dao.VendaDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div style="background:#4072A6" class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4" style="color: #FCFCFC">Livraria Tades</h1>
            </div>
        </div>

        <div class="cotainer">
            <h1>Relatório de Vendas</h1>
            <hr>
            <br>
            <div class="form-row">
                <div class="form-group col-md-10">
                    <label>Data inicial: &nbsp </label>
                    <input  id="date" type="date" name="dataIni"> &nbsp&nbsp

                    <label>Data final: &nbsp </label>
                    <input  id="date" type="date" name="dataFim"> &nbsp&nbsp

                    <label>Cliente </label>
                    <input type="text" name="id" maxlength="10"> 

                    <br><br>
                </div>
            </div>
            <table class="table table-bordered">
                <tr>
                    <th class="text-center">Id Pedido</th>
                    <th class="text-center">Cliente</th>
                    <th class="text-center">Forma de Pagamento</th>
                    <th class="text-center">Valor Total</th>
                </tr>
                <form method="get" action="relatorio-venda">
                    <button class="btn btn-warning btn-sm" type="submit" >Consultar </button>
                    <c:forEach var="cat" items="${consulta}">
                        <tr>
                            <td class="text-center"><c:out value="${cat.Id}"/></td>
                        </tr>
                    </c:forEach>
                </form>
            </table>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'homePage.jsp'">
        </div>
    </body>
</html>
