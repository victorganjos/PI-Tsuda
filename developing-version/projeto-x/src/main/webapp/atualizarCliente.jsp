<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cliente - Atualizar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div style="background:#4072A6 !important" class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4" style="color: #FCFCFC">Livraria Tades</h1>
            </div>
        </div>
        <div class="container">
            <h2>Atualizar Cliente</h2>
            <br>
            <c:if test="${msgErro == true}">
                <div class="alert-danger" role="alert" style="font-size: 20px"><strong>Preencha todos os campos Obrigatórios!</strong></div>
            </c:if> 
            <br>
            <form action="atualizar-cliente" method="post">
                <c:if test="${sessionScope.acesso != null && !sessionScope.acesso.isEmpty()}">
                    <c:forEach items="${sessionScope.acesso}" var="acesso">
                        <input type="hidden" name="tipo" value="c"/>
                        <input type="hidden" name="id" maxlength="10" value="${acesso.id}"/>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Nome Cliente*</label>
                                <input type="text" name="nome" class="form-control" maxlength="50" value="${acesso.nome}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Email</label>
                                <input  type="text" name="email" class="form-control" maxlength="80" value="${acesso.email}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>CPF*</label>
                                <input  type="text" name="cpf" class="form-control" maxlength="50" value="${acesso.cpf}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Telefone*</label>
                                <input  type="text" name="telefone" class="form-control" maxlength="50" value="${acesso.telefone}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Endereço*</label>
                                <input type="text" name="endereco" class="form-control" maxlength="50" value="${acesso.endereco}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Número do endereço*</label>
                                <input type="text" name="numero" class="form-control" maxlength="50" value="${acesso.numero}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Complemento</label>
                                <input type="text" name="complemento" class="form-control" maxlength="50" value="${acesso.complemento}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Estado*</label>
                                <input type="text" name="estado" class="form-control" maxlength="50" value="${acesso.estado}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Cidade*</label>
                                <input type="text" name="cidade" class="form-control" maxlength="50" value="${acesso.cidade}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Bairro</label>
                                <input type="text" name="bairro" class="form-control" maxlength="50" value="${acesso.bairro}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>CEP*</label>
                                <input type="text" name="cep" class="form-control" maxlength="50" value="${acesso.cep}" >
                            </div>
                            <div>
                                <label>   Campos com (*) são obrigatórios!</label>
                            </div>
                            <div class="form-group col-md-6">  
                                <button class="btn btn-info btn-sm" type="submit">Salvar</button>
                            </div>
                        </div>
                    </c:forEach>
                </c:if> 
            </form>
        </div>
        <div class="container">
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Página inicial" OnClick="parent.location.href = 'homePage.jsp'">
            <input class="btn btn-info btn-sm" type="submit" value="Consultar Cliente" OnClick="parent.location.href = 'consultar-cliente'">
        </div>
    </body>
</html>
