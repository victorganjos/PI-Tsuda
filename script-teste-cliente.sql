create database cliente;
use cliente;

create table dadosCliente(
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(50),
    email varchar(80)
);

insert into dadosCliente (nome,email)
value ("fabio", "fabio@gmail.com");

select * from dadosCliente;