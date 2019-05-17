<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Usuário - Excluir</title>
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
            <h2>Excluir Usuário</h2>
            <br>
            <form action="excluir-usuario" method="post">
                <c:forEach items="${consulta}" var="consulta">
                    <input type="hidden" name="tipo" value="f"/>
                    <input type="hidden" name="id" maxlength="10" value="${consulta.id}"/>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Nome Completo</label>
                            <input type="text" name="nome" class="form-control" maxlength="50" value="${consulta.nome}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Username</label>
                            <input  type="text" name="username" class="form-control" maxlength="50" value="${consulta.username}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Senha</label>
                            <input  type="password" name="senha" class="form-control" maxlength="50" value="${consulta.senha}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Cargo</label>
                            <input  type="text" name="cargo" class="form-control" maxlength="50" value="${consulta.cargo}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Filial</label>
                            <input type="text" name="filial" class="form-control" maxlength="50" value="${consulta.filial}" readonly>
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
            <input class="btn btn-info btn-sm" type="submit" value="Página inicial" OnClick="parent.location.href = 'homePage.jsp'">
            <input class="btn btn-info btn-sm" type="submit" value="Consultar Usuário" OnClick="parent.location.href = 'consultar-usuario'">
        </div>
    </body>
</html>
