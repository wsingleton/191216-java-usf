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
reimb_status_id     NUMBER CONSTRAINT reimb_status_pk PRIMARY KEY,
reimb_status        VARCHAR2(10) NOT NULL
);

CREATE TABLE ers_reimb_type (
reimb_type_id       NUMBER CONSTRAINT reimb_type_pk PRIMARY KEY,
reimb_type          VARCHAR2(10) NOT NULL
);

CREATE TABLE ers_user_roles (
ers_user_role_id    NUMBER CONSTRAINT ers_user_role_id PRIMARY KEY,
user_role           VARCHAR2(10) NOT NULL
);

CREATE TABLE ers_users (
ers_user_id         NUMBER CONSTRAINT ers_users_pk PRIMARY KEY,
ers_username        VARCHAR2(50) UNIQUE NOT NULL,
ers_password        VARCHAR2(50) NOT NULL,
user_first_name     VARCHAR2(100) NOT NULL,
user_last_name      VARCHAR2(100) NOT NULL,
user_email          VARCHAR2(150) UNIQUE NOT NULL,
user_role_id        NUMBER NOT NULL,

CONSTRAINT user_role_fk 
FOREIGN KEY (user_role_id)
REFERENCES ers_user_roles (ers_user_role_id)
);

CREATE TABLE ers_reimbursement (
reimb_id            NUMBER CONSTRAINT ers_reimbursement_pk PRIMARY KEY,
reimb_amount        NUMBER NOT NULL,
expense_date        DATE,
reimb_submitted     DATE NOT NULL,
reimb_resolved      DATE,
reimb_description   VARCHAR2(250),
reimb_receipt       BLOB,
reimb_author        NUMBER NOT NULL,
reimb_resolver      NUMBER,
reimb_status_id     NUMBER NOT NULL,
reimb_type_id       NUMBER NOT NULL,

CONSTRAINT ers_users_fk_author
FOREIGN KEY (reimb_author)
REFERENCES ers_users (ers_user_id),

CONSTRAINT ers_users_fk_resolver
FOREIGN KEY (reimb_resolver)
REFERENCES ers_users (ers_user_id),

CONSTRAINT ers_reimbursment_status_fk
FOREIGN KEY (reimb_status_id)
REFERENCES ers_reimb_status (reimb_status_id),

CONSTRAINT ers_reimbursement_type_fk
FOREIGN KEY (reimb_type_id)
REFERENCES ers_reimb_type (reimb_type_id)
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
    INTO :new.reimb_type_id
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
    INTO :new.reimb_status_id
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
    INTO :new.ers_user_role_id
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
    INTO :new.ers_user_id
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
    INTO :new.reimb_id
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

COMMIT;