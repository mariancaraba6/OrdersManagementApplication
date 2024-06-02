create table products
(
    productId   int          not null
        primary key,
    productName varchar(32)  not null,
    description varchar(128) not null,
    price       float        not null,
    quantity    int          not null,
    constraint productId
        unique (productId)
);

