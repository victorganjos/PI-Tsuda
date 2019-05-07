
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="cotainer">
            <h1>Consulta</h1>
            <hr>

            <table class="table table-bordered">
                <tr>
                    <th class="text-center">Id</th><th class="text-center">Nome</th><th class="text-center">Filial</th><th class="text-center">Cargo</th><th class="text-center">Setor</th><th class="text-center">CPF</th><th class="text-center">RG</th><th class="text-center">Data Nascimento</th><th class="text-center">Endereço</th><th class="text-center">Numero</th><th class="text-center">Complemento</th><th class="text-center">Estado</th><th class="text-center">Cidade</th><th class="text-center">Bairro</th><th class="text-center">CEP</th><th class="text-center">Telefone</th><th class="text-center">Celular</th><th class="text-center">E-mail</th><th class="text-center">Informações Adcionais</th><th class="text-center" colspan="2">Ação</th>
                </tr>

                <c:forEach var="cat" items="${consulta}" >
                    <tr>
                        <td class="text-center"><c:out value="${cat.id}"/></td>
                        <td class="text-center"><c:out value="${cat.nome}"/></td>
                        <td class="text-center"><c:out value="${cat.filial}"/></td>
                        <td class="text-center"><c:out value="${cat.cargo}"/></td>
                        <td class="text-center"><c:out value="${cat.setor}"/></td>
                        <td class="text-center"><c:out value="${cat.CPF}"/></td>
                        <td class="text-center"><c:out value="${cat.RG}"/></td>
                        <td class="text-center"><c:out value="${cat.data}"/></td>
                        <td class="text-center"><c:out value="${cat.endereco}"/></td>
                        <td class="text-center"><c:out value="${cat.numero}"/></td>
                        <td class="text-center"><c:out value="${cat.complemento}"/></td>
                        <td class="text-center"><c:out value="${cat.estado}"/></td>
                        <td class="text-center"><c:out value="${cat.cidade}"/></td>
                        <td class="text-center"><c:out value="${cat.bairro}"/></td>
                        <td class="text-center"><c:out value="${cat.cep}"/></td>
                        <td class="text-center"><c:out value="${cat.telefone}"/></td>
                        <td class="text-center"><c:out value="${cat.celular}"/></td>
                        <td class="text-center"><c:out value="${cat.email}"/></td>
                        <td class="text-center"><c:out value="${cat.infoAdcionais}"/></td>
                    <form method="get" action="${pageContext.request.contextPath}/atualizar-usuario">
                        <td class="text-center"><button class="btn btn-warning btn-sm" type="submit" value="${cat.id}" name="id">Atualizar</td>
                    </form>
                    <form method="get" action="${pageContext.request.contextPath}/excluir-usuario">
                        <td class="text-center"><button class="btn btn-danger btn-sm" type="submit" value="${cat.id}" name="id">Excluir</td>
                    </form>    
                    </tr>
                </c:forEach>
            </table>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href = 'index.jsp'">
        </div>
    </body>
</html>
