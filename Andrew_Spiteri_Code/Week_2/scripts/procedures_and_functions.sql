--This allows TO PRINT messages to console.  Off by default.
SET SERVEROUTPUT ON;

--Function: Get the max ID from artist table

--Method signature (method name, return type, variables to be returned)
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
    DBMS_OUTPUT.PUT_LINE('The max id  in the artist table is ' || maxId);
END;
/
 
DROP FUNCTION get_max_id;    


-- Task: Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
    IS my_cursor SYS_REFCURSOR;
        
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname, birthdate 
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
            
    RETURN my_cursor;
END;
/

CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
    IS my_cursor SYS_REFCURSOR;
        
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
            
    RETURN my_cursor;
END;
/
--simple yet primitive way to invoke functions that return cursors
SELECT after_1968()
FROM dual;

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

--Example of parameter
--CREATE OR REPLACE FUNCTION find_artist_by_id(id IN NUMBER)

--CREATE a procedure that returns all of the artists in the artist table
CREATE OR REPLACE PROCEDURE get_all_artists(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT * 
    FROM artist
    ORDER BY artistid;
END;
/

DECLARE
    a_id artist.artistid%TYPE;
    a_name artist.name%TYPE;
    v_cursor SYS_REFCURSOR;
BEGIN
    get_all_artists(v_cursor);
    LOOP
        FETCH v_cursor
        INTO a_id, a_name;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Artist id: ' || a_id || ', Name: ' || a_name);
    END LOOP;
    
    CLOSE v_cursor;
END;
/

--+__-------------------------------------------------__+

--Create a sequence that will be used to obtain PK values (starting at 276)
CREATE SEQUENCE artist_pk_seq
MINVALUE 1
MAXVALUE 9999999
INCREMENT BY 1
START WITH 276;
/

--Create a trigger that will use ARTIST_PK_SEQ whenever a new row is inserted
CREATE OR REPLACE TRIGGER artist_insert_trig
BEFORE INSERT ON artist
FOR EACH ROW

BEGIN
    SELECT artist_pk_seq.NEXTVAL
    into :new.artistid
    FROM dual;
END;
/

SELECT *
FROM artist
ORDER BY artistid

INSERT INTO artist (name)
values('Blink-182');