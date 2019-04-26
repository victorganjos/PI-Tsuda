<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>CRUD CLIENTE</h1>
         <input class="btn btn-sucess btn-sm" type="submit" value="Inserir" OnClick="parent.location.href='formulario.jsp'">
          <input class="btn btn-info btn-sm" type="submit" value="Consultar" OnClick="parent.location.href='consultar-servlet'">
          <br><br><br>
         <h1>CRUD FORNECEDOR</h1>
         <input class="btn btn-sucess btn-sm" type="submit" value="Inserir" OnClick="parent.location.href='formularioFornecedor.jsp'">
         <input class="btn btn-info btn-sm" type="submit" value="Consultar" OnClick="parent.location.href='consultar-servlet-fornecedor'">
    </body>
          
    </body>
</html>
