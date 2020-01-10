

-- This allows to print DBMS messages to the console (OFF by default)
SET SERVEROUTPUT ON;

-- Function: Get the max id from artists table
-- method signature (method name, return type, variables to be returned)

CREATE OR REPLACE FUNCTION get_max_id
    RETURN NUMBER
    AS max_id NUMBER;
    
BEGIN 
    SELECT MAX (artistid)
    INTO max_id
    FROM artist;
    
    RETURN max_id;
END;
/
------------------------------------------------------------------ 
DECLARE 
    maxId NUMBER;
BEGIN
    maxId := get_max_id();
    DBMS_OUTPUT.PUT_LINE('The max ID in the artist table is ' || maxId);
END;
/

/*
Task: create a function that returns all employees who are born after 1968
Because we want to return different data from a table, we will use a SYS_REFCURSOR as a return type.
*/
CREATE OR REPLACE FUNCTION young_employees
    RETURN SYS_REFCURSOR
    IS born_after_1968 SYS_REFCURSOR;
BEGIN
    OPEN born_after_1968 FOR
    SELECT firstname, lastname, birthdate 
    FROM employee
    WHERE birthdate > DATE '1968-12-31';
    
    RETURN born_after_1968;
END;
/
DECLARE
    v_cursor SYS_REFCURSOR;
    v_firstname employee.firstname%TYPE;
    v_lastname employee.lastname%TYPE;
    v_birthdate employee.birthdate%TYPE;
    
BEGIN
    v_cursor:= young_employees();
    LOOP 
        FETCH v_cursor
        INTO v_firstname, v_lastname, v_birthdate;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('First name: ' || v_firstname || ', Last name: ' || v_lastname || ', Birthdate: ' || v_birthdate);
    
    
    END LOOP;
    CLOSE v_cursor;
    --DBMS_OUTPUT.PUT(v_cursor);
   -- DBMS_OUTPUT.PUT_LINE('The max ID in the artist table is ' || maxId);
END;
/

---- CURSOR FROM TUTORIALS POINT
SELECT *
FROM employee;

DECLARE
    fname employee.firstname%TYPE;
    lname employee.lastname%TYPE;
    CURSOR my_cursor IS
    SELECT firstname, lastname 
    FROM employee
    WHERE employeeid < 5;
BEGIN
    OPEN my_cursor;
    LOOP
        FETCH my_cursor INTO fname, lname;
        EXIT WHEN my_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(fname || ' ' || lname);
    END LOOP;
    CLOSE my_cursor;
END;
/

 ----------------------------------------------------
 
 -- CREATING SEQUENCES
 CREATE SEQUENCE artist_pk_seq
 MINVALUE 1
 MAXVALUE 999999999999
 INCREMENT BY 1
 START WITH 276;
 /
    
    -- Create a trigger to use the artist pk sequence
CREATE OR REPLACE TRIGGER artist_instert_trig
BEFORE INSERT ON artist
FOR EACH ROW

BEGIN
    SELECT artist_pk_seq.NEXTVAL
    INTO: new.artistid
    FROM dual;
END;
/

INSERT INTO artist(name)
VALUES('Blink-182');

-- haven't run this yet
INSERT INTO artist
VALUES(ARTIST_PK_SEQ.nextval);
    
SELECT *
FROM artist
ORDER BY artistid;


