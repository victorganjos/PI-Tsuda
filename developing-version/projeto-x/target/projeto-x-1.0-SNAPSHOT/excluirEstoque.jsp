<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

                <c:forEach items="${consulta}" var="consulta">
                    <div>
                        <label>Id</label>
                        <div>
                            <input type="text" name="id" maxlength="10" value="${consulta.id}" readonly/>
                        </div>
                    </div>
                    <div>
                        <label>Decrição</label>
                        <div>
                            <input type="text" name="descricao" maxlength="50" value="${consulta.descricao}"/>
                        </div>
                    </div>
                    <div>
                        <label>Filial</label>
                        <div>
                            <input type="text" name="filial" maxlength="5" value="${consulta.filial}" />
                        </div>
                    </div>               
                </c:forEach>

                <button type="submit">Excluir</button>
            </form>

            <br>

            <input class="btn btn-info btn-sm" type="submit" value="Página inicial" OnClick="parent.location.href = 'homePage.jsp'">
            <input class="btn btn-info btn-sm" type="submit" value="Consultar estoque" OnClick="parent.location.href = 'consultar-estoque'">
        </div>
    </body>
</html>
