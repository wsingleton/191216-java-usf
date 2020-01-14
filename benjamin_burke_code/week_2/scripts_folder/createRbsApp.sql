--CREATE USER rbs_app
--IDENTIFIED BY p4ssw0rd
--DEFAULT TABLESPACE users
--TEMPORARY TABLESPACE temp
--QUOTA 10M ON users;
--
--GRANT CONNECT TO rbs_app;
--GRANT RESOURCE TO rbs_app;
--GRANT CREATE SESSION TO rbs_app;
--GRANT CREATE TABLE TO rbs_app;
--GRANT CREATE VIEW TO rbs_app;

CREATE USER rbs_user
IDENTIFIED BY p4ssw0rd;

GRANT CONNECT TO rbs_user;
GRANT CREATE SESSION TO rbs_user;
GRANT SELECT, INSERT, UPDATE ON rbs_app.users TO rbs_user;
GRANT SELECT ON rbs_app.user_roles TO rbs_user;
GRANT SELECT ON rbs_app.book_genres TO rbs_user;
GRANT SELECT, UPDATE ON rbs_app.books TO rbs_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON rbs_app.user_wishlists TO rbs_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON rbs_app.user_favorites TO rbs_user;
