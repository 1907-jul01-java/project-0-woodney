drop table if exists client,bankaccount,bankTransaction,employee,joint;
drop sequence if exists client_id_seq,bank_id_seq;
--create sequence client_id_seq increment by 30 minvalue 400000 maxvalue 20000000 start with 428193;
--create sequence bank_id_seq increment by 30 minvalue 400000 maxvalue 20000000 start with 428193;

 create table client 
(
    id serial primary key,
    firstName text not null,
    lastName text not null,
    username text not null,
    user_password text not null,
    user_address text not null,
    city text not null,
    user_state text not null,
    DOB text not null
);


create table bankAccount (
    id serial primary key references client(id),
    checking_account_balance numeric(12,2),
    savings_account_balance numeric(12,2)
);


create table employee (
    employee_id serial primary key,
    employee_username text not null,
    employee_password text not null
);

create table joint (
    id serial primary key,
    username text not null,
    password text not null,
    checking_account_balance numeric(12,2),
    savings_account_balance numeric(12,2)
);

insert into employee(employee_username,employee_password) values ('2713839','revature45');
--insert into client(username,user_password,firstname,lastname,user_address,city,user_state,DOB) values ('woodneyg', 'password','Woodney', 'Guerrier','10802 Ryan Oaks Dr', 'Houston', 'Texas', '12/15/1994');
--insert into client(username,user_password,firstname,lastname,user_address,city,user_state,DOB) values ('BobbyS', 'yolo45','Bobby', 'Shmurda','10452 Green Ave', 'Harlen', 'New York', '1/5/1990');
--insert into client(username,user_password,firstname,lastname,user_address,city,user_state,DOB) values ('Zen97', 'euphoria','Zendaya', 'Coleman','12345 Happy Ln', 'Los Angelos', 'California', '4/28/1997');
--insert into client(username,user_password,firstname,lastname,user_address,city,user_state,DOB) values ('ruth30', 'leo3030','Ruth', 'Guerrier','13415 Lynnville Dr', 'Houston', 'Texas', '07/30/1996');
--select * from client;
--delete from client where id = 1;
--insert into bankAccount(checking_account_balance,savings_account_balance) values (4000, 3000);
--insert into bankAccount(checking_account_balance,savings_account_balance) values (34000, 19000);
--update bankAccount set checking_account_balance = 400.00;
--update bankAccount set savings_account_balance = 400.00;