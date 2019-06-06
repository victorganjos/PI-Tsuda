<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Filial - Cadastro</title>
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
        <input type="hidden" name="escondido" value="xpto" />
        <div class="container">
            <h2>Adicionar Filial</h2>
            <br>
            <form action="incluir-filial" method="post">
                <input type="hidden" name="tipo" value="fi" />
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Nome Filial*</label>
                        <input type="text" name="nome" class="form-control"placeholder="Digite o nome:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>E-mail</label>
                        <input  type="text" name="email" class="form-control"placeholder="Digite o email:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>CNPJ*</label>
                        <input  type="text" name="cnpj" class="form-control"placeholder="Digite o cnpj:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>Telefone*</label>
                        <input  type="text" name="telefone" class="form-control"placeholder="Digite o telefone:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>Endereço*</label>
                        <input type="text" name="endereco" class="form-control"placeholder="Digite o endereço:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>Número do endereço*</label>
                        <input type="text" name="numero" class="form-control"placeholder="Digite o número:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>Complemento</label>
                        <input type="text" name="complemento" class="form-control"placeholder="Digite o complemento:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>Estado*</label>
                        <input type="text" name="estado" class="form-control"placeholder="Digite a estado:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>Cidade*</label>
                        <input type="text" name="cidade" class="form-control"placeholder="Digite a cidade:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>Bairro</label>
                        <input type="text" name="bairro" class="form-control"placeholder="Digite o bairro:" maxlength="50">
                    </div>
                    <div class="form-group col-md-6">
                        <label>CEP*</label>
                        <input type="text" name="cep" class="form-control"placeholder="Digite o cep:" maxlength="50">
                    </div>
                    <div>
                        <label>   Campos com (*) são obrigatórios!</label>
                    </div>
                    <c:if test="${msgErro != null}">
                        <div class="erro" color="red" ><c:out value="${msgErro}" /></div>
                    </c:if>
                    <br>
                    <script>
                        function alerta()
                        {
                            alert("Filial Cadastrado com Sucesso!");
                        }
                    </script>
                    <div class="form-group col-md-6">  
                        <button class="btn btn-info btn-sm" OnClick="alerta()" type="submit">Salvar</button>
                        <button class="btn btn-info btn-sm" type="reset" value="Reset">Resetar</button>
                    </div>
                </div>
            </form> 
        </div>
        <div class="container">
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'homePage.jsp'">
        </div>

    </body>
</html>
