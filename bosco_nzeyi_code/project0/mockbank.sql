/*
db details for mock BANK application
*/
SET SERVEROUTPUT ON;

-- TABLE FOR USERS
CREATE TABLE users(
 user_id NUMBER,
 first_name VARCHAR2(50) NOT NULL,
 last_name VARCHAR2(50) NOT NULL,
 username VARCHAR2(10) UNIQUE NOT NULL,
 address VARCHAR2(100),
 password VARCHAR2(10) NOT NULL,
 role VARCHAR2(50) DEFAULT 'Customer',
 CONSTRAINT pk_users
 PRIMARY KEY (user_Id)
);

--DROP TABLE users;
--DROP TABLE accounts;
--DROP TABLE activities;
--DROP TABLE users_accounts;

-- TABLE TO HOLD ACCOUNTS
/*
accounts table rules
-   Unique account numbers
- Accessible by account Id.
- multiple users can share one account
Account access can be Personal or Shared.
*/
CREATE TABLE accounts(
account_id NUMBER,
account_type VARCHAR2(25) DEFAULT 'Checking' NOT NULL,
account_access VARCHAR2(25) DEFAULT 'Personal',
date_opened DATE,
current_balance NUMBER(30,2) DEFAULT 0,

CONSTRAINT pk_accounts
PRIMARY KEY (account_id)
);

-- TABLE TO RECORD ACCOUNT ACCOUNT HISTORY
/*
Rules: 
- The table will register the type of activities performed and dates.
- Acivities can be Deposit or Saving
- A user id of the person who perfrmed the activity is recorded.
- if a shared account is used by multiple users, the activity log will log the individual responsible for the activity.
*/

CREATE TABLE activities(
activity_id NUMBER NOT NULL,
user_id NUMBER NOT NULL,
account_id NUMBER NOT NULL,
activity_date DATE NOT NULL,
transaction_details VARCHAR2(50) NOT NULL,
amount NUMBER (30,2) NOT NULL,

CONSTRAINT pk_activities
PRIMARY KEY (activity_id), 

CONSTRAINT fk_users
FOREIGN KEY (user_id)
REFERENCES users (user_id)
ON DELETE CASCADE,

CONSTRAINT fk_accounts_table
FOREIGN KEY (account_id)
REFERENCES accounts (account_id)
ON DELETE CASCADE

);

/*
USERS_ACCOUNTS 

    this table is to bridge the users and their accounts. 
    1 user can have multiple accounts. 
    This is a third normal form concept to provide a safe link between the two 2 tables
    while avoiding duplicate information.

*/

CREATE TABLE users_accounts(
user_id NUMBER,
account_id NUMBER,

CONSTRAINT fk_users_accounts_users
FOREIGN KEY (user_id)
REFERENCES users (user_id)
ON DELETE CASCADE,

CONSTRAINT fk_users_accounts_accounts
FOREIGN KEY (account_id)
REFERENCES accounts (account_id)
ON DELETE CASCADE

);

--COMMIT;

-- SEQUENCE TO CREATE PRIMARY KEYS
 --- Seq 1: Sequence to create user ids
CREATE SEQUENCE userid_factory
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 999999999999999
CYCLE;
/

 --- Seq 2: Sequence to create account ids
CREATE SEQUENCE accountid_factory
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 999999999999999
CYCLE;
/

 --- Seq 3: Sequence to create activities ids
CREATE SEQUENCE activityid_factory
START WITH 1
INCREMENT BY 1
MINVALUE 1
MAXVALUE 999999999999999
CYCLE;
/

-- TRIGGERS TO AUTOMATE SEQS WHEN NEW ROWS ARE INSERTED IN TABLES
    -- Trigger for user ids
CREATE OR REPLACE TRIGGER create_userid_trig
BEFORE INSERT
ON users
FOR EACH ROW

BEGIN
    SELECT userid_factory.NEXTVAL
    INTO: new.user_id
    FROM dual;
END;
/
    -- Trigger for account ids
CREATE OR REPLACE TRIGGER create_accountid_trig
BEFORE INSERT
ON accounts
FOR EACH ROW

BEGIN
    SELECT accountid_factory.NEXTVAL
    INTO: new.account_id
    FROM dual;
END;
/
    -- Trigger for activity ids
CREATE OR REPLACE TRIGGER create_activityid_trig
BEFORE INSERT
ON activities
FOR EACH ROW

BEGIN
    SELECT activityid_factory.NEXTVAL
    INTO: new.activity_id
    FROM dual;
END;
/

INSERT INTO activities(activity_id, user_id, account_id, transaction_details, amount)
VALUES(0, 1, 1, 'Deposit', 100);

-- Removes address column from the table
ALTER TABLE users
DROP COLUMN address;

-- Removes date openned column from the table
ALTER TABLE accounts
DROP COLUMN date_opened;

-- Set sysdate as default input for date-opened column in accounts table
ALTER TABLE accounts
MODIFY date_opened DATE DEFAULT SYSDATE;

-- Set localtimestamp as default input for activity_date column in activitiess table
ALTER TABLE activities
MODIFY activity_date TIMESTAMP DEFAULT LOCALTIMESTAMP;

-- selecting a specific time element form a column that has date as input type
SELECT EXTRACT(SECOND FROM activity_date) "second" FROM activities ;

COMMIT;

SELECT * FROM activities;
SELECT SYSDATE FROM DUAL;
DELETE FROM accounts;
-- UPDATING BALANCES ON SAVINGS ACCOUNTS AND CALCULATING COMPOUND INTEREST EARNED
    --
    --
    --
    --
    
-- INSERTING PRELIMINARY DATA IN THE USERS_ACCOUNTS TABLE (COMPOSITE KEY TABLE)
--INSERT INTO users_accounts
--VALUES(1, 1);
--INSERT INTO users_accounts
--VALUES(1, 2);
--COMMIT;

-- CREATE A PROCEDURE THAT UPDATES THE AMOUNT IF A DEPOSIT OR WITHDRAW IS MADE
CREATE OR REPLACE PROCEDURE update_balance (accountId IN NUMBER, amount IN NUMBER, activity_type IN VARCHAR2)
IS  
BEGIN

    IF
    activity_type = 'Deposit'
    THEN
    UPDATE accounts
    SET current_balance = current_balance + amount
    WHERE account_id = accountId;
    ELSIF
    activity_type = 'Withdraw'
    THEN 
    UPDATE accounts
    SET current_balance = current_balance - amount
    WHERE account_id = accountId;
    ELSE
    dbms_output.put_line('Request failed');
    END IF;
END;
/

BEGIN
update_balance(43, 50, 'Withdraw');
END;

SELECT * FROM accounts WHERE account_id = 91;
SELECT * FROM activities WHERE account_id = 91;
SELECT * FROM users_accounts WHERE user_id = 32;
SELECT * FROM ACTIVITIES;

SELECT * FROM accounts;
SELECT * FROM users_accounts;
SELECT * FROM users WHERE username = 'nebo';

INSERT INTO users_accounts VALUES(61, 45);
COMMIT;

DELETE FROM activities WHERE amount < 0;
COMMIT;





