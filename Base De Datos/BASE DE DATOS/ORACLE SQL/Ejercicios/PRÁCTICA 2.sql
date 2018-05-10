---1---

CREATE OR REPLACE TYPE employee UNDER person
(emp_ID INT)

CREATE TABLE employee_table OF employee

INSERT INTO employee_table VALUES (name('Paul', 'Miller', 'Lopez'), 
phone('9165494745','856254471','695474153'),Int_adrress(Adrress(Street('calle Siete','7','9'),'Madrid','28280'),'España'),0);

INSERT INTO employee_table VALUES (name('Sally', 'Jones', 'Jurado'), 
phone('9166594487','876454852','695287754'),Int_adrress(Adrress(Street('calle Seis','3','11'),'Madrid','28280'),'España'),1);

INSERT INTO employee_table VALUES (name('Mary', 'Edwards', 'Perez'), 
phone('916588474','874854554','696547741'),Int_adrress(Adrress(Street('calle Cinco','4','10'),'Madrid','28280'),'España'),2);
INSERT INTO employee_table VALUES (name('Mike', 'Miller', 'Lopez'), 
phone('9165494745','856254471',NULL),Int_adrress(Adrress(Street('calle Siete','7','9'),'Madrid','28280'),'España'),3);

ALTER TABLE employee_table ADD CONSTRAINT PK_EMP_ID PRIMARY KEY(emp_ID);

ALTER TABLE JOB_TABLE ADD CONSTRAINT PK_JOP_ID PRIMARY KEY(job_ID);

---2---

CREATE TYPE emp_person_typ AS OBJECT (
employees REF employee,
position REF job);

INSERT INTO job_table VALUES ('data analyst',2,36000,6)
INSERT INTO job_table VALUES ('designer',1,25000,4)
INSERT INTO job_table VALUES ('programmer',0,35000,5)

CREATE TABLE employment OF emp_person_typ

INSERT INTO employment VALUES
((SELECT REF(e)
FROM employee_table e
WHERE e.emp_ID = 0),(SELECT REF(f)
FROM job_table f
WHERE f.job_ID = 2))

INSERT INTO employment VALUES
((SELECT REF(e)
FROM employee_table e
WHERE e.emp_ID = 1),(SELECT REF(f)
FROM job_table f
WHERE f.job_ID = 1))

INSERT INTO employment VALUES
((SELECT REF(e)
FROM employee_table e
WHERE e.emp_ID = 2),(SELECT REF(f)
FROM job_table f
WHERE f.job_ID = 0))

---3---

SELECT DEREF(employees,position) FROM employment e;

SELECT e.employees.pname.first NOMBRE, e.employees.pname.middle APELLIDO, e.position.jobtitle PUESTO FROM employment e;

SELECT e.employees.pname.first NOMBRE, e.employees.pname.middle APELLIDO, e.position.salary_amount PUESTO 
FROM employment e 
WHERE e.position.salary_amount>2000;

---4---

CREATE TYPE proyect AS OBJECT (
project_id INT,
project_name VARCHAR(30),
project_leader REF person);

CREATE TABLE project_table OF proyect;

ALTER TABLE project_table ADD CONSTRAINT PK_PRO_ID PRIMARY KEY(project_id);

INSERT INTO project_table VALUES
(0,'Redesign',(SELECT REF(e)
FROM Persons_table e
WHERE e.pname.first ='Juan'))

INSERT INTO project_table VALUES
(1,'Interface',(SELECT REF(e)
FROM Persons_table e
WHERE e.pname.first ='Adrian'))

INSERT INTO project_table VALUES
(2,'Redesign',(SELECT REF(e)
FROM Persons_table e
WHERE e.pname.first ='Maria'))

SELECT p.project_name PROYECTO, p.project_leader.pname.first "Jefe Proyecto" FROM project_table p;

CREATE TYPE member_project AS OBJECT (
project_id REF proyect,
mem REF person);

CREATE TABLE project_membership OF member_project;

INSERT INTO project_membership VALUES
((SELECT REF(e)
FROM project_table e
WHERE e.project_id = 0),(SELECT REF(f)
FROM employee_table f
WHERE f.emp_ID = 0))

INSERT INTO project_membership VALUES
((SELECT REF(e)
FROM project_table e
WHERE e.project_id = 1),(SELECT REF(f)
FROM employee_table f
WHERE f.emp_ID = 1))

INSERT INTO project_membership VALUES
((SELECT REF(e)
FROM project_table e
WHERE e.project_id = 2),(SELECT REF(f)
FROM employee_table f
WHERE f.emp_ID = 2))

SELECT DEREF(project_id),DEREF(mem) FROM project_membership e;


SELECT p.mem.pname.first NOMBRE, p.mem.pname.middle APELLIDO,  p.project_id.project_name PROYECTO FROM project_membership p;








