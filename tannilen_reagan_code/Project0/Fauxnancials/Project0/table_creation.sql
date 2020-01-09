/*
    user_roles
    users
    account_types
    accounts
    trans_types
    transactions
    user_accounts
*/
create table user_roles (role_id number constraint pk_roles primary key, role_name varchar2(25));
create table users (user_id number constraint pk_user primary key, username varchar(25) unique not null, passhash number not null, given_name varchar2(25) not null, family_name varchar2(25) not null);
create table account_types (type_id number constraint pk_types primary key, type_name varchar2(25));
create table accounts (acct_id number constraint pk_accts primary key, type_id number, acct_bal number, constraint fk_types foreign key (type_id) references account_types (type_id));
create table user_accounts (acct_id number, user_id number, constraint pk_user_accts primary key (acct_id, user_id), constraint fk_users foreign key (user_id) references users(user_id), constraint fk_accts foreign key (acct_id) references accounts(acct_id));
create table trans_types (ttype_id number, ttype_name varchar2(25), constraint pk_trans_type primary key (ttype_id));
create table transactions (trans_id number, ttype_id number, acct_id number, user_id number, trans_amt number, constraint pk_trans primary key (trans_id), constraint fk_trans_type foreign key (ttype_id) references trans_types (ttype_id), constraint fk_trans_acct foreign key (acct_id) references accounts (acct_id), constraint fk_trans_user foreign key (user_id) references users (user_id));
--autoincrementation: user roles
create sequence user_role_pk_sequence minvalue 1 maxvalue 99999 increment by 1 start with 1;
create or replace trigger user_roles_pk_trigger before insert on user_roles for each row begin
    select user_role_pk_sequence.nextval into :new.role_id from dual;
end;
/
--autoincrementation: users
create sequence users_pk_sequence minvalue 1 maxvalue 99999 increment by 1 start with 1;
create or replace trigger users_pk_trigger before insert on users for each row begin
    select users_pk_sequence.nextval into :new.user_id from dual;
end;
/
--autoincrementation: account types
create sequence acct_types_pk_sequence minvalue 1 maxvalue 99999 increment by 1 start with 1;
create or replace trigger acct_types_pk_trigger before insert on account_types for each row begin
    select acct_types_pk_sequence.nextval into :new.type_id from dual;
end;
/
--autoincrementation: accounts
create sequence accts_pk_sequence minvalue 1 maxvalue 99999 increment by 1 start with 1;
create or replace trigger accts_pk_trigger before insert on accounts for each row begin
    select accts_pk_sequence.nextval into :new.acct_id from dual;
end;
/
--autoincrementation: trans_types
create sequence trans_types_pk_sequence minvalue 1 maxvalue 99999 increment by 1 start with 1;
create or replace trigger trans_types_pk_trigger before insert on trans_types for each row begin
    select trans_types_pk_sequence.nextval into :new.ttype_id from dual;
end;
/
--autoincrementation: transactions
create sequence transactions_pk_sequence minvalue 1 maxvalue 99999 increment by 1 start with 1;
create or replace trigger transactions_pk_trigger before insert on transactions for each row begin
    select transactions_pk_sequence.nextval into :new.trans_id from dual;
end;
/