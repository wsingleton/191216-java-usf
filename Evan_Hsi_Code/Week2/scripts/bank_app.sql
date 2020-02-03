CREATE TABLE USERS 
(
    USERID NUMBER,
    FIRSTNAME VARCHAR2(25) NOT NULL,
    LASTNAME VARCHAR2(25) NOT NULL,
    USERNAME VARCHAR2(25) NOT NULL UNIQUE,
    PASSWORD NUMBER NOT NULL,
    TYPE NUMBER NOT NULL,
    CONSTRAINT PK_USERS PRIMARY KEY (USERID)
    
);

ALTER TABLE USERS ADD CONSTRAINT FK_USERTYPE
FOREIGN KEY ( TYPE ) REFERENCES USERTYPELOOKUP ( TYPEID );

CREATE TABLE ACCOUNTS
(
    ACCOUNTID NUMBER,
    TYPE NUMBER NOT NULL,
    BALANCE NUMBER(10,2) DEFAULT 000 NOT NULL,
    CONSTRAINT PK_ACCOUNTS PRIMARY KEY (ACCOUNTID)
    
);

ALTER TABLE ACCOUNTS ADD CONSTRAINT FK_ACCOUNTTYPE
FOREIGN KEY ( TYPE ) REFERENCES ACCOUNTTYPELOOKUP ( TYPEID );

CREATE TABLE USERSACCOUNTS
(
    USERID NUMBER,
    ACCOUNTID NUMBER,
    CONSTRAINT PK_USERSACCOUNTS PRIMARY KEY (USERID, ACCOUNTID)
    
);
    
CREATE TABLE USERTYPELOOKUP
(
    TYPEID NUMBER,
    TYPE VARCHAR2(15) NOT NULL UNIQUE,
    CONSTRAINT PK_USERTYPELOOKUP PRIMARY KEY ( TYPEID )
    
);

CREATE TABLE ACCOUNTTYPELOOKUP
(
    TYPEID NUMBER,
    TYPE VARCHAR2(15) NOT NULL UNIQUE,
    CONSTRAINT PK_ACCOUNTTYPELOOKUP PRIMARY KEY ( TYPEID )
);

CREATE TABLE TRANSACTIONS
(
    TRANSACTIONID NUMBER,
    ACCOUNTID NUMBER,
    TRANSACTIONTYPE NUMBER NOT NULL,
    TRANSACTIONDATE TIMESTAMP NOT NULL,
    TRANSACTIONAMOUNT NUMBER(10,2) NOT NULL,
    CONSTRAINT PK_TRANSACTIONS PRIMARY KEY ( TRANSACTIONID ),
    CONSTRAINT FK_TRANSACTIONACCOUNT FOREIGN KEY ( ACCOUNTID )
    REFERENCES accounts ( ACCOUNTID ) ON DELETE CASCADE
);

ALTER TABLE TRANSACTIONS MODIFY TRANSACTIONTYPE NUMBER;

ALTER TABLE TRANSACTIONS ADD CONSTRAINT FK_TRANSACTIONTYPE
FOREIGN KEY ( TRANSACTIONTYPE ) REFERENCES TRANSACTIONTYPELOOKUP (TYPEID );

CREATE TABLE TRANSACTIONTYPELOOKUP
(
    TYPEID NUMBER,
    TYPE VARCHAR(15) NOT NULL UNIQUE,
    CONSTRAINT PK_TRANSACTIONTYPELOOKUP PRIMARY KEY ( TYPEID )
);
    
-- TABLE CREATION AND CONSTRAINTS +=======================================================
DROP SEQUENCE bank_user_seq;

CREATE SEQUENCE bank_user_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 10;
    

    
CREATE OR REPLACE TRIGGER bank_user_seq_trigger BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
    SELECT bank_user_seq.NEXTVAL INTO :NEW.USERID FROM DUAL;
END;
/

DROP SEQUENCE bank_account_seq;

CREATE SEQUENCE bank_account_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 20;
    
Delete From Users where USERID = 4;
    
    
CREATE OR REPLACE TRIGGER bank_account_seq_trigger BEFORE INSERT ON ACCOUNTS
FOR EACH ROW
BEGIN
    SELECT bank_account_seq.NEXTVAL INTO :NEW.ACCOUNTID FROM DUAL;
END;
/

CREATE SEQUENCE bank_transaction_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 50;
    
CREATE OR REPLACE TRIGGER bank_transaction_seq_trigger BEFORE INSERT ON TRANSACTIONS
FOR EACH ROW

DECLARE 
v_d TIMESTAMP;
BEGIN
    
    SELECT bank_transaction_seq.NEXTVAL INTO :NEW.TRANSACTIONID FROM DUAL;
    SELECT SYSTIMESTAMP INTO v_d FROM DUAL;
    :NEW.TRANSACTIONDATE := v_d;
END;
/

CREATE OR REPLACE TRIGGER insert_transaction AFTER UPDATE ON ACCOUNTS
FOR EACH ROW
DECLARE 

TRANSTYPE NUMBER;
TRANSTIME TIMESTAMP;
AMOUNT NUMBER;

BEGIN
    SELECT SYSTIMESTAMP INTO TRANSTIME FROM DUAL;
    AMOUNT := abs(:NEW.BALANCE - :OLD.BALANCE);
    IF :OLD.BALANCE < :NEW.BALANCE THEN TRANSTYPE := 1;
    ELSIF :OLD.BALANCE > :NEW.BALANCE THEN TRANSTYPE := 2;
    END IF;
    INSERT INTO TRANSACTIONS VALUES(1, :NEW.ACCOUNTID, TRANSTYPE, TRANSTIME, AMOUNT);
END;
/


CREATE OR REPLACE TRIGGER delete_user_accounts BEFORE DELETE ON USERS
FOR EACH ROW

BEGIN
    DELETE FROM ACCOUNTS 
    WHERE ACCOUNTID 
    IN (
        SELECT ACCOUNTID FROM USERSACCOUNTS
        JOIN ACCOUNTS USING(ACCOUNTID)
        WHERE ACCOUNTID IN (
                            SELECT ACCOUNTID FROM USERSACCOUNTS 
                            GROUP BY ACCOUNTID HAVING COUNT(ACCOUNTID) = 1) 
        AND USERID = 1);
    
    DELETE FROM USERSACCOUNTS WHERE USERID = :OLD.USERID;
END;
/

/*
CREATE OR REPLACE TRIGGER delete_accounts BEFORE DELETE ON USERSACCOUNTS
FOR EACH ROW

BEGIN
    IF actid IN (1, 2, 3 )
    THEN actid := 1;
    ENDIF;
    SELECT * FROM accounts;
END;
/
*/

CREATE OR REPLACE TRIGGER delete_accounts BEFORE DELETE ON USERSACCOUNTS
FOR EACH ROW

BEGIN 

    IF (:OLD.ACCOUNTID IN(SELECT ACCOUNTID FROM USERSACCOUNTS GROUP BY ACCOUNTID HAVING COUNT(ACCOUNTID) = 1)) 
    THEN DELETE FROM ACCOUNTS WHERE ACCOUNTID = :OLD.ACCOUNTID AND USERID = :OLD.USERID; 
    END IF;
    
END;
/
DROP TRIGGER delete_accounts;

SELECT ACCOUNTID, BALANCE, TRANSACTIONAMOUNT, TRANSACTIONTYPE, TRANSACTIONDATE FROM ACCOUNTS 
JOIN USERSACCOUNTS USING (ACCOUNTID)
JOIN TRANSACTIONS USING (ACCOUNTID)
WHERE USERID = 2;

DECLARE
v_d TIMESTAMP;
BEGIN
SELECT SYSTIMESTAMP INTO v_d FROM DUAL;
INSERT INTO TRANSACTIONS (accountid, transactiontype, transactiondate, transactionamount) VALUES(3, 1, v_d, 50.00);
INSERT INTO TRANSACTIONS (accountid, transactiontype, transactiondate, transactionamount) VALUES(1, 2, v_d, 20.00);

END;
/



SELECT ACCOUNTID FROM USERSACCOUNTS GROUP BY ACCOUNTID HAVING COUNT(ACCOUNTID) = 1;

DELETE FROM USERS WHERE USERNAME = 'ehsi';

SELECT * FROM USERS;
SELECT * FROM USERSACCOUNTS;
SELECT * FROM ACCOUNTS;

SELECT ACCOUNTID FROM USERSACCOUNTS a
JOIN ACCOUNTS b USING (ACCOUNTID)
JOIN USERS c USING (USERID)
WHERE ACCOUNTID NOT IN (SELECT ACCOUNTID FROM USERSACCOUNTS GROUP BY ACCOUNTID HAVING COUNT(ACCOUNTID) = 1) AND USERID = 1;

SELECT ACCOUNTID FROM USERSACCOUNTS
JOIN ACCOUNTS USING(ACCOUNTID)
WHERE ACCOUNTID IN (SELECT ACCOUNTID FROM USERSACCOUNTS GROUP BY ACCOUNTID HAVING COUNT(ACCOUNTID) = 1) AND USERID = 1;

SELECT USERID, ACCOUNTID, COUNT(ACCOUNTID) 
FROM USERSACCOUNTS
GROUP BY USERID, ACCOUNTID;
--HAVING COUNT(ACCOUNTID) = 1;
--ORDER BY USERID

SELECT * FROM bank_app.ACCOUNTS
JOIN bank_app.USERSACCOUNTS 
USING (ACCOUNTID)
WHERE USERID = 1;

commit;

INSERT INTO USERS VALUES(1, 'EVAN', 'HSI', 'ehsi', 1, 1);
INSERT INTO USERS VALUES(1, 'CONRAD', 'DIAO', 'econraddiao', 1234, 3);
UPDATE USERS SET PASSWORD = 1216985755 WHERE USERNAME = 'ehsi';

INSERT INTO ACCOUNTS (ACCOUNTID, TYPE) VALUES(1, 1);
INSERT INTO ACCOUNTS (ACCOUNTID, TYPE) VALUES(1, 2);
INSERT INTO ACCOUNTS (ACCOUNTID, TYPE) VALUES(1, 1);
INSERT INTO ACCOUNTS (ACCOUNTID, TYPE) VALUES(1, 2);

INSERT INTO USERSACCOUNTS VALUES(1, 1);
INSERT INTO USERSACCOUNTS VALUES(1, 2);
INSERT INTO USERSACCOUNTS VALUES(1, 3);
INSERT INTO USERSACCOUNTS VALUES(2, 3);
INSERT INTO USERSACCOUNTS VALUES(2, 4);

SELECT DISTINCT ACCOUNTID FROM USERSACCOUNTS WHERE USERID = 1;

delete from users;
delete from accounts;
delete from usersaccounts;
delete from transactions;



INSERT INTO USERTYPELOOKUP VALUES(1, 'ADMIN');
INSERT INTO USERTYPELOOKUP VALUES(2, 'MANAGER');
INSERT INTO USERTYPELOOKUP VALUES(3, 'BASIC_MEMBER');

INSERT INTO ACCOUNTTYPELOOKUP VALUES(1, 'CHECKING');
INSERT INTO ACCOUNTTYPELOOKUP VALUES(2, 'SAVINGS');

INSERT INTO TRANSACTIONTYPELOOKUP VALUES(1, 'DEPOSIT');
INSERT INTO TRANSACTIONTYPELOOKUP VALUES(2, 'WITHDRAWAL');
    
-- SEQUENCES AND TRIGGERS +===========================================================

CREATE OR REPLACE PROCEDURE junction(OWNERID IN NUMBER, ACCOUNTID IN NUMBER)
IS
BEGIN
    INSERT INTO USERSACCOUNTS VALUES(OWNERID, ACCOUNTID);
END;
/

BEGIN
    junction(1,1);
END;
/

INSERT INTO bank_app.accounts VALUES(0, 0.00, 1);

CREATE OR REPLACE PROCEDURE withdrawCheck(ID IN NUMBER, AMOUNT IN NUMBER)
IS

BAL NUMBER;

BEGIN
    SELECT BALANCE INTO BAL FROM ACCOUNTS WHERE ACCOUNTID = ID;
    IF AMOUNT < BAL 
    THEN UPDATE accounts SET BALANCE = BALANCE - AMOUNT WHERE ACCOUNTID = ID;
    END IF;
END;
/

UPDATE ACCOUNTS SET BAlANCE = BALANCE + 50 WHERE ACCOUNTID = 2;

DECLARE
TEMP NUMBER;
BEGIN
    withdrawCheck(2, 40);
END;
/

commit;

CREATE OR REPLACE PROCEDURE delete_account_check(ID IN NUMBER)
IS

BEGIN
    IF ID NOT IN(SELECT DISTINCT ACCOUNTID FROM USERSACCOUNTS)
    THEN DELETE FROM ACCOUNTS WHERE ACCOUNTID = ID;
    END IF;
END;
/



CREATE OR REPLACE PROCEDURE delete_account_check(my_cursor OUT SYS_REFCURSOR, ID IN NUMBER)
IS
BEGIN
    
    OPEN my_cursor FOR SELECT DISTINCT ACCOUNTID FROM USERSACCOUNTS WHERE USERID = ID;
    
END;
/

DECLARE
    v_cursor        SYS_REFCURSOR;
    
BEGIN
    
    delete_account_check(v_cursor);
    
    LOOP
        Cursor.delete();
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln);
    END LOOP;
    CLOSE v_cursor;
    
END;
/





