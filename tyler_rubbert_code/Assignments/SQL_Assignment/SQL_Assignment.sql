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
