--- QUERRY EXERCICES FROM CHINOOK DATABASES HERE
---- ------------------ -------------

-- This allows to print DBMS messages to the console (OFF by default)
SET SERVEROUTPUT ON;
/*
2.1 SELECT

Task – Select all records from the Employee table. 
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

*/

--Select all records from the Employee table.
SELECT *
FROM employee;

--Select all records from the Employee table where last name is King.
SELECT *
FROM employee
WHERE lastname = 'King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM employee
WHERE
firstname = 'Andrew'
AND 
reportsto IS NULL
;

/*
2.2 ORDER BY
Task – Select all albums in album table and sort result set in descending order
Task – Select first name from Customer and sort result set in ascending order
*/
-- Task – Select all albums in album table and sort result set in descending order
SELECT *
FROM album
ORDER BY albumid DESC;

-- Task – Select first name from Customer and sort result set in ascending order
SELECT firstname
FROM customer
ORDER BY firstname;

/*
2.3 INSERT INTO
Task – Insert two new records into Genre table
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/
--Task – Insert two new records into Genre table
    -- step 1. get the largest index in the table
    -- step 2. give the new entry an index of the max index + 1
    SELECT MAX(genreid) FROM genre;
    -- Max-genre id = 25. the new genre is then 26. 
INSERT INTO genre
VALUES (26, 'Muzika');
INSERT INTO genre
VALUES (27, 'Izasabwe');

--Task – Insert two new records into Employee table
    SELECT MAX(employeeid) FROM employee;
    -- the last record id is 8. the next will be 9
INSERT INTO employee 
VALUES(9, 'Bosco', 'Neeee', 'Boss', 3, '01-JAN-1994', '01-JAN-2020', 'NYC', 'Ny City', 'NY', 'USA', 2020, 0789899899, 344432323, 'my@email.email');
INSERT INTO employee 
VALUES(10, 'Ervin', 'Niiii', 'Bro', 2, '01-JAN-1994', '01-JAN-2020', 'NYC', 'Ny City', 'NY', 'USA', '2020', '0789899899', 344432323, 'my@email.email');

-- Task – Insert two new records into Customer table
INSERT INTO customer(customerid, firstname, lastname, phone, email)
VALUES (60, 'Brett', 'Shrekk', 45678967, 'emnail@com.com');
INSERT INTO customer(customerid, firstname, lastname, phone, email)
VALUES (61, 'Rob', 'Smith', 45674564, 'contact@email.rw');

/*
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter */

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

-- Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

/*
2.5 LIKE

Task – Select all invoices with a billing address like “T”
*/
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
*/
SELECT *
FROM INVOICE
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';
/*
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/
    -- step 1: Modify the foreign key and primary keys to ON DELETE CASCADE in all tables related to customer
    -- step 2: Proceed with modifying the table
    ALTER TABLE customer
    DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;
    -- Now, alter table again and allow cascade on delete;
    ALTER TABLE customer
    ADD CONSTRAINT FK_CUSTOMERSUPPORTREPID
    FOREIGN KEY (supportrepid)
    REFERENCES employee (employeeid)
    ON DELETE CASCADE;
    
    -- Also drop the reference in invoice table and invoice line table.
     ALTER TABLE invoice
    DROP CONSTRAINT FK_INVOICECUSTOMERID;

    ALTER TABLE invoice
    ADD CONSTRAINT FK_INVOICECUSTOMERID
    FOREIGN KEY (customerid)
    REFERENCES customer (customerid)
    ON DELETE CASCADE;
    
     ALTER TABLE invoiceline
    DROP CONSTRAINT FK_INVOICELINEINVOICEID;

    ALTER TABLE invoiceline
    ADD CONSTRAINT FK_INVOICELINEINVOICEID
    FOREIGN KEY (invoiceid)
    REFERENCES invoice (invoiceid)
    ON DELETE CASCADE;
    
    -- Now we can proceed with a safe delete.     
DELETE customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

/*

3.0 SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
3.1 System Defined Functions
*/
-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION current_time
    RETURN DATE IS
    current_date DATE;
BEGIN
 SELECT CURRENT_DATE INTO current_date
 FROM DUAL;
 RETURN current_date;
END;
/
DECLARE
    d DATE;
BEGIN
    d := current_time();
    dbms_output.put_line(d);
END;
/

--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION media_length(id NUMBER)
    RETURN NUMBER IS
    mediatype_length NUMBER;
BEGIN
    SELECT LENGTH(name) INTO mediatype_length
    FROM mediatype
    WHERE mediatypeid = id;
    RETURN mediatype_length; 
END;
/
DECLARE
    length NUMBER;
BEGIN
    length := media_length(5);
    dbms_output.put_line(length);
END;
/
/*
3.2 System Defined Aggregate Functions
*/
--Task –Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION invoice_average_total
    RETURN NUMBER IS
    invoice_average NUMBER;
BEGIN
    SELECT AVG(total) INTO invoice_average
    FROM invoice;
    RETURN ROUND(invoice_average, 2);
END;
/
DECLARE
    average NUMBER;
BEGIN
    average := invoice_average_total;
    dbms_output.put_line(average);
END;
/
 --Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive_tack
RETURN NUMBER IS
expensive_track NUMBER;
BEGIN
    SELECT MAX(unitprice) INTO expensive_track
    FROM track;
    RETURN expensive_track;
END;
/

SELECT name, unitprice
FROM track
WHERE unitprice = most_expensive_tack();
/*
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoice-line items in the invoice-line table
*/
CREATE OR REPLACE FUNCTION average_price_invoiceline
RETURN NUMBER IS
average_price NUMBER (10, 2);
BEGIN
    SELECT AVG (unitprice) INTO average_price
    FROM invoiceline;
    RETURN average_price;
END;
/
SELECT average_price_invoiceline FROM dual;

/*
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/
CREATE OR REPLACE FUNCTION born_after_68
RETURN SYS_REFCURSOR IS
employees_after68 SYS_REFCURSOR;

BEGIN
    OPEN employees_after68 FOR
    SELECT employeeid, firstname, birthdate 
    FROM employee
    WHERE birthdate > '01-JAN-68';
    RETURN employees_after68;
END;
/
SELECT born_after_68 FROM employee;

-- Using the DBMS OUTPUT SYSTEM TO PRINT THE INPUT TO THE CONSOLE
DECLARE
 emp_cursor SYS_REFCURSOR;
 emp_id employee.employeeid%TYPE;
 fn employee.firstname%TYPE;
 db employee.birthdate%TYPE; 
BEGIN
    emp_cursor := born_after_68;
    LOOP
    FETCH emp_cursor
    INTO emp_id, fn, db;
    EXIT WHEN emp_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('First name: ' || fn || ', ID: ' || emp_id || ', Birthdate: ' || db);
    END LOOP;
    CLOSE emp_cursor;
END;
/
/*
4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/
CREATE OR REPLACE PROCEDURE emp_first_last_names (names OUT SYS_REFCURSOR)
IS
BEGIN
OPEN names FOR
SELECT firstname, lastname
FROM employee;
END;
/
DECLARE
fn employee.firstname%TYPE;
ln employee.lastname%TYPE;
e_cursor SYS_REFCURSOR;
BEGIN
emp_first_last_names(e_cursor);
LOOP
    FETCH e_cursor
    INTO fn, ln;
    EXIT WHEN e_cursor%NOTFOUND;
    
    DBMS_OUTPUT.PUT_LINE('First name: ' || fn || '  Last name: ' || ln);
END LOOP;  
END;
/
/*
4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
*/
CREATE OR REPLACE PROCEDURE update_emp_info (emp_id IN NUMBER, new_data IN VARCHAR2)
IS
BEGIN
    UPDATE employee
    SET firstname = new_data
    WHERE employeeid = emp_id;
END;
/
BEGIN
update_emp_info(1, 'Domina');
END;
/

--Task – Create a stored procedure that returns the managers of an employee
CREATE OR REPLACE PROCEDURE emp_manager (emp_id IN NUMBER, manager OUT NUMBER)
IS
BEGIN 
    SELECT reportsto INTO manager
    FROM employee
    WHERE employeeid = emp_id;
END;
/

DECLARE
    m NUMBER;
    id NUMBER;
BEGIN
    id := 2;
    emp_manager(id, m);
    DBMS_OUTPUT.PUT_LINE('MANAGER ID: ' || m);
END;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE customer_name_company(cust_id IN NUMBER, customer_name OUT VARCHAR2, customer_company OUT VARCHAR2)
IS
BEGIN
    SELECT lastname, company INTO customer_name, customer_company
    FROM customer
    WHERE customerid = cust_id;
END;
/

DECLARE
    c_id NUMBER;
    lastname VARCHAR2(100);
    company VARCHAR2(100);
BEGIN
    c_id := 1;
    customer_name_company(c_id, lastname, company);
    DBMS_OUTPUT.PUT_LINE('Last name: ' || lastname || ' Company: ' || company);
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure. You will also be working with handling errors in your SQL.

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them)...poiij
CREATE OR REPLACE PROCEDURE delete_invoice(invoice_id IN NUMBER)
    IS
BEGIN
    DELETE FROM invoice
    WHERE invoiceid = invoice_id;
    
    COMMIT;
END;
/
EXEC delete_invoice(1);

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
         -- let us first create a sequence to be able to create a unique id.
    CREATE SEQUENCE id_factory
    START WITH 68
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 999999999999999
    CYCLE;
CREATE OR REPLACE PROCEDURE insert_customer(first IN VARCHAR, last IN VARCHAR2, rep_email VARCHAR2)
    IS
BEGIN
    INSERT INTO customer (customerid, firstname, lastname, email)
    VALUES(id_factory.NEXTVAL, first, last, rep_email);
    COMMIT;
END;
/
EXEC insert_customer('Keza', 'Dan', 'pr@gmail.rw');

--6.0 Triggers 
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER after_rec_trig
AFTER INSERT
ON customer
FOR EACH ROW
DECLARE
    c_id NUMBER;
BEGIN
    c_id := :NEW.customerid; 
    DBMS_OUTPUT.PUT_LINE('Your assigned id is ' || c_id);
END;
/

--Task – Create an after update trigger on the album table that fires after a row is updated in the table
CREATE OR REPLACE TRIGGER after_update_trig
AFTER UPDATE
ON album
FOR EACH ROW
DECLARE
    old_title VARCHAR2(100);
BEGIN
    old_title := :OLD.title;
    DBMS_OUTPUT.PUT_LINE('The old title before update was ' || old_title);

END;
/
--SELECT * FROM album;
UPDATE album
SET title = 'Small Twos' WHERE albumid = 5;
      -- just rolling back to keep the original record;
--ROLLBACK;

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete_customer
BEFORE DELETE
ON customer
FOR EACH ROW
DECLARE
    old_c_lastname VARCHAR2(100);
BEGIN
    old_c_lastname := :OLD.lastname;
    DBMS_OUTPUT.PUT_LINE('You deleted a customer whose lastname was ' ||old_c_lastname);
END;
/  -- testing the trigger with this delete command. 
DELETE FROM customer WHERE customerid = 2;

--6.2 BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER prevent_delete_over50
BEFORE DELETE
ON invoice
FOR EACH ROW
DECLARE
    inv_total NUMBER(20);
    old_i_city VARCHAR2(100);
BEGIN
    inv_total := :OLD.total;
    old_i_city := :OLD.billingcity;
    IF 
    inv_total > 50
    THEN
    RAISE_APPLICATION_ERROR(-20001, 'Delete for invoice over $50 not allowed');
    ELSE
    DBMS_OUTPUT.PUT_LINE('You deleted an invoice where billing city was ' || old_i_city);
    END IF;  
END;
/
SELECT invoiceid, billingcity, total FROM invoice WHERE total > 50;
DELETE FROM invoice where invoiceid = 800;
   -- let's create a record with total oveer 50
   INSERT INTO invoice(invoiceid, customerid, invoicedate, billingcity, total)
   VALUES (800, 3, '10-JUL-20', 'Kigali', 51);

--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, lastname, invoice.invoiceid 
FROM customer
INNER JOIN invoice ON invoice.customerid = customer.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice ON customer.customerid = invoice.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT album.title, artist.name
FROM album
RIGHT JOIN artist
ON album.artistid = artist.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM artist
CROSS JOIN album
ORDER BY artist.name ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
SELECT
a.lastname AS EmployeeA,
b.lastname AS EmployeeB,
a.reportsto
FROM employee a, employee b
WHERE
a.reportsto = b.reportsto
AND a.employeeid <> b.employeeid;

--8.0 Indexes
--In this section you will be creating Indexes on various tables. Indexes can speed up performance of reading data.
--8.1 Indexes
--Task – Create an index on of table of your choice
CREATE INDEX customer_index
ON customer (lastname);

SELECT * FROM customer;



