--Section 2.1
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' and REPORTSTO  is NULL;

--Section 2.2
SELECT * FROM album ORDER BY title desc;
SELECT firstname FROM customer ORDER BY city asc;

Select * from genre;
--Section 2.3
INSERT INTO genre VALUES (26, 'Munble Rap');
INSERT INTO genre VALUES (27, 'Punk Rock');

select * from employee;
INSERT INTO employee values (9, 'Burke', 'Benjamin', 'CEO', null, '1-MAR-92', '13-DEC-19','Address', 'CITY', 'STATE', 'USA', 'postcode', 2222222, 4444444, 'Email' );
INSERT INTO employee values (10, 'Hauser', 'Olive', 'Staff', null, '1-MAR-92', '13-DEC-19','Address', 'CITY', 'STATE', 'USA', 'postcode', 2222222, 4444444, 'Email' );

SELECT
    *
FROM customer;
INSERT INTO Customer VALUES(60, 'John', 'Smith', null, 'Address', 'New York', 'NY', 'USA', '68475', 4755244, 547521, 'email', 4);
INSERT INTO Customer VALUES(61, 'Steve', 'Smith', null, 'Address', 'New York', 'NY', 'USA', '68475', 4755244, 547521, 'email', 3);

SELECT * FROM customer where firstname = 'Robert';
--Section 2.4
UPDATE customer SET firstname = 'Robert', lastname = 'Walter' WHERE customerid=32;
SELECT * FROM artist where name = 'CCR';
UPDATE artist SET name = 'CCR' WHERE artistid=76;

--SECTION 2.5
SELECT
    *
FROM invoice WHERE billingaddress LIKE 'T%';

--SECTION 2.6
SELECT * FROM invoice WHERE (total>15) and (total <50);
SELECT * FROM employee WHERE hiredate between '01-JUN-03' and '01-MAR-04';

--Section 2.7
ALTER TABLE invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE invoice ADD CONSTRAINT FK_INVOICECUSTOMERID 
FOREIGN KEY (CUSTOMERID) REFERENCES Customer (CUSTOMERID) 
ON DELETE CASCADE;

ALTER TABLE invoiceline DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE invoiceline ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES invoice (INVOICEID)
ON DELETE CASCADE;
DELETE FROM customer WHERE firstname='Robert' and lastname='Walter';
COMMIT;

--Section 3.1
CREATE or REPLACE function getSysdate
return date is
  l_sysdate date;

BEGIN
  SELECT sysdate
    INTO l_sysdate
    FROM dual;

  return l_sysdate;
END;

select getsysdate() from dual;
-----------------------------
CREATE OR REPLACE FUNCTION mediaType;

--Section 3.2
CREATE OR REPLACE FUNCTION invoiceAvg
        RETURN NUMBER AS mean NUMBER;
BEGIN
  SELECT AVG(total)INTO mean FROM invoice;
  RETURN mean;
END;
/
DECLARE mean NUMBER;
BEGIN
  mean :=invoiceAvg();
  DBMS_OUTPUT.PUT_LINE('AVG is' || mean );
END;
/

---------------
SELECT MAX(unitprice) FROM track;

CREATE OR REPLACE FUNCTION getMostExpensiveTrack
RETURN number is
    price number;
BEGIN
  SELECT MAX(unitprice)
  INTO price
    FROM track;
    RETURN PRICE;
END;
/

SELECT getmostexpensivetrack from dual;

--Section 3.3
CREATE OR REPLACE FUNCTION avgPriceInvoice
RETURN number is
    average number;
BEGIN
  SELECT   avg(total)
  into average
  from invoice;
  return average;
END;
/
--this took way too long to figure out idk
--not sure what it was asking exaclty
--also way off
SELECT avgpriceinvoice from dual;
/
--Section 3.4
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
IS
  EMPLOYEE_C SYS_REFCURSOR;
BEGIN
  OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= TO_DATE('01-01-1968','DD-MM-YYYY');
  RETURN EMPLOYEE_C;
END;
/


    
SELECT after_1968 FROM DUAL;

--SECTION 4.1
CREATE OR REPLACE PROCEDURE EMPLOYEE_INFO(CURSOR1 OUT SYS_REFCURSOR)
AS
BEGIN
   OPEN CURSOR1 FOR
   SELECT firstname, lastname
   from employee;
    end;
/
SELECT


--SECTION 4.2
CREATE OR REPLACE PROCEDURE updateEmployee(
empid in number,
fn in varchar2,
ln in varchar2
)
AS
BEGIN
    UPDATE employee
    SET firstname =fn, lastname= ln
    WHERE employeeid = empid;
END;
/
BEGIN
    updateEmployee(10, 'Benjamin', 'Burke');
END;
--------------------------------------------------
CREATE OR REPLACE PROCEDURE getManagers(
empid IN NUMBER,
cursor1 OUT SYS_REFCURSOR
)
as
BEGIN
  OPEN cursor1 FOR
  SELECT * FROM employee
  WHERE employeeid = (
    SELECT reportsto
    FROM employee
    WHERE employeeid = empid
  );
END;
/

--Section 4.3--ummmm need to add fname, lname, cname
--UGH NEED TO COME BACK TO THIS ONE
CREATE OR REPLACE PROCEDURE nameAndCompany(cusId in NUMBER,
cursor1 OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN cursor1 FOR
    SELECT * FROM customer
    WHERE customerid = cusid;
END;
/
COMMIT;

--SECTION 5.0
CREATE OR REPLACE PROCEDURE deleteInvoice(
  invid in number
)
as
BEGIN
  DELETE FROM invoiceline
  WHERE invoiceid = invid;
  
  DELETE FROM invoice
  WHERE invoiceid = invid;
  commit;
END;
/
----------------------------
CREATE or REPLACE PROCEDURE insertCustomer(
  fn in varchar2,
  ln in varchar2,
  cus_email in varchar2
)
AS
BEGIN
  INSERT INTO customer (firstname, lastname, email) VALUES (fn, ln, cus_email);
  COMMIT;
END;
/

--Section 6.1
CREATE OR REPLACE TRIGGER insertEmployee
AFTER INSERT
ON employee
FOR EACH ROW
BEGIN
  dbms_output.put_line('new employee inserted');
END;
/

---------------------------
CREATE OR REPLACE TRIGGER updateAlbum
AFTER UPDATE
ON album
FOR EACH ROW
BEGIN
  dbms_output.put_line('album updated');
END;
/

------------------------------------
CREATE OR REPLACE TRIGGER deleteCustomer
AFTER DELETE
ON customer
FOR EACH ROW
BEGIN
  dbms_output.put_line('customer deleted');
END;
/

--SECTIION 7.1
SELECT c.firstname, c.lastname, i.invoiceid
FROM customer c INNER JOIN invoice i
ON c.customerid = i.customerid
ORDER BY c.lastname ASC;

--section 7.2

--Section 7.3
SELECT art.NAME, alb.title
from artist art RIGHT JOIN album alb
ON art.artistid = alb.artistid
ORDER BY art.NAME asc;

-- section 7.4
SELECT art.NAME, alb.title
FROM album alb
CROSS JOIN artist art
ORDER BY art.name asc;

--SECTION 7.5
SELECT x.firstname, x.lastname
FROM employee x, employee y
WHERE x.reportsto = y.reportsto
ORDER BY lastname asc;

--Section 8.1
CREATE INDEX artist_idx ON artist (name) COMPUTE STATISTICS;


