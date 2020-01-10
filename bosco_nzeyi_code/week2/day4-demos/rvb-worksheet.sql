-- Give permission to a new user user in the revabooks database

CREATE USER revabooks_user
IDENTIFIED BY p4ssw0rd;

GRANT CONNECT TO revabooks_user;
GRANT CREATE SESSION TO revabooks_user;
GRANT SELECT, INSERT, UPDATE ON revabook.users TO revabooks_user;
GRANT SELECT ON revabook.user_roles TO revabooks_user;
GRANT SELECT ON revabook.book_genres TO revabooks_user;
GRANT SELECT, UPDATE ON revabook.books TO revabooks_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON revabook.user_wishlists TO revabooks_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON revabook.user_favorites TO revabooks_user;


