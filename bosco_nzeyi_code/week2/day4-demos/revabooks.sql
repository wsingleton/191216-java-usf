
-- creating a new db for revabooks

CREATE USER revabook
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

-- grant connection to this new database
GRANT connect to revabook;
GRANT resource to revabook;
GRANT create session TO revabook;
GRANT create table TO revabook;
GRANT create view TO revabook;
