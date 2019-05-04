<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Produto - Atualizar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Produto - Atualizar</h1>
    <div>
        <form action="atualizar-servlet-produto" method="post">
            <input type="hidden" name="escondido" value="xpto" />
            <div>
                <label>Id</label>
                <div>
                    <input type="text" name="id"  maxlength="10" value="<%=request.getParameter("id")%>" />
                </div>
            </div>
            <div>
                <label>Nome Produto</label>
                <div>
                    <input type="text" name="nomeProduto" maxlength="80" value="<%=request.getParameter("nomeProduto")%>"/>
                </div>
            </div>
            <div>
                <label>Categoria</label>
                <div>
                    <input type="text" name="categoria" maxlength="80" value="<%=request.getParameter("categoria")%>" />
                </div>
            </div>
            <button type="submit">Salvar</button>
  
        </form>
        <a href="index.jsp">Pagina Inicial</a>
    </div>
</body>
</html>
