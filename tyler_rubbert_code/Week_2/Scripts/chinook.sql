-- This allows the DBMS to print messages to the console (OFF by default)
SET SERVEROUTPUT ON;

-- Function: Get the max ID from the artist table

-- Method signature (method name, return type, variables to be returned)
CREATE OR REPLACE FUNCTION get_max_id
    RETURN NUMBER
    AS max_id NUMBER;

BEGIN
    SELECT MAX(artistid)
    INTO max_id
    FROM artist;
    
    RETURN max_id;

END;
/

DECLARE
    maxId NUMBER;
BEGIN
    maxId := get_max_id();
    DBMS_OUTPUT.PUT_LINE('The max id in the artist table is ' || maxId);
END;
/

-- Because functions are schema objects (like tables), they can be dropped
DROP FUNCTION get_max_id;

-- Task: Create a function that returns all employees who are born after 1968
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
    IS my_cursor SYS_REFCURSOR;
    
BEGIN
-- Blake's solution
--    OPEN my_cursor FOR 
--    SELECT firstname, lastname, birthdate
--    FROM employee
--    WHERE birthdate > DATE '1969-12-31';
--    RETURN my_cursor;

    OPEN my_cursor FOR
    SELECT firstname, lastname, birthdate
    FROM employee
    GROUP BY firstname, lastname, birthdate
    HAVING MIN(birthdate) > DATE '1968-12-31';
    
    RETURN my_cursor;
END;
/

-- simple, yet primitive, way to invoke functions taht return cursors
SELECT after_1968()
FROM DUAL;

-- A better way - if more verbose - to look at the contents of our cursor
DECLARE
    v_cursor    SYS_REFCURSOR;
    v_fn        employee.firstname%TYPE;
    v_ln        employee.lastname%TYPE;
    v_bd        employee.birthdate%TYPE;
BEGIN
    v_cursor := after_1968();
    
    LOOP
        FETCH v_cursor
        INTO v_fn, v_ln, v_bd;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln || ' was born on ' || v_bd);
    END LOOP;
    CLOSE v_cursor;
END;
/

-- Create a procedure that returns all of the artists in the artist table
CREATE OR REPLACE PROCEDURE get_all_artist(my_cursor OUT SYS_REFCURSOR)
IS 
BEGIN
    OPEN my_cursor FOR
    SELECT * 
    FROM artist
    ORDER BY artistid;
END;
/

DECLARE 
    a_id        artist.artistid%TYPE;
    a_name      artist.name%TYPE;
    v_cursor    SYS_REFCURSOR;
BEGIN
    get_all_artist(v_cursor);
    
    LOOP
        FETCH v_cursor
        INTO a_id, a_name;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Artist id: ' || a_id || ', Name: ' || a_name);
    END LOOP;
    
    CLOSE v_cursor;
END;
/

--------------------------------------------------------------------------------------------------------------------------------

-- Create a sequence that will be used to obtain PK values (starting at 276)
CREATE SEQUENCE artist_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 276;
/

-- Create a trigger that will use ARTIST_PK_SEQ whenever a new row is inserted
CREATE OR REPLACE TRIGGER artist_insert_trig
BEFORE INSERT ON artist
FOR EACH ROW

BEGIN
    SELECT artist_pk_seq.NEXTVAL
    INTO :new.artistid
    FROM dual;
END;
/

SELECT *
FROM artist
ORDER BY artistid;

INSERT INTO artist (name)
VALUES ('Blink-182');

