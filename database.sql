create database loja;

create table vendedor(
    id_vendedor int not null auto_increment,
    primary key (id_vendedor),
    nome varchar(200) not null,
    email varchar(100) not null unique,
    senha varchar(128) not null
);

create table pedido(
    id_pedido int not null auto_increment,
    primary key (id_pedido),
    nome_cliente varchar(200) not null,
    fk_vendedor int not null,
    foreign key (fk_vendedor) references vendedor(id_vendedor),
    descricao text,
    data datetime not null,
    preco_total float not null
);

create table produto(
    id_produto int not null auto_increment,
    primary key (id_produto),
    nome varchar(200) not null,
    descricao text,
    preco float not null
);

create table pedido_produto(
    fk_pedido int not null,
    foreign key (fk_pedido) references pedido(id_pedido),
    fk_produto int not null,
    foreign key (fk_produto) references produto(id_produto),
    quantidade int not null,
    primary key (fk_pedido, fk_produto)
);

insert into vendedor (nome, email, senha)
values ('Yuri', 'yuri@gmail.com',
        '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');
insert into vendedor (nome, email, senha)
values ('João', 'joao@gmail.com',
        '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');
insert into vendedor (nome, email, senha)
values ('Monica', 'monica@gmail.com',
        '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');
insert into vendedor (nome, email, senha)
values ('Renato', 'renato@gmail.com',
        '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');

insert into produto (nome, descricao, preco)
values ('PlayStation 5', 'Graficos de ultima geração - 825gb de armazenamento', 4699.90);
insert into produto (nome, descricao, preco)
values ('Xbox Series X', 'Graficos de ultima geração - 1TB de armazenamento', 4399.90);
insert into produto (nome, descricao, preco)
values ('Nintendo Switch', 'Para a familia se divertir - 64gb', 1699.90);
insert into produto (nome, descricao, preco)
values ('PSP 3000', 'Um classico portatil', 699.90);

insert into pedido (nome_cliente, fk_vendedor, descricao, data, preco_total)
values ('Rosana', 1, 'cliente abriu e conferio os produtos', '2020-10-05 14:54:39', 13499.70);

insert into pedido (nome_cliente, fk_vendedor, descricao, data, preco_total)
values ('Douglas', 3, 'cliente ficou de testar em casa', '2020-09-13 11:55:08', 3399.80);

insert into pedido (nome_cliente, fk_vendedor, descricao, data, preco_total)
values ('José', 4, 'cleinte pediu para avisar quando chegar novos jogos', '2020-11-14 19:23:48', 6099.70);

insert into pedido_produto (fk_pedido, fk_produto, quantidade)
values (1, 1, 1);
insert into pedido_produto (fk_pedido, fk_produto, quantidade)
values (1, 2, 2);
insert into pedido_produto (fk_pedido, fk_produto, quantidade)
values (2, 3, 2);
insert into pedido_produto (fk_pedido, fk_produto, quantidade)
values (3, 1, 1);
insert into pedido_produto (fk_pedido, fk_produto, quantidade)
values (3, 4, 2);
