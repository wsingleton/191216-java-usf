--DROP TABLE ers_reimbursement;
--DROP TABLE ers_users;
--DROP TABLE ers_reimb_status;
--DROP TABLE ers_reimb_type;
--DROP TABLE ers_user_roles;
--DROP SEQUENCE reimb_pk_seq;
--DROP SEQUENCE reimb_status_pk_seq;
--DROP SEQUENCE reimb_types_pk_seq;
--DROP SEQUENCE user_role_pk_seq;
--DROP SEQUENCE users_pk_seq;
----+---------------------------------------------------------------

CREATE TABLE ers_reimb_status (
statusId     NUMBER CONSTRAINT reimb_status_pk PRIMARY KEY,
status        VARCHAR2(10) NOT NULL
);

CREATE TABLE ers_reimb_type (
typeId       NUMBER CONSTRAINT reimb_type_pk PRIMARY KEY,
type          VARCHAR2(10) NOT NULL
);

CREATE TABLE ers_user_roles (
roleId         NUMBER CONSTRAINT user_role_id PRIMARY KEY,
role           VARCHAR2(10) NOT NULL
);

CREATE TABLE ers_users (
userId          NUMBER CONSTRAINT ers_users_pk PRIMARY KEY,
username        VARCHAR2(50) UNIQUE NOT NULL,
password        VARCHAR2(50) NOT NULL,
firstName       VARCHAR2(100) NOT NULL,
lastName        VARCHAR2(100) NOT NULL,
email           VARCHAR2(150) UNIQUE NOT NULL,
roleId          NUMBER NOT NULL,

CONSTRAINT user_role_fk 
FOREIGN KEY (roleId)
REFERENCES ers_user_roles (roleId)
);

CREATE TABLE ers_reimbursement (
reimbId            NUMBER CONSTRAINT ers_reimbursement_pk PRIMARY KEY,
amount             NUMBER NOT NULL,
submitted          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
resolved           DATE,
description        VARCHAR2(250),
receipt            BLOB,
author             NUMBER NOT NULL,
resolver           NUMBER,
statusId           NUMBER NOT NULL,
typeId             NUMBER NOT NULL,

CONSTRAINT ers_users_fk_author
FOREIGN KEY (author)
REFERENCES ers_users (userId),

CONSTRAINT ers_users_fk_resolver
FOREIGN KEY (resolver)
REFERENCES ers_users (userId),

CONSTRAINT ers_reimbursment_status_fk
FOREIGN KEY (statusId)
REFERENCES ers_reimb_status (statusId),

CONSTRAINT ers_reimbursement_type_fk
FOREIGN KEY (typeId)
REFERENCES ers_reimb_type (typeId)
);

--+----------SEQUENCES AND TRIGGERS------------+

CREATE SEQUENCE reimb_types_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER reimb_types_insert_trig
BEFORE INSERT ON ers_reimb_type
FOR EACH ROW

BEGIN
    SELECT reimb_types_pk_seq.NEXTVAL
    INTO :new.typeId
    FROM dual;
END;
/

CREATE SEQUENCE reimb_status_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER reimb_status_insert_trig
BEFORE INSERT ON ers_reimb_status
FOR EACH ROW

BEGIN
    SELECT reimb_status_pk_seq.NEXTVAL
    INTO :new.statusId
    FROM dual;
END;
/

CREATE SEQUENCE user_role_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER user_role_insert_trig
BEFORE INSERT ON ers_user_roles
FOR EACH ROW

BEGIN
    SELECT user_role_pk_seq.NEXTVAL
    INTO :new.roleId
    FROM dual;
END;
/

CREATE SEQUENCE users_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER users_id_insert_trig
BEFORE INSERT ON ers_users
FOR EACH ROW

BEGIN
    SELECT users_pk_seq.NEXTVAL
    INTO :new.userId
    FROM dual;
END;
/

CREATE SEQUENCE reimb_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;
/

CREATE OR REPLACE TRIGGER reimb_insert_trig
BEFORE INSERT ON ers_reimbursement
FOR EACH ROW

BEGIN
    SELECT reimb_pk_seq.NEXTVAL
    INTO :new.reimbId
    FROM dual;
END;
/

INSERT INTO ers_reimb_status VALUES (0, 'PENDING');
INSERT INTO ers_reimb_status VALUES (0, 'APRROVED');
INSERT INTO ers_reimb_status VALUES (0, 'DENIED');

INSERT INTO ers_reimb_type VALUES (0, 'LODGING');
INSERT INTO ers_reimb_type VALUES (0, 'TRAVEL');
INSERT INTO ers_reimb_type VALUES (0, 'FOOD');
INSERT INTO ers_reimb_type VALUES (0, 'OTHER');

INSERT INTO ers_user_roles VALUES (0, 'ADMIN');
INSERT INTO ers_user_roles VALUES (0, 'MANAGER');
INSERT INTO ers_user_roles VALUES (0, 'EMPLOYEE');

INSERT INTO ers_users VALUES (0, 'buhlakay', 'boatsnhoes', 'Blake', 'Dunn', 'bdunn@buhlakify.com', 1);
INSERT INTO ers_users VALUES (0, 'spacemvn', 'nevergonnascore', 'Ervin', 'Stewart', 'estewart@buhlakify.com', 2);

COMMIT;

select * from ers_users;

delete from ers_users where userId = 21;

select * from ers_users where username = 'buhlakay' and password = 'boatsnhoes';

INSERT INTO ers_reimbursement (reimbId, amount, description, author, statusId, typeId)
VALUES (0, 25.00, 'TEST', 41, 1, 1);
INSERT INTO ers_reimbursement (reimbId, amount, description, author, statusId, typeId)
VALUES (0, 25.00, 'TEST', 41, 1, 1);

select * from ers_reimbursement where statusId = 1;

update ers_reimbursement
set resolved = current_date, resolver = 1, statusId = 2 where reimbId = 2;
