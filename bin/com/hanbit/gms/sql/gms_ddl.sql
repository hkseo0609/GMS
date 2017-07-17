CREATE SEQUENCE article_seq
	START WITH 1000
	INCREMENT BY 1
	NOCACHE
	NOCYCLE;
-- id, pwd, name, ssn, regdate
CREATE table Member(
	id VARCHAR2(10), 
	pwd VARCHAR2(10), 
	name VARCHAR2(20), 
	ssn VARCHAR2(15),
	regdate DATE,
	primary key(id)
);

CREATE TABLE Board(
	article_seq NUMBER,
	hitcount NUMBER,
	id VARCHAR2(10),
	title VARCHAR2(20),
	content VARCHAR2(100),
	regdate DATE,
	primary key(article_seq),
	FOREIGN KEY(id) REFERENCES MEMBER(id) ON DELETE CASCADE
);

SELECT * FROM BOARD;



