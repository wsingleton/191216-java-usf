-- this allows the DBMS to print messages to the console(off by default)
set serveroutput on;

--function get the max id from the artist table

--method signature (method name, return tye, variable to be returned)
create or replace function get_max_id
return number
as max_id number;

begin 
select max (artistid)
into max_id
from artist;
return max_id;
end;
/

Declare
maxId number;
begin
maxId := get_max_id();
dbms_output.put_line('the max id in the artist table is ' || maxId);
end;
/

--to remove functions
drop function get_max_id;

-- Task: create a function that returns all employees who are born after 1968
create or replace function after_1968
return sys_refcursor
is my_cursor sys_refcursor;

begin
open my_cursor for 
select firstname,lastname,birthdate 
from employee
where birthdate > date '1968-12-31';
return my_cursor;
end;
/

select after_1968()
from dual;

Declare
v_cursor sys_refcursor;
v_fn employee.firstname%type;
v_ln employee.lastname%type;
v_bd employee.birthdate%type;
begin 
v_cursor := after_1968();
loop
 fetch v_cursor
 into v_fn,v_ln,v_bd;
 Exit when v_cursor%notfound;
 DBMS_OUTPUT.PUT_LINE(v_fn ||' '|| v_ln || ' was born on ' || v_bd );
 end loop;
 close v_cursor;
 end;
 /
 
 --cretae a procedure that returns all ofthe artists in the artist table
 create or replace procedure get_all_artists(my_cursor out sys_refcursor)
 is 
 begin
 open my_cursor for
 select *
 from artist
 order by artistid;
 end;
 /
 
 declare
 a_id artist.artistid%type;
 a_name artist.name%type;
 v_cursor sys_refcursor;
 begin
 get_all_artists(v_cursor);
 loop
 fetch v_cursor
 into a_id, a_name;
 exit when v_cursor%notfound;
 dbms_output.put_line('artist id: ' || a_id || ',Name: ' || a_name);
 end loop;
 close v_cursor;
 end;
 /
 
 -- create a sequence that will be used to obtain ok values
 create sequence artist_pk_seq
 minvalue 1
 maxvalue 9999999
 increment by 1
 start with 276;
 /
 
 --create a trigger that will artist_pk_seq whenever a new row is inserted
 create or replace trigger artist_insert_trig
 before insert on artist
 for each row
 begin select artist_pk_seq.nextval
 into :new.artistid
 from dual;
 end;
 /
 
 insert into artist(name)
 values ('Blink-182');