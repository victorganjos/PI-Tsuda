<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Estoque - Excluir</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Estoque - Excluir</h1>
        <div>
            <form action="excluir-estoque" method="post">
                <div>
                    <label>Id</label>
                    <div>
                        <input type="text" name="id" maxlength="10" value="<%=request.getParameter("id")%>" readonly/>
                    </div>
                </div>
                    
                <div>
                    <label>Descrição</label>
                    <div>
                        <input type="text" name="descricao" maxlength="50" value="<%=request.getParameter("descricao")%>" readonly/>
                    </div>
                </div>
                    
                <button type="submit">Excluir</button>

            </form>

            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'index.jsp'">
        </div>
    </body>
</html>
