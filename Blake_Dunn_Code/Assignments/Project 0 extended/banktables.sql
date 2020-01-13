/*
    1) Users
    2) AccountTypes
    3) Accounts
    4) UsersAccounts
    5) TransactionType
    6) Transactions
*/

CREATE TABLE users (
    user_id         NUMBER(5) CONSTRAINT pk_users PRIMARY KEY,
    username        VARCHAR2(25) UNIQUE NOT NULL,
    password        VARCHAR2(25) NOT NULL,
    first_name      VARCHAR2(25) NOT NULL,
    last_name       VARCHAR2(25)NOT NULL
);

CREATE TABLE account_types (
    type_id         NUMBER(5) CONSTRAINT pk_account_types PRIMARY KEY,
    acct_type       VARCHAR2(25)  
);

CREATE TABLE accounts (
    acct_id         NUMBER(5),
    type_id         NUMBER(5),
    balance         NUMBER(10,2),
    
    CONSTRAINT pk_accounts 
    PRIMARY KEY (acct_id),
    
    CONSTRAINT fk_type_id 
    FOREIGN KEY (type_id)
    REFERENCES account_types(type_id)
);

CREATE TABLE users_accounts (
    user_id     NUMBER(5),
    acct_id     NUMBER(5),
    
    CONSTRAINT pk_users_accounts
    PRIMARY KEY (user_id, acct_id),
    
    CONSTRAINT fk_ua_users
    FOREIGN KEY (user_id)
    REFERENCES users(user_id),
    
    CONSTRAINT fk_ua_accounts
    FOREIGN KEY (acct_id)
    REFERENCES accounts(acct_id)
);

CREATE TABLE transaction_types (
    trans_type_id       NUMBER(10) CONSTRAINT pk_transaction_types PRIMARY KEY,
    trans_type          VARCHAR2(25)
);

CREATE TABLE transactions (
    trans_id            NUMBER(10),
    user_id             NUMBER(5),
    acct_id             NUMBER(5),
    trans_type_id       NUMBER(10),
    amount              NUMBER(10,2),
    trans_date          DATE,
    
    CONSTRAINT pk_transactions
    PRIMARY KEY (trans_id),
    
    CONSTRAINT fk_transactions_users_accounts
    FOREIGN KEY (user_id, acct_id)
    REFERENCES users_accounts (user_id, acct_id),
    
    CONSTRAINT fk_trans_types
    FOREIGN KEY (trans_type_id)
    REFERENCES transaction_types (trans_type_id)
);

CREATE SEQUENCE account_types_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER account_types_insert_trig
BEFORE INSERT ON account_types
FOR EACH ROW

BEGIN
    SELECT account_types_pk_seq.NEXTVAL
    INTO :new.type_id
    FROM dual;
END;
/

CREATE SEQUENCE account_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER accounts_insert_trig
BEFORE INSERT ON accounts
FOR EACH ROW

BEGIN
    SELECT account_pk_seq.NEXTVAL
    INTO :new.acct_id
    FROM dual;
END;
/

CREATE SEQUENCE trans_types_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER trans_types_insert_trig
BEFORE INSERT ON transaction_types
FOR EACH ROW

BEGIN
    SELECT trans_types_pk_seq.NEXTVAL
    INTO :new.trans_type_id
    FROM dual;
END;
/

CREATE SEQUENCE users_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER users_insert_trig
BEFORE INSERT ON users
FOR EACH ROW

BEGIN
    SELECT users_pk_seq.NEXTVAL
    INTO :new.user_id
    FROM dual;
END;
/

CREATE SEQUENCE transactions_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER transactions_insert_trig
BEFORE INSERT ON transactions
FOR EACH ROW

BEGIN
    SELECT transactions_pk_seq.NEXTVAL
    INTO :new.trans_id
    FROM dual;
END;
/