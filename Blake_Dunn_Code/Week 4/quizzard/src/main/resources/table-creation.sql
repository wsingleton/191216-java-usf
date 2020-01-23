CREATE TABLE user_role (
    role_id		NUMBER,
    name	VARCHAR2(25) UNIQUE NOT NULL,

    CONSTRAINT pk_user_role
    PRIMARY KEY (role_id)
);

CREATE TABLE app_user (
    user_id		NUMBER,
    username	VARCHAR2(25) UNIQUE NOT NULL,
    password	VARCHAR2(256) NOT NULL,
    first_name	VARCHAR2(25) NOT NULL,
    last_name	VARCHAR(25) NOT NULL,
    role_id		NUMBER NOT NULL,

    CONSTRAINT pk_app_user
    PRIMARY KEY (user_id),

    CONSTRAINT fk_user_role
    FOREIGN KEY (role_id)
    REFERENCES user_role (role_id)
);

CREATE TABLE category (
    category_id		NUMBER,
    name			VARCHAR2(50) UNIQUE NOT NULL,

    CONSTRAINT pk_category
    PRIMARY KEY (category_id)
);

CREATE TABLE flashcard (
    flashcard_id	NUMBER,
    question		VARCHAR2(1000) UNIQUE NOT NULL,
    answer			VARCHAR2(1000) NOT NULL,
    category_id		NUMBER NOT NULL,

    CONSTRAINT pk_flashcard
    PRIMARY KEY (flashcard_id),

    CONSTRAINT fk_flashcard_category
    FOREIGN KEY (category_id)
    REFERENCES category (category_id)
);

CREATE TABLE study_set (
    study_set_id	NUMBER,
    name			VARCHAR2(100) NOT NULL,
    owner_id		NUMBER NOT NULL,

    CONSTRAINT pk_study_set
    PRIMARY KEY (study_set_id),

    CONSTRAINT fk_study_set_owner
    FOREIGN KEY (owner_id)
    REFERENCES app_user (user_id)
);

CREATE TABLE study_set_card (
    study_set_id	NUMBER,
    flashcard_id	NUMBER,

    CONSTRAINT pk_ck_study_set_card
    PRIMARY KEY (study_set_id, flashcard_id),

    CONSTRAINT fk_study_set
    FOREIGN KEY (study_set_id)
    REFERENCES study_set (study_set_id),

    CONSTRAINT fk_flashcard
    FOREIGN KEY (flashcard_id)
    REFERENCES flashcard (flashcard_id)

);

------------------------------------------------

CREATE SEQUENCE user_role_pk_seq
    MINVALUE 1
    MAXVALUE 9999999
    INCREMENT BY 1
    START WITH 1;

CREATE OR REPLACE TRIGGER user_role_binsert_trigger
    BEFORE INSERT ON user_role
    FOR EACH ROW
BEGIN
    SELECT user_role_pk_seq.NEXTVAL
    INTO :new.role_id
    FROM dual;
END;
/

----------------------------------------------------------

CREATE SEQUENCE app_user_pk_seq
    MINVALUE 1
    MAXVALUE 9999999
    INCREMENT BY 1
    START WITH 1;

CREATE OR REPLACE TRIGGER app_user_binsert_trigger
    BEFORE INSERT ON app_user
    FOR EACH ROW
BEGIN
    SELECT app_user_pk_seq.NEXTVAL
    INTO :new.user_id
    FROM dual;
END;
/

----------------------------------------------------------

CREATE SEQUENCE category_pk_seq
    MINVALUE 1
    MAXVALUE 9999999
    INCREMENT BY 1
    START WITH 1;

CREATE OR REPLACE TRIGGER category_binsert_trigger
    BEFORE INSERT ON category
    FOR EACH ROW
BEGIN
    SELECT category_pk_seq.NEXTVAL
    INTO :new.category_id
    FROM dual;
END;
/

----------------------------------------------------------

CREATE SEQUENCE flashcard_pk_seq
    MINVALUE 1
    MAXVALUE 9999999
    INCREMENT BY 1
    START WITH 1;

CREATE OR REPLACE TRIGGER flashcard_binsert_trigger
    BEFORE INSERT ON flashcard
    FOR EACH ROW
BEGIN
    SELECT flashcard_pk_seq.NEXTVAL
    INTO :new.flashcard_id
    FROM dual;
END;
/

----------------------------------------------------------

CREATE SEQUENCE study_set_pk_seq
    MINVALUE 1
    MAXVALUE 9999999
    INCREMENT BY 1
    START WITH 1;

CREATE OR REPLACE TRIGGER study_set_binsert_trigger
    BEFORE INSERT ON study_set
    FOR EACH ROW
BEGIN
    SELECT study_set_pk_seq.NEXTVAL
    INTO :new.study_set_id
    FROM dual;
END;
/