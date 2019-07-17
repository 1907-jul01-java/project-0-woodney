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

--insert into client(username,user_password,firstname,lastname,user_address,city,user_state,DOB) values ('woodneyg', 'password','Woodney', 'Guerrier','10802 Ryan Oaks Dr', 'Houston', 'Texas', '12/15/1994');
--insert into bankAccount(checking_account_balance,savings_account_balance) values (0.00, 0.00);
--update bankAccount set checking_account_balance = 400.00;
--update bankAccount set savings_account_balance = 400.00;