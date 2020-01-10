ALTER USER rbs_app
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON USERS;

GRANT CONNECT TO rbs_app;
GRANT CREATE SESSION TO rbs_app;
GRANT RESOURCE TO rbs_app;
GRANT CREATE TABLE TO rbs_app;
GRANT CREATE VIEW TO rbs_app;


/*
    Create in this order:
        User Roles
        Users
        Book Genres
        Books
        User Wishlists
        User Favorites
*/

CREATE TABLE user_roles(
    role_id     NUMBER,
    role_name   VARCHAR2(25),
    
    CONSTRAINT pk_roles
    PRIMARY KEY (role_id)
);

CREATE TABLE users (
    user_id     NUMBER,
    username    VARCHAR(25) UNIQUE NOT NULL,
    password    VARCHAR(25) NOT NULL,
    first_name    VARCHAR(25) NOT NULL,
    last_name   VARCHAR(25) NOT NULL,
    role_id     NUMBER,
    
    CONSTRAINT pk_users
    PRIMARY KEY(user_id),
    
    CONSTRAINT fk_user_role
    FOREIGN KEY(role_id)
    REFERENCES user_roles(role_id)
);
--DROP TABLE book_genres;
CREATE TABLE book_genres(
    genre_id    NUMBER,
    genre_name  VARCHAR2(25),
    
    CONSTRAINT pk_genres
    PRIMARY KEY (genre_id)
);

CREATE TABLE books(
    book_id NUMBER,
    ISBN   varchar(14),
    title  varchar(50),
    author_fn   varchar(25),
    author_ln   varchar(25),
    genre_id    NUMBER,
    price   NUMBER,
    stock_count NUMBER,
    
    CONSTRAINT pk_books
    PRIMARY KEY (book_id),
    
    CONSTRAINT fk_book_genre
    FOREIGN KEY (genre_id)
    REFERENCES book_genres(genre_id)
);
--DROP TABLE user_wishlists;
CREATE TABLE user_wishlists(
    user_id NUMBER,
    book_id NUMBER,
    
    CONSTRAINT pk_wishlist
    PRIMARY KEY (user_id,book_id),
    
    CONSTRAINT fk_wishlist_user
    FOREIGN KEY (user_id)
    REFERENCES users(user_id),
    
    CONSTRAINT fk_wishlist_book
    FOREIGN KEY (book_id)
    REFERENCES books(book_id)
    );

CREATE TABLE user_favorites(
    user_id NUMBER,
    book_id NUMBER,
    
    CONSTRAINT pk_favorites
    PRIMARY KEY (user_id,book_id),
    
    CONSTRAINT fk_favorites_user
    FOREIGN KEY (user_id)
    REFERENCES users(user_id),
    
    CONSTRAINT fk_favorites_book
    FOREIGN KEY (book_id)
    REFERENCES books(book_id)
    );
    
CREATE SEQUENCE users_pk_seq
MINVALUE 1
MAXVALUE 9999999
increment BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER users_pk_trigger
BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    SELECT users_pk_seq.NEXTVAL
    INTO :new.user_id
    FROM dual;
END;
/

CREATE SEQUENCE books_pk_seq
MINVALUE 1
MAXVALUE 9999999
increment BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER books_pk_trigger
BEFORE INSERT ON books
FOR EACH ROW
BEGIN
    SELECT books_pk_seq.NEXTVAL
    INTO :new.book_id
    FROM dual;
END;
/

CREATE SEQUENCE genre_pk_seq
MINVALUE 1
MAXVALUE 9999999
increment BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER genres_pk_trigger
BEFORE INSERT ON book_genres
FOR EACH ROW
BEGIN
    SELECT genre_pk_seq.NEXTVAL
    INTO :new.genre_id
    FROM dual;
END;
/

CREATE SEQUENCE roles_pk_seq
MINVALUE 1
MAXVALUE 9999999
increment BY 1
START WITH 1;

CREATE OR REPLACE TRIGGER roles_pk_trigger
BEFORE INSERT ON user_roles
FOR EACH ROW
BEGIN
    SELECT roles_pk_seq.NEXTVAL
    INTO :new.role_id
    FROM dual;
END;
/

ALTER TABLE books 
MODIFY isbn VARCHAR(14);

INSERT INTO user_roles VALUES (0, 'ADMIN');
INSERT INTO user_roles VALUES (0, 'MANAGER');
INSERT INTO user_roles VALUES (0, 'PREMIUM MEMBER');
INSERT INTO user_roles VALUES (0, 'BASIC MEMBER');

INSERT INTO users VALUES (0, 'wsingleton', 'p4ssw0rd', 'Wezley', 'Singleton', 1);
INSERT INTO users VALUES (0, 'dmcbee', 'password', 'Dylan', 'McBee', 2);
INSERT INTO users VALUES (0, 'bkruppa', 'p4ssword', 'Blake', 'Kruppa', 2);
INSERT INTO users VALUES (0, 'skelsey', 'drowssap', 'Steven', 'Kelsey', 2);
INSERT INTO users VALUES (0, 'njurczak', 'dr0wss4p', 'Nickolas', 'Jurczak', 2);

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

INSERT INTO books VALUES (0, '978-1118974400', 'OCA Study Guide', 'Scott', 'Selikoff', 1, 59.99, 20);
INSERT INTO books VALUES (0, '978-2352245232', 'Dark Tower I: The Gunslinger', 'Steven', 'King', 2, 9.99, 8);
INSERT INTO books VALUES (0, '978-8787924870', 'Autobiography of a Yogi', 'Paramhansa', 'Yogananda', 15, 19.99, 12);
INSERT INTO books VALUES (0, '978-3450023752', 'Deep Work', 'Cal', 'Newport', 14, 16.99, 305);
INSERT INTO books VALUES (0, '978-3450002342', 'The Upanishads', 'Eknath', 'Easwaran', 15, 8.99, 7);

INSERT INTO user_wishlists VALUES (1, 1);
INSERT INTO user_wishlists VALUES (1, 3);
INSERT INTO user_wishlists VALUES (1, 5);
INSERT INTO user_wishlists VALUES (2, 1);
INSERT INTO user_wishlists VALUES (2, 2);
INSERT INTO user_wishlists VALUES (2, 4);
INSERT INTO user_wishlists VALUES (3, 4);
INSERT INTO user_wishlists VALUES (3, 5);
INSERT INTO user_wishlists VALUES (4, 1);

select * from book_genres;
select * from books;
select * from users;
select * from user_roles;
select * from user_wishlists;
select * from user_favorites;

commit;