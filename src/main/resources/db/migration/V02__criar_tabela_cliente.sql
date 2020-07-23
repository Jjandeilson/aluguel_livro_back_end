create table cliente(
	id bigint auto_increment,
    nome varchar(80) not null,
    data_nascimento date,
    rg varchar(9) not null unique,
    estado varchar(20) not null,
    cidade varchar(50) not null,
    logradouro varchar(60) not null,
    bairro varchar(40) not null,
    cep varchar(10) not null,
    numero varchar(5),
    complemento varchar(30),
    primary key(id)
)engine = InnoDB default charset=utf8;

insert into cliente(nome, data_nascimento, rg, estado, cidade, logradouro, bairro, cep, numero) values
('Ana Silva de Andreda','1998-06-21','0.000.000','PB', 'João Pessoa', 'Rua Desembargador Freitosa', 'Centro', '58.010-050', '210');

insert into cliente(nome, data_nascimento, rg, estado, cidade, logradouro, bairro, cep, numero) values
('Beatriz de Oliveira','1991-06-21','1.111.111','PB', 'João Pessoa', 'Rua Maciel Pinheiro', 'Varadouro', '58.010-132', '40');

insert into cliente(nome, data_nascimento, rg, estado, cidade, logradouro, bairro, cep, numero) values
('Carlos Cavalcante','1987-09-17','2.222.222','PB', 'João Pessoa', 'Rua General Lime Mindelo', 'Varadouro', '58.010-560', '673');

insert into cliente(nome, data_nascimento, rg, estado, cidade, logradouro, bairro, cep, numero) values
('Daniel Pereira','2000-04-01','3.333.333','PB', 'João Pessoa', 'Rua Branca dias', 'Trincheiras', '58.010-060', '940');

insert into cliente(nome, data_nascimento, rg, estado, cidade, logradouro, bairro, cep, numero) values
('Estevão Félix','1997-10-07','4.444.444','PB', 'João Pessoa', 'Rua Apolônio Sales Miranda', 'Ilha do Bispo', '58.011-447', '30');

insert into cliente(nome, data_nascimento, rg, estado, cidade, logradouro, bairro, cep, numero) values
('Fernando Galvão','1989-09-17','5.521.487','PB', 'João Pessoa', 'Rua General Lime Mindelo', 'Varadouro', '58.010-560', '384');

insert into cliente(nome, data_nascimento, rg, estado, cidade, logradouro, bairro, cep, numero) values
('Geraldo Gomes','1980-06-24','6.666.666','PB', 'João Pessoa', 'Rua Desembargador Freitosa', 'Centro', '58.010-050', '10');

insert into cliente(nome, data_nascimento, rg, estado, cidade, logradouro, bairro, cep, numero) values
('Hernando Barbosa','2001-03-10','7.102.660','PB', 'João Pessoa', 'Rua Branca dias', 'Trincheiras', '58.010-060', '100');

insert into cliente(nome, data_nascimento, rg, estado, cidade, logradouro, bairro, cep, numero) values
('João Galdino','1985-09-16','8.360.111','PB', 'João Pessoa', 'Rua Maciel Pinheiro', 'Varadouro', '58.010-132', '23');

insert into cliente(nome, data_nascimento, rg, estado, cidade, logradouro, bairro, cep, numero) values
('Leonardo Gentil','1998-12-07','9.300.487','PB', 'João Pessoa', 'Rua Apolônio Sales Miranda', 'Ilha do Bispo', '58.011-447', '178');