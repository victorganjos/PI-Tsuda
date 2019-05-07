<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Adcionar Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Adcionar Usuario</h1>
        <div>
            <form action="incluir-usuario" method="post">
                <input type="hidden" name="escondido" value="xpto" />
                <div>
                    <label>Nome Completo</label>
                    <div>
                        <input type="text" name="nome" maxlength="50" required />
                    </div>
                </div>
                <div>
                    <label>Username</label>
                    <div>
                        <input type="text" name="username" maxlength="50" required/>
                    </div>
                </div>
                <div>
                    <label>Senha</label>
                    <div>
                        <input type="password" name="senha" maxlength="50" required/>
                    </div>
                </div>
                <div>
                    <label>Cargo</label>
                    <div>
                        <input type="text" name="cargo" maxlength="50" required/>
                    </div>
                </div>
                <div>
                    <label>Filial</label>
                    <div>
                        <input type="text" name="filial" maxlength="50" required/>
                    </div>
                </div>
                <div>
                    <button type="submit">Salvar</button>
                    <button type="reset">Resetar</button>

            </form>
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'index.jsp'">
        </div>
    </body>
</html>
