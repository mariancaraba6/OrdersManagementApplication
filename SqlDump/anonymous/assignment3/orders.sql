create table orders
(
    orderId       int not null
        primary key,
    clientId      int not null,
    productId     int not null,
    orderQuantity int not null,
    constraint orderId
        unique (orderId)
);

