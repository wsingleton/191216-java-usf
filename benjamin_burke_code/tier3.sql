CREATE TABLE app_user
(
    user_id number,
    username VARCHAR2(25) UNIQUE NOT NULL,
    password VARCHAR2(25) NOT NULL,
    first_name VARCHAR2(25) NOT NULL,
    last_name VARCHAR2(25) NOT NULL,
    role_id number NOT NULL,
    CONSTRAINT pk_app_user PRIMARY KEY (user_id),
    CONSTRAINT fk_app_user_user_role FOREIGN KEY (role_id)
    REFERENCES user_role(role_id)
);



CREATE TABLE user_role
(
role_id		number,
name 		varchar2(25) UNIQUE NOT NULL,

CONSTRAINT pk_user_role PRIMARY KEY (role_id)
);

CREATE TABLE study_set
(
study_set_id 	number CONTSTRIANT pk_study_set PRIMARY KEY,
name 		varchar2(25) UNIQUE NOT NULL,
owner_id 	number NOT NULL,
CONSTRAINT pk_study_set PRIMARY KEY (study_set_id),
CONSTRAINT fk_study_set_app_user FOREIGN KEY (owner_id)
REFERENCES app_user(user_id)

);

CREATE TABLE study_set_card
(
 study_set_id number NOT NULL,
 flashcard_id number NOT NULL,
 CONSTRAINT pk_study_set_card PRIMARY KEY (study_set_id,flashcard_id),
 CONSTRAINT fk_study_set_card_study_set FOREIGN KEY(study_set_id)
 REFERENCES study_set(study_set_id),
 CONSTRAINT fk_study_set_card_flashcard FOREIGN KEY(flashcard_id)
 REFERENCES flashcard(flashcard_id)
);

CREATE TABLE study_set
(
study_set_id number NOT NULL,
name VARCHAR2(25) UNIQUE NOT NULL,
owner_id number NOT NULL,
CONSTRAINT pk_study_set PRIMARY KEY (study_set_id),
CONSTRAINT fk_study_set_app_user FOREIGN KEY (owner_id)
REFERENCES app_user(user_id)
);

CREATE TABLE flashcard
(
flashcard_id	number NOT NULL,
question	varchar2(300) UNIQUE NOT NULL,
answer		varchar2(300) UNIQUE NOT NULL,
category_id 	number NOT NULL,
CONSTRAINT pk_flashcard PRIMARY KEY (flashcard_id),
CONSTRAINT fk_flashcard_category FOREIGN KEY (category_id)
REFERENCES category(category_id)
);

CREATE TABLE category
(
category_id number	NOT NULL,
name VARCHAR2(25) UNIQUE NOT NULL,
CONSTRAINT pk_category PRIMARY KEY (category_id)
);

-- sequences
--------------------------
CREATE SEQUENCE user_role_pk_seq
MINVALUE 1
MAXVALUE 99999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER user_role_pk_trigger
BEFORE INSERT ON user_role
FOR EACH ROW
BEGIN
	select user_role_pk_seq.NEXTVAL
	into :new.role_id
	ROM DUAL;
END;
/

CREATE SEQUENCE app_user_pk_seq
MINVALUE 1
MAXVALUE 99999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER app_user_pk_trigger
BEFORE INSERT ON app_user
FOR EACH ROW
BEGIN
	SELECT app_user_pk_seq.NEXTVAL
	INTO :new.user_id
	FROM DAUL;
END
/

CREATE SEQUENCE category_pk_seq
MINVALUE 1
MAXVALUE 99999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER category_pk_trigger
BEFORE INSERT ON category
FOR EACH ROW
BEGIN
	select category_pk_seq.NEXTVAL
	into :new category_id
	FROM DUAL;
END;
/

CREATE SEQUENCE flashcard_pk_seq
MINVALUE 1
MAXVALUE 99999
INCREMENT BY 1
START WITH 1;

CREATE OR REPLACE flashcard_pk_trigger
BEFORE INSERT ON flashcard
FOR EACH ROW
BEGIN 
	select flashcard_pk_seq.NEXTVAL
	into : new.flashcard_id
	FROM DUAL;
End;
/

CREATE SEQUENCE study_set_pk_seq
MINVALUE 1
MAXVALUE 99999
INCREMENT BY 1
START WTIH 1;

CREATE OR REPLACE study_set_pk_trigger
BEFORE INSERT ON study_set
FOR EACH ROW
BEGIN
	select study_set_pk_seq.NEXTVAL
	into :new.study_set_id
	FROM DUAL
END;
/

