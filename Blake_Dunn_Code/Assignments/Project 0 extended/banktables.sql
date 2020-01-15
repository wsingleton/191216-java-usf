/*
    1) Users
    2) AccountTypes
    3) Accounts
    4) UsersAccounts
    5) TransactionType
    6) Transactions
*/

-- +-------------------------------------------------------------------+


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

ALTER TABLE accounts
ADD created_date DATE DEFAULT CURRENT_DATE;

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
    trans_date          TIMESTAMP DEFAULT CURRENT_TIMESTAMP(0),
    
    CONSTRAINT pk_transactions
    PRIMARY KEY (trans_id),
    
    CONSTRAINT fk_transactions_users_accounts
    FOREIGN KEY (user_id, acct_id)
    REFERENCES users_accounts (user_id, acct_id),
    
    CONSTRAINT fk_trans_types
    FOREIGN KEY (trans_type_id)
    REFERENCES transaction_types (trans_type_id)
);
DROP TABLE transactions;

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

CREATE SEQUENCE accounts_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER accounts_insert_trig
BEFORE INSERT ON accounts
FOR EACH ROW

BEGIN
    SELECT accounts_pk_seq.NEXTVAL
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

-- +-------------------------------------------------------------+

INSERT INTO account_types VALUES (0, 'CHECKING');
INSERT INTO account_types VALUES (0, 'SAVINGS');


INSERT INTO transaction_types VALUES (0, 'DEPOSIT');
INSERT INTO transaction_types VALUES (0, 'WITHDRAW');
INSERT INTO transaction_types VALUES (0, 'TRANSFER');


INSERT INTO users VALUES (0, 'buhlakay9', 'k!llinit', 'Blake', 'Dunn');
INSERT INTO users VALUES (0, 'spacemvn69', 'fly!inhigh', 'Ervin', 'Stewart');
INSERT INTO users VALUES (0, 'bossco96', 'str8ball!n', 'Bosco', 'Nzeyimana');
INSERT INTO users VALUES (0, 'nilesbarkley', 'n!ghtowl', 'Niles', 'Diggs');
INSERT INTO users VALUES (0, 'bigbenji123', 'wh@tsupbro', 'Ben', 'Burke');
INSERT INTO users VALUES (0, 'hellatight', 'notfromnorc@l', 'Jared', 'Carter');
INSERT INTO users VALUES (0, 'bigballer', 'l@kers4life', 'Kobe', 'Bryant');
INSERT INTO users VALUES (0, 'laxbro99', 'f!owbucket', 'Corbin', 'Dunn');


INSERT INTO accounts VALUES (0, 1, 5000);
INSERT INTO accounts VALUES (0, 1, 2576.45);
INSERT INTO accounts VALUES (0, 1, 10000);
INSERT INTO accounts VALUES(0, 1, 3500);
INSERT INTO accounts VALUES (0, 1, 4098);
INSERT INTO accounts VALUES(0, 1, 63524);
INSERT INTO accounts VALUES(0, 1, 73643);
INSERT INTO accounts VALUES (0, 1, 500);

INSERT INTO accounts (acct_id, type_id, balance) VALUES (0, 2, 4098);
INSERT INTO accounts (acct_id, type_id, balance) VALUES(0, 2, 63524);
INSERT INTO accounts (acct_id, type_id, balance) VALUES(0, 2, 73643);
INSERT INTO accounts (acct_id, type_id, balance) VALUES (0, 2, 500);


INSERT INTO users_accounts VALUES (1,1);
INSERT INTO users_accounts VALUES (2,2);
INSERT INTO users_accounts VALUES (3,3);
INSERT INTO users_accounts VALUES (4,4);
INSERT INTO users_accounts VALUES (5,5);
INSERT INTO users_accounts VALUES (6,6);
INSERT INTO users_accounts VALUES (7,7);
INSERT INTO users_accounts VALUES (8,8);
INSERT INTO users_accounts VALUES (1,21);
INSERT INTO users_accounts VALUES (2,22);
INSERT INTO users_accounts VALUES (3,23);
INSERT INTO users_accounts VALUES (4,24);

COMMIT;

CREATE OR REPLACE PROCEDURE update_acct (bal IN accounts.balance%TYPE, a_id IN accounts.acct_id%TYPE)
IS
BEGIN
    UPDATE accounts
    SET balance = bal
    WHERE acct_id = a_id;

    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE add_trans (tr_id IN transactions.trans_id%type, u_id IN transactions.user_id%TYPE, a_id IN transactions.acct_id%TYPE, 
    t_id IN transactions.trans_type_id%TYPE, amount IN transactions.amount%TYPE)
IS
BEGIN
    INSERT INTO transactions (trans_id, user_id, acct_id,trans_type_id, amount)
    VALUES (tr_id, u_id, a_id, t_id, amount);
    
    COMMIT;
END;
/

CALL add_trans (1,1,1,1,500);

Delete from users where user_id = 21;
commit;
insert into users_accounts values (22, 26);
SELECT user_id, acct_id, trans_type_id, amount, trans_date(TO_CHAR(trans_date, 'MM/DD/YY HH24:MM:SS')) AS "Transaction_Date"
FROM transactions
WHERE user_id = 1 AND acct_id = 1;
