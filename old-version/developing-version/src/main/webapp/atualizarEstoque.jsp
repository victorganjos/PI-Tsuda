<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Estoque - Atualizar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Estoque - Atualizar</h1>
        <div>
            <form action="atualizar-estoque" method="post">
                <div>
                    <label>Id</label>
                    <div>
                        <input type="text" name="id" maxlength="10" value="<%=request.getParameter("id")%>" readonly/>
                    </div>
                </div>
                <div>
                    <label>Decrição</label>
                    <div>
                        <input type="text" name="descricao" maxlength="50" value="<%=request.getParameter("descricao")%>"/>
                    </div>
                </div>
                <div>
                    <label>Filial</label>
                    <div>
                        <input type="text" name="filial" maxlength="5" value="<%=request.getParameter("filial")%>" />
                    </div>
                </div>
                <button type="submit">Salvar</button>

            </form>
            <a href="index.jsp">Pagina Inicial</a>
        </div>
    </body>
</html>
