-- Create the account and user tables
CREATE TABLE accts(
    acctid            NUMBER(5)   CONSTRAINT   pk_accts   PRIMARY KEY,
    balance           NUMBER   
);

CREATE TABLE busers(
    user_id          NUMBER(5),
    user_fn          VARCHAR2(25),
    user_ln          VARCHAR2(25),
    user_name        VARCHAR2(25),
    user_pass        VARCHAR2(25),
    acct_id          NUMBER(5),

    CONSTRAINT  pk_busers
    PRIMARY KEY (user_id),
    
    CONSTRAINT  fk_user_acct
    FOREIGN KEY (acct_id)
    REFERENCES accts (acctid)
);

INSERT INTO accts VALUES (1, 500);
INSERT INTO accts VALUES (2, 650);
INSERT INTO accts VALUES (3, 2358);
INSERT INTO accts VALUES (4, 986);
INSERT INTO accts VALUES (5, 54300);
INSERT INTO accts VALUES (6, 69843);
INSERT INTO accts VALUES (7, 325);
INSERT INTO accts VALUES (8, 1584);
INSERT INTO accts VALUES (9, 4850);
INSERT INTO accts VALUES (10, 25908);

INSERT INTO busers VALUES (1, 'Ciel', 'Phantomhive', 'cPhantom12', 'Funtom13', 5);
INSERT INTO busers VALUES (2, 'Sebastian', 'Michaelis', 'sMichealis9', 'kuroshitsuji31', 3);
INSERT INTO busers VALUES (3, 'Lelouch', 'Lamperouge', 'blacKnight17', 'Nanali12345', 9);
INSERT INTO busers VALUES (4, 'Edward', 'Elric', 'Fullmetal4', 'alchemist12', 2);
INSERT INTO busers VALUES (5, 'Allen', 'Walker', 'aWalker15', 'BlackOrder7', 1);
INSERT INTO busers VALUES (6, 'Faye', 'Valentine', 'Fvalentin3', 'bHunter1', 8);
INSERT INTO busers VALUES (7, 'Lenalee', 'Lee', 'DarkBoots2', 'Brother17', 10);
INSERT INTO busers VALUES (8, 'Winry', 'Rockbell', 'wRockbell3', 'Mech4nic', 4);
INSERT INTO busers VALUES (9, 'Sunako', 'Nakahara', 'wallFlower16', 'horrorGirl1331', 6);
INSERT INTO busers VALUES (10, 'Kyoko', 'Mogami', 'SkipBeat1', 'wildChild5', 7);

COMMIT;