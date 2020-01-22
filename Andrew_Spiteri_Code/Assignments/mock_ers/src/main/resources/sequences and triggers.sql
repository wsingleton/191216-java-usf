CREATE SEQUENCE ers_users_pk_seq
MINVALUE 1 
MAXVALUE 9999999
INCREMENT BY 1;

CREATE SEQUENCE ers_reimbursement_pk_seq
MINVALUE 1 
MAXVALUE 9999999
INCREMENT BY 1;


CREATE OR REPLACE TRIGGER ers_users_insert_trig
BEFORE INSERT ON ers_users
FOR EACH ROW

BEGIN
    SELECT ers_users_pk_seq.NEXTVAL
    into :new.ers_users_id
    FROM dual;
END;
/

CREATE OR REPLACE TRIGGER ers_users_insert_trig
BEFORE INSERT ON ers_users
FOR EACH ROW

BEGIN
    SELECT ers_users_pk_seq.NEXTVAL
    into :new.ers_users_id
    FROM dual;
END;
/