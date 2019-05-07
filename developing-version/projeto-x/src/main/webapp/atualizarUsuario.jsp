<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Usuario - Atualizar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Usuario - Atualizar</h1>
        <div>
            <form action="atualizar-usuario" method="post">
                <input type="hidden" name="escondido" value="xpto" />

                <c:forEach items="${consulta}" var="consulta">
                    <div>
                        <label>Id</label>
                        <div>
                            <input type="number" name="id" value="${consulta.id}" readonly/> 
                        </div>
                    </div>
                    <div>
                        <label>Nome</label>
                        <div>
                            <input type="text" name="nome" maxlength="50" value="${consulta.nome}"required/>
                        </div>
                    </div>
                    <div>
                        <label>Username</label>
                        <div>
                            <input type="text" name="username" maxlength="50" value="${consulta.username}" required/>
                        </div>
                    </div>
                    <div>
                        <label>Senha</label>
                        <div>
                            <input type="password" name="senha" maxlength="50" value="${consulta.senha}" required/>
                        </div>
                    </div>
                    <div>
                        <label>Cargo</label>
                        <div>
                            <input type="text" name="cargo" maxlength="50" value="${consulta.cargo}" required/>
                        </div>
                    </div>
                    <div>
                        <label>Filial</label>
                        <div>
                            <input type="text" name="filial" maxlength="50" value="${consulta.filial}" required/>
                        </div>
                    </div>
                    
                </c:forEach>
                <button type="submit">Salvar</button>

            </form>
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'index.jsp'">
        </div>
    </body>
</html>
