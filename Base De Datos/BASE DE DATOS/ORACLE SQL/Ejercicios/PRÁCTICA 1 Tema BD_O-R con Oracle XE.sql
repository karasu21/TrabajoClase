---1---

CREATE OR REPLACE TYPE person AS OBJECT
(name VARCHAR2(30),
phone VARCHAR2(20))

CREATE TABLE people (
name VARCHAR2(30),
phone VARCHAR2(20) );

CREATE TABLE Persons_table OF person

---2---

INSERT INTO people VALUES ('Juan', '918273647')
INSERT INTO people VALUES ('Pepe', '917564758')
INSERT INTO people VALUES ('Jaime', '918574650')
INSERT INTO people VALUES ('Maria', '915748374')
INSERT INTO people VALUES ('Ana', '910697856')

INSERT INTO Persons_table VALUES (person('Juan', '918273647'))
INSERT INTO Persons_table VALUES('Pepe', '917564758')
INSERT INTO Persons_table VALUES (person('Jaime', '918574650'))
INSERT INTO Persons_table VALUES('Maria', '915748374')
INSERT INTO Persons_table VALUES('Ana', '910697856')

CREATE TYPE job AS OBJECT
(jobtitle VARCHAR(20),
job_ID INT,
salary_amount INT,
years_of_experience INT)

CREATE TABLE job_table OF job

---3---

SELECT name FROM Persons_table WHERE name='Juan';

SELECT VALUE(P) FROM Persons_table P WHERE P.name='Juan';

select p.name from Persons_table p WHERE p.name='Juan';

---4---

CREATE TYPE Street AS OBJECT
(sname VARCHAR2(30),
snumber INT,
flatnumber VARCHAR(20)
)

CREATE TYPE Adrress AS OBJECT
(calle Street,
city VARCHAR2(30),
postal_code VARCHAR(20)
)

CREATE TYPE Int_adrress AS OBJECT
(direccion Adrress,
country VARCHAR2(30)
)


---5---
DROP TABLE Persons_table
DROP TYPE person

CREATE TYPE name AS OBJECT
(first  VARCHAR2(30),
middle VARCHAR2(30),
last VARCHAR2(30)
)

CREATE TYPE phone AS OBJECT
(homeph  VARCHAR2(30),
businessph VARCHAR2(30),
mobileph VARCHAR2(30)
)

CREATE TYPE person AS OBJECT
(pname name,
pphone phone,
ppaddres Int_adrress
)

CREATE TABLE Persons_table OF person

INSERT INTO Persons_table VALUES (name('Juan', 'Garcia', 'Mateo'), 
phone('915478554','874587554','698547854'),Int_adrress(Adrress(Street('calle falsa','1','23'),'Madrid','28280'),'España'));

INSERT INTO Persons_table VALUES (name('Adrian', 'Martinez', 'Perez'), 
phone('916588474','874854554','696547741'),Int_adrress(Adrress(Street('calle principal','3','13'),'Madrid','28280'),'España'));

INSERT INTO Persons_table VALUES (name('Maria', 'Salazar', 'Perez'), 
phone('916588474','874854554','696547741'),Int_adrress(Adrress(Street('calle Cinco','4','10'),'Madrid','28280'),'España'));

INSERT INTO Persons_table VALUES (name('Ana', 'Rodriguez', 'Jurado'), 
phone('9166594487','876454852','695287754'),Int_adrress(Adrress(Street('calle Seis','3','11'),'Madrid','28280'),'España'));

INSERT INTO Persons_table VALUES (name('Martin', 'Arcos', 'Lopez'), 
phone('9165494745','856254471','695474153'),Int_adrress(Adrress(Street('calle Siete','7','9'),'Madrid','28280'),'España'));


