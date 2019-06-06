<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Estoque - Atualizar</title>
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
            <h2>Atualizar Estoque</h2>
            <br>
            <c:if test="${msgErro == true}">
                <div class="alert-danger" role="alert" style="font-size: 20px"><strong>Preencha todos os campos Obrigatórios!</strong></div>
            </c:if> 
            <br>
            <form action="atualizar-estoque" method="post">
                <c:if test="${sessionScope.acesso != null && !sessionScope.acesso.isEmpty()}">
                    <c:forEach items="${sessionScope.acesso}" var="acesso">
                        <input type="hidden" name="id" maxlength="10" value="${acesso.id}"/>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Descrição*</label>
                                <input type="text" name="descricao" class="form-control" maxlength="50" value="${acesso.descricao}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Filial*</label>
                                <input  type="text" name="filial" class="form-control" maxlength="50" value="${acesso.filial}" >
                            </div>
                            <div>
                                <label>   Campos com (*) são obrigatórios!</label>
                            </div>
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
            <input class="btn btn-info btn-sm" type="submit" value="Consultar Estoque" OnClick="parent.location.href = 'consultar-estoque'">
        </div>
    </body>
</html>