create table livro(
	id bigint auto_increment,
    nome varchar(70) not null unique,
    autor varchar(70) not null,
    genero varchar(50) not null,
    data_lancamento date not null,
    quantidade int not null,
    primary key(id)
)engine = innodb default charset = utf8;

insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Percy Jackson  o Ladão de Raios', 'Rick Riordan'
			, 'Fantasia', '2005-06-28', 10);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Percy Jackson O Mar de Monstros', 'Rick Riordan'
			, 'Fantasia', '2006-04-01', 10);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Percy Jackson A Maldição do Titã', 'Rick Riordan'
			, 'Fantasia', '2007-04-01', 0);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Percy Jackson A Batalha do Labirinto', 'Rick Riordan'
			, 'Fantasia', '2008-05-06', 10);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Percy Jackson O Último Olimplivroiano', 'Rick Riordan'
			, 'Fantasia', '2009-05-05', 10);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Senhor dos Anéis A sociedade do Anel', 'J. R. R. Tolkien'
			, 'Fantasia', '1954-07-29', 10);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Senhor dos Anéis As duas Torres', 'J. R. R. Tolkien'
			, 'Fantasia', '1954-07-29', 10);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Senhor dos Anéis O retorno do Rei', 'J. R. R. Tolkien'
			, 'Fantasia', '1955-10-20', 0);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Crepúsculo', 'Stephenie Meyer',
			'Romance', '2005-10-05', 10);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Lua nova', 'Stephenie Meyer',
			'Romance', '2006-09-06', 0);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Amanhecer', 'Stephenie Meyer',
			'Romance', '2008-08-02', 10);
insert into livro(nome, autor, genero, data_lancamento, quantidade) values ('Sol da meia-noite', 'Stephenie Meyer',
			'Romance', '2020-08-04', 0);
