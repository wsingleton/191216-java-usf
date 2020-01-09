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
