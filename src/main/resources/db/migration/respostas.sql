create table respostas(

    id bigint not null auto_increment,
    mensagem varchar(500) not null,
    data datetime not null,
    topico varchar(500) not null,
    autor varchar(100) not null,

    primary key(id)

);