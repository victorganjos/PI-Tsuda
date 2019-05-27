<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Estoque - Excluir</title>
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
            <h2>Excluir Estoque</h2>
            <br>
            <form action="excluir-estoque" method="post">
                <c:forEach items="${consulta}" var="consulta">
                    <input type="hidden" name="tipo" value="f"/>
                    <input type="hidden" name="id" maxlength="10" value="${consulta.id}"/>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Descrição</label>
                            <input type="text" name="descricao" class="form-control" maxlength="50" value="${consulta.descricao}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Filial</label>
                            <input  type="text" name="filial" class="form-control" maxlength="50" value="${consulta.filial}" readonly>
                        </div>
                        <div class="form-group col-md-4">  
                            <button class="btn btn-info btn-sm" Onclick="alerta()" type="submit">Excluir</button>
                        </div>
                    </c:forEach>
                </div> 
                <script>
                    function alerta()
                    {
                        alert("Exclusão do Estoque realizada com sucesso!");
                    }
                </script>
            </form>
        </div>
        <div class="container">
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Página inicial" OnClick="parent.location.href = 'homePage.jsp'">
            <input class="btn btn-info btn-sm" type="submit" value="Consultar Estoque" OnClick="parent.location.href = 'consultar-estoque'">
        </div>
    </body>
</html>
