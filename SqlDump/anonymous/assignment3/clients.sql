create table clients
(
    clientId   int         not null
        primary key,
    clientName varchar(32) not null,
    address    varchar(64) not null,
    email      varchar(64) not null,
    age        int         not null,
    constraint clientId
        unique (clientId),
    constraint email
        unique (email)
);

