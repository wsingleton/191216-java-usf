-- this allows DBMS to print to console , off by default 
SET SERVEROUTPUT ON;

-- Functions: Get the max ID from the artist table 

-- Method signature (method name, return type, variable to be return)
CREATE OR REPLACE FUNCTION get_max_id
    RETURN NUMBER
    AS max_id NUMBER;
    
BEGIN
    -- bussiness logic goes here 
    SELECT MAX(artistID)
    INTO max_id
    FROM artist;
    
    RETURN max_id;
END;
/

DECLARE 
    maxID NUMBER;
BEGIN
    maxID := get_max_id();
    DBMS_OUTPUT.PUT_LINE('THE MAX IS IN THE ARTIST TABLE IS '|| maxID);
END;    
/

-- Because functions are schema objects (like tables), they can be dropped

DROP FUNCTION get_max_id;


-- Task: Create a function that returnd all employees who are born after 1968

CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
    IS my_cursor SYS_REFCURSOR;
    
BEGIN
    OPEN my_cursor FOR 
    SELECT firstname, lastname, birthdate
    FROM employee
    GROUP BY firstname, lastname, birthday
    HAVING MIN (birthdate)> DATE '1968-12-31';
    
    RETURN my_cursor;
    
END;
/




DECLARE     
    v_cursor    SYS_REFCURSOR;
    v_fn        employee.firstname%TYPE;
    v_ln        employee.lastname%TYPE;
    v_bd        employee.birthdate%TYPE;
BEGIN
    v_cursor := after_1968();
    
    LOOP
    END LOOP;
    CLOSE v_cursor
    
END;
/




-- create a procedures that returns all of the artist in the artist table 

CREATE OR REPLACE FUNCTION get_all_artists(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor
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
        DBMS_OUTPUT.PUT_LINE('Artist id: ' || a_id ||  ', Name: ' || a_name);
    END LOOP;
    
    CLOSE v_cursor;
END;
/

----------------------------------------------------------------------------------------


CREATE OR  SEQUENCE artist_pk_seq
MINVALUE 1
MAXVALUE 99999999999
INCREMENT BY 1
START WITH 276;
/
    

    
CREATE OR REPLACE TRIGGER artist_insert_trig
BEFORE INSERT ON ARTIST
FOR EACH ROW 

BEGIN 
    SELECT artist_pk_seq.NEXTVAL
    INTO :  new.artistid
    FROM daul;
END;
/


SELECT *
FROM artist
ORDER BY artistid;

INSERT INTO  artist (name)
VALUES  ('Blink-182');

--INSERT INTO artist
--VALUES (artist_pk_seq.NEXTVAL, 'Blind Guardian');

INS