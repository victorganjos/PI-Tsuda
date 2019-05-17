<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cliente - Excluir</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div style="background:#4072A6 !important" class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4" style="color: #FCFCFC">Livraria Tades: Excluir Cliente</h1>
            </div>
        </div>    
        <div class="container">
            <h2>Excluir Cliente</h2>
            <br>
            <form action="excluir-cliente" method="post">
                <c:forEach items="${consulta}" var="consulta">
                    <input type="hidden" name="tipo" value="c"/>
                    <input type="hidden" name="id" maxlength="10" value="${consulta.id}"/>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Nome Cliente</label>
                            <input type="text" name="nome" class="form-control" maxlength="50" value="${consulta.nome}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Email</label>
                            <input  type="text" name="email" class="form-control" maxlength="50" value="${consulta.email}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>CPF</label>
                            <input  type="text" name="cpf" class="form-control" maxlength="50" value="${consulta.cpf}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Telefone</label>
                            <input  type="text" name="telefone" class="form-control" maxlength="50" value="${consulta.telefone}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Endereço</label>
                            <input type="text" name="endereco" class="form-control" maxlength="50" value="${consulta.endereco}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Número do endereço</label>
                            <input type="text" name="numero" class="form-control" maxlength="50" value="${consulta.numero}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Complemento</label>
                            <input type="text" name="complemento" class="form-control" maxlength="50" value="${consulta.complemento}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Estado</label>
                            <input type="text" name="estado" class="form-control" maxlength="50" value="${consulta.estado}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Cidade</label>
                            <input type="text" name="cidade" class="form-control" maxlength="50" value="${consulta.cidade}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Bairro</label>
                            <input type="text" name="bairro" class="form-control" maxlength="50" value="${consulta.bairro}" readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label>CEP</label>
                            <input type="text" name="cep" class="form-control" maxlength="50" value="${consulta.cep}" readonly>
                        </div>
                        <div class="form-group col-md-4">  
                            <button class="btn btn-info btn-sm" OnClick="alerta()" type="submit">Excluir</button>
                        </div>
                    </c:forEach>
                </div> 
                <script>
                    function alerta()
                    {
                        alert("Exclusão do Cliente realizada com sucesso!");
                    }
                </script>
            </form>
        </div>
        <div class="container">
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Página inicial" OnClick="parent.location.href = 'homePage.jsp'">
            <input class="btn btn-info btn-sm" type="submit" value="Consultar Cliente" OnClick="parent.location.href = 'consultar-cliente'">
        </div>
    </body>
</html>
