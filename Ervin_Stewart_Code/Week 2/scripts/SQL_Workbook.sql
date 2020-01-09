--2.0 SQL Queries: performing various queries agianst oracle chinook database
--2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT *
FROM employee;


--Task – Select all records from the Employee table where last name is King.
SELECT *
FROM employee
WHERE lastname = 'King';


--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM employee
WHERE firstname = 'Andrew' and reportsto is NULL;

--2.2 ORDER BY
--Task – Select all albums in album table and sort result set in descending order
SELECT *
FROM album
ORDER BY albumid DESC;

--Task – Select first name from Customer and sort result set in ascending order
SELECT firstname
FROM customer
ORDER BY firstname;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
  insert into genre(genreid, name)
 values(26,'Dubstep');
insert into genre(genreid, name)
 values (26,'Riddim');
--Task – Insert two new records into Employee table
insert into employee(employeeid, lastname, firstname)
 values (9,'Stewart','Ervin');
insert into employee(employeeid, lastname, firstname, title)
 values (10,'Dunn','Blake', 'CEO');
 
--Task – Insert two new records into Customer table
insert into customer(customerid, lastname, firstname, email)
 values (60,'Nzeyimana','Bosco','BigBosco@gmail.com');
insert into customer(customerid, lastname, firstname, email)
 values (61,'Kuznetz','Brian','FoolBoyB@gmail.com');

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
update customer
set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';


--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T”
SELECT*
FROM invoice
WHERE billingaddress LIKE '%T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT*
FROM invoice
WHERE total BETWEEN  15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT*
FROM employee
WHERE hiredate BETWEEN '1-JUN-2003' AND '1-MAR-2004';

/*2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter 
(There may be constraints that rely on this, find out how to resolve them).
*/
ALTER TABLE invoice
DROP CONSTRAINT fk_invoicecustomerid 

ALTER TABLE invoice
ADD CONSTRAINT fk_invoicecustomerid foreign key(customerid)
references customer(customerid)
on delete cascade;

ALTER TABLE invoiceline
DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoiceline
ADD CONSTRAINT fk_invoicelineinvoiceid foreign key(invoiceid)
references invoice(invoiceid)
on delete cascade;

DELETE FROM customer WHERE customerid = '32';

--3.1 System Defined Functions
--Task – Create a function that returns the current time.

create or replace function get_current_time
return VARCHAR2
IS current_time varchar2(20);
begin 
    select to_char(current_date, 'HH:MI:SS')
    into current_time
    from dual;
    return current_time;
end;
/
SELECT get_current_time()
FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
create or replace function get_mediatype_length
return SYS_REFCURSOR
IS my_cursor sys_refcursor;
begin 
    OPEN my_cursor for
    select  mediatypeid, length(name)
    from mediatype;
    return my_cursor;
end;
/
SELECT get_mediatype_length
FROM DUAL;

--3.2 System Defined Aggregate Functions
--Task –Create a function that returns the average total of all invoices
create or replace function get_invoice_avg_total
RETURN number
IS total_average number(10,2);
begin 
    select AVG(total)
    into total_average
    from invoice;
    return total_average;
end;
/
SELECT get_invoice_avg_total()
FROM DUAL;

--Task – Create a function that returns the most expensive track
create or replace function get_max_unitprice
RETURN number
IS max_unitprice number(10,2);
begin 
    select max(unitprice)
    into max_unitprice
    from track;
    return max_unitprice;
end;
/

DECLARE
max_unitprice NUMBER(10,2);
BEGIN
max_unitprice := get_max_unitprice();
dbms_output.put_line('the max unit price in the track table is ' || max_unitprice);
END;
/


--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoice-line items
--in the invoice-line table



--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
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
 

