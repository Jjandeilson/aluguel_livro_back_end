create table aluguel(
	id bigint auto_increment,
    data_inicio date,
    data_entrega date,
    cliente_id bigint not null,
    livro_id bigint not null,
    valor decimal(8,2) not null,
    alugado boolean not null,
    primary key(id),
    foreign key(cliente_id) references cliente(id),
    foreign key(livro_id) references livro(id)
)engine = InnoDB default charset=utf8;

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-20', '2020-08-20', 1, 1, 5.00, true);

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-20', '2020-08-20', 2, 2, 5.00, true);

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-21', '2020-08-21', 3, 3, 5.00, true);

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-21', '2020-08-21', 4, 4, 5.00, true);

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-22', '2020-08-22', 5, 5, 5.00, true);

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-22', '2020-08-22', 6, 6, 5.00, true);

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-23', '2020-08-23', 7, 7, 5.00, true);

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-23', '2020-08-23', 8, 8, 5.00, true);

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-24', '2020-08-24', 9, 9, 5.00, true);

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-24', '2020-08-24', 10, 10, 5.00, true);

insert into aluguel(data_inicio, data_entrega, cliente_id, livro_id, valor, alugado) values
('2020-07-20', '2020-08-23', 6, 1, 5.00, true);