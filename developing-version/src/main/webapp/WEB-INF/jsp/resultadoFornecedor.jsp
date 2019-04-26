<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.projetox.web.model.Fornecedor"%>
<%@page import="com.projetox.web.dao.FornecedorDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fornecedor - Resultado</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Resultado <c:out value="${metodoHttp}" /></h1>
        <div>
            <div>Escondido <c:out value="${escondido}" /></div>
            <div>Nome Fantasia: <c:out value="${nomeFantasia}" /></div>
            <div>CNPJ: <c:out value="${cnpj}"/></div>
        </div>
        <br>
        <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href='index.jsp'">
    </body>
</html>
