drop table if exists products;

create table products(
    id int(4) NOT NULL AUTO_INCREMENT,
    name varchar(128) NOT NULL UNIQUE,
    descr text NOT NULL,
    image varchar(256) NOT NULL,
    price float(6, 2) NOT NULL,
    PRIMARY KEY(id)
);