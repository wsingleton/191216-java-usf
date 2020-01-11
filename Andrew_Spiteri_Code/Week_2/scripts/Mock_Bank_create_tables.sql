CREATE TABLE account(
    accountno   NUMBER NOT NULL,
    amount      DECIMAL(38,2),
    type        VARCHAR2(20) NOT NULL,
    
    CONSTRAINT pk_account
    PRIMARY KEY (accountno)
);

CREATE TABLE users(
    id          NUMBER NOT NULL,
    username    VARCHAR(20)NOT NULL UNIQUE,
    password    NUMBER NOT NULL,
    fname       VARCHAR2(20) NOT NULL,
    lname       VARCHAR(20) NOT NULL,
    role        NUMBER NOT NULL,
    transunion  NUMBER(38,0),
    experian    NUMBER(38,0),
    isjoint     NUMBER NOT NULL,
    jointid     NUMBER,
    
    CONSTRAINT pk_users
    PRIMARY KEY (id)
);

CREATE TABLE user_account(
    user_id NUMBER NOT NULL,
    account_no NUMBER NOT NULL,
    
    CONSTRAINT pk_user_account
    PRIMARY KEY (user_id,account_no)
);

CREATE TABLE role(
    role_id NUMBER NOT NULL,
    role_name VARCHAR2(20) NOT NULL,
    
    CONSTRAINT pk_role
    PRIMARY KEY(role_id)
);

ALTER TABLE users ADD CONSTRAINT fk_role
    FOREIGN KEY (role) REFERENCES role(role_id);
    
ALTER TABLE user_account ADD CONSTRAINT fk_users
    FOREIGN KEY (user_id) REFERENCES users(id);
    
ALTER TABLE user_account ADD CONSTRAINT fk_account
    FOREIGN KEY (account_no) REFERENCES account(accountno);
    
CREATE TABLE isjoint(
    joint_id    NUMBER NOT NULL,
    user_id     NUMBER NOT NULL,
    
    CONSTRAINT pk_isjoint
    PRIMARY KEY (joint_id, user_id),
    
    CONSTRAINT fk_user_joint
    FOREIGN KEY (user_id)
    REFERENCES users(id)
);
    
--+--------------------------------------------------------------+
DROP SEQUENCE joint_pk_seq;/
CREATE SEQUENCE joint_pk_seq MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 1;/

DROP TRIGGER joint_pk_trigger;

CREATE OR REPLACE TRIGGER joint_pk_trigger
AFTER INSERT ON users
BEGIN
    INSERT INTO isjoint (joint_id)
    VALUES (joint_pk_seq.NEXTVAL);
END;
/
 
CREATE OR REPLACE TRIGGER joint_user_pk_trigger
AFTER INSERT ON users
FOR EACH ROW
BEGIN
    INSERT INTO isjoint (user_id)
    VALUES(:new.id);
END;
/ 
 
 
 

select * 
from 
   user_errors
where 
   type = 'TRIGGER' 
and 
   name = 'joint_pk_trigger';