create user ERS
identified by Beating15
default tablespace users 
temporary tablespace temp 
quota 10M on users;
--grant privileges to admin user
grant connect to ERS;
grant resource to ERS;
grant create session to ERS;
grant create table to ERS;
grant create view to ERS;

--DROP TABLE ERS_REIMBURSMENT_STATUS
---------------------------------------------------------------


CREATE TABLE ERS_REIMBURSEMENT_STATUS(
    REIMB_STATUS_ID     NUMBER,
    REIMB_STATUS        VARCHAR2(10),
    
    CONSTRAINT REIMB_STATUS_PK PRIMARY KEY (REIMB_STATUS_ID)
)
---
CREATE SEQUENCE REIMB_STATUS_PK_SEQ;
---
CREATE OR REPLACE TRIGGER INSERT_REIMB_STATUS_PK_TRIGGER
BEFORE INSERT ON ERS_REIMBURSEMENT_STATUS
FOR EACH ROW

BEGIN
    SELECT REIMB_STATUS_PK_SEQ.NEXTVAL
    INTO :new.REIMB_STATUS_ID
    FROM dual;
END;
/
------------------------------------------------------------

CREATE TABLE ERS_REIMBURSEMENT_TYPE(
    REIMB_TYPE_ID       NUMBER,
    REIMB_TYPE          VARCHAR2(10),
    
    CONSTRAINT REIMB_TYPE_PK PRIMARY KEY (REIMB_TYPE_ID)
)
---
CREATE SEQUENCE REIMB_TYPE_ID_SEQ;
---
CREATE OR REPLACE TRIGGER INSERT_REIMB_TYPE_ID_TRIGGER
BEFORE INSERT ON ERS_REIMBURSEMENT_TYPE
FOR EACH ROW

BEGIN
    SELECT REIMB_TYPE_ID_SEQ.NEXTVAL
    INTO :new.REIMB_TYPE_ID    
    FROM dual;
END;
/
--------------------------------------------------------------------

CREATE TABLE ERS_USER_ROLES(
    ERS_USER_ROLE_ID    NUMBER,
    USER_ROLE           VARCHAR2(10),
    
    CONSTRAINT ERS_USER_ROLES_PK PRIMARY KEY (ERS_USER_ROLE_ID)
)
---

CREATE SEQUENCE ERS_USER_ROLE_ID_SEQ;

---

CREATE OR REPLACE TRIGGER INSERT_ERS_USER_ROLE_ID_TRIG
BEFORE INSERT ON ERS_USER_ROLES
FOR EACH ROW

BEGIN
    SELECT ERS_USER_ROLE_ID_SEQ.NEXTVAL
    INTO :new.ERS_USER_ROLE_ID
    FROM dual;
END;
/
-----------------------------------------------------------------------

CREATE TABLE ERS_USERS(
    ERS_USERS_ID        NUMBER,
    ERS_USERNAME        VARCHAR2(50) UNIQUE,
    ERS_PASSWORD        VARCHAR2(50),
    USER_FIRST_NAME     VARCHAR2(100),
    USER_LAST_NAME      VARCHAR2(100),
    USER_EMAIL          VARCHAR2(150) UNIQUE,
    USER_ROLE_ID        NUMBER,
    
    CONSTRAINT ERS_USERS_PK PRIMARY KEY (ERS_USERS_ID),
    
    CONSTRAINT USER_ROLES_FK FOREIGN KEY (USER_ROLE_ID) REFERENCES ERS_USER_ROLES (ERS_USER_ROLE_ID)
)

---

CREATE SEQUENCE ERS_USERS_SEQ;

---

CREATE OR REPLACE TRIGGER INSERT_ERS_USERS_TRIG
BEFORE INSERT ON ERS_USERS
FOR EACH ROW

BEGIN
    SELECT ERS_USERS_SEQ.NEXTVAL
    INTO :new.ERS_USERS_ID 
    FROM dual;
END;
/


--------------------------------------------------------------------------------

CREATE TABLE  ERS_REIMBURSEMENT (
    REIMB_ID            NUMBER,
    REIMB_AMOUNT        NUMBER,
    REIMB_SUBMITTED     TIMESTAMP,
    REIMB_RESOLVED      TIMESTAMP,
    REIMB_DESCRIPTION   VARCHAR2(250),
    REIMB_RECEIPT       BLOB,
    REIMB_AUTHOR        NUMBER,
    REIMB_RESOLVER      NUMBER,
    REIMB_STATUS_ID     NUMBER,
    REIMB_TYPE_ID       NUMBER,
    
    CONSTRAINT ERS_REIMBURSEMENT_PK PRIMARY KEY (REIMB_ID),
    
   
    CONSTRAINT ERS_USERS_FK_AUTHOR FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_USERS (ERS_USERS_ID),
    CONSTRAINT ERS_USERS_FK_RESOLVER FOREIGN KEY (REIMB_RESOLVER) REFERENCES ERS_USERS (ERS_USERS_ID),
    CONSTRAINT ERS_REIMBURSEMENT_STATUS_FK FOREIGN KEY (REIMB_STATUS_ID)REFERENCES ERS_REIMBURSEMENT_STATUS (REIMB_STATUS_ID),
    CONSTRAINT ERS_REIMBURSEMENT_TYPE_FK   FOREIGN KEY (REIMB_TYPE_ID) REFERENCES ERS_REIMBURSEMENT_TYPE (REIMB_TYPE_ID)
    
);

---

CREATE SEQUENCE REIMB_ID_SEQ;

---

CREATE OR REPLACE TRIGGER INSERT_REIMB_ID_TRIG
BEFORE INSERT ON ERS_REIMBURSEMENT
FOR EACH ROW

BEGIN
    SELECT REIMB_ID_SEQ.NEXTVAL
    INTO :new.REIMB_ID  
    FROM dual;
END;
/
--------------------------------------------------------------
COMMIT;

--------



INSERT INTO ERS_USER_ROLES VALUES (0, 'ADMIN');
INSERT INTO ERS_USER_ROLES VALUES (0, 'EMPOLYEE');

INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES (0, 'OTHER');
INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES (0, 'TRAVEL');
INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES (0, 'LODGING');
INSERT INTO ERS_REIMBURSEMENT_TYPE VALUES (0, 'FOOD');

INSERT INTO ERS_REIMBURSEMENT_STATUS VALUES (0, 'PENDING');
INSERT INTO ERS_REIMBURSEMENT_STATUS VALUES (0, 'APRROVED');
INSERT INTO ERS_REIMBURSEMENT_STATUS VALUES (0, 'DENIEND');



INSERT INTO ERS_USERS VALUES (0, 'J19', 'PASSWORD' , 'Jar','Ewe', 'tmoney@gmail.com' , 2);
INSERT INTO ERS_USERS VALUES (0, 'J20', 'PASSWORD' , 'Jarw','Ewevy', 'mones@gmail.com' , 2);
INSERT INTO ERS_USERS VALUES (0, 'J21', 'PASSWORD' , 'Jarw','Ewevy', 'monhands@gmail.com' , 2);
INSERT INTO ERS_REIMBURSEMENT VALUES (0, '15', CURRENT_TIMESTAMP , NULL,'Went to Arizona', NULL , 22, 2, 2, 1 );
-------------------------------------------

SELECT * FROM ers_reimbursement
WHERE REIMB_STATUS_ID='2';

-------------------------
UPDATE ers_reimbursement_type
SET REIMB_TYPE_ID = 3
WHERE reimb_type_id = 21;

UPDATE ers_reimbursement_type
SET REIMB_TYPE_ID = 4
WHERE reimb_type_id = 22;

COMMIT;