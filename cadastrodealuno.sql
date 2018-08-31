create database cadastroaluno;

use cadastroaluno;

select * from cadastro_model;

create table cadastro_model(
	codigo bigint(20) primary key auto_increment,
    matricula varchar(255) not null,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    telefone varchar(255)
);

select * from cadastro_model;


