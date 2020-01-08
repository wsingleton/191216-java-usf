--- QUERRY EXERCICES FROM CHINOOK DATABASES HERE
---- ------------------ -------------

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

