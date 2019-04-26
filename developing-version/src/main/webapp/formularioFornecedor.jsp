<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fornecedor - Inclusão</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Fornecedor - Inclusão</h1>
    <div>
        <form action="formulario-servlet-fornecedor" method="post">
            <input type="hidden" name="escondido" value="xpto" />
            <div>
                <label>Nome Fornecedor</label>
                <div>
                    <input type="text" name="nomeFantasia" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Cnpj</label>
                <div>
                    <input type="text" name="cnpj" maxlength="80" />
                </div>
            </div>
            <button type="submit">Salvar</button>
            <button type="reset">Resetar</button>
            
        </form>
        <br>

        <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href='index.jsp'">
    </div>
</body>
</html>
