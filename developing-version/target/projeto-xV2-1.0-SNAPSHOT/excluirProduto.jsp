<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Produto - Excluir</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Produto - Excluir</h1>
        <div>
            <form action="excluir-servlet-produto" method="post">
                <input type="hidden" name="escondido" value="xpto" />
                <div>
                    <label>Id</label>
                    <div>
                        <input type="text" name="id" maxlength="10" value="<%=request.getParameter("id")%>" />
                    </div>
                </div>
                <div>
                    <label>Nome Produto</label>
                    <div>
                        <input type="text" name="nomeProduto" maxlength="50" value="<%=request.getParameter("nomeProduto")%>"/>
                    </div>
                </div>
                <button type="submit">Deletar</button>
                
            </form>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'index.jsp'">
        </div>
    </body>
</html>
