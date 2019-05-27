<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Adicionar Produto</title>
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
        <h2>Cadastrar Produto</h2>
            <br>
        <c:if test="${msgErro == true}">
                <div class="alert-danger" role="alert" style="font-size: 20px"><strong>Preencha todos os campos Obrigatórios!</strong></div>
            </c:if>
        <form action="incluir-produto" method="post">
            <input type="hidden" name="tipo" value="f" />
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Nome Produto*</label>
                    <input type="text" name="nomeProd" class="form-control"placeholder="Digite o nome do produto:" maxlength="50">
                </div>
                <div class="form-group col-md-6">
                    <label>Categoria*</label>
                    <input  type="text" name="categoria" class="form-control"placeholder="Digite a categoria:" maxlength="50">
                </div>
                <div class="form-group col-md-6">
                    <label>Descrição</label>
                    <input  type="text" name="descricao" class="form-control"placeholder="Digite a descrição:" maxlength="50">
                </div>
                <div class="form-group col-md-6">
                    <label>Valor Venda*</label>
                    <input  type="text" name="valorVenda" class="form-control"placeholder="Digite o valor de venda:" maxlength="50">
                </div>
                <div class="form-group col-md-6">
                    <label>Estoque Disponível*</label>
                    <input type="text" name="estoqueDisp" class="form-control"placeholder="Digite a quantidade de estoque:" maxlength="50">
                </div>
                <div class="form-group col-md-6">
                    <label>Situação*</label>
                    <input type="text" name="situacao" class="form-control"placeholder="Digite a situação do produto:" maxlength="50">
                </div>
                <div>
                        <label>   Campos com (*) são obrigatórios!</label>
                    </div> 
                <br>
                <div class="form-group col-md-6">  
                    <button class="btn btn-info btn-sm" type="submit">Salvar</button>
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
