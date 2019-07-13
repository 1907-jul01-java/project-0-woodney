drop table if exists client,bankaccount,bankTransaction,employee;

create table client 
(
    id serial primary key,
    username text not null,
    user_password text not null
);

create table bankAccount (
    id serial primary key,
    client_username text not null,
    account_balance float
);

create table bankTransaction (
    id serial primary key,
    client_username text not null,
    transaction_type text not null,
    amount int not null,
    previous_balance float
);

create table employee (
    employee_id serial primary key,
    employee_username text not null,
    employee_password text not null
);


insert into client(username,user_password) values ('woodneyg', 'password');
