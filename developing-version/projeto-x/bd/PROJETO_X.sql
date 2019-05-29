CREATE	DATABASE PROJETO_X;
USE PROJETO_X;

CREATE TABLE DADOSUSUARIO(
id INT AUTO_INCREMENT,
nome varchar(50),
username varchar(50),
senha varchar(50),
cargo varchar(50),
filial varchar(50),
constraint pk_id primary key (id)
);

CREATE TABLE DADOSCLIENTE(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50),
    email VARCHAR(80),
    cpf LONG,
    cnpj LONG,
    telefone VARCHAR(15),
    endereco VARCHAR(255),
    numero INT,
    complemento VARCHAR (30),
    estado VARCHAR (30),
    cidade VARCHAR (30),
    bairro VARCHAR (30),
    cep VARCHAR (15),
    tipo VARCHAR(2)
);

CREATE TABLE ESTOQUE(
	pk_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    ds_descricao VARCHAR(50),
    ds_filial VARCHAR(5)
);

CREATE TABLE PRODUTO(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
nomeprod  varchar(50),
categoria  varchar(80),
descricao  varchar(80),
valorvenda FLOAT,
estoquedisp int,
situacao  varchar(80)
);
/*SELECT VEN.*, CLI.NOME AS DS_NOMECLIENTE FROM VENDA VEN LEFT JOIN DADOSCLIENTE CLI ON CLI.ID = VEN.CLIENTE  'fabio';*/
create table VENDA(
    id int not null primary key auto_increment,
    cliente int,
    formapagamento Varchar(255),
    valortotal float,
    datavenda date
);

create table ITEMVENDA (
    id int not null primary key auto_increment,
    idvenda int,
    idproduto int,
    valorunitario float,
    FOREIGN KEY (idvenda) REFERENCES VENDA(id)
);
/*select * from venda;
select * from itemvenda;*/


INSERT INTO DADOSUSUARIO VALUE (1,'fabio','fabio123','123','back','sp');
INSERT INTO DADOSUSUARIO VALUE (2,'caio','caio123','123','vendedor','sp');
INSERT INTO DADOSUSUARIO VALUE (3,'johnnys','johnnys123','123','back','sp');
INSERT INTO DADOSUSUARIO VALUE (4,'victor','victor123','123','vendedor','sp');
INSERT INTO DADOSUSUARIO VALUE (5,'layssa','layssa123','123','back','sp');


INSERT INTO DADOSCLIENTE VALUE (1,'livreto','fornecedor@livreto.com',null,1314512514123,1141353829,'helmtuh strobel',85,null,'Sao Paulo', 'Sao Paulo', 'Pinheiros','06767-077','F');
INSERT INTO DADOSCLIENTE VALUE (2,'silvano','fornecedor@silvano.com',null,1314512532423,1141353529,'Cidao cardoso',37,null,'Sao Paulo', 'Sao Paulo', 'Butantã','74857-789','F');
INSERT INTO DADOSCLIENTE VALUE (3,'biena','fornecedor@biena.com',null,13145112314123,1141354829,'maria do carmos',97,null,'Sao Paulo', 'Sao Paulo', 'Santo Antonio','14257-369','F');
INSERT INTO DADOSCLIENTE VALUE (4,'saber','fornecedor@saber.com',null,1314122514123,1141353129,'brigadeiro luiz antorio',74,null,'Sao Paulo', 'Sao Paulo', 'Freguesia','96968-852','F');
INSERT INTO DADOSCLIENTE VALUE (5,'conhecimento','fornecedor@conhecimento.com',null,13145155554123,1141353229,'maringa',69,null,'Sao Paulo', 'Sao Paulo', 'Brasilandia','36365-147','F');