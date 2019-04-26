<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fornecedor - Atualizar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Fornecedor - Atualizar</h1>
    <div>
        <form action="atualizar-servlet-fornecedor" method="post">
            <input type="hidden" name="escondido" value="xpto" />
            <div>
                <label>Id</label>
                <div>
                    <input type="text" name="id"  maxlength="10" value="<%=request.getParameter("id")%>" />
                </div>
            </div>
            <div>
                <label>Nome Fantasia</label>
                <div>
                    <input type="text" name="nomeFantasia" maxlength="50" value="<%=request.getParameter("nomeFantasia")%>"/>
                </div>
            </div>
            <div>
                <label>CNPJ</label>
                <div>
                    <input type="text" name="cnpj" maxlength="80" value="<%=request.getParameter("cnpj")%>" />
                </div>
            </div>
            <button type="submit">Salvar</button>
  
        </form>
        <a href="index.jsp">Pagina Inicial</a>
    </div>
</body>
</html>
