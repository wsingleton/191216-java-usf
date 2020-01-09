CREATE USER rbs_user
IDENTIFIED BY p4ssw0rd;

GRANT CONNECT TO rbs_user;
GRANT CREATE SESSION TO rbs_user;
GRANT SELECT, INSERT, UPDATE ON rbs_app.users to rbs_user;
GRANT SELECT ON rbs_app.user_roles to rbs_user;
GRANT SELECT ON rbs_app.book_genres to rbs_user;
GRANT SELECT, UPDATE ON rbs_app.books to rbs_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON rbs_app.user_wishlists to rbs_user;
GRANT SELECT, INSERT, UPDATE, DELETE ON rbs_app.user_favorites to rbs_user;
