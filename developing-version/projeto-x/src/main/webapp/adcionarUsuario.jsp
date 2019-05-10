<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Adcionar Usuario</title>
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
            <form action="incluir-usuario" method="post">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Nome Completo</label>
                        <input type="text" name="nome" class="form-control"placeholder="Digite o nome:" maxlength="50" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Username</label>
                        <input type="text" name="username" class="form-control"placeholder="Digite o nome de usuário:" maxlength="50" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Senha</label>
                        <input type="password" name="senha" class="form-control"placeholder="Digite a senha" maxlength="50" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Cargo</label>
                        <input type="text" name="cargo" class="form-control"placeholder="Digite o cargo" maxlength="50" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Filial</label>
                        <input type="text" name="filial" class="form-control"placeholder="Digite a filial" maxlength="50" required>
                    </div>
                    <div class="form-group col-md-6">  
                        <button class="btn btn-info btn-sm" type="submit">Salvar</button>
                        <button class="btn btn-info btn-sm" type="reset" value="Reset">Resetar</button>
                    </div>
                </div>
            </form> 
        </div>
        <div class="container">
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'index.jsp'">
        </div>
    </body>
</html>
