SELECT * FROM user_roles;
SELECT * FROM users;
SELECT * FROM book_genres;
SELECT * FROM books;
SELECT * FROM user_wishlists;
SELECT * FROM user_favorites;

INSERT INTO BOOK_GENRES (genre_name)
VALUES('OTHER');

commit;

SELECT * FROM book_genres ORDER BY genre_id;