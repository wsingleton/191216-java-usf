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
    REFERENCES ers.ers_reimburstment_type (reim_typr_id)
    
    );