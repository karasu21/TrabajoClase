---1---
CREATE OR REPLACE TYPE phone_code AS OBJECT (
area_code VARCHAR2(20),
local_number VARCHAR2(20)
);

CREATE TYPE phone_numbers AS VARRAY(10) OF phone_code;

CREATE TYPE company AS OBJECT(
name VARCHAR2(30),
PHONE phone_numbers
);

CREATE TABLE company3 OF company;

INSERT INTO company3 VALUES ('IBM', phone_numbers(phone_code('+51', '555 754 999')));
INSERT INTO company3 VALUES ('DELL', phone_numbers(phone_code('+51', '555 589 654')));
INSERT INTO company3 VALUES ('CISCO', phone_numbers(phone_code('+34', '91 629 587')));

SELECT * FROM company3;
SELECT c.name, t.* from company3 c, TABLE(c.phone) t;

DECLARE
phone_origen  phone_numbers;
phone_destino phone_numbers;
i NUMBER := 0;
j NUMBER;
BEGIN
INSERT INTO company3 VALUES ('XEROX', phone_numbers(phone_code('+51', '895 784 958'), phone_code('+51', '245 657 452')));
SELECT c.phone INTO phone_origen FROM company3 c WHERE c.name='IBM';
SELECT c.phone INTO phone_destino FROM company3 c WHERE c.name='XEROX';
FOR i IN phone_origen.FIRST .. phone_origen.LAST
  LOOP
      phone_destino.EXTEND();
	  j:=i+2;
	  phone_destino(j):=phone_origen(i);
 END LOOP;
UPDATE company3 set phone=phone_destino where name='XEROX';
END;

---2---

CREATE TYPE phone_numbers_nested AS TABLE OF phone_code;


CREATE TABLE company3_nested(
name VARCHAR2(30),
phone phone_numbers_nested)
NESTED TABLE phone STORE AS phone_nr_table;

INSERT INTO company3_nested VALUES ('IBM', phone_numbers_nested(phone_code('+51', '555 754 999')));
INSERT INTO company3_nested VALUES ('DELL', phone_numbers_nested(phone_code('+51', '555 589 654')));
INSERT INTO company3_nested VALUES ('CISCO', phone_numbers_nested(phone_code('+34', '91 629 587')));

SELECT * FROM company3_nested;
SELECT c.name, t.* from company3_nested c, TABLE(c.phone) t;

DECLARE
phone_origen  phone_numbers;
phone_destino phone_numbers;
i NUMBER := 0;
j NUMBER;
BEGIN
INSERT INTO company3 VALUES ('XEROX', phone_numbers(phone_code('+51', '895 784 958'), phone_code('+51', '245 657 452')));
SELECT c.phone INTO phone_origen FROM company3 c WHERE c.name='IBM';
SELECT c.phone INTO phone_destino FROM company3 c WHERE c.name='XEROX';
FOR i IN phone_origen.FIRST .. phone_origen.LAST
  LOOP
      phone_destino.EXTEND();
	  j:=i+2;
	  phone_destino(j):=phone_origen(i);
 END LOOP;
UPDATE company3 set phone=phone_destino where name='XEROX';
END;

---3---
DECLARE
n_phone  phone_numbers;
v_name VARCHAR2(20);
Cursor c_name is SELECT name FROM company3;
BEGIN
DBMS_OUTPUT.PUT_LINE(RPAD('Name', 10, ' ') || 'number of phones');
OPEN c_name;
LOOP
FETCH c_name INTO v_name;
EXIT WHEN c_name%NOTFOUND;
SELECT c.phone INTO n_phone FROM company3 c WHERE c.name=v_name;
DBMS_OUTPUT.PUT_LINE(RPAD(v_name, 10, ' ') || n_phone.count);
END LOOP;
CLOSE c_name;
END;
