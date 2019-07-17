drop table if exists client,bankaccount,bankTransaction,employee;

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
    checking_account_balance float,
    savings_account_balance float
);

create table bankTransaction (
    id serial primary key references client(id),
    transaction_type text not null,
    amount int not null,
    previous_balance float
);

create table employee (
    employee_id serial primary key,
    employee_username text not null,
    employee_password text not null
);

--insert into client(username,user_password,firstname,lastname,user_address,city,user_state,DOB) values ('woodneyg', 'password','Woodney', 'Guerrier','10802 Ryan Oaks Dr', 'Houston', 'Texas', '12/15/1994');
--insert into bankAccount(checking_account_balance,savings_account_balance) values (0.00, 0.00);