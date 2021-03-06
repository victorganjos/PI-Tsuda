<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
<body>
    <div style="background:#4072A6 !important" class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4" style="color: #FCFCFC">Livraria Tades</h1>
        </div>
    </div>
    <div class="col-lg-3">
	<div class="container-fluid">
            <div class="dropdown">
		<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width:190px;height:50px">Cadastros</button>
		<div class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <div class="form-row">
			<input class="btn btn-sucess btn-sm" type="submit" value="Cadastrar Usuário" OnClick="parent.location.href='adcionarUsuario.jsp'">
                    </div>
                    <div class="form-row">
                        <input class="btn btn-sucess btn-sm" type="submit" value="Cadastrar Cliente" OnClick="parent.location.href='formulario.jsp'">
                    </div>
                    <div class="form-row">
 			<input class="btn btn-sucess btn-sm" type="submit" value="Cadastrar Fornecedor" OnClick="parent.location.href='adicionarFornecedor.jsp'">
                    </div>
                    <div class="form-row">
 			<input class="btn btn-sucess btn-sm" type="submit" value="Cadastrar Produto" OnClick="parent.location.href='adicionarProduto.jsp'">
                    </div>
                </div>
            </div>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width:190px;height:50px">Consultas</button>
		<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <div class="form-row">
                        <input class="btn btn-info btn-sm" type="submit" value="Consultar Usuário" OnClick="parent.location.href='consultar-usuario'">
                    </div>
                    <div class="form-row">
			<input class="btn btn-info btn-sm" type="submit" value="Consultar Cliente" OnClick="parent.location.href='consultar-servlet'">
                    </div>
                    <div class="form-row">
                        <input class="btn btn-info btn-sm" type="submit" value="Consulta Fornecedor" OnClick="parent.location.href='consultar-fornecedor'">
                    </div>
                    <div class="form-row">
                        <input class="btn btn-info btn-sm" type="submit" value="Consulta Produto" OnClick="parent.location.href='consultar-produto'">
                    </div>
                </div>
            </div>	
            <div class="dropdown">	
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="width:190px;height:50px">Estoque</button>
		<div class="dropdown-menu" aria-labelledby="dropdownMenu3">
                    <div class="form-row">
                        <input class="btn btn-info btn-sm" type="submit" value="Consultar Estoque" OnClick="parent.location.href='consultar-estoque'">
                    </div>
                    <div class="form-row">
			<input class="btn btn-sucess btn-sm" type="submit" value="Incluir Estoque" OnClick="parent.location.href='incluirEstoque.jsp'">
                    </div>
                </div>
            </div>	
	</div>
    </div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>   
</body>
</html>
