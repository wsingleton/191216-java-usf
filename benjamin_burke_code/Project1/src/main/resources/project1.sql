--CREATE USER ers_user
--IDENTIFIED BY p4ssw0rd;
--
--GRANT CONNECT TO ers_user;
--GRANT CREATE SESSION TO ers_user;
--GRANT SELECT, INSERT, UPDATE ON ersadmin.ers_users TO ers_user;
--GRANT SELECT ON ersadmin.ers_user_roles TO ers_user;
--GRANT SELECT, INSERT, UPDATE, DELETE ON ersadmin.ers_reimbursement TO ers_user;

--CREATE TABLE ers_reimbursement_status (
--reimb_status_id     NUMBER, 
--reimb_status        VARCHAR2(10) NOT NULL,
--CONSTRAINT pk_ers_reimbursement_status PRIMARY KEY (reimb_status_id)
--);

--CREATE TABLE ers_reimb_type (
--reimb_type_id       NUMBER,
--reimb_type          VARCHAR2(10) NOT NULL,
--CONSTRAINT pk_ers_reimb_type PRIMARY KEY (reimb_type_id)
--);

--CREATE TABLE ers_user_role
--(
--	ers_user_role_id	number,
--	user_role		varchar(10),
--	CONSTRAINT pk_ers_user_role PRIMARY KEY (ers_user_role_id)
--);

--CREATE TABLE ers_users
--(
--	ers_user_id		number,
--	ers_user_name		varchar2(50) UNIQUE NOT NuLL,
--	ers_password		varchar2(50),
--	user_first_name		varchar2(100),
--	user_last_name		varchar2(100),
--	user_email		varchar2(160) UNIQUE NOT NULL,
--	user_role_id		number,
--
--	CONSTRAINT pk_ers_users PRIMARY KEY (ers_user_id),
--	CONSTRAINT fk_ers_user_role FOREIGN KEY (user_role_id) REFERENCES ers_user_role (ers_user_role_id)
--);


--CREATE TABLE ers_reimbursement (
--reimb_id            NUMBER NOT NULL,
--reimb_amount        NUMBER NOT NULL,
--expense_date        DATE,
--reimb_submitted     DATE NOT NULL,
--reimb_resolved      DATE,
--reimb_description   VARCHAR2(250),
--reimb_receipt       BLOB,
--reimb_author        NUMBER NOT NULL,
--reimb_resolver      NUMBER,
--reimb_status_id     NUMBER NOT NULL,
--reimb_type_id       NUMBER NOT NULL,
--
--
--CONSTRAINT pk_ers_reimbursement PRIMARY KEY (reimb_id),
--
--
--
--CONSTRAINT ers_users_fk_auth FOREIGN KEY (reimb_author) REFERENCES ers_users (ers_user_id),
--
--CONSTRAINT ers_users_fk_resolver FOREIGN KEY (reimb_resolver) REFERENCES ers_users (ers_user_id),
--
--
--
--CONSTRAINT fk_ers_reimbursement_status FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status (reimb_status_id),
--
--
--CONSTRAINT fk_ers_reimbursement_type FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type (reimb_type_id)
--);



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
----+----------------------------
--+----------SEQUENCES AND TRIGGERS------------+

--CREATE SEQUENCE reimb_types_pk_seq
--MINVALUE 1
--MAXVALUE 999999999
--INCREMENT BY 1
--START WITH 1;
--/

--CREATE OR REPLACE TRIGGER reimb_types_insert_trig
--BEFORE INSERT ON ers_reimbursement_type
--FOR EACH ROW
--
--BEGIN
--    SELECT reimb_types_pk_seq.NEXTVAL
--    INTO :new.reimb_type_id
--    FROM dual;
--END;
--/

--CREATE SEQUENCE reimb_status_pk_seq
--MINVALUE 1
--MAXVALUE 999999999
--INCREMENT BY 1
--START WITH 1;
--/

--CREATE OR REPLACE TRIGGER reimb_status_insert_trig
--BEFORE INSERT ON ers_reimbursement_status
--FOR EACH ROW
--
--BEGIN
--    SELECT reimb_status_pk_seq.NEXTVAL
--    INTO :new.reimb_status_id
--    FROM dual;
--END;
--/

--CREATE SEQUENCE user_role_pk_seq
--MINVALUE 1
--MAXVALUE 999999999
--INCREMENT BY 1
--START WITH 1;
--/

--CREATE OR REPLACE TRIGGER user_role_insert_trig
--BEFORE INSERT ON ers_user_role
--FOR EACH ROW
--
--BEGIN
--    SELECT user_role_pk_seq.NEXTVAL
--    INTO :new.ers_user_role_id
--    FROM dual;
--END;
--/

--CREATE SEQUENCE users_pk_seq
--MINVALUE 1
--MAXVALUE 999999999
--INCREMENT BY 1
--START WITH 1;
--/

--CREATE OR REPLACE TRIGGER users_id_insert_trig
--BEFORE INSERT ON ers_users
--FOR EACH ROW
--
--BEGIN
--    SELECT users_pk_seq.NEXTVAL
--    INTO :new.ers_user_id
--    FROM dual;
--END;
--/

--CREATE SEQUENCE reimb_pk_seq
--MINVALUE 1
--MAXVALUE 999999999
--INCREMENT BY 1
--START WITH 1;
--/

--CREATE OR REPLACE TRIGGER reimb_insert_trig
--BEFORE INSERT ON ers_reimbursement
--FOR EACH ROW
--
--BEGIN
--    SELECT reimb_pk_seq.NEXTVAL
--    INTO :new.reimb_id
--    FROM dual;
--END;
--/


