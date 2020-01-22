CREATE TABLE app_user
(
    user_id         NUMBER,
    username        varchar2(25) UNIQUE NOT NULL,
    password        varchar2(25) NOT NULL,
    first_name varchar2(20) NOT NULL,
    last_name varchar2(20) NOT NULL,
    role_id NUMBER,
    
    CONSTRAINT APP_USER_PK PRIMARY KEY ( user_id )
);