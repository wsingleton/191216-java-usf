
CREATE OR REPLACE procedure get_all_books(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT *
    FROM books
    ORDER BY book_id;
END;
/
