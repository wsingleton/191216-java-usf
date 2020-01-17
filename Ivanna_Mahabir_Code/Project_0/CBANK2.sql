-- Create the account and user tables
CREATE TABLE accts(
    acctid            NUMBER(5)   CONSTRAINT   pk_accts   PRIMARY KEY,
    acctusr           VARCHAR2(25),  
    balance           NUMBER(12, 2)   
);

CREATE TABLE busers(
    user_id          NUMBER(5)	CONSTRAINT  pk_busers    PRIMARY KEY,
    user_fn          VARCHAR2(25),
    user_ln          VARCHAR2(25),
    user_name        VARCHAR2(25),
    user_pass        VARCHAR2(25),

);

INSERT INTO accts VALUES (1,'aWalker15', 500);
INSERT INTO accts VALUES (2,'Fullmetal4', 650);
INSERT INTO accts VALUES (3,'sMichealis9', 2358);
INSERT INTO accts VALUES (4,'wRockbell3', 986);
INSERT INTO accts VALUES (5,'cPhantom12',54300);
INSERT INTO accts VALUES (6,'wallFlower16', 69843);
INSERT INTO accts VALUES (7,'SkipBeat1', 325);
INSERT INTO accts VALUES (8,'Fvalentin3', 1584);
INSERT INTO accts VALUES (9,'blacKnight17', 4850);
INSERT INTO accts VALUES (10,'DarkBoots2', 25908);

INSERT INTO busers VALUES (1, 'Ciel', 'Phantomhive', 'cPhantom12', 'Funtom13');
INSERT INTO busers VALUES (2, 'Sebastian', 'Michaelis', 'sMichealis9', 'kuroshitsuji31');
INSERT INTO busers VALUES (3, 'Lelouch', 'Lamperouge', 'blacKnight17', 'Nanali12345');
INSERT INTO busers VALUES (4, 'Edward', 'Elric', 'Fullmetal4', 'alchemist12');
INSERT INTO busers VALUES (5, 'Allen', 'Walker', 'aWalker15', 'BlackOrder7');
INSERT INTO busers VALUES (6, 'Faye', 'Valentine', 'Fvalentin3', 'bHunter1');
INSERT INTO busers VALUES (7, 'Lenalee', 'Lee', 'DarkBoots2', 'Brother17');
INSERT INTO busers VALUES (8, 'Winry', 'Rockbell', 'wRockbell3', 'Mech4nic');
INSERT INTO busers VALUES (9, 'Sunako', 'Nakahara', 'wallFlower16', 'horrorGirl1331');
INSERT INTO busers VALUES (10, 'Kyoko', 'Mogami', 'SkipBeat1', 'wildChild5');

COMMIT;