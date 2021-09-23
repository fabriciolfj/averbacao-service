create table consignado(
    id bigint not null auto_increment,
    code varchar(255) not null,
    cliente varchar(255) not null,
    valor_parcela decimal(15,4) not null,
    prazo_contrato int not null,
    data_primeiro_vencimento date not null,
    status int not null,
    descricao_erro varchar(500),
    created datetime not null,
    version integer not null,
    updated datetime,
    primary key (id)
) engine=InnoDB default charset=utf8;