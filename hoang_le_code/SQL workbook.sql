--2.1
SELECT  *
FROM employee;

SELECT * FROM employee WHERE lastname = 'King';

SELECT *FROM employee 
WHERE firstname = 'Andrew' and reportsto = null;

--2.2
SELECT *
FROM album 
ORDER by albumid DESC;

SELECT firstname FROM customer ORDER BY firstname ASC;

--2.3
INSERT INTO genre VALUES(26,'Country');
INSERT INTO genre VALUES(27,'Music');

INSERT INTO employee VALUES(9,'Le', 'Hoang','Staff',5,date  '1990-08-30',date '2019-12-16','1503 N Mckinley ave','Chicago', 'IL','USA','61821','217-281-2842','2172812842','Hoangle@gmail.com');
INSERT INTO employee VALUES(10,'Le1', 'Hoang11','Staff1',5,date  '1990-08-30',date '2019-12-16','11234 N University ave','Champaign', 'IL','USA','61822','217-281-2842','2172812842','Hoangle111@gmail.com');

INSERT INTO customer VALUES(60,'Le', 'Hoang','Revature','1503 N Mckinley ave','Chicago', 'IL','USA','61821','217-281-2842','2172812842','Hoangle@gmail.com', 3);
INSERT INTO customer VALUES(61,'Le1', 'Hoang11','Revature','1503 N Univesity ave','Champaign', 'IL','USA','61822','217-281-2842','2172812842','Hoangle111@gmail.com', 3);

COMMIT ;

--2.4
UPDATE customer SET firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

UPDATE artist SET name = 'CCR' where name = 'Creedence Clearwater Revival';
COMMIT ;
--2.5

SELECT * FROM invoice where billingaddress LIKE '%T%';
--2.6
SELECT *
FROM invoice
WHERE total BETWEEN 15 AND 50;

SELECT *
FROM employee
WHERE hiredate BETWEEN  date '2003-06-01' AND date '2004-04-01';

--2.7
-- frist use select to get customer id 
Select * FROM customer  WHERE firstname = 'Robert'and lastname = 'Walter';
-- we got customer id is 32, then get all invoice that have customerid = 32 in invoiceline
Select * FROM invoice  WHERE customerid = 32;
-- we got 245,268,290,342,50,61,116. then we delete all the invoiceline that have invoic id same with these id
DELETE FROM invoiceline  WHERE invoiceid = 245;
DELETE FROM invoiceline  WHERE invoiceid = 268;
DELETE FROM invoiceline  WHERE invoiceid = 290;
DELETE FROM invoiceline  WHERE invoiceid = 342;
DELETE FROM invoiceline  WHERE invoiceid = 50;
DELETE FROM invoiceline  WHERE invoiceid = 61;
DELETE FROM invoiceline  WHERE invoiceid = 116;

-- now delete all invoice that have customer id = 32 

DELETE FROM invoice  WHERE customerid = 32;
-- finally delete Robert Walter
DELETE FROM customer  WHERE firstname = 'Robert'and lastname = 'Walter';

COMMIT ;



-- section 3

--3.1
SELECT systimestamp
FROM dual;

SELECT LENGTH(name)
FROM mediatype;

--3.2
SELECT AVG(total) as "Average" from invoice;
SELECT MAX(unitprice)as "Most expensive" from track;

--3.3
SELECT ROUND(AVG(unitprice),2) as "Average" from invoiceline;

--3.4

SELECT * FROM employee WHERE birthdate > date'1968-12-31';

