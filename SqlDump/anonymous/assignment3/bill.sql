create table bill
(
    billId        int auto_increment
        primary key,
    orderId       int  not null,
    clientId      int  not null,
    productId     int  not null,
    orderQuantity int  not null,
    dateOfBill    date not null,
    constraint billId
        unique (billId)
);

