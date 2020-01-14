--2.0 SQL Queries
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
WHERE firstname = 'Andrew'
AND reportsto IS NULL;

--2.2 ORDER BY
--Task – Select all albums in album table and sort result set in descending order
SELECT * 
FROM ALBUM
ORDER BY albumid DESC

--Task – Select first name from Customer and sort result set in ascending order
SELECT firstname
FROM customer
ORDER BY firstname;

--2.3 INSERT INTO
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

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
set firstname= 'Robert', lastname = 'Walter'
where firstname = 'Aaron'
and lastname = 'Mitchell';

--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist
set name= 'CCR'
where name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T”
SELECT *
from invoice
where billingaddress like 'T';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--TODO finish statement
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoiceline
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE invoiceline
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY(invoiceid)
REFERENCES invoice(invoiceid)
ON DELETE CASCADE;

ALTER TABLE invoice
DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE invoice
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY(customerid)
REFERENCES customer(customerid)
ON DELETE CASCADE;

DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

--3.0 SQL Functions
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT SYSTIMESTAMP(9) FROM DUAL;

--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name)
FROM mediatype;

--3.2 System Defined Aggregate Functions
--Task –Create a function that returns the average total of all invoices
SELECT AVG(total) as avg
FROM invoice;

--Task – Create a function that returns the most expensive track
SELECT MAX(unitprice)
FROM track;

--3.3 User Defined Scalar functions
--Task – Create a function that returns the average price of invoice-line items in the invoice-line table
CREATE OR REPLACE FUNCTION apInvoiceLine
    RETURN NUMBER
    AS avg_price NUMBER;
    
BEGIN
    SELECT AVG(unitprice)
    INTO avg_price
    FROM invoiceline;
    
    RETURN avg_price;
END;
/

SET SERVEROUTPUT ON;

DECLARE 
    avgPrice NUMBER;
BEGIN
    avgPrice := apInvoiceLine();
    DBMS_OUTPUT.PUT_LINE('The avg price in the Invoice Line table is ' || avgPrice);
END;
/

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
/

DECLARE
    v_cursor    SYS_REFCURSOR;
    v_fn        employee.firstname%TYPE;
    v_ln        employee.lastname%TYPE;
    v_bd        employee.birthdate%TYPE;
BEGIN
    v_cursor := after_1968();
    LOOP
        FETCH v_cursor
        INTO v_fn, v_ln, v_bd;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln || ' was born on ' || v_bd);
    END LOOP;
    CLOSE v_cursor;
END;
/

--4.0 Stored Procedures
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE first_and_last (my_cursor OUT SYS_REFCURSOR)
    IS
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname
    FROM employee;
END;
/

DECLARE
    v_cursor    SYS_REFCURSOR;
    v_fn        employee.firstname%TYPE;
    v_ln        employee.lastname%TYPE;
BEGIN
    first_and_last(v_cursor);
    LOOP
    FETCH v_cursor
    INTO v_fn, v_ln;
    EXIT WHEN v_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln);
    END LOOP;
    CLOSE v_cursor;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_phone 
    (phone_number IN VARCHAR2, empid IN NUMBER)
    AS
BEGIN
    UPDATE employee 
    SET phone = phone_number
    WHERE employeeid = empid;
END;
/

EXECUTE update_phone('810-657-9007', 1);

SELECT phone FROM employee WHERE employeeid = 1;

--Task – Create a stored procedure that returns the managers of an employee
CREATE OR REPLACE PROCEDURE emp_managers 
    (empid IN employee.employeeid%TYPE,
    fn OUT employee.firstname%TYPE, ln OUT employee.lastname%TYPE)
    AS
BEGIN
    SELECT e2.firstname, e2.lastname
    INTO fn, ln
    from employee e1
    join employee e2
    on e2.employeeid = e1.reportsto
    where empid = e1.employeeid;
END;
/

DECLARE
    fn      employee.firstname%TYPE;
    ln      employee.lastname%TYPE;
BEGIN
    emp_managers(5, fn, ln);
    DBMS_OUTPUT.PUT_LINE(fn || ' ' || ln);
END;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE cust_name_comp
    (
        c_cursor OUT SYS_REFCURSOR
    )
    AS
BEGIN
    OPEN c_cursor FOR
    SELECT firstname, lastname, company
    FROM customer;
END;
/

DECLARE
    fn  customer.firstname%TYPE;
    ln  customer.lastname%TYPE;
    comp customer.company%TYPE;
    c_cursor SYS_REFCURSOR;
BEGIN
    cust_name_comp(c_cursor);
    LOOP
        FETCH c_cursor
        INTO fn, ln, comp;
        EXIT WHEN c_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Company: ' || comp || ', Name: ' || fn || ' ' || ln);
    END LOOP;
    CLOSE c_cursor;
END;
/

--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely 
--on this, find out how to resolve them)...poiij
CREATE OR REPLACE PROCEDURE deleteInvoice(p_invoiceId IN NUMBER)
IS
BEGIN
DELETE FROM invoice WHERE invoiceid = p_invoiceId;
END;
/

EXECUTE deleteinvoice(1);

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE create_customer
IS
BEGIN
INSERT INTO customer VALUES (5000, 'Andrew', 'Spiteri', 'Best Industries', '333 Long Way', 'Tampa', 'FL', 'USA', '33612', '810-336-7158', '810-336-7159', 'ecclesy@gmail.com', 1);
END;
/

execute create_customer();

--6.0 Triggers
--6.1 After/For
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
DROP SEQUENCE PK_EMPLOYEE_SEQ;
CREATE SEQUENCE pk_employee_genre_seq MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 27;/

CREATE OR REPLACE TRIGGER pk_employee_trigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    INSERT INTO genre VALUES (PK_EMPLOYEE_GENRE_SEQ.nextval, :new.lastname);
END;
/ 

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER genre_album_trigger
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    INSERT INTO genre VALUES (PK_EMPLOYEE_GENRE_SEQ.nextval, :new.title);
END;
/ 

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER del_genre_customer_trigger
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    INSERT INTO genre VALUES (PK_EMPLOYEE_GENRE_SEQ.nextval, :old.lastname);
END;
/ 

--6.2 BEFORE
--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.
CREATE OR REPLACE TRIGGER del_invoice_trigger
INSTEAD OF DELETE 
ON invoice
FOR EACH ROW
BEGIN
    INSERT INTO genre VALUES (PK_EMPLOYEE_GENRE_SEQ.nextval, :old.lastname);
END;
/

--7.0 JOINs
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT c.firstname, c.lastname, i.invoiceid FROM customer c JOIN invoice i USING (customerid);

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
SELECT c.customerid, c.firstname, c.lastname, i.invoiceid, i.total FROM customer c OUTER JOIN invoice i USING (customerid);

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title FROM artist RIGHT JOIN album USING (artistid);

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT artist.name, album.title FROM artist CROSS JOIN album USING (artistid) ORDER BY artist.name;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
SELECT e.firstname, e.lastname, e.reportsto, em.firstname, em.lastname FROM employee e JOIN employee em ON em.employeeid = e.reportsto;

--8.0 INDEXes
--8.1 INDEXes
--Task – Create an index on of table of your choice
CREATE UNIQUE INDEX emp_unique_index ON employee(employeeid)
    TABLESPACE users;