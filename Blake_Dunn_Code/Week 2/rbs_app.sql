/*
    Create in this order:
    
        1) USER_ROLES
        2) USERS
        3) BOOK_GENRES
        4) BOOKS
        5) USER_WISHLISTS
        6) USER_FAVORITES
*/

CREATE TABLE user_roles (
    role_id     NUMBER,
    role_name   VARCHAR2(25),
    
    CONSTRAINT pk_roles
    PRIMARY KEY (role_id)
);

CREATE TABLE users (
    user_id     NUMBER,
    username    VARCHAR2(25) UNIQUE NOT NULL,
    password    VARCHAR2(25) NOT NULL,
    first_name  VARCHAR2(25) NOT NULL,
    last_name   VARCHAR2(25) NOT NULL,
    role_id     NUMBER,
    
    CONSTRAINT pk_users
    PRIMARY KEY (user_id),
    
    CONSTRAINT fk_user_role
    FOREIGN KEY (role_id)
    REFERENCES user_roles (role_id)
);

CREATE TABLE book_genres (
    genre_id    NUMBER,
    genre_name  VARCHAR2(25),
    
    CONSTRAINT pk_genres
    PRIMARY KEY (genre_id)
);

CREATE TABLE books (
    book_id     NUMBER,
    isbn        VARCHAR2(14) UNIQUE NOT NULL,
    title       VARCHAR2(50) NOT NULL,
    author_fn   VARCHAR2(25) NOT NULL,
    author_ln   VARCHAR2(25) NOT NULL,
    genre_id    NUMBER,
    price       NUMBER,
    stock_count NUMBER,
    
    CONSTRAINT pk_books
    PRIMARY KEY (book_id),
    
    CONSTRAINT fk_book_genre
    FOREIGN KEY (genre_id)
    REFERENCES book_genres (genre_id)
);

CREATE TABLE user_wishlists (
    user_id     NUMBER,
    book_id     NUMBER,
    
    CONSTRAINT pk_ck_user_wishlists
    PRIMARY KEY (user_id, book_id),
    
    CONSTRAINT fk_wishlists_user
    FOREIGN KEY (user_id)
    REFERENCES users (user_id),
    
    CONSTRAINT fk_wishlists_book
    FOREIGN KEY (book_id)
    REFERENCES books (book_id)
);

--DROP TABLE user_wishlist;

CREATE TABLE user_favorites (
    user_id     NUMBER,
    book_id     NUMBER,
    
    CONSTRAINT pk_ck_user_favorites
    PRIMARY KEY (user_id, book_id),
    
    CONSTRAINT fk_favorites_user
    FOREIGN KEY (user_id)
    REFERENCES users (user_id),
    
    CONSTRAINT fk_favorites_book
    FOREIGN KEY (book_id)
    REFERENCES books (book_id)
);

CREATE SEQUENCE user_roles_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;


CREATE OR REPLACE TRIGGER user_roles_trigger
BEFORE INSERT ON user_roles
FOR EACH ROW
BEGIN
    SELECT user_roles_pk_seq.NEXTVAL
    INTO :new.role_id
    FROM dual;
END;
/

CREATE SEQUENCE users_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;


CREATE OR REPLACE TRIGGER users_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    SELECT users_pk_seq.NEXTVAL
    INTO :new.user_id
    FROM dual;
END;
/

CREATE SEQUENCE book_genres_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;


CREATE OR REPLACE TRIGGER book_genres_trigger
BEFORE INSERT ON book_genres
FOR EACH ROW
BEGIN
    SELECT book_genres_pk_seq.NEXTVAL
    INTO :new.genre_id
    FROM dual;
END;
/

CREATE SEQUENCE books_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1;


CREATE OR REPLACE TRIGGER books_trigger
BEFORE INSERT ON books
FOR EACH ROW
BEGIN
    SELECT books_pk_seq.NEXTVAL
    INTO :new.book_id
    FROM dual;
END;
/

--ALTER TABLE books
--MODIFY isbn VARCHAR2(14);

INSERT INTO user_roles VALUES (0, 'ADMIN');
INSERT INTO user_roles VALUES (0, 'MANAGER');
INSERT INTO user_roles VALUES (0, 'PREMIUM MEMBER');
INSERT INTO user_roles VALUES (0, 'BASIC MEMBER');
--SELECT * FROM user_roles;
--DELETE FROM user_roles WHERE role_id > 4;

INSERT INTO users VALUES (0, 'wsingleton', 'p4ssw0rd', 'Wezley', 'Singleton', 1);
INSERT INTO users VALUES (0, 'dmcbee', 'password', 'Dylan', 'McBee', 2);
INSERT INTO users VALUES (0, 'bkruppa', 'p4ssword', 'Blake', 'Kruppa', 2);
INSERT INTO users VALUES (0, 'skelsey', 'drowssap', 'Steven', 'Kelsey', 2);
INSERT INTO users VALUES (0, 'njurczak', 'dr0wss4p', 'Nickolas', 'Jurczak', 2);
--SELECT * FROM users;

INSERT INTO book_genres VALUES (0, 'TECHNICAL');
INSERT INTO book_genres VALUES (0, 'FANTASY');
INSERT INTO book_genres VALUES (0, 'ADVENTURE');
INSERT INTO book_genres VALUES (0, 'ROMANCE');
INSERT INTO book_genres VALUES (0, 'CONTEMPORARY');
INSERT INTO book_genres VALUES (0, 'DYSTOPIAN');
INSERT INTO book_genres VALUES (0, 'MYSTERY');
INSERT INTO book_genres VALUES (0, 'HORROR');
INSERT INTO book_genres VALUES (0, 'THRILLER');
INSERT INTO book_genres VALUES (0, 'HISTORICAL FICTION');
INSERT INTO book_genres VALUES (0, 'SCIENCE FICTION');
INSERT INTO book_genres VALUES (0, 'COOKING');
INSERT INTO book_genres VALUES (0, 'ART');
INSERT INTO book_genres VALUES (0, 'PERSONAL DEVELOPMENT');
INSERT INTO book_genres VALUES (0, 'SPIRITUAL');
INSERT INTO book_genres VALUES (0, 'BIOGRAPHY');
--SELECT * FROM book_genres;
--DELETE FROM book_genres WHERE genre_id > 16;

INSERT INTO books VALUES (0, '978-1118974400', 'OCA Study Guide', 'Scott', 'Selikoff', 1, 59.99, 20);
INSERT INTO books VALUES (0, '978-2352245232', 'Dark Tower I: The Gunslinger', 'Steven', 'King', 2, 9.99, 8);
INSERT INTO books VALUES (0, '978-8787924870', 'Autobiography of a Yogi', 'Paramhansa', 'Yogananda', 15, 19.99, 12);
INSERT INTO books VALUES (0, '978-3450023752', 'Deep Work', 'Cal', 'Newport', 14, 16.99, 305);
INSERT INTO books VALUES (0, '978-3450002342', 'The Upanishads', 'Eknath', 'Easwaran', 15, 8.99, 7);
--SELECT * FROM books;

INSERT INTO user_wishlists VALUES (1, 1);
INSERT INTO user_wishlists VALUES (1, 3);
INSERT INTO user_wishlists VALUES (1, 9);
INSERT INTO user_wishlists VALUES (2, 1);
INSERT INTO user_wishlists VALUES (2, 2);
INSERT INTO user_wishlists VALUES (2, 4);
INSERT INTO user_wishlists VALUES (3, 4);
INSERT INTO user_wishlists VALUES (3, 9);
INSERT INTO user_wishlists VALUES (4, 1);
--SELECT * FROM user_wishlists;

--ALTER TABLE books
--MODIFY title VARCHAR2(50);


CREATE OR REPLACE PROCEDURE get_all_books(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT *
    FROM books
    ORDER BY book_id;
END;
/

COMMIT;

SELECT * FROM book_genres;

INSERT INTO book_genres VALUES (0, 'OTHER');

UPDATE book_genres SET genre_id = 17 WHERE genre_id = 33;