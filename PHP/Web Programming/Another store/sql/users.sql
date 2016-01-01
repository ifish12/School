drop table if exists users;
drop function if exists newUser;
drop function if exists login;

create table users(
    id int(4) NOT NULL AUTO_INCREMENT,
    email varchar(40) NOT NULL UNIQUE,
    password varchar(20) NOT NULL,
    fName varchar(25) NOT NULL,
    lName varchar(25) NOT NULL,
    birth date NOT NULL,
    gender char(1) NOT NULL,
    PRIMARY KEY(id)
);
