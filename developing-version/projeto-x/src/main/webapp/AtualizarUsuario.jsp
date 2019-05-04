<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Usuario - Atualizar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Usuario - Atualizar</h1>
        <div>
            <form action="atualizar-usuario" method="post">
                <input type="hidden" name="escondido" value="xpto" />
                
                <c:forEach items="${consulta}" var="consulta">
                <div>
                    <label>Id</label>
                    <div>
                            <input type="number" name="id" value="${consulta.id}"/> 
                    </div>
                </div>
                <div>
                    <label>Nome</label>
                    <div>
                        <input type="text" name="nome" value="${consulta.nome}"/>
                    </div>
                </div>
                    <div>
                <label>Flial</label>
                <div>
                    <input type="text" name="filial" value="${consulta.filial}" />
                </div>
            </div>
            <div>
                <label>Cargo</label>
                <div>
                    <input type="text" name="cargo" maxlength="50" value="${consulta.cargo}" />
                </div>
            </div>
            <div>
                <label>Setor</label>
                <div>
                    <input type="text" name="setor" maxlength="50" value="${consulta.setor}" />
                </div>
            </div>
            <div>
                <label>CPF</label>
                <div>
                    <input type="text" name="CPF" maxlength="50" value="${consulta.CPF}"/>
                </div>
            </div>
            <div>
                <label>RG</label>
                <div>
                    <input type="text" name="RG" maxlength="50" value="${consulta.RG}" />
                </div>
            </div>
            <div>
                <label>Data Nascimento</label>
                <div>
                    <input type="date" name="nome" maxlength="50" value="${consulta.data}"/>
                </div>
            </div>
            <div>
                <label>Endereço</label>
                <div>
                    <input type="text" name="endereco" maxlength="50" value="${consulta.endereco}" />
                </div>
            </div>
            <div>
                <label>Numero</label>
                <div>
                    <input type="text" name="numero" maxlength="50" value="${consulta.numero}" />
                </div>
            </div><div>
                <label>Complemento</label>
                <div>
                    <input type="text" name="complemento" maxlength="50" value="${consulta.complemento}"/>
                </div>
            </div>
            <div>
                <label>Estado</label>
                <div>
                    <input type="text" name="estado" maxlength="50" value="${consulta.estado}"/>
                </div>
            </div>
            <div>
                <label>Cidade</label>
                <div>
                    <input type="text" name="cidade" maxlength="50" value="${consulta.cidade}"/>
                </div>
            </div>
            <div>
                <label>Bairro</label>
                <div>
                    <input type="text" name="bairro" maxlength="50" value="${consulta.bairro}" />
                </div>
            </div>
            <div>
                <label>CEP</label>
                <div>
                    <input type="text" name="cep" maxlength="50" value="${consulta.cep}"/>
                </div>
            </div>
            <div>
                <label>Telefone</label>
                <div>
                    <input type="text" name="telefone" maxlength="50" value="${consulta.telefone}"/>
                </div>
            </div>
            <div>
                <label>Celular</label>
                <div>
                    <input type="text" name="celular" maxlength="50" value="${consulta.celular}"/>
                </div>
            </div> 
                <div>
                    <label>Email</label>
                    <div>
                        <input type="text" name="email" value="${consulta.email}"/>
                    </div>
                </div>
                 <div>
                    <label>Email</label>
                    <div>
                        <input type="text" name="infoAdcionais" value="${consulta.infoAdcionais}"/>
                    </div>
                </div>
                    </c:forEach>
                <button type="submit">Salvar</button>

            </form>
            <br>
            <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href='index.jsp'">
        </div>
    </body>
</html>
