<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Estoque - Inclusão</title>
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
        <input type="hidden" name="escondido" value="xpto" />
        <div class="container">
            <h2>Incluir Estoque</h2>
            <br>
            <c:if test="${msgErro == true}">
                <div class="alert-danger" role="alert" style="font-size: 20px"><strong>Preencha todos os campos Obrigatórios!</strong></div>
            </c:if> 
            <br>
            <form action="incluir-estoque" method="post">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Descrição*</label>
                        <input type="text" name="descricao" class="form-control"placeholder="Digite a Descrição:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>Filial*</label>
                        <input type="text" name="filial" class="form-control"placeholder="Digite a filial" maxlength="50" >
                    </div>
                    <div>
                        <label>   Campos com (*) são obrigatórios!</label>
                    </div> 
                    <br>
                    <div class="form-group col-md-6">  
                        <button class="btn btn-info btn-sm" type="submit">Salvar</button>
                        <button class="btn btn-info btn-sm" type="reset" value="Reset">Resetar</button>
                    </div>

                </div>
            </form> 
        </div>
        <div class="container">
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'homePage.jsp'">
        </div>
    </body>
</html>
