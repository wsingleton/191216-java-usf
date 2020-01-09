-- this allows the ddms to print messafes to the console (OFF by default)
SET SERVEROUTPUT ON;
-- Function : get the ,z ID from the artis table 
-- Method signature (method name, return typr, variablt to be return 

CREATE or REPLACE FUNCTION get_maz_id
    return number
    as max_id number;
BEGIN
    SELECT MAX(artistid)
    Into max_id
    from artist;
    
    RETURN max_id;
  
END;
/

DECLARE 
    maxid number;
BEGIN
    maxid := get_maz_id();
    DBMS_OUTPUT.PUT_LINE('the max id in the artiest table is ' || maxid);
end;
/
DROP FUNCTION get_maz_id;

CREATE or REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
    is my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor for 
    Select firstname,lastname,birthdate
    From employee 
    where birthdate > date'1968-12-31';
    
    return my_cursor;
END;
/
-- simple way to invoke function 
SELECT after_1968
from dual;


DECLARE 
    v_cursor SYS_REFCURSOR;
    v_fn employee.firstname%type;
    v_ln employee.lastname%TYPE;
    v_bd employee.birthdate%TYPE;
    
BEGIN
   v_cursor := after_1968();
   
   LOOP
    FETCH v_cursor
    INTO v_fn,v_ln,v_bd;
    EXIT WHEN v_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(v_fn ||' ' || v_ln || ' was born on ' || v_bd);
    end loop;
    close v_cursor;
end;
/


-- create a procedure that return all of the artist in the artis table 

CREATE or REPLACE PROCEDURE get_all_artists(my_cursor out SYS_REFCURSOR)
is
BEGIN
    OPEN my_cursor for 
    SELECT * 
    FROM artist
    ORDER BY artistid;
End;
/

DECLARE 
  
    a_id artist.artistid%type;
    a_name artist.name%TYPE;
    v_cursor SYS_REFCURSOR;
    
BEGIN
   get_all_artists(v_cursor);
   
   LOOP
    FETCH v_cursor
    INTO a_id, a_name;
    EXIT WHEN v_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Artist name : '||a_name ||'----- Artist id:  ' || a_id );
    end loop;
    close v_cursor;
end;




----------------


-- create a sequence that will be use to obtain PK values (starting at 276)
CREATE SEQUENCE artist_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT by 1
START WITH 276;
/

-- Create a trigger that will use artist_pk_seq whenverer a new row is inserted 

CREATE or REPLACE TRIGGER artist_insert_trig
BEFORE INSERT ON artist
FOR EACH ROW

BEGIN
    SELECT artist_pk_seq.nextval
    INTO :new.artistid
    from dual;
end;
/

SELECT
    *
FROM artist
ORDER by artistid;

insert into artist (name)
VALUES ('blick-152');

insert into artist (name)
VALUES ('lion');

insert into artist 
VALUES (ARTIST_PK_SEQ.nextval,'hoangle');




