<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div style="background:#4072A6 !important" class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4" style="color: #FCFCFC">Livraria Tades</h1>
            </div>
        </div>
        <div class="container" style="width: 400px">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-row">
                    <label for="validationServer01">Login</label>
                    <input type="text" name="username" class="form-control is-valid" placeholder="Digite o Login" required>
                </div>
                <div class="form-row">
                    <label for="validationServer01">Senha</label>
                    <input type="password" name="senha" class="form-control is-valid" placeholder="Digite a Senha" required>
                </div>
                <br>
                <c:if test="${msgErro != null}">
                    <div class="erro"><c:out value="${msgErro}" /></div>
                </c:if>
                <button class="btn btn-primary" type="submit">Enviar</button>
            </form>
        </div>	
    </body>
</html>
