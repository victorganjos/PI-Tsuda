<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Adcionar Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Adcionar Usuario</h1>
    <div>
        <form action="incluir-usuario" method="post">
            <input type="hidden" name="escondido" value="xpto" />
            <div>
                <label>Nome</label>
                <div>
                    <input type="text" name="nome" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Flial</label>
                <div>
                    <input type="text" name="filial" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Cargo</label>
                <div>
                    <input type="text" name="cargo" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Setor</label>
                <div>
                    <input type="text" name="setor" maxlength="50" />
                </div>
            </div>
            <div>
                <label>CPF</label>
                <div>
                    <input type="text" name="CPF" maxlength="50" />
                </div>
            </div>
            <div>
                <label>RG</label>
                <div>
                    <input type="text" name="RG" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Data Nascimento</label>
                <div>
                    <input type="date" name="data" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Endereço</label>
                <div>
                    <input type="text" name="endereco" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Numero</label>
                <div>
                    <input type="text" name="numero" maxlength="50" />
                </div>
            </div><div>
                <label>Complemento</label>
                <div>
                    <input type="text" name="complemento" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Estado</label>
                <div>
                    <input type="text" name="estado" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Cidade</label>
                <div>
                    <input type="text" name="cidade" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Bairro</label>
                <div>
                    <input type="text" name="bairro" maxlength="50" />
                </div>
            </div>
            <div>
                <label>CEP</label>
                <div>
                    <input type="text" name="cep" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Telefone</label>
                <div>
                    <input type="text" name="telefone" maxlength="50" />
                </div>
            </div>
            <div>
                <label>Celular</label>
                <div>
                    <input type="text" name="celular" maxlength="50" />
                </div>
            </div> 
            <div>
                <label>Email</label>
                <div>
                    <input type="text" name="email" maxlength="80" />
                </div>
            </div>
            <div>
                <label>Informações Adcionais</label>
                <div>
                    <input type="text" name="infoAdcionais" maxlength="300" />
                </div>
            </div>
            <script>
            function alerta(){
                alert("Salvo com sucesso!");
            }
            </script>
            <button type="submit" onclick="alerta()">Salvar</button>
            <button type="reset">Resetar</button>
            
        </form>
        <br>
        <input class="btn btn-info btn-sm" type="submit" value="Pagina inicial" OnClick="parent.location.href='index.jsp'">
    </div>
</body>
</html>
