<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.cliente.formulario.web.model.Cliente"%>
<%@page import="com.mycompany.cliente.formulario.web.dao.ClienteDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Produto - Resultado</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Resultado <c:out value="${metodoHttp}" /></h1>
        <div>
            <div>Escondido <c:out value="${escondido}" /></div>
            <div>Nome: <c:out value="${nome}" /></div>
            <div>Email: <c:out value="${email}"/></div>
        </div>
    </body>
</html>
