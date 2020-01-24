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

INSERT INTO user_role VALUES (0, 'ADMIN');
INSERT INTO user_role VALUES (0, 'DEV');
INSERT INTO user_role VALUES (0, 'BASIC_USER');
INSERT INTO user_role VALUES (0, 'PREMIUM_USER');
INSERT INTO user_role VALUES (0, 'LOCKED');

INSERT INTO app_user VALUES (0, 'wsingleton', 'revature', 'Wezley', 'Singleton', 1);
INSERT INTO app_user VALUES (0, 'rconnell', 'rolltide', 'Robert', 'Connell', 1);
INSERT INTO app_user VALUES (0, 'skelsey', 'revasteve', 'Steven', 'Kelsey', 2);
INSERT INTO app_user VALUES (0, 'mknighten', 'knifehand', 'Jason', 'Knighten', 3);
INSERT INTO app_user VALUES (0, 'bkruppa', 'revature', 'Blake', 'Kruppa', 4);
INSERT INTO app_user VALUES (0, 'trolluser', 'banned', 'Eric', 'Cartman', 5);

INSERT INTO category VALUES (0, 'Core Java');
INSERT INTO category VALUES (0, 'Java Threads');
INSERT INTO category VALUES (0, 'Java Reflection');
INSERT INTO category VALUES (0, 'Java Collections');
INSERT INTO category VALUES (0, 'Java Streams');
INSERT INTO category VALUES (0, 'Oracle SQL');
INSERT INTO category VALUES (0, 'PostgreSQL');
INSERT INTO category VALUES (0, 'Oracle PL/SQL');
INSERT INTO category VALUES (0, 'Postgre PL/pgSQL');
INSERT INTO category VALUES (0, 'JDBC');
INSERT INTO category VALUES (0, 'HTML');
INSERT INTO category VALUES (0, 'CSS');
INSERT INTO category VALUES (0, 'Core JavaScript');
INSERT INTO category VALUES (0, 'JavaScript DOM Manipulation');
INSERT INTO category VALUES (0, 'AJAX');
INSERT INTO category VALUES (0, 'Fetch API');
INSERT INTO category VALUES (0, 'Axios');
INSERT INTO category VALUES (0, 'Java Servlets');
INSERT INTO category VALUES (0, 'TypeScript');
INSERT INTO category VALUES (0, 'Node.js');
INSERT INTO category VALUES (0, 'Angular');
INSERT INTO category VALUES (0, 'React');
INSERT INTO category VALUES (0, 'Redux');
INSERT INTO category VALUES (0, 'Express');
INSERT INTO category VALUES (0, 'AWS Cloud');
INSERT INTO category VALUES (0, 'MS Azure Cloud');
INSERT INTO category VALUES (0, 'DevOps Principles');
INSERT INTO category VALUES (0, 'Jenkins');
INSERT INTO category VALUES (0, 'Containerization');
INSERT INTO category VALUES (0, 'Container Orchestration');
INSERT INTO category VALUES (0, 'Hibernate');
INSERT INTO category VALUES (0, 'Core Spring Framework');
INSERT INTO category VALUES (0, 'Spring Boot');
INSERT INTO category VALUES (0, 'Spring Data');
INSERT INTO category VALUES (0, 'Service Oriented Architecture');
INSERT INTO category VALUES (0, 'REST Web Services');
INSERT INTO category VALUES (0, 'SOAP Web Services');
INSERT INTO category VALUES (0, 'Microservice Architecture');
INSERT INTO category VALUES (0, 'Messaging Queues');

INSERT INTO flashcard VALUES (0, 'Dummy Core Java Question 1', 'Dummy Answer', 1);
INSERT INTO flashcard VALUES (0, 'Dummy Core Java Question 2', 'Dummy Answer', 1);
INSERT INTO flashcard VALUES (0, 'Dummy Core Java Question 3', 'Dummy Answer', 1);
INSERT INTO flashcard VALUES (0, 'Dummy Java Threads Question 1', 'Dummy Answer', 2);
INSERT INTO flashcard VALUES (0, 'Dummy Oracle SQL Question 1', 'Dummy Answer', 6);
INSERT INTO flashcard VALUES (0, 'Dummy Oracle SQL Question 2', 'Dummy Answer', 6);
INSERT INTO flashcard VALUES (0, 'Dummy Core JavaScript Question 1', 'Dummy Answer', 13);
INSERT INTO flashcard VALUES (0, 'Dummy Core JavaScript Question 2', 'Dummy Answer', 13);
INSERT INTO flashcard VALUES (0, 'Dummy Core JavaScript Question 3', 'Dummy Answer', 13);
INSERT INTO flashcard VALUES (0, 'Dummy Core JavaScript Question 4', 'Dummy Answer', 13);
INSERT INTO flashcard VALUES (0, 'Dummy Angular Question 1', 'Dummy Answer', 21);
INSERT INTO flashcard VALUES (0, 'Dummy React Question 1', 'Dummy Answer', 22);
INSERT INTO flashcard VALUES (0, 'Dummy React Question 2', 'Dummy Answer', 22);
INSERT INTO flashcard VALUES (0, 'Dummy DevOps Principles Question 1', 'Dummy Answer', 27);
INSERT INTO flashcard VALUES (0, 'Dummy Containerization Question 1', 'Dummy Answer', 29);
INSERT INTO flashcard VALUES (0, 'Dummy Containerization Question 2', 'Dummy Answer', 29);
INSERT INTO flashcard VALUES (0, 'Dummy Hibernate Question 1', 'Dummy Answer', 31);
INSERT INTO flashcard VALUES (0, 'Dummy Hibernate Question 2', 'Dummy Answer', 31);
INSERT INTO flashcard VALUES (0, 'Dummy Core Spring Question 1', 'Dummy Answer', 32);
INSERT INTO flashcard VALUES (0, 'Dummy Core Spring Question 2', 'Dummy Answer', 32);
INSERT INTO flashcard VALUES (0, 'Dummy Spring Boot Question 1', 'Dummy Answer', 33);
INSERT INTO flashcard VALUES (0, 'Dummy Spring Boot Question 2', 'Dummy Answer', 33);
INSERT INTO flashcard VALUES (0, 'Dummy Microservice Architecture Question 1', 'Dummy Answer', 38);
INSERT INTO flashcard VALUES (0, 'Dummy Microservice Architecture Question 2', 'Dummy Answer', 38);

INSERT INTO study_set VALUES (0, 'Core Java Study Set', 4);
INSERT INTO study_set VALUES (0, 'Spring Study Set', 4);
INSERT INTO study_set VALUES (0, 'Core JavaScript Study Set', 5);
INSERT INTO study_set VALUES (0, 'React Study Set', 5);
INSERT INTO study_set VALUES (0, 'DevOps Study Set', 5);

INSERT INTO study_set_card VALUES (1, 1);
INSERT INTO study_set_card VALUES (1, 2);
INSERT INTO study_set_card VALUES (1, 3);
INSERT INTO study_set_card VALUES (2, 19);
INSERT INTO study_set_card VALUES (2, 20);
INSERT INTO study_set_card VALUES (2, 21);
INSERT INTO study_set_card VALUES (2, 22);
INSERT INTO study_set_card VALUES (3, 7);
INSERT INTO study_set_card VALUES (3, 8);
INSERT INTO study_set_card VALUES (3, 9);
INSERT INTO study_set_card VALUES (3, 10);
INSERT INTO study_set_card VALUES (4, 12);
INSERT INTO study_set_card VALUES (4, 13);
INSERT INTO study_set_card VALUES (5, 14);
INSERT INTO study_set_card VALUES (5, 15);
INSERT INTO study_set_card VALUES (5, 16);

COMMIT;

Update app_user set password = 'killinit' where user_id = 8;
