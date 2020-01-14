/*
    SQL Workbook Assignment
        Tyler Rubbert
*/
-- 2.1 Select all records from the employee table
SELECT *
FROM employee;

-- 2.1 Select all records from the employee table where last name is King
SELECT *
FROM employee
WHERE lastname = 'King';

-- 2.1 Select all records from the employee table where first name is Andrew and REPORTSTO is Null
SELECT *
FROM employee
WHERE (firstname = 'Andrew' AND reportsto IS NULL);

-- 2.2 Select all albums in albums table and sort result in descending order
SELECT albumid
FROM album
ORDER BY albumid DESC;

-- 2.2 Select first name from customer table and sort result in ascending order.
SELECT firstname
FROM customer
ORDER BY firstname ASC;

-- 2.3 Insert 2 new records into Genre table
INSERT INTO genre (genreid, name)
VALUES (26, 'Christian');
INSERT INTO genre VALUES (27, 'Country');

-- 2.3 Insert 2 new records into Employee table
INSERT INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, 
    address, city, state, country, postalcode, phone, fax, email)VALUES (9, 'Marsh', 'Randy', 'Sales Support Agent', 2, '23-OCT-67', '15-AUG-04',
    '5432 This ST', 'Edmonton', 'AB', 'Canada', 'T5K 2L2', '+1 (780) 428-1234', '+1 (780) 428-9876', 'randy@chinookcorp.com');
INSERT INTO employee VALUES (10, 'Dirt', 'Joe', 'IT Staff', 6, '04-MAY-69', '19-MAR-04', 
    '2345 That Ave', 'Lethbridge', 'AB', 'Canada', 'T1K 2L2', '+1 (403) 428-1234', '+1 (403) 428-9876', 'joe@chinookcorp.com');
    
-- 2.3 Insert 2 new records into Customer table
INSERT INTO customer VALUES (60, 'Tyler', 'Rubbert', 'Revature', 'Place', 'Fargo','ND', 'USA', '58104', '7015000599', '5555555555', 'tyler.rubbert@email.com', 3);
INSERT INTO customer VALUES (61, 'Greg', 'Greggerson', '', 'Other Place', 'Fargo', 'ND', 'USA', '58103', '1234567890', '0987654321','ggreg@email.com', 4);

COMMIT;

-- 2.4 Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

-- 2.4 Update name of artist "Creedence Clearwater Revival" to "CCR"
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

-- 2.5 Select all invoices with a billing address like "T"
SELECT *
FROM invoice
WHERE billingaddress LIKE '%T%';

-- 2.6 Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice 
WHERE total BETWEEN 15 AND 50;

-- 2.6 Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * 
FROM employee 
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 Delete a record in Customer table where the name is Robert Walter
SELECT *
FROM customer 
WHERE firstname = 'Robert' AND lastname = 'Walter';

SELECT *
FROM invoice
WHERE customerid = 32;

-- DELETE FROM RESULTS
DELETE FROM invoiceline
WHERE invoiceid = 245 OR invoiceid = 268 OR 
    invoiceid = 290 OR invoiceid = 342 OR 
    invoiceid = 50 OR invoiceid = 61 OR invoiceid = 116;
    
DELETE FROM invoice
WHERE customerid = 32;

DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

-- 3.1 Create a function that returns the current time.
SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION current_time
RETURN TIMESTAMP AS time TIMESTAMP;
BEGIN
    SELECT current_timestamp
    INTO time
    FROM dual;
    RETURN time;
END;
/

DECLARE 
    time TIMESTAMP;
BEGIN
    time := current_time();
    DBMS_OUTPUT.PUT_LINE(time);
END;
/

-- 3.1 Create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_media_length
   RETURN NUMBER AS media_length NUMBER;
BEGIN
    SELECT LENGTH(name) 
    INTO media_length
    FROM mediatype
    WHERE mediatypeid = 1;
    RETURN media_length;
END;
/

DECLARE 
    media_length NUMBER;
BEGIN
    media_length := get_media_length();
    DBMS_OUTPUT.PUT_LINE('Media type length is ' || media_length);
END;
/

-- 3.2 Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION ave_of_invoices
    RETURN NUMBER AS ave_num NUMBER;
BEGIN 
    SELECT AVG(total)
    INTO ave_num
    FROM invoice;
    RETURN ave_num;
END;
/

DECLARE
    ave_num NUMBER;
BEGIN
    ave_num := ave_of_invoices;
    DBMS_OUTPUT.PUT_LINE('The average total of the invoices is ' || ave_num);
END;
/


-- 3.2  Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive_track
    RETURN NUMBER AS price NUMBER;
BEGIN
    SELECT MAX(unitprice)
    INTO price
    FROM track;
    RETURN price;
END;
/

DECLARE
    price NUMBER;
BEGIN
    price := most_expensive_track();
    DBMS_OUTPUT.PUT_LINE('The most expensive track costs $' || price);
END;
/

-- 3.3 Create a function that returns the average price of invoice-line items in the invoice-line table
CREATE OR REPLACE FUNCTION average_price
    RETURN NUMBER AS avg_price NUMBER;
BEGIN 
    SELECT AVG(unitprice)
    INTO avg_price
    FROM invoiceline;
    RETURN avg_price;
END;
/

DECLARE
    avg_price NUMBER;
BEGIN
    avg_price := average_price();
    DBMS_OUTPUT.PUT_LINE('The the average price is $' || avg_price);
END;
/

-- 3.4 Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR IS my_cursor SYS_REFCURSOR;
BEGIN 
    OPEN my_cursor FOR 
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate > '12-dec-68';
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
        FETCH v_cursor INTO v_fn, v_ln, v_bd;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln || ' ' || v_bd);
    END LOOP;
    CLOSE v_cursor;
END;
/

-- 4.0 Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_employees(my_cursor OUT SYS_REFCURSOR)
IS 
BEGIN
    OPEN my_cursor FOR
    SELECT firstname, lastname
    FROM employee
    ORDER BY lastname;
END;
/

DECLARE 
    v_cursor    SYS_REFCURSOR;
    v_fn        employee.firstname%TYPE;
    v_ln        employee.lastname%TYPE;
BEGIN
    get_employees(v_cursor);
    LOOP
        FETCH v_cursor 
        INTO v_fn, v_ln;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_ln || ', ' || v_fn);
    END LOOP;
    CLOSE v_cursor;
END;
/

-- 4.2  Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee(f_name IN VARCHAR2, l_name IN VARCHAR2, new_firstname IN VARCHAR2, new_lastname IN VARCHAR2)
IS
BEGIN
    UPDATE employee
    SET firstname = new_firstname, lastname = new_lastname 
    WHERE firstname = f_name AND lastname = l_name;
END;
/

BEGIN
    update_employee('Joe', 'Dirt', 'Joseph', 'Dirty');
END;
/

-- 4.2 Create a stored procedure that returns the managers of an employee


-- 4.3 Create a stored procedure that returns the name and company of a customer.

-- 5.0 Create a transaction that given a invoiceId will delete that invoice


-- 5.0 Create a transaction nested within a stored procedure that inserts a new record in the Customer table

-- 6.1 Create an after insert trigger on the employee table fired after a new record is inserted into the table

-- 6.1 Create an after update trigger on the album table that fires after a row is updated in the table

-- 6.1 Create an after delete trigger on the customer table that fires after a row is deleted from the table

-- 6.2 Create a before trigger that restricts the deletion of any invoice that is priced over 50 dollars

-- 7.1 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
SELECT firstname, lastname, invoiceid
FROM customer
JOIN invoice
USING(customerid);

-- 7.2 Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total
SELECT firstname, lastname, customerid, invoiceid, total
FROM customer
FULL OUTER JOIN invoice
USING(customerid);

-- 7.3 Create a right join that joins album and artist specifying artist name and title
SELECT title, name
FROM artist
RIGHT JOIN album
USING(artistid);

-- 7.4 Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT title, name
FROM artist
CROSS JOIN album
ORDER BY name ASC;

-- 7.5 Perform a self-join on the employee table, joining on the reports to column
SELECT *
FROM employee
SELF JOIN employee
USING(reportsto);

-- 8.1 Create an index on of table of your choice
CREATE INDEX artist_index ON artist(name);
