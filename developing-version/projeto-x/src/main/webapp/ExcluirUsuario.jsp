<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Usuario - Excluir</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Usuario - Excluir</h1>
        <div>
            <form action="excluir-usuario" method="post">
                <input type="hidden" name="escondido" value="xpto" />
                <c:forEach items="${consulta}" var="consulta">
                <div>
                    <div>
                    <label>Id</label>
                        <input type="number" name="id" value="${consulta.id}"/>
                    </div>
                </div>
                <div>
                    <label>Nome</label>
                    <div>
                        <input type="text" name="nome" value="${consulta.nome}"/>
                    </div>
                </div>
                    </c:forEach>
                <button type="submit">Deletar</button>
                
            </form>
  
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'index.jsp'">
        </div>
    </body>
</html>
        