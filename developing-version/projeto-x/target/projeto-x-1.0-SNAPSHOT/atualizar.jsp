<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cliente - Atualizar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Cliente - Atualizar</h1>
    <div>
        <form action="atualizar-servlet" method="post">
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
            <div>
                <label>Email</label>
                <div>
                    <input type="text" name="email" maxlength="80" value="<%=request.getParameter("email")%>" />
                </div>
            </div>
            <button type="submit">Salvar</button>
  
        </form>
        <a href="index.jsp">Pagina Inicial</a>
    </div>
</body>
</html>
