
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
