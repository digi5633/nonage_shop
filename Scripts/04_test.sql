SELECT PSEQ, NAME, KIND, PRICE1, PRICE2, PRICE3, CONTENT, IMAGE, USEYN, BESTYN, INDATE FROM PRODUCT WHERE USEYN = 'y' ORDER BY PSEQ DESC;

SELECT PSEQ, NAME, KIND, PRICE1, PRICE2, PRICE3, CONTENT, IMAGE, USEYN, BESTYN, INDATE FROM PRODUCT WHERE BESTYN = 'y' ORDER BY PSEQ DESC;

SELECT PSEQ, NAME, KIND, PRICE1, PRICE2, PRICE3, CONTENT, IMAGE, USEYN, BESTYN, INDATE FROM PRODUCT WHERE PSEQ = 1;

SELECT PSEQ, NAME, KIND, PRICE1, PRICE2, PRICE3, CONTENT, IMAGE, USEYN, BESTYN, INDATE FROM PRODUCT WHERE KIND = 3;

--------------------------

SELECT ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE, USEYN, INDATE FROM MEMBER ORDER BY NAME ASC;

SELECT ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE, USEYN, INDATE FROM MEMBER WHERE id = 'one';

INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE) VALUES ('three', '3333', '김자바', 'aaaa@bbbb.com', '333-333', '대구시', '019-999-9999');

DELETE FROM MEMBER WHERE ID = 'three';

UPDATE MEMBER SET PWD='4444', NAME='이자바', EMAIL='ccc@dddd.com', ZIP_NUM='555-555', ADDRESS='제주도', PHONE='010-7777-7777' WHERE ID = 'three';

--------------------------------------------

SELECT ZIP_NUM, SIDO, GUGUN, DONG, BUNJI, ZIP_CODE FROM ADDRESS;

SELECT * FROM ADDRESS WHERE DONG LIKE '%'||'아파트'||'%';
  
DELETE FROM address WHERE SIDO = '서울';

------------------------------------
SELECT *
  FROM CART;
