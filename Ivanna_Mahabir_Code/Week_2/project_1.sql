CREATE TABLE ers_user_roles(
    ers_user_role_id       NUMBER   CONSTRAINT   pk_ers_user_roles  PRIMARY KEY,
    user_role              VARCHAR2(10)    
);

CREATE TABLE ers_reimburstment_type(
    reimb_type_id       NUMBER   CONSTRAINT   pk_reimburstment_type  PRIMARY KEY,
    reimb_type          VARCHAR2(10)    
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
    reimb_id          NUMBER(5),
    reimb_amount      NUMBER(7, 2),
    reimb_submitted   TIMESTAMP,
    reimb_resolved    TIMESTAMP,
    reimb_description   VARCHAR(250),
    reimb_author        NUMBER,
    reimb_resolver      NUMBER,
    reimb_status_id      NUMBER,
    reimb_type_id       NUMBER,
        
    CONSTRAINT  pk_ers_reimburstment
    PRIMARY KEY (reimb_id),
    
    CONSTRAINT  ers_users_fk_auth
    FOREIGN KEY (reimb_author)
    REFERENCES ers.ers_users (ers_user_id),
    
    CONSTRAINT  ers_users_fk_resolver
    FOREIGN KEY (reimb_resolver)
    REFERENCES ers.ers_users (ers_user_id),
    
    CONSTRAINT  fk_ers_reimburstment_status
    FOREIGN KEY (reimb_status_id)
    REFERENCES ers.ers_reimburstment_status (reimb_status_id),
    
    CONSTRAINT  fk_ers_reimburstment_type
    FOREIGN KEY (reimb_type_id)
    REFERENCES ers.ers_reimburstment_type (reimb_type_id)
    
);


INSERT INTO ers_user_roles VALUES (1, 'Manager');
INSERT INTO ers_user_roles VALUES (2, 'Employee');

INSERT INTO ers_reimburstment_status VALUES (1, 'Approved');
INSERT INTO ers_reimburstment_status VALUES (2, 'Denied');
INSERT INTO ers_reimburstment_status VALUES (3, 'Submitted');

INSERT INTO ers_reimburstment_type VALUES (1, 'Lodging');
INSERT INTO ers_reimburstment_type VALUES (2, 'Travel');
INSERT INTO ers_reimburstment_type VALUES (3, 'Food');
INSERT INTO ers_reimburstment_type VALUES (4, 'Other');

INSERT INTO ers_users VALUES (1, 'cPhantom12', 'Funtom13', 'Ciel', 'Phantomhive', 'cphantom@lol.com', 1);
INSERT INTO ers_users VALUES (2, 'sMichealis9', 'kuroshitsuji31','Sebastian', 'Michaelis','smichealis@lol.com',2);
INSERT INTO ers_users VALUES (3, 'SkipBeat1', 'wildChild5','Kyoko', 'Mogami','kmogami@lol.com', 2);
INSERT INTO ers_users VALUES (4, 'aWalker15', 'BlackOrder7','Allen', 'Walker', 'awalker@lol.com', 1);

COMMIT;