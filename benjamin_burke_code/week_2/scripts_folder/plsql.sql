SET SERVEROUTPUT ON;

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

DROP FUNCTION get_max_id;

--task: Create a function that returns all employees who are born after 1968

CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
    IS my_cursor SYS_REFCURSOR;

BEGIN
--  bLAKES SOLUTION
--   OPEN my_cursor FOR
--   SELECT fristname, lastname, birthdate
--   FROM employee
--   WHERE birthdate > DATE '68-12-31';
--   RETURN my_cursor;

    OPEN my_cursor FOR
    SELECT firstname, lastname, birthdate
    FROM employee
    GROUP BY firstname, lastname, birthdate
    HAVING MIN(BIRTHDATE)>DATE '1968-12-31';
    
    RETURN my_cursor;
END;
/

SELECT after_1968
FROM DUAL;

DECLARE
    v_cursor        SYS_REFCURSOR;
    v_fn            employee.firstname%TYPE;
    v_ln            employee.lastname%TYPE;
    v_bd            employee.birthdate%TYPE;
    
BEGIN
    v_cursor := after_1968();
    
    LOOP
        FETCH v_cursor
        INTO v_fn, v_ln, v_bd;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || ' was born on ' || v_bd);
        END LOOP;
        CLOSE v_cursor;
END;
/


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
    a_id        artist.artistid%TYPE;
    a_name      artist.name%TYPE;
    v_cursor    SYS_REFCURSOR;

BEGIN
    get_all_artists(v_cursor);
    
    LOOP
        FETCH v_cursor
        INTO a_id, a_name;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Artist id: ' || a_id || ', Name: ' || a_name);
    END LOOP;
END;
/
    

--------------------------------------------------------------------------------

--CREATE A SEQUENCE THAT WILL BE USED TO OBTAIN PE VALUES (STARTING AT 275)
CREATE SEQUENCE artist_pk_seq
MINVALUE 1
MAXVALUE 99999
INCREMENT BY 1
START WITH 276;
/

--CREATE A TRIGGER THAT WILL USE ARTIST_PK_SEQ WHENEVER A NEW ROW IS INSTERTED
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

--USE IF WE DON'T USE A TRIGGER
INSERT INTO artist
VALUES (artist_pk_seq.NEXTVAL, 'Breaking Benjamin');

INSERT INTO artist
VALUES (999, 'MCR');

