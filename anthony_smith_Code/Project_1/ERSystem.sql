create user ers_admin identified by p4ssw0rd default tablespace users temporary tablespace temp quota 10M on users;
--grant privileges to admin user
grant connect to ers_admin;
grant resource to ers_admin;
grant create session to ers_admin;
grant create table to ers_admin;
grant create view to ers_admin;


----------------------------------------------------


CREATE TABLE ERS_REIMBURSMENT_STATUS
(
    REIMB_STATUS_ID     NUMBER,
    REIMB_STATUS        VARCHAR2(10),
    
    CONSTRAINT REIMB_STATUS_PK PRIMARY KEY (REIMB_STATUS_ID)
)

------------------------------------------------------

CREATE TABLE ERS_REIMNURSEMENT_TYPE
(
    REIMB_TYPE_ID       NUMBER,
    REIMB_TYPE          VARCHAR2(10),
    
    CONSTRAINT REIMB_TYPE_PK PRIMARY KEY (REIMB_TYPE_ID)
)

-------------------------------------------------------

CREATE TABLE ERS_USER_ROLES
(
    ERS_USER_ROLE_ID    NUMBER,
    USER_ROLE           VARCHAR2(10),
    
    CONSTRAINT ERS_USER_ROLES_PK PRIMARY KEY (ERS_USER_ROLE_ID)
)

---------------------------------------------------------

CREATE TABLE ERS_USERS
(
    ERS_USERS_ID    NUMBER,
    ERS_USERNAME    VARCHAR2(50) UNIQUE,
    ERS_PASSWORD    VARCHAR2(50),
    USER_FIRST_NAME VARCHAR2(100),
    USER_LAST_NAME  VARCHAR2(100),
    USER_EMAIL      VARCHAR2(100) UNIQUE,
    USER_ROLE_ID    NUMBER,
    
    CONSTRAINT ERS_USERS_PK PRIMARY KEY (ERS_USERS_ID),
    
    CONSTRAINT USER_ROLES_FK FOREIGN KEY (USER_ROLE_ID) REFERENCES ERS_USER_ROLES
)

-----------------------------------------------------------------

CREATE TABLE  ERS_REIMBURSEMENT 
(
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
    
    CONSTRAINT ERS_USERS_FK_RESLVR FOREIGN KEY (REIMB_RESOLVER) REFERENCES ERS_REIMBURSEMENT,
    CONSTRAINT ERS_USERS_FK_AUTH FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_REIMBURSEMENT,
    CONSTRAINT ERS_REIMBURSEMENT_STATUS_FK FOREIGN KEY (REIMB_STATUS_ID)REFERENCES ERS_REIMBURSEMENT,
    CONSTRAINT ERS_REIMBURSEMENT_TYPE_FK   FOREIGN KEY (REIMB_TYPE_ID) REFERENCES ERS_REIMBURSEMENT
    
    
)
