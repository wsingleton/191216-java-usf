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
WHERE firstname = 'Andrew'
AND reportsto IS NULL;

--Task – Select all albums in album table and sort result set in descending order
SELECT * 
FROM ALBUM
ORDER BY albumid DESC

--Task – Select first name from Customer and sort result set in ascending order
SELECT firstname
FROM customer
ORDER BY firstname;

--Task – Insert two new records into Genre table
INSERT  
INTO genre
VALUES (26,'Christian Contemporary');
INSERT INTO genre 
VALUES (27, 'Hymns');

--Task – Insert two new records into Employee table
INSERT ALL
INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
VALUES (9, 'Spiteri', 'Andrew', 'CEO', NULL, '31-JAN-92', '07-JAN-20', '644 Maple Rd', 'Tampa', 'FL', 'USA', '33612', '813-230-5456', '813-230-8765', 'andrews@chinookcorp.com')
INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
VALUES (10, 'Wilson', 'George', 'CTO', 9, '28-FEB-92', '07-JAN-20', '815 Craftbridge Dr', 'Tampa', 'FL', 'USA', '33612', '813-904-7865', '813-904-2535', 'george@chinookcorp.com')
SELECT *
FROM dual;

--Task – Insert two new records into Customer table
INSERT ALL
INTO customer (customerid,firstname,lastname,company,address,city,state,country,postalcode,phone, fax,email,SUPPORTREPID)
VALUES (60, 'Jose', 'Luis', 'Montego', '6577 Aloysius Rd', 'Tampa', 'FL', 'USA', '33612', '813-230-8773', '813-230-2889', 'jose@montego.com', 4)
INTO customer (customerid,firstname,lastname,company,address,city,state,country,postalcode,phone, fax,email,SUPPORTREPID)
VALUES (61, 'Amanda', 'Ratliffe', 'Underwood Industries', '990 Whatchamacallit Ave', 'Tampa', 'FL', 'USA', '33612', '813-230-7777', '813-230-6666', 'amanda@underwood.com', 4)
SELECT *
FROM dual;

--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
set firstname= 'Robert', lastname = 'Walter'
where firstname = 'Aaron'
and lastname = 'Mitchell';

--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist
set name= 'CCR'
where name = 'Creedence Clearwater Revival';

--Task – Select all invoices with a billing address like “T”
SELECT *
from invoice
where billingaddress like 'T';

--Task – Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

--TODO finish statement
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
SELECT *
FROM invoiceline
full outer join invoice
on invoice.invoiceid = invoiceline.invoiceid
full outer join customer
on customer.customerid = invoice.customerid
where customer.lastname = 'Walter' AND customer.firstname = 'Robert';

--Task – Create a function that returns the current time.
SELECT SYSTIMESTAMP(9) FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name)
FROM mediatype;

--Task –Create a function that returns the average total of all invoices
SELECT AVG(total) as avg
FROM invoice;

--Task – Create a function that returns the most expensive track
SELECT MAX(unitprice)
FROM track;

