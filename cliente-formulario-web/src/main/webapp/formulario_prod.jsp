<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.cliente.formulario.web.model.Cliente"%>
<%@page import="com.mycompany.cliente.formulario.web.dao.ClienteDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Produto - Inclusão</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Produto - Inclusão</h1>
    <div>
        <form action="formulario-servlet" method="post">
            <input type="hidden" name="escondido" value="xpto" />
            <div>
                <label>ID</label>
                <div>
                    <input type="text" name="id" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Titulo</label>
                <div>
                    <input type="text" name="Titulo" maxlength="80" />
                </div>
            </div>
            <div>
                <label>Subtitulo</label>
                <div>
                    <input type="text" name="Subtitulo" maxlength="80" />
                </div>
            </div>
            <button type="submit">Salvar</button>
            <button type="reset">Resetar</button>
        </form>
    </div>
</body>
</html>
