SET SERVEROUTPUT ON;

-- 2.1 SELECT

-- Task - Select all records from the Employee table
SELECT *
FROM employee;

-- Task - Select all records from the Employee table where last name is King.
SELECT * 
FROM employee
WHERE lastname = 'King';

-- Task - Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM employee
WHERE firstname = 'Andrew' 
        AND 
      reportsto IS null;
      
-- 2.2 ORDER BY

-- Task – Select all albums in album table and sort result set in descending order
SELECT *
FROM album
ORDER BY albumid DESC;

-- Task – Select first name from Customer and sort result set in ascending order
SELECT firstname
FROM customer
ORDER BY firstname;

-- 2.3 INSERT INTO

-- Task – Insert two new records into Genre table 
SELECT *
FROM genre;

INSERT INTO genre VALUES (26, 'Dubstep');
INSERT INTO genre VALUES (27, 'Edm');

-- Task – Insert two new records into Employee table
SELECT *
FROM employee;

INSERT INTO employee VALUES (10, 'Stewart', 'Ervin', 'CFO', 3, TO_DATE('1962-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
'23456 Canada St', 'Calgary', 'AB', 'Canada', 'T2P 5G3', '1 (403) 555-8888', '1 (403) 555-6543', 'ervin@chinookcorp.com');

INSERT INTO employee VALUES (9, 'Dunn', 'Blake', 'CEO', 4, TO_DATE('1992-10-2 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2002-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
'12345 Chernobyl Ave NW', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 555-9876', '+1 (780) 555-5678', 'blake@chinookcorp.com');

-- Task – Insert two new records into Customer table
SELECT *
FROM customer;

INSERT INTO customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, email, supportrepid)
VALUES (60, 'Blake', 'Dunn', 'Revature', '123 Baller St', 'Los Angeles', 'CA', 'United States', '99999', '1 (909) 555 1234', 'bigballer@gmail.com', 5); 

INSERT INTO customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, email, supportrepid)
VALUES (61, 'Buhlakay', 'Ay-Ay-Ron', 'Dee-Nice LLC', '1345 Jay-Quelan St', 'New York', 'NY', 'United States', '99999', '1 (555) 555 1234', 'smallballer@gmail.com', 4); 


-- 2.4 UPDATE

-- Task – Update Aaron Mitchell in Customer table to Robert Walter
SELECT *
FROM customer
WHERE customerid = 32;

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;

-- Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

SELECT *
FROM artist
WHERE name = 'CCR';


-- 2.5 LIKE

-- Task – Select all invoices with a billing address like “T”
SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';


-- 2.6 BETWEEN

-- Task – Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';


-- 2.7 DELETE

-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoice
DROP CONSTRAINT fk_invoicecustomerid;

ALTER TABLE invoice
ADD CONSTRAINT fk_invoicecustomerid FOREIGN KEY(customerid)
references customer(customerid)
on delete cascade; 

ALTER TABLE invoiceline
DROP CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE invoiceline
ADD CONSTRAINT fk_invoicelineinvoiceid FOREIGN KEY(invoiceid)
references invoice(invoiceid)
on delete cascade;

DELETE FROM customer
WHERE customerid = 32;

SELECT *
FROM invoiceline;


-- 3.1 System Defined Functions

-- Task – Create a function that returns the current time.
--STILL NEED TO FIGURE THIS OUT
CREATE OR REPLACE FUNCTION the_current_time
    RETURN VARCHAR2
    IS current_time VARCHAR2(20);
    
BEGIN
    SELECT TO_CHAR(CURRENT_DATE, 'HH:MI:SS')
    INTO current_time
    FROM DUAL;
    
    RETURN current_time;
END;
/

SELECT the_current_time()
FROM DUAL;

-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION mediatype_length
    RETURN SYS_REFCURSOR
    IS my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR
    SELECT mediatypeid AS ID, LENGTH(name) AS Length
    FROM mediatype;
    
    RETURN my_cursor;
END;
/

SELECT mediatype_length
FROM DUAL;

DECLARE
    v_cursor    sys_REFCURSOR;
    v_id        mediatype.mediatypeid%TYPE;
    v_name      mediatype.name%TYPE;
BEGIN
    v_cursor := mediatype_length();
    
    LOOP
        FETCH v_cursor
        INTO v_id, v_name;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ID: ' || v_id || ' Length= ' || v_name);
    END LOOP;
    CLOSE v_cursor;
END;
/

-- 3.2 System Defined Aggregate Functions

-- Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION average_total
    RETURN NUMBER
    AS avg_total NUMBER(10,2);
BEGIN
    SELECT AVG(total)
    INTO avg_total
    FROM invoice;
    
    RETURN avg_total;
END;
/

SELECT average_total()
FROM DUAL;

-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION priciest
    RETURN NUMBER
    AS most_expensive NUMBER;
BEGIN
    SELECT MAX(unitprice)
    INTO most_expensive
    FROM track;
    
    RETURN most_expensive;
END;
/

SELECT priciest()
FROM DUAL;

-- 3.3 User Defined Scalar Functions

-- Task – Create a function that returns the average price of invoice-line items in the invoice-line table

-- This function returns the average unit price among all the invoice lines in the table.
CREATE OR REPLACE FUNCTION avg_unit_price
    RETURN NUMBER
    AS average_price NUMBER(10,2);
BEGIN
    SELECT AVG(unitprice)
    INTO average_price
    FROM invoiceline;
    
    RETURN average_price;
END;
/

SELECT avg_unit_price
FROM dual;
-- This function does an average for each invoice id within the table
CREATE OR REPLACE FUNCTION average_price
    RETURN SYS_REFCURSOR
    AS my_cursor SYS_REFCURSOR;
BEGIN
    OPEN my_cursor FOR
    SELECT invoiceid, AVG(unitprice)
    FROM invoiceline
    GROUP BY invoiceid;
    
    RETURN my_cursor;
END;
/

SELECT average_price()
FROM dual;

SELECT * 
FROM invoiceline;

DECLARE
    v_cursor    sys_REFCURSOR;
    v_ilid      invoiceline.invoicelineid%TYPE;
    v_up        invoiceline.unitprice%TYPE;
BEGIN
    v_cursor := average_price; 
    LOOP
        FETCH v_cursor
        INTO v_ilid, v_up;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('InvoiceLineID = ' || v_ilid || ' Avg Price = ' || v_up);
    END LOOP;
    CLOSE v_cursor;
END;
/

SELECT average_price()
FROM DUAL;

-- 3.4 User Defined Table Valued Functions

-- Task – Create a function that returns all employees who are born after 1968.
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

SELECT after_1968()
FROM DUAL;

DECLARE
    v_cursor    sys_REFCURSOR;
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


-- 4.1 Basic Stored Procedure

--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_all_employees(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname
    FROM employee
    ORDER BY firstname;
END;
/

DECLARE 
    e_fn        employee.firstname%TYPE;
    e_ln        employee.lastname%TYPE;
    v_cursor    SYS_REFCURSOR;
BEGIN
    get_all_employees(v_cursor);
    
    LOOP
        FETCH v_cursor
        INTO e_fn, e_ln;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('First name: ' || e_fn || ', Last name: ' || e_ln);
    END LOOP;
END;
/

--4.2 Stored Procedure Input Parameters

--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_emp_info(
        e_phone IN employee.phone%TYPE, e_id IN employee.employeeid%TYPE)
IS
BEGIN
    UPDATE employee 
    SET phone = e_phone
    WHERE employeeid = e_id;
    
    COMMIT;
END;
/
--Task – Create a stored procedure that returns the managers of an employee
CREATE OR REPLACE PROCEDURE get_employee_manager(e_id IN employee.employeeid%TYPE)
IS manager_id NUMBER;
BEGIN
    SELECT reportsto
    INTO manager_id
    FROM employee
    WHERE employeeid = e_id;
    
    DBMS_OUTPUT.PUT_LINE('Manager ID: ' || manager_id);
END;
/

EXEC get_employee_manager(2);
--4.3 Stored Procedure Output Parameters

--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_customer_name_company(
cid IN NUMBER, 
fn OUT VARCHAR2,
ln OUT VARCHAR2,
cn OUT VARCHAR2)
AS
BEGIN
    SELECT firstname, lastname, company
    INTO fn, ln, cn
    FROM customer
    WHERE customerid = cid;
END;
/

DECLARE 

fn VARCHAR2(30);
ln VARCHAR2(30);
co VARCHAR2(30);

BEGIN 
get_customer_name_company(5, fn, ln, co);
DBMS_OUTPUT.PUT_LINE('First name: ' || fn || ' Last name: ' || ln || ' Company: ' || co);
END;
/


-- 5.0 Transactions

-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them)...poiij
CREATE OR REPLACE PROCEDURE delete_invoice(i_id IN invoice.invoiceid%TYPE)
IS
BEGIN
    DELETE FROM invoice
    WHERE invoiceid = i_id;
    
    COMMIT;
END;
/


EXEC delete_invoice(123);
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE SEQUENCE customer_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 62;
/

CREATE OR REPLACE PROCEDURE insert_new_customer (c_fn IN customer.firstname%TYPE, c_ln IN customer.lastname%TYPE, c_em IN customer.email%TYPE)
IS 
BEGIN
    INSERT INTO customer (customerid, firstname, lastname, email)
    VALUES (customer_pk_seq.NEXTVAL, c_fn, c_ln, c_em); 
    
    COMMIT;
END;
/

EXEC insert_new_customer('Ko', 'Bryn', 'ko@chinook.com');
select * from customer;
-- 6.1 AFTER/FOR

-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER display_new_employee_id_trig
AFTER INSERT ON employee
FOR EACH ROW

BEGIN
    DBMS_OUTPUT.PUT_LINE('New employee number: ' || :new.employeeid);
END;
/

CREATE SEQUENCE employee_pk_seq
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 62;
/

CREATE OR REPLACE TRIGGER employee_insert_trig
BEFORE INSERT ON employee
FOR EACH ROW

BEGIN
    SELECT employee_pk_seq.NEXTVAL
    INTO :new.employeeid
    FROM dual;
END;
/

INSERT INTO employee (firstname, lastname)
VALUES ('Buhlakay', 'Aaron');
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_name_update
AFTER UPDATE ON album
FOR EACH ROW

BEGIN
    DBMS_OUTPUT.PUT_LINE('You just changed the ID from ' || :old.albumid || ' to ' || :new.albumid);
END;
/
Select max(albumid)
from album;


update album a
set a.albumid = 348
where a.albumid = 347
join track t
udpate track t
set t.albumid
where 
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_confirmation_message
AFTER DELETE ON customer
FOR EACH ROW

BEGIN
    DBMS_OUTPUT.PUT_LINE(' You just deleted ' || :old.firstname || ' ' || :old.lastname ||' from customer DB.');
END;
/

DELETE FROM customer 
WHERE customerid = 62;
-- 6.2 BEFORE

-- Task – Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars.

CREATE OR REPLACE TRIGGER invoice_greater_than_trig
BEFORE DELETE ON invoice
FOR EACH ROW

BEGIN 
    IF (:old.total > 50) THEN
        RAISE_APPLICATION_ERROR (-20000, :old.total || 
        ' is greater than $50 for this invoice. Cannot delete this item');
    END IF;
END;
/

DELETE from invoice Where invoiceid = 222;

SELECT invoiceid, total
FROM invoice;
--WHERE invoiceid = 413;

INSERT INTO invoice (invoiceid, customerid, invoicedate, total)
VALUES (413, 60, DATE '2019-12-25', 60);


EXEC delete_invoice(413);

-- 7.1 INNER

-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT c.firstname, c.lastname, i.invoiceid
FROM customer c
INNER JOIN invoice i
ON c.customerid = i.customerid;

-- 7.2 OUTER

-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
SELECT c.customerid, c.firstname, c.lastname, i.invoiceid, i.total
FROM customer c
FULL JOIN invoice i
ON c.customerid = i.customerid;

-- 7.3 RIGHT

-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT a.name, b.title
FROM artist a
RIGHT JOIN album b
ON a.artistid = b.artistid;

-- 7.4 CROSS

-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT a.name, b.title
FROM artist a
CROSS JOIN album b
ORDER BY a.name;


-- 7.5 SELF

-- Task – Perform a self-join on the employee table, joining on the reports to column.
SELECT a.firstname AS FIRSTNAME, a.lastname AS LASTNAME, b.reportsto AS MANAGERID
FROM employee a
JOIN employee b
ON a.employeeid = b.employeeid;

-- 8.1 Indexes

-- Task – Create an index on of table of your choice
CREATE INDEX employee_lastname
ON employee(lastname);

