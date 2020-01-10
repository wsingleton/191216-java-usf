SET SERVEROUTPUT ON;

-- 2.1 +===========================================================

SELECT * FROM employee;

SELECT * FROM employee WHERE lastname = 'King';

SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto = null;

-- 2.2 +===========================================================

SELECT * FROM album ORDER BY albumid DESC;

SELECT  firstname FROM customer ORDER BY firstname ASC;

-- 2.3 +===========================================================

INSERT INTO genre VALUES(26, 'Bebop');
INSERT INTO genre VALUES(27, 'Lofi');

INSERT INTO employee VALUES(9, 'Dwayne', 'Johnson', 'The Rock', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO employee VALUES(10, 'asdf', 'jkl;', 'jaksjdfk', null, null, null, null, null, null, null, null, null, null, null);

INSERT INTO customer (customerid, firstname, lastname, email) VALUES (60, 'Bill', 'And', 'email');
INSERT INTO customer (customerid, firstname, lastname, email) VALUES (61, 'Ted', 'sExcellentAdventure', 'email');

-- 2.4 +===========================================================

UPDATE  customer SET firstname = 'Robert', lastname = 'Walter' WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

UPDATE artist SET name = 'CCR' Where name = 'Creedence Clearwater Revival';

-- 2.5 +===========================================================

SELECT * FROM invoice WHERE billingaddress LIKE 'T';

-- 2.6 +===========================================================

SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

SELECT * FROM employee WHERE hiredate BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';

-- 2.7 +===========================================================

ALTER TABLE invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE invoice ADD CONSTRAINT FK_INVOICECUSTOMERID 
FOREIGN KEY (CUSTOMERID) REFERENCES Customer (CUSTOMERID) 
ON DELETE CASCADE;

ALTER TABLE invoiceline DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE invoiceline ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES invoice (INVOICEID)
ON DELETE CASCADE;

DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';

-- 2.X END +=======================================================

COMMIT;

-- 3.1 +===========================================================

CREATE OR REPLACE FUNCTION returnTime
        RETURN TIMESTAMP AS currentTime TIMESTAMP;
    
BEGIN
        SELECT SYSTIMESTAMP INTO currentTime FROM DUAL;
        RETURN currentTime;
END;
/

DECLARE currentTime TIMESTAMP;
BEGIN
        currentTime := returnTime();
        DBMS_OUTPUT.PUT_LINE('Current time is ' || currentTime);
END;
/

CREATE OR REPLACE FUNCTION mediaTypeLen(id NUMBER)
        RETURN NUMBER AS len NUMBER;
        
BEGIN
        SELECT LENGTH(name) INTO len FROM mediatype WHERE mediatypeid = id;
        RETURN len;
END;
/

DECLARE len NUMBER;
BEGIN
        len := mediaTypeLen(1);
        DBMS_OUTPUT.PUT_LINE('Length is ' || len);
END;
/

-- 3.2 +===========================================================


CREATE OR REPLACE FUNCTION invoiceAvg
        RETURN NUMBER AS mean NUMBER;
        
BEGIN
          SELECT AVG(total) INTO mean FROM invoice;
          RETURN mean;
 END;
        /

DECLARE mean NUMBER;
BEGIN
        mean := invoiceAvg();
        DBMS_OUTPUT.PUT_LINE('AVG is ' || mean);
END;
/

CREATE OR REPLACE FUNCTION maxPriceTrack
        RETURN NUMBER AS maxprice NUMBER;
        
BEGIN
        SELECT MAX(unitprice) INTO maxprice FROM track;
        RETURN maxprice;
END;
/

DECLARE maxprice NUMBER;
BEGIN
        maxprice := maxPriceTrack();
        DBMS_OUTPUT.PUT_LINE('MAX TRACK IS ' || maxprice);
END;
/

-- 3.3 +===========================================================

-- Just return the unit price?  not sure if this is describing scalar or aggregate operation?

CREATE OR REPLACE FUNCTION getAvgPrice
    RETURN SYS_REFCURSOR IS my_cursor SYS_REFCURSOR;
    
BEGIN

OPEN my_cursor FOR SELECT  invoiceid,  (AVG(unitprice)) AS invoiceAvg
FROM invoiceline GROUP BY invoiceid, invoiceAvg ORDER BY invoiceid;

RETURN my_cursor;

END;
/

DECLARE
    v_cursor        SYS_REFCURSOR;
    v_id              invoiceline.invoiceid%TYPE;
    v_avg           NUMBER;
    
BEGIN
    
    v_cursor := getAvgPrice();
    
    LOOP
        FETCH v_cursor INTO v_id, v_avg;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_id || ' ' || v_avg);
    END LOOP;
    CLOSE v_cursor;
    
END;
/

-- 3.4 +===========================================================

CREATE OR REPLACE FUNCTION get_after_1968
    RETURN SYS_REFCURSOR IS my_cursor SYS_REFCURSOR;

BEGIN

OPEN my_cursor FOR SELECT firstname, lastname, birthdate 
FROM EMPLOYEE GROUP BY firstname, lastname, birthdate 
HAVING MIN(birthdate) > DATE '1968-12-31';

RETURN my_cursor;

END;
/

DECLARE
    v_cursor        SYS_REFCURSOR;
    v_fn            employee.firstname%TYPE;
    v_ln            employee.lastname%TYPE;
    v_bd            employee.birthdate%TYPE;
    
BEGIN
    
    v_cursor := get_after_1968();
    
    LOOP
        FETCH v_cursor INTO v_fn, v_ln, v_bd;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln || ' ' || v_bd);
    END LOOP;
    CLOSE v_cursor;
    
END;
/

-- 3.X END +=======================================================

COMMIT;

-- 4.1 +===========================================================

CREATE OR REPLACE PROCEDURE getAllEmployees(my_cursor OUT SYS_REFCURSOR)
IS
BEGIN
    
    OPEN my_cursor FOR SELECT firstname, lastname FROM employee ORDER BY lastname;
    
END;
/

DECLARE
    v_cursor        SYS_REFCURSOR;
    v_fn            employee.firstname%TYPE;
    v_ln            employee.lastname%TYPE;
BEGIN
    
    getAllEmployees(v_cursor);
    
    LOOP
        FETCH v_cursor INTO v_fn, v_ln;
        EXIT WHEN v_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln);
    END LOOP;
    CLOSE v_cursor;
    
END;
/

-- 4.2 +===========================================================

CREATE OR REPLACE PROCEDURE updateEmployee(id IN NUMBER, fn IN VARCHAR2, ln IN VARCHAR2) 
IS
BEGIN
    
    UPDATE employee SET firstname = fn, lastname = ln WHERE employeeid = id;
    
END;
/

BEGIN
    updateEmployee(10, 'Evan', 'Hsi');
END;
/

CREATE OR REPLACE PROCEDURE returnManagers(id IN NUMBER, fname OUT VARCHAR2, lname OUT VARCHAR2)
IS 

man_id NUMBER;

BEGIN

    SELECT reportsto INTO man_id FROM employee WHERE employeeid = id;
    
    SELECT firstname, lastname INTO fname, lname FROM employee WHERE employeeid = man_id;
    
END;
/

DECLARE
    v_fn    VARCHAR2(25);
    v_ln    VARCHAR2(25);

BEGIN
    returnManagers(2, v_fn, v_ln);
    DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln);
END;
/

-- 4.3 +===========================================================

CREATE OR REPLACE PROCEDURE returnNameAndCompany(
    id IN NUMBER, 
    fname OUT VARCHAR2,
    lname OUT VARCHAR2,
    cname OUT VARCHAR2
    ) AS
    
BEGIN
    SELECT firstname, lastname, company
    INTO fname, lname, cname
    FROM customer
    WHERE customerid = id;
END;
/

DECLARE
    v_fn    VARCHAR2(25);
    v_ln    VARCHAR2(25);
    v_cn    VARCHAR2(50);

BEGIN

    returnNameAndCompany(2, v_fn, v_ln, v_cn);
    DBMS_OUTPUT.PUT_LINE(v_fn || ' ' || v_ln || ' from ' || v_cn);

END;
/

-- 4.X END +=======================================================

COMMIT;

-- 5.1 +===========================================================

ALTER TABLE invoiceline DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE invoiceline ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES invoice (INVOICEID)
ON DELETE CASCADE;

CREATE OR REPLACE PROCEDURE deleteInvoice(id IN NUMBER)
AS

BEGIN
    
    DELETE FROM invoice WHERE invoiceid = id;
    
END;
/

BEGIN
    deleteInvoice(1);
END;
/

INSERT INTO invoice VALUES(1, 2, DATE '2009-01-09', 'Theodor-Heuss-Straße 34', 
    'Stuttgart', null, 'Germany', 70174, 1.98);
    
INSERT INTO invoiceline VALUES(1, 1, 2, 0.99, 1);
INSERT INTO invoiceline VALUES(2, 1, 4, 0.99, 1);

COMMIT;

CREATE OR REPLACE PROCEDURE insertCustomer(id IN NUMBER, fn IN VARCHAR2, 
                                            ln IN VARCHAR2, email IN VARCHAR2)
AS

BEGIN
    INSERT INTO customer (customerid, firstname, lastname, email)
    VALUES(id, fn, ln, email);
    COMMIT;
END;
/


BEGIN

    insertCustomer(62, 'Evan', 'Hsi', 'dummy@gmail.com');
    --DBMS_OUTPUT.PUT_LINE('Inserting record');
    
END;
/

SELECT * FROM CUSTOMER;

BEGIN

    DBMS_OUTPUT.PUT_LINE('Deleting customer');
    DELETE FROM CUSTOMER WHERE customerid = 62;

END;
/

SELECT * FROM CUSTOMER;

-- 5.X END +=======================================================

COMMIT;

-- 6.1 +===========================================================

CREATE OR REPLACE TRIGGER afterEmployeeInsert AFTER INSERT ON employee

BEGIN
    
    DBMS_OUTPUT.PUT_LINE('INSERT successful');

END;
/

INSERT INTO employee (employeeid, firstname, lastname) VALUES(11, 'Conrad', 'Diao');
DELETE FROM employee WHERE employeeid = 11;


CREATE OR REPLACE TRIGGER afterUpdateAlbum AFTER INSERT ON album

BEGIN

    DBMS_OUTPUT.PUT_LINE('UPDATE trigger??');

END;
/

CREATE OR REPLACE TRIGGER afterDeleteCustomer AFTER DELETE ON customer

BEGIN

    DBMS_OUTPUT.PUT_LINE('DELETE trigger');

END;
/

INSERT INTO customer (customerid, firstname, lastname, email) 
VALUES(62, 'Conrad', 'Diao', 'dummy2@gmail.com');

DELETE FROM customer WHERE customerid = 62;

-- 6.2 +===========================================================

CREATE OR REPLACE TRIGGER checkDelete BEFORE DELETE ON invoice
FOR EACH ROW
BEGIN
        IF :OLD.total > 50 THEN
            RAISE_APPLICATION_ERROR(-20000, 'Invoice > $50');
        END IF;
END;
/

UPDATE invoice SET total = 55 where invoiceid = 1; 

DELETE FROM invoice WHERE invoiceid = 1;

UPDATE invoice SET total = 1.98 where invoiceid = 1; 

INSERT INTO invoice VALUES(1, 2, DATE '2009-01-09', 'Theodor-Heuss-Straße 34', 
    'Stuttgart', null, 'Germany', 70174, 1.98);
    
INSERT INTO invoiceline VALUES(1, 1, 2, 0.99, 1);
INSERT INTO invoiceline VALUES(2, 1, 4, 0.99, 1);


-- 6.X END +=======================================================

COMMIT;

-- 7.1 +===========================================================

SELECT firstname, lastname, invoiceid FROM customer
JOIN invoice
--ON c.customerid = i.customerid;
USING (customerid);

-- 7.2 +===========================================================

SELECT customerid, firstname, lastname, invoiceid, total FROM customer
FULL OUTER JOIN invoice
USING ( customerid );

-- 7.3 +===========================================================

/*
    This join makes the most sense out of right/left artist/album joins because
    some of the artists don't have albums, so I did it this way, the other way
    results in some artists being displayed with null for album titles.
*/

SELECT name, title FROM artist
RIGHT JOIN album
USING (artistid);

-- 7.4 +===========================================================

SELECT name, title FROM artist
CROSS JOIN album
ORDER BY name ASC;

-- 7.5 +===========================================================

SELECT * FROM employee
SELF JOIN employee 
USING (reportsto);


-- 7.X END +=======================================================

COMMIT;

-- 8.1 +===========================================================

CREATE INDEX artist_idx ON artist (name) COMPUTE STATISTICS;

DROP INDEX artist_idx;

-- ALTER INDEX artist_idx REBUILD COMPUTE STATISTICS;



