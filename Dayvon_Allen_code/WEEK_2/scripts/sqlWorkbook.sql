
/*
    SELECT 2.1
*/

--select everything from the employee table
SELECT * FROM employee;

--select everything from the employee table where the last name is king
SELECT * FROM employee 
WHERE lastname = 'King';

--select everything from the employee table where the first name is andrew and "reportsto" is null.
SELECT * FROM employee 
WHERE firstname = 'Andrew' 
AND reportsto IS NULL;

/*
    2.2 Order By
*/

--Select all albums in album table and sort result set in descending order
SELECT * FROM album
ORDER BY title DESC;

--Select first name from Customer and sort result set in ascending order
SELECT firstname FROM customer
ORDER BY firstname ASC;

/*
    2.3 Insert into
*/

--Insert two new records into Genre table
INSERT INTO genre VALUES (0, 'DNB');
INSERT INTO genre VALUES (27, 'House');


--Insert two new records into Employee table
INSERT INTO employee VALUES (0, 
'Jackson', 
'Jimmy', 
'IT staff', 
6,
TO_DATE('65-12-04', 'YY-MM-DD'),
TO_DATE('07-12-12', 'YY-MM-DD'),
'104 1st st',
'Calgary', 
'AB',
'Canada', 
'T3B 1Y7', 
'1 (780) 836-9934', 
'1 (780) 836-8392', 
'jimmy@chinookcorp.com' );

INSERT INTO employee VALUES (9,
'Washington', 
'Charles', 
'IT staff', 
6, 
TO_DATE('63-02-04', 'YY-MM-DD'),
TO_DATE('05-08-05', 'YY-MM-DD'),
'110 3rd st',
'Calgary', 
'AB',
'Canada', 
'T3B 1Y7', 
'1 (780) 850-8334', 
'1 (780) 810-7832', 
'charles@chinookcorp.com' );

--Insert two new records into Customer table
INSERT INTO customer VALUES(
0, 
'Larry',
'Sparks',
'Target',
'123 elm st.',
'Tucson',
'AZ',
'USA',
'90003',
'+1 (310)233-4509',
'+1 (310)322-4909',
'larry@target.com',
5
);

INSERT INTO customer VALUES(
60, 
'Jerry',
'Jone',
'Tesoro',
'150 spring st.',
'Los Angeles',
'CA',
'USA',
'90043',
'+1 (323)343-5409',
'+1 (323)902-5919',
'jerry@tesoro.com',
5
);


/*
    2.4 update
*/

--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert',lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';


--Update name of artist “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

/*
    2.5 like
*/

--Select all invoices with a billing address like “T”
SELECT *
FROM invoice
WHERE billingaddress LIKE '%T%';


/*
    2.6 Between
*/

--Select all invoices that have a total between 15 and 50

SELECT * 
FROM invoice
WHERE total BETWEEN 15 AND 50;

--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate BETWEEN TO_DATE('03-06-01', 'YY-MM-DD') AND TO_DATE('04-03-01', 'YY-MM-DD');

/*
    Delete
*/

--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoiceline
DROP CONSTRAINT  FK_INVOICELINEINVOICEID;

DELETE FROM invoice WHERE customerid = (SELECT customerid FROM customer WHERE lastname = 'Walter');
DELETE FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';

ROLLBACK;



/*
    3.1 System Defined Functions
*/
SET SERVEROUTPUT ON;

--Create a function that returns the current time.
CREATE OR REPLACE FUNCTION current_time
    RETURN TIMESTAMP
        AS time TIMESTAMP;
        
BEGIN
   select CURRENT_TIMESTAMP
   INTO time
    from dual;
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

--Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_mediatype_length
    RETURN NUMBER
    AS media_length NUMBER;

BEGIN
    SELECT LENGTH(name)
    INTO media_length
    FROM mediatype
    WHERE mediatypeid = 1;
    
    RETURN media_length;
END;
/

DECLARE
    mediatype NUMBER;
BEGIN
    mediatype := get_mediatype_length();
    DBMS_OUTPUT.PUT_LINE('The length of the mediatype table is ' || mediatype);
END;
/

/*
    3.2 System Defined Aggregate Functions
*/

--Task –Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_avg
    RETURN NUMBER
    AS avgTotal NUMBER;

BEGIN
    SELECT AVG(total)
    INTO avgTotal
    FROM invoice;
    
    RETURN avgTotal;
END;
/

DECLARE
    avgTotal NUMBER;
BEGIN
    avgTotal := get_avg();
    DBMS_OUTPUT.PUT_LINE('The average of all of the total costs is $' || avgTotal);
END;
/

--Task – Create a function that returns the most expensive tracks
CREATE OR REPLACE FUNCTION most_expensive_tracks
    RETURN SYS_REFCURSOR
    IS my_cursor SYS_REFCURSOR;

BEGIN
    OPEN my_cursor FOR
    SELECT name, unitprice
    FROM track
    GROUP BY name, unitprice
    HAVING  unitprice = (SELECT MAX(unitprice) FROM track);
    RETURN my_cursor;
END;
/


DECLARE
    v_cursor  SYS_REFCURSOR;
    v_n     track.name%TYPE;
    v_price      track.unitprice%TYPE;
    
BEGIN
    V_cursor := most_expensive_tracks();
    
    DBMS_OUTPUT.PUT_LINE('Most Expensive albums:' );

    LOOP
       FETCH v_cursor
       INTO v_n, v_price;
       EXIT WHEN v_cursor%NOTFOUND;
       DBMS_OUTPUT.PUT_LINE(v_n || ' costs $' || v_price );
       END LOOP;
       CLOSE v_cursor;
END;
/


/*
    3.3 User Defined Scalar Functions
*/

--Task – Create a function that returns the average price of invoice-line items in the invoice-line table

CREATE OR REPLACE FUNCTION get_avg
    RETURN NUMBER
    AS avgPrice NUMBER;

BEGIN
    SELECT AVG(unitprice)
    INTO avgPrice
    FROM invoiceline;
    
    RETURN avgPrice;
END;
/

DECLARE
    avgPrice NUMBER;
BEGIN
    avgPrice := get_avg();
    DBMS_OUTPUT.PUT_LINE('The average price of all of the invoices is $' || avgPrice);
END;
/

/*
3.4 User Defined Table Valued Functions
*/

--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION after_1968
    RETURN SYS_REFCURSOR
    IS my_cursor SYS_REFCURSOR;
    
BEGIN

    OPEN my_cursor FOR
    SELECT firstname, lastname, birthdate
    FROM employee
    WHERE birthdate BETWEEN DATE'1968-12-31' AND DATE'2019-12-31';
    
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

/*
    4.1 Basic Stored Procedure
*/

-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_employees_name(my_cursor OUT SYS_REFCURSOR)
IS 
BEGIN
OPEN my_cursor FOR
SELECT firstname, lastname
FROM employee
ORDER BY firstname;
END;
/

DECLARE
    e_fn     employee.firstname%TYPE;
    e_ln   employee.lastname%TYPE;
    v_cursor SYS_REFCURSOR;
BEGIN
    get_employees_name(v_cursor);
    
    LOOP
       FETCH V_cursor
       INTO e_fn, e_ln;
       EXIT WHEN v_cursor%NOTFOUND;
       DBMS_OUTPUT.PUT_LINE('Employee First Name: ' || e_fn || ' , Last Name: ' || e_ln);
       END LOOP;
       
       CLOSE v_cursor;
END;
/

/*
    4.2 Stored Procedure Input Parameters
*/

-- Task – Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE updateEmployee(
	   employee_fn IN employee.firstname%TYPE,
       employee_newfn IN employee.firstname%TYPE
	   )
IS
BEGIN
  UPDATE employee SET firstname = employee_newfn WHERE employee_fn  = firstname;
END;
/
BEGIN
   updateEmployee('Jimmy', 'Holly');
END;

--Task – Create a stored procedure that returns the managers of an employee

CREATE OR REPLACE PROCEDURE get_employees_Manager(my_cursor OUT SYS_REFCURSOR)
IS 
BEGIN
OPEN my_cursor FOR
SELECT firstname, lastname, reportsto
FROM employee
ORDER BY firstname;
END;
/

DECLARE
    e_fn     employee.firstname%TYPE;
    e_ln   employee.lastname%TYPE;
    e_rt   employee.reportsto%TYPE;
    b_fn  employee.firstname%TYPE;
    v_cursor SYS_REFCURSOR;
BEGIN
    get_employees_name(v_cursor);
    
    LOOP
       FETCH V_cursor
       INTO e_fn, e_ln;
SELECT reportsto INTO e_rt FROM employee WHERE firstname = e_fn;
        b_fn := e_rt;

       EXIT WHEN v_cursor%NOTFOUND;

       DBMS_OUTPUT.PUT_LINE('Employee Name: ' 
       || e_fn 
       || ' '
       || e_ln 
       || '; ' 
       || 'Boss ID: '
       || b_fn 
       );
       END LOOP;
       CLOSE v_cursor;
END;
/

/*
    4.3 Stored Procedure Output Parameters
*/

--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_all_customer_comapanies(my_cursor OUT SYS_REFCURSOR)
IS 
BEGIN
OPEN my_cursor FOR
SELECT firstname, lastname,company
FROM customer
ORDER BY firstname;
END;
/

DECLARE
    a_fn    customer.firstname%TYPE;
    a_ln   customer.lastname%TYPE;
    a_com   customer.company%TYPE;
    v_cursor SYS_REFCURSOR;
BEGIN
    get_all_customer_comapanies(v_cursor);
    
    LOOP
       FETCH V_cursor
       INTO a_fn, a_ln, a_com;
       EXIT WHEN v_cursor%NOTFOUND;
       DBMS_OUTPUT.PUT_LINE('Customer name: ' || a_fn || ' ' || a_ln || '; Company name: ' || a_com);
       END LOOP;
       
       CLOSE v_cursor;
END;
/


/*
    5.0 Transactions
*/

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them)...poiij
CREATE OR REPLACE PROCEDURE deleteInvoice(
	   invoice_id IN invoice.invoiceid%TYPE
	   )
IS
BEGIN
  DELETE FROM invoice WHERE invoiceid = invoice_id;
END;
/
BEGIN
   deleteInvoice(111);
   COMMIT;
END;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insertRecord(
	   customer_id IN customer.customerid%TYPE,
       customer_fn IN customer.firstname%TYPE,
       customer_ln IN customer.lastname%TYPE,
       customer_com IN customer.company%TYPE,
       customer_address IN customer.address%TYPE,
       customer_ct IN customer.city%TYPE,
       customer_st IN customer.state%TYPE,
       customer_coun IN customer.country%TYPE,
       customer_pc IN customer.postalcode%TYPE,
       customer_pn IN customer.phone%TYPE,
       customer_fx IN customer.fax%TYPE,
       customer_email IN customer.email%TYPE,
       customer_sp IN customer.supportrepid%TYPE
	   )
IS
BEGIN
  INSERT INTO customer VALUES(customer_id,
  customer_fn,
  customer_ln, 
  customer_com, 
  customer_address,
  customer_ct,
  customer_st,
  customer_coun,
  customer_pc,
  customer_pn,
  customer_fx,
  customer_email,
  customer_sp);
END;
/
BEGIN
   insertRecord(1500, 'Jack','Cage','Amazon', '102 S. 5th St.','Tucson','AZ', 'USA', '30239','321-456-0987','321-607-1289','jcage@amazon.com',5);
   COMMIT;
END;

--SELECT * FROM customer WHERE firstname = 'Jack' AND lastname = 'Cage';


/*
    Triggers
    6.1 after/before
*/

--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
SET SERVEROUTPUT ON;

CREATE OR REPLACE TRIGGER employee_insert_trigger
AFTER INSERT ON employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee Inserted successfully!');
END;
/

INSERT INTO employee VALUES (12,
'Powell', 
'Harold', 
'IT staff', 
6, 
TO_DATE('45-10-04', 'YY-MM-DD'),
TO_DATE('93-12-05', 'YY-MM-DD'),
'150 King st',
'Los Angeles', 
'CA',
'USA', 
'90043', 
'1 (323) 756-8334', 
'1 (310) 903-7832', 
'haroldP@chinookcorp.com' );

--Task – Create an after update trigger on the album table that fires after a row is updated in the table
SET SERVEROUTPUT ON;

CREATE OR REPLACE TRIGGER album_update_trigger
AFTER UPDATE ON album
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album updated successfully!');
END;
/

UPDATE album
SET title = 'Fake Name'
WHERE title = 'Duos II';

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
SET SERVEROUTPUT ON;

CREATE OR REPLACE TRIGGER customer_delete_trigger
AFTER DELETE ON customer
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer deleted successfully!');
END;
/

DELETE FROM customer
WHERE firstname = 'Larry' AND lastname = 'Sparks';

--Task – Create a before trigger that restricts the deletion of any invoice that is priced over 20 dollars.
CREATE OR REPLACE TRIGGER invoice_delete_trigger
BEFORE DELETE ON invoice
  FOR EACH ROW 

BEGIN
    IF (:old.total > 20) THEN
      RAISE_APPLICATION_ERROR(-20000,
        'The total is over $20 and cannot be deleted, invoice total is: ' || :old.total);
    END IF;
END;
/

DELETE FROM invoice
WHERE invoiceid = 194;

/*
    7.0 Joins
*/

--Task – Create an inner join that joins customers and invoice and specifies the name of the customer and the invoiceId.
SELECT firstname, lastname, invoiceid
FROM customer
JOIN invoice
ON customer.customerid = invoice.customerid;

--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid
ORDER BY customerid;

--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title
FROM artist
RIGHT OUTER JOIN album 
ON album.artistid = artist.artistid
ORDER BY name;

--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM artist 
CROSS JOIN album
ORDER BY artist.name ASC;

--Task – Perform a self-join on the employee table, joining on the reports to column.
SELECT *
FROM employee e1
INNER JOIN employee e2 
ON e1.reportsto = e2.reportsto; 

/*
    8.0 indexes
*/

--Task – Create an index on of table of your choice
CREATE INDEX test_index
ON employee(firstname);

