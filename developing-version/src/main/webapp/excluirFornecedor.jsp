<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fornecedor - Excluir</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Fornecedor - Excluir</h1>
        <div>
            <form action="excluir-servlet-fornecedor" method="post">
                <input type="hidden" name="escondido" value="xpto" />
                <div>
                    <label>Id</label>
                    <div>
                        <input type="text" name="id" maxlength="10" value="<%=request.getParameter("id")%>" />
                    </div>
                </div>
                <div>
                    <label>Nome Fantasia</label>
                    <div>
                        <input type="text" name="nomeFantasia" maxlength="50" value="<%=request.getParameter("nomeFantasia")%>"/>
                    </div>
                </div>
                <button type="submit">Deletar</button>
                
            </form>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'indexFornecedor.jsp'">
        </div>
    </body>
</html>
