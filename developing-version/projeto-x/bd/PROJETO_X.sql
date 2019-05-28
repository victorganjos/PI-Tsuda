CREATE	DATABASE PROJETO_X;
USE PROJETO_X;

CREATE TABLE projeto_x.DADOSUSUARIO(
ID INT AUTO_INCREMENT,
NOME varchar(50),
USERNAME varchar(50),
SENHA varchar(50),
CARGO varchar(50),
FILIAL varchar(50),
constraint pk_id primary key (id)
);

CREATE TABLE DADOSCLIENTE(
    ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(50),
    EMAIL VARCHAR(80),
    CPF LONG,
    CNPJ LONG,
    TELEFONE VARCHAR(15),
    ENDERECO VARCHAR(255),
    NUMERO INT,
    COMPLEMENTO VARCHAR (30),
    ESTADO VARCHAR (30),
    CIDADE VARCHAR (30),
    BAIRRO VARCHAR (30),
    CEP VARCHAR (15),
    TIPO VARCHAR(2)
);

CREATE TABLE ESTOQUE(
	PK_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
    DS_DESCRICAO VARCHAR(50),
    DS_FILIAL VARCHAR(5)
);

CREATE TABLE PRODUTO(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nomeProd  varchar(50),
categoria  varchar(80),
descricao  varchar(80),
valorVenda FLOAT,
estoqueDisp int,
situacao  varchar(80)
);


create table venda(
    id int not null primary key not null auto_increment,
    cliente int,
    formaPagamento Varchar(255),
    valorTotal float(4,2),
    dataVenda date
);

create table itemVenda (
    id int not null primary key auto_increment,
    idVenda int,
    idProduto int,
    valorUnitario float,
    FOREIGN KEY (idVenda) REFERENCES venda(id)
);

INSERT INTO VENDA VALUE (3,1,'CREDITO',25.20, 2018-06-06);
select * from venda;
INSERT INTO DADOSUSUARIO VALUE (1,'fabio','fabio123','123','back','sp');
INSERT INTO DADOSUSUARIO VALUE (2,'caio','caio123','123','vendedor','sp');
INSERT INTO DADOSUSUARIO VALUE (3,'johnnys','johnnys123','123','back','sp');
INSERT INTO DADOSUSUARIO VALUE (4,'victor','victor123','123','vendedor','sp');
INSERT INTO DADOSUSUARIO VALUE (5,'layssa','layssa123','123','back','sp');


INSERT INTO dadoscliente VALUE (1,'livreto','fornecedor@livreto.com',null,1314512514123,1141353829,'helmtuh strobel',85,null,'Sao Paulo', 'Sao Paulo', 'Pinheiros','06767-077','F');
INSERT INTO dadoscliente VALUE (2,'silvano','fornecedor@silvano.com',null,1314512532423,1141353529,'Cidao cardoso',37,null,'Sao Paulo', 'Sao Paulo', 'Butantã','74857-789','F');
INSERT INTO dadoscliente VALUE (3,'biena','fornecedor@biena.com',null,13145112314123,1141354829,'maria do carmos',97,null,'Sao Paulo', 'Sao Paulo', 'Santo Antonio','14257-369','F');
INSERT INTO dadoscliente VALUE (4,'saber','fornecedor@saber.com',null,1314122514123,1141353129,'brigadeiro luiz antorio',74,null,'Sao Paulo', 'Sao Paulo', 'Freguesia','96968-852','F');
INSERT INTO dadoscliente VALUE (5,'conhecimento','fornecedor@conhecimento.com',null,13145155554123,1141353229,'maringa',69,null,'Sao Paulo', 'Sao Paulo', 'Brasilandia','36365-147','F');