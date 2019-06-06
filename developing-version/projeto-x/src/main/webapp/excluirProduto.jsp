<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Produto - Excluir</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
<body>
    <div style="background:#4072A6 !important" class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4" style="color: #FCFCFC">Livraria Tades</h1>
        </div>
    </div>    
    <div class="container">
        <form action="excluir-produto" method="post">
            <c:forEach items="${consulta}" var="consulta">
                <input type="hidden" name="tipo" value="f"/>
                <input type="hidden" name="id" maxlength="10" value="${consulta.id}"/>
                <div class="form-row">
                    
                <div class="form-group col-md-6">
                    <label>Nome Produto</label>
                    <input type="text" name="nomeProd" class="form-control" maxlength="50" value="${consulta.nomeProd}">
                </div>
                <div class="form-group col-md-6">
                    <label>Categoria</label>
                    <input  type="text" name="categoria" class="form-control" maxlength="50" value="${consulta.categoria}">
                </div>
                <div class="form-group col-md-6">
                    <label>Descrição</label>
                    <input  type="text" name="descricao" class="form-control" maxlength="50" value="${consulta.descricao}">
                </div>
                <div class="form-group col-md-6">
                    <label>Valor Venda</label>
                    <input type="text" name="valorVenda" class="form-control" maxlength="50" value="${consulta.valorVenda}">
                </div>
                <div class="form-group col-md-6">
                    <label>Estoque Disponível</label>
                    <input type="text" name="estoqueDisp" class="form-control" maxlength="50" value="${consulta.estoqueDisp}">
                </div>
                <div class="form-group col-md-6">
                    <label>Situação</label>
                    <input type="text" name="situacao" class="form-control" maxlength="50" value="${consulta.situacao}">
                </div>

               
                <div class="form-group col-md-4">  
                    <button class="btn btn-info btn-sm" type="submit">Excluir</button>
                </div>
            </c:forEach>
            </div>        
        </form>
    </div>
    <div class="container">
        <br>
        <input class="btn btn-info btn-sm" type="submit" value="Página inicial" OnClick="parent.location.href = 'index.jsp'">
        <input class="btn btn-info btn-sm" type="submit" value="Consultar produto" OnClick="parent.location.href = 'consultar-produto'">
    </div>
</body>
</html>
