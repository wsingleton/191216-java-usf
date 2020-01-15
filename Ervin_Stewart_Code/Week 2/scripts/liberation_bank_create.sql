/*
create in this order
1.user_roles
2.users
3.book_genres
4.books
5,user_wishlist
6.user_favorites
*/

CREATE USER lb_app
IDENTIFIED BY p4ssw0rdlb
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to lb_app;
GRANT resource to lb_app;
GRANT create session TO lb_app;
GRANT create table TO lb_app;
GRANT create view TO lb_app;

CREATE USER lb_user
IDENTIFIED BY p4ssw0rd;

GRANT CONNECT TO lb_user;
GRANT CREATE SESSION TO lb_user;
GRANT SELECT, INSERT, UPDATE ON lb_app.users to lb_user;
GRANT SELECT ON lb_app.user_roles to lb_user;
GRANT SELECT ON lb_app.account_type to lb_user;
GRANT SELECT, UPDATE ON lb_app.accounts to lb_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON rbs_app.user_wishlists to rbs_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON rbs_app.user_favorites to rbs_user;


CREATE TABLE user_roles (
    role_id     NUMBER,
    role_name   VARCHAR2(25),
    CONSTRAINT pk_roles
    PRIMARY KEY (role_id)
);


CREATE TABLE users (
    user_id     NUMBER,
    first_name  VARCHAR2(25) NOT NULL,
    last_name   VARCHAR2(25) NOT NULL,
    username    VARCHAR2(25) UNIQUE NOT NULL,
    password    VARCHAR2(25) NOT NULL,
    role_id     NUMBER,
    CONSTRAINT pk_users
    PRIMARY KEY (user_id),
    CONSTRAINT fk_user_role
    FOREIGN KEY (role_id)
    REFERENCES user_roles (role_id)
);

CREATE TABLE account_type (
    account_type_id    NUMBER ,
    account_type_name  VARCHAR2(25),
    CONSTRAINT pk_account_types
    PRIMARY KEY (account_type_id)
);
CREATE TABLE accounts (
    account_id     NUMBER ,
    balance    NUMBER DEFAULT 0,
    account_type_id   NUMBER,
    CONSTRAINT pk_accounts
    PRIMARY KEY (account_id),
    CONSTRAINT fk_account_type
    FOREIGN KEY (account_type_id)
    REFERENCES account_type (account_type_id)
);
CREATE TABLE users_accounts (
    user_id     NUMBER,
    account_id     NUMBER ,
    CONSTRAINT pk_ck_users_accounts
    PRIMARY KEY (user_id, account_id),
    CONSTRAINT fk_user
    FOREIGN KEY (user_id)
    REFERENCES users (user_id),
    CONSTRAINT fk_accounts
    FOREIGN KEY (account_id)
    REFERENCES accounts (account_id)
);

CREATE SEQUENCE user_roles_pk_seq
MINVALUE 1
MAXVALUE 99999
INCREMENT BY 1
START WITH 1;
CREATE OR REPLACE TRIGGER user_roles_pk_trigger
BEFORE INSERT ON user_roles
FOR EACH ROW
BEGIN
    SELECT user_roles_pk_seq.NEXTVAL
    INTO :new.role_id
    FROM dual;
END;
/
CREATE SEQUENCE users_pk_seq
MINVALUE 1
MAXVALUE 9999999
INCREMENT BY 1
START WITH 1;
CREATE OR REPLACE TRIGGER users_pk_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    SELECT users_pk_seq.NEXTVAL
    INTO :new.user_id
    FROM dual;
END;
/


CREATE SEQUENCE account_types_pk_seq
MINVALUE 1
MAXVALUE 99999
INCREMENT BY 1
START WITH 1;
CREATE OR REPLACE TRIGGER account_types_pk_trigger
BEFORE INSERT ON account_type
FOR EACH ROW
BEGIN
    SELECT account_types_pk_seq.NEXTVAL
    INTO :new.account_type_id
    FROM dual;
END;
/

CREATE SEQUENCE account_pk_seq
MINVALUE 1
MAXVALUE 9999999
INCREMENT BY 1
START WITH 1;
CREATE OR REPLACE TRIGGER account_pk_trigger
BEFORE INSERT ON accounts
FOR EACH ROW
BEGIN
    SELECT account_pk_seq.NEXTVAL
    INTO :new.account_id
    FROM dual;
END;
/

insert into account_type(account_type_name)
 values ('CHECKING');
 insert into account_type(account_type_name)
 values ('SAVINGS');
 commit;
 insert into user_roles(role_name)
 values ('ADMIN');
 insert into user_roles(role_name)
 values ('BASIC_MEMBER');
 
 insert into users( last_name, first_name, username, password, role_id)
 values ('Stewart','Ervin','Spacemvn', 'password', 1);
 insert into accounts( balance,account_type_id)
 values (150000, 1);
 
 ALTER TABLE accounts
MODIFY balance DEFAULT 0;

insert into users_accounts (user_id, account_id)
values(1,1)

--procedure that updates USERS_ACCOUNTS 
create or replace procedure set_users_accounts(newuser_id number, newaccount_id number)
is
begin
insert into users_accounts(user_id,account_id)
 values(newuser_id,newaccount_id);
 commit;
end;
/



insert into users(user_id,first_name,last_name,username,password,role_id)
values(0,'Blake','Dunn','Bulayke','bdunn22',1);

insert into accounts ( account_id, account_type_id)
values(400000,2);

update accounts
set balance = 420000
where account_id = 43;

update users
set username = 'Gandalph', last_name = 'Mccullen', first_name = 'Edward',password = 'thewhite!'
where user_id = 41;

insert into users_accounts (user_id, account_id)
values(43,43);