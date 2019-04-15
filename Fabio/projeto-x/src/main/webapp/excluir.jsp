<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cliente - Excluir</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Cliente - Excluir</h1>
        <div>
            <form action="excluir-servlet" method="post">
                <input type="hidden" name="escondido" value="xpto" />
                <div>
                    <label>Id</label>
                    <div>
                        <input type="text" name="id" maxlength="10" value="<%=request.getParameter("id")%>" />
                    </div>
                </div>
                <div>
                    <label>Nome</label>
                    <div>
                        <input type="text" name="nome" maxlength="50" value="<%=request.getParameter("nome")%>"/>
                    </div>
                </div>
                <button type="submit">Deletar</button>
                
            </form>
  exit
  
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'index.jsp'">
        </div>
    </body>
</html>
