CREATE TABLE ers_user_roles(
    ers_user_role_id       NUMBER   CONSTRAINT   pk_ers_user_roles  PRIMARY KEY,
    user_role              VARCHAR2(10)    
);

CREATE TABLE ers_reimburstment_type(
    reim_typr_id       NUMBER   CONSTRAINT   pk_reimburstment_type  PRIMARY KEY,
    reim_type          VARCHAR2(10)    
);

CREATE TABLE ers_reimburstment_status(
    reimb_status_id       NUMBER   CONSTRAINT   pk_ers_reimburstment_status  PRIMARY KEY,
    reimb_status          VARCHAR2(10)    
);

CREATE TABLE ers_users(
    ers_user_id         NUMBER,
    ers_username        VARCHAR2(50)    UNIQUE,
    ers_password        VARCHAR2(50),
    user_first_name     VARCHAR2(100),
    user_last_name      VARCHAR2(100),
    user_email          VARCHAR2(100)   UNIQUE,
    user_role_id        NUMBER,
    
    CONSTRAINT pk_ers_users 
    PRIMARY KEY(ers_user_id),
    
    CONSTRAINT fk_ers_ers_user_roles 
    FOREIGN KEY (user_role_id)
    REFERENCES ers_user_roles (ers_user_role_id)
);

CREATE TABLE ers_reimburstment(
    reimb_id            NUMBER,
    reimb_amount        NUMBER,
    reimb_submitted     TIMESTAMP,
    reimb_resolved      TIMESTAMP,
    reimb_description   VARCHAR2(250),
    reimb_receipt       BLOB,
    reimb_author        NUMBER,
    reimb_resolver      NUMBER,
    reimb_status_id     NUMBER,
    reimb_type_id       NUMBER,
    
    CONSTRAINT pk_ers_reimburstment 
    PRIMARY KEY(reimb_id),
    
    CONSTRAINT fk_ers_ers_users 
    FOREIGN KEY (reim_author)
    REFERENCES ers_users (user_role_id),
    
    CONSTRAINT fk_ers_ers_users 
    FOREIGN KEY (reimb_resolver)
    REFERENCES ers_users (user_role_id),
    
    CONSTRAINT fk_ers_ers_reimburstment_status 
    FOREIGN KEY (reimb_status_id)
    REFERENCES ers_reimburstment_status (reimb_status_id),
    
    CONSTRAINT fk_ers_ers_reimburstment_type 
    FOREIGN KEY (reimb_type_id)
    REFERENCES ers_reimburstment_type (reimb_type_id)
);