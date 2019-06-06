<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>
    </head>
    <body>
        <div style="background:#4072A6 !important" class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4" style="color: #FCFCFC">Livraria Tades</h1>
            </div>
        </div>
        <c:choose>
            <c:when test="${sessionScope.usuario != null}">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"style="width:150px">
                        Cadastros
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" style="width:200px">
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="adicionarUsuario.jsp">Cadastrar Usuário</a>
                        </div>
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="adicionarCliente.jsp">Cadastrar Cliente</a>
                        </div>
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="adicionarFornecedor.jsp">Cadastrar Fornecedor</a>
                        </div>
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="adicionarProduto.jsp">Cadastrar Produto</a>
                        </div>
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="adicionarFilial.jsp">Cadastrar Filial</a>
                        </div>
                    </div>
                </div>

                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"style="width:150px">
                        Consultas
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" style="width:200px">
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="consultar-usuario">Consultar Usuário</a>
                        </div>
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="consultar-cliente">Consultar Cliente</a>
                        </div>
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="consultar-fornecedor">Consultar Fornecedor</a>
                        </div>
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="consultar-produto">Consultar Produto</a>
                        </div>
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="consultar-filial">Consultar Filial</a>
                        </div>
                    </div>
                </div>

                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"style="width:150px">
                        Estoque
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" style="width:200px">
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="adicionarEstoque.jsp">Incluir Estoque</a>
                        </div>
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="consultar-estoque">Consultar Estoque</a>
                        </div>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"style="width:150px">
                        Venda
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" style="width:200px">
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="venda.jsp">Venda</a>
                        </div>
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"style="width:150px">
                        Relatório
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" style="width:200px">
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="relatorioVenda.jsp">Relatório de Vendas</a>
                        </div>
                    </div>
                </div>
                <br>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"style="width:150px">
                        Sair
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" style="width:200px">
                        <div class="form-group col-md-12">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Sair</a>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <p>Usuário não fez login</p>
                </div>
            </c:otherwise>
        </c:choose>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>   
    </body>
</html>
