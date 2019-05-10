<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Estoque - Atualizar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <h1>Estoque - Atualizar</h1>
        <div>
            <form action="atualizar-estoque" method="post">
                <c:if test="${sessionScope.acesso != null && !sessionScope.acesso.isEmpty()}">
                    <c:forEach items="${sessionScope.acesso}" var="acesso">
                        <div>
                            <label>Id</label>
                            <div>
                                <input type="text" name="id" maxlength="10" value="${acesso.id}" readonly/>
                            </div>
                        </div>
                        <div>
                            <label>Decrição</label>
                            <div>
                                <input type="text" name="descricao" maxlength="50" value="${acesso.descricao}"/>
                            </div>
                        </div>
                        <div>
                            <label>Filial</label>
                            <div>
                                <input type="text" name="filial" maxlength="5" value="${acesso.filial}" />
                            </div>
                        </div>               
                    </c:forEach>
                </c:if>
                
                <button type="submit">Salvar</button>

            </form>

            <br>

            <input class="btn btn-info btn-sm" type="submit" value="Página inicial" OnClick="parent.location.href = 'index.jsp'">
            <input class="btn btn-info btn-sm" type="submit" value="Consultar estoque" OnClick="parent.location.href = 'consultar-estoque'">

        </div>
    </body>
</html>
