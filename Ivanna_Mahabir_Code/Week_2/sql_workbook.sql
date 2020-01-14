-- Revature Associate SQL Workbook
-- Oracle 12c
-- Working with Relational Database Management Systems

--2.0 SQL Queries
--2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * FROM employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee
WHERE lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee
WHERE firstname = 'Andrew'
AND reportsto IS NULL;

--2.2 ORDER BY
--Task – Select all albums in album table and sort result set in descending order
--Ordered using the albumid: 
SELECT * FROM album
ORDER BY albumID DESC;

--Ordered using the album title:
SELECT * FROM album
ORDER BY title DESC;

--Task – Select first name from Customer and sort result set in ascending order
SELECT firstname FROM customer
ORDER BY firstname ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
--Initial check for the number of records in Genre: 
SELECT * FROM genre;
--Insert two new records into Genre: 
INSERT INTO genre VALUES(26, 'soca');
INSERT INTO genre VALUES(27, 'Calypso');

--Task – Insert two new records into Employee table
--Initial check for the number of records in Employee: 
SELECT * FROM employee;
--Insert two new records into Employee: 
INSERT INTO employee VALUES(9, 'Grande', 'Ariane', 'Sales Manager',1, '06-Aug-75', '05-Jun-05', 
'265 Orange Ave', 'Calgary', 'AB', 'Canada', 'T2P 5F9','+1 (403) 486-6959', 
'+1 (403) 486-6995','ariane@chinookcorp.com');

INSERT INTO employee VALUES(10, 'Mitchell', 'Shay', 'IT Manager', 1, '19-Jun-85', '23-Aug-05', 
'203 Main St', 'Calgary', 'AB', 'Canada', 'T3B 5F9','+1 (403) 458-6985', 
'+1 (403) 458-6989','shay@chinookcorp.com');

--Task – Insert two new records into Customer table
--Initial check for the number of records in Customer: 
SELECT * FROM customer;
INSERT INTO customer VALUES(60, 'Montoya', 'Diego', '', '203 Main St', 'London', 
'', 'United Kingdom', 'T3B 5F9','+44 403 4588 6985', '','diego.montoya@hotmail.com', 3);

INSERT INTO customer VALUES(61, 'Dora', 'Montcristo', '', '404 Peach St', 'Santiago', 
'', 'Chile', '','+56 (0)2 654 8856', '','dmontoya@hotmail.com', 5);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--Initial check for Customer Aaron Mitchell: 
SELECT * FROM customer
   WHERE firstname = 'Aaron'
   AND lastname = 'Mitchell';

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;

--Another method without lookup for customerid:
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN '01-Jun-2003' AND ' 01-Mar-2004';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--Cascade delete

SELECT * FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

DELETE FROM invoiceline WHERE invoiceid IN(
SELECT invoiceid FROM invoice WHERE customerid IN(
SELECT customerid FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter'));

DELETE FROM invoice WHERE customerid IN(
SELECT customerid FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter');

DELETE FROM customers
WHERE firstname = 'Robert' AND lastname = 'Walter';

--3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions

--Task – Create a function that returns the current time.
SELECT
CURRENT_TIMESTAMP
FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT name, 
LENGTH(name)
FROM mediatype;

--3.2 System Defined Aggregate Functions
--Task –Create a function that returns the average total of all invoices
--Raw Average:
SELECT AVG(total) FROM invoice;

--Average with Rounding:
	SELECT ROUND(AVG(total), 2) FROM invoice;

--Task – Create a function that returns the most expensive track
SELECT * FROM track 
WHERE unitprice = (
SELECT MAX(unitprice)
FROM track)
ORDER BY name ASC;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoice-line items in the invoice-line table
CREATE OR REPLACE FUNCTION invoiceline_avg
RETURN SYS_REFCURSOR
IS my_cursor SYS_REFCURSOR;
BEGIN
OPEN my_cursor FOR
SELECT ROUND (AVG(unitprice),2)
FROM invoiceline;
RETURN my_cursor;
END;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
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

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure

--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_fn_ln_emp(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
OPEN my_cursor FOR
SELECT
"A1"."FIRSTNAME"   "FIRSTNAME",
"A1"."LASTNAME"    "LASTNAME"
FROM
"CHINOOK"."EMPLOYEE" "A1"
ORDER BY
"A1"."EMPLOYEEID";
END;

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE get_employees
AS
BEGIN
    UPDATE employee e
    SET e.firstname = 'Jane', e.lastname = 'Crowley',
    e.birthdate = '05-Feb-79', e.hiredate = '09-Jun-09',
    e.email = 'jcrowley@chinookcorp.com'
    WHERE e.employeeid = 8;
END;

--Task – Create a stored procedure that returns the managers of an employee
CREATE OR REPLACE PROCEDURE get_managers(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT *
FROM
    employee e
WHERE
    e.reportsto = 1;
END;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_customers(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT c.firstname, c.lastname, c.company
    FROM customer c
    WHERE c.customerid = 1;  -- Search by customerid, or search by c.firstname = ‘ ‘ AND c.lastname = ‘ ‘
END;

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them)...poiij


--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table


--6.0 Triggers 
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_insert_trig
AFTER INSERT ON employee
FOR EACH ROW

BEGIN
    INSERT INTO employee 
    (
        employeeid, lastname, firstname, title, reportsto,
        birthdate, hiredate, address, city, state, country, 
        postalcode, phone, fax, email
    )
                          
    VALUES 
    (
        :new.employeeid, :new.lastname, :new.firstname, :new.title, :new.reportsto,
        :new.birthdate, :new.hiredate, :new.address, :new.city, :new.state, :new.country, 
        :new.postalcode, :new.phone, :new.fax, :new.email
    );
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_update_trig
AFTER INSERT ON album
FOR EACH ROW

BEGIN
UPDATE album 
SET albumid = albumid, title = title, artistid = artistid 
WHERE albumid = albumid;
END;

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.


--6.2 BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.


--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, lastname, invoiceid
FROM customer
JOIN invoice
ON customer.customerid = invoice.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM album
RIGHT JOIN artist
ON artist.artistid = album.artistid
ORDER BY artist.name;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM artist
CROSS JOIN album
ORDER BY artist.name;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
SELECT e.employeeid, e.firstname, e.lastname, e.reportsto, 
       em.firstname || ' ' || em.lastname AS manager_name
FROM employee e
JOIN employee em
ON e.employeeid = em.employeeid;

--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Indexes
--Task – Create an index on of table of your choice
SELECT e.employeeid, e.firstname, e.lastname, e.reportsto, 
       em.firstname || ' ' || em.lastname AS manager_name
FROM employee e
JOIN employee em
ON e.reportsto = em.employeeid
ORDER BY e.employeeid;
