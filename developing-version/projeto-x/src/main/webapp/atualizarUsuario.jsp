<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Usuário - Atualizar</title>
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
            <h2>Atualizar Usuário</h2>
            <br>
            <form action="atualizar-usuario" method="post">
                <c:if test="${sessionScope.acesso != null && !sessionScope.acesso.isEmpty()}">
                    <c:forEach items="${sessionScope.acesso}" var="acesso">
                        <input type="hidden" name="id" maxlength="10" value="${acesso.id}"/>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Nome Completo*</label>
                                <input type="text" name="nome" class="form-control" maxlength="50" value="${acesso.nome}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Username*</label>
                                <input  type="text" name="username" class="form-control" maxlength="50" value="${acesso.username}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Senha*</label>
                                <input  type="password" name="senha" class="form-control" maxlength="50" value="${acesso.senha}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Cargo*</label>
                                <input  type="text" name="cargo" class="form-control" maxlength="50" value="${acesso.cargo}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Filial*</label>
                                <input type="text" name="filial" class="form-control" maxlength="50" value="${acesso.filial}" >
                            </div>
                            <div>
                                <label>   Campos com (*) são obrigatórios!</label>
                            </div>
                            <c:if test="${msgErro != null}">
                                <div class="erro" color="red" ><c:out value="${msgErro}" /></div>
                            </c:if>
                            <br>
                            <div class="form-group col-md-6">  
                                <button class="btn btn-info btn-sm" type="submit">Salvar</button>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>    
            </form>
        </div>
        <div class="container">
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Página inicial" OnClick="parent.location.href = 'homePage.jsp'">
            <input class="btn btn-info btn-sm" type="submit" value="Consultar Usuários" OnClick="parent.location.href = 'consultar-usuario'">
        </div>
    </body>
</html>
