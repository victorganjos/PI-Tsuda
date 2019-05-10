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
        <h1>Estoque - Inclusão</h1>
        <div>
            <form action="incluir-estoque" method="post">
                <div>
                    <label>Descrição</label>
                    <div>
                        <input type="text" name="descricao" maxlength="50" />
                    </div>
                </div>
                <div>
                    <label>Filial</label>
                    <div>
                        <input type="text" name="filial" maxlength="5" />
                    </div>
                </div>
                
                <button type="submit">Salvar</button>
                <button type="reset">Resetar</button>

            </form>
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'index.jsp'">
        </div>
    </body>
</html>
