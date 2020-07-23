create table reserva(
	id bigint auto_increment,
    data_reserva date,
    cliente_id bigint not null,
    livro_id bigint not null,
    primary key(id),
    foreign key(cliente_id) references cliente(id),
    foreign key(livro_id) references livro(id)
)engine = InnoDB default charset = utf8;

insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-20', 1, 10);
insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-20', 2, 9);

insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-21', 3, 8);
insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-21', 4, 7);

insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-22', 5, 6);
insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-22', 6, 5);

insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-23', 7, 5);
insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-23', 8, 4);

insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-24', 9, 3);
insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-24', 10, 2);

insert into reserva(data_reserva, cliente_id, livro_id) values ('2020-07-21', 3, 1);
