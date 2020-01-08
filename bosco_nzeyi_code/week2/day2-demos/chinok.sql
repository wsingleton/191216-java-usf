CREATE USER chinook
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

-- grant connection to this new database
GRANT connect to chinook;
GRANT resource to chinook;
GRANT create session TO chinook;
GRANT create table TO chinook;
GRANT create view TO chinook;

/*
for creating new connections: 

SID is usually ORCL

To check whether the new database was created, we navigate to other users and check if the newly
created database is present. 
*/

