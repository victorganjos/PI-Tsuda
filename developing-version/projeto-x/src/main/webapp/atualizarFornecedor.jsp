<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Fornecedor - Atualizar</title>
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
            <h2>Atualizar Fornecedor</h2>
            <br>
            <form action="atualizar-fornecedor" method="post">
                <c:if test="${sessionScope.acesso != null && !sessionScope.acesso.isEmpty()}">
                    <c:forEach items="${sessionScope.acesso}" var="acesso">
                        <input type="hidden" name="tipo" value="f"/>
                        <input type="hidden" name="id" maxlength="10" value="${acesso.id}"/>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Nome Fornecedor*</label>
                                <input type="text" name="nome" class="form-control" maxlength="50" value="${acesso.nome}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>Email</label>
                                <input  type="text" name="email" class="form-control" maxlength="80" value="${acesso.email}" >
                            </div>
                            <div class="form-group col-md-6">
                                <label>CNPJ*</label>
                                <input  type="text" name="cnpj" class="form-control" maxlength="50" value="${acesso.cnpj}" >
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
                            <c:if test="${msgErro != null}">
                                <div class="erro" color="red" ><c:out value="${msgErro}" /></div>
                            </c:if>
                            <div class="form-group col-md-6">  
                                <button class="btn btn-info btn-sm" OnClick="alerta()" type="submit">Salvar</button>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>   

                <script>
                    function alerta()
                    {
                        alert("Fornecedor Atualizado com Sucesso!");
                    }
                </script>
            </form>
        </div>
        <div class="container">
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Página inicial" OnClick="parent.location.href = 'homePage.jsp'">
            <input class="btn btn-info btn-sm" type="submit" value="Consultar fornecedor" OnClick="parent.location.href = 'consultar-fornecedor'">
        </div>
    </body>
</html>
