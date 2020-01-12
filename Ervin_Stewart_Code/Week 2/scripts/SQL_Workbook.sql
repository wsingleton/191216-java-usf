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
create or replace function get_avg_invoice_unitprice
RETURN number
IS avg_unitprice number(10,2);
begin 
    select avg(unitprice)
    into avg_unitprice
    from invoiceline;
    return avg_unitprice;
end;
/

DECLARE
avg_unitprice NUMBER(10,2);
BEGIN
avg_unitprice := get_avg_invoice_unitprice();
dbms_output.put_line('The average unit price in the invoiceline table is ' || avg_unitprice);
END;
/


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
 
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
set serveroutput on;
create or replace procedure get_fn_ln (my_cursor out sys_refcursor)
is
begin
open my_cursor for 
select firstname,lastname 
from employee
order by firstname;
end;
/

Declare
v_cursor sys_refcursor;
e_fn employee.firstname%type;
e_ln employee.lastname%type;
begin 
get_fn_ln(v_cursor);
loop
    fetch v_cursor
    into e_fn,e_ln;
    Exit when v_cursor%notfound;
    DBMS_OUTPUT.PUT_LINE('Firstname :' || e_fn ||' Lastname:'|| e_ln);
     end loop;
    
 end;
 /


--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
create or replace procedure update_employee (e_id number, new_first_name  VARCHAR2, new_last_name VARCHAR2)
is
begin
UPDATE employee 
SET firstname = new_first_name, lastname = new_last_name
WHERE employeeid = e_id;
end;
/

begin
update_employee(9,'Catherine', 'Jones');
end;
/


--Task – Create a stored procedure that returns the managers of an employee
create or replace procedure get_employee_manager (my_cursor out sys_refcursor)
is
begin
open my_cursor for 
select employeeid, firstname,reportsto 
from employee
order by employeeid;
end;
/

Declare
v_cursor sys_refcursor;
e_id employee.employeeid%type;
e_fn employee.firstname%type;
e_manager employee.reportsto%type;
begin 
get_employee_manager(v_cursor);
loop
    fetch v_cursor
    into e_id,e_fn,e_manager;
    Exit when v_cursor%notfound;
    DBMS_OUTPUT.PUT_LINE('Employee '||e_id|| ' '|| e_fn ||' reports to:'|| e_manager);
     end loop;
    
 end;
 /

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure get_customer_company (my_cursor out sys_refcursor)
is
begin
open my_cursor for 
select firstname, lastname,company 
from customer
order by firstname;
end;
/

Declare
v_cursor sys_refcursor;
e_fn customer.firstname%type;
e_ln customer.lastname%type;
e_company customer.company%type;
begin 
get_customer_company(v_cursor);
loop
    fetch v_cursor
    into e_fn,e_ln,e_company;
    Exit when v_cursor%notfound;
    DBMS_OUTPUT.PUT_LINE('Customer name is '||e_fn|| ' '|| e_ln ||' and their company is:'|| e_company);
     end loop;
    
 end;
 /
--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them)...poiij

create or replace procedure delete_invoice_by_id (i_id number)
is
begin
DELETE invoice
WHERE invoiceid = i_id;
end;
/

begin
delete_invoice_by_id(9);
end;
/


--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace procedure new_customer_record (c_id number,c_lastname varchar2, c_firstname varchar2, c_email varchar2)
is
begin
insert into customer(customerid, lastname, firstname, email)
 values (c_id,c_lastname,c_firstname,c_email);
end;
/

begin
new_customer_record(63,'Jadaka','N','killmonger@gmail.com');
end;
/

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger display_new_employee_name
after insert on employee
for each row
begin 
 dbms_output.put_line('New employee is: ' || :new.firstname || ' ' || :new.lastname);
end;
/
insert into employee(employeeid, lastname, firstname,title, reportsto)
values(11, 'Dent', 'Harvey','Garbage Man', 1);
insert into employee(employeeid, lastname, firstname,title, reportsto)
values(12, 'Wayne', 'Bruce','Garbage Man Assistant', 11);

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger display_album_name
after insert on album
for each row
begin 
 dbms_output.put_line('New album is: ' || :new.title);
end;
/
insert into artist(artistid,name)
values(276, 'Liquid Stranger');
insert into album(albumid, title, artistid)
values(348, 'Anomally: The Collection', 296);
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger display_deleted_customer_name
after Delete on customer
for each row
begin 
 dbms_output.put_line('Customer ' || :old.firstname || ' ' || :old.lastname|| ' is deleted.');
end;
/
DELETE FROM customer WHERE customerid = '60';
--6.2 BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
create or replace trigger restrict_invoice_delete
before delete on invoice
for each row
begin
    if(:old.total > 50)
    then raise_application_error(-20000, :old.total || ' is greater than 50 cannot be deleted.');
    end if;
end;
/

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select i.invoiceid, c.firstname, c.lastname 
from customer c
inner join invoice i
on i.invoiceid = c.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
SELECT c.customerid,i.invoiceid, c.firstname, c.lastname, i.total 
FROM customer c
FULL OUTER JOIN invoice i
ON i.invoiceid = c.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT a.name, b.title 
FROM artist a
RIGHT JOIN album b
ON a.artistid = b.artistid;


--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select *
from artist
cross join album
order by name ASC;


--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
select e.employeeid,e.firstname,e.lastname,em.reportsto
from employee e
join employee em
on e.employeeid = em.employeeid;



--8.1 Indexes
--Task – Create an index on of table of your choice
CREATE  INDEX fn
ON customer(firstname);
