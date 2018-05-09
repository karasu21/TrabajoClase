---1---

CREATE OR REPLACE TYPE job2 AS OBJECT (
jobtitle varchar(20),
job_id int,
salary_amount int,
years_of_experience int,
MEMBER FUNCTION evaluate_qualification RETURN STRING,
MEMBER FUNCTION salary_fraction (N INT) RETURN NUMBER);

CREATE TABLE job2_table OF job2;

INSERT INTO job2_table VALUES ('data analyst',2,36000,6)
INSERT INTO job2_table VALUES ('designer',1,25000,4)
INSERT INTO job2_table VALUES ('programmer',0,35000,5)

CREATE OR REPLACE TYPE BODY job2 AS
MEMBER FUNCTION evaluate_qualification RETURN STRING IS
BEGIN
IF self.years_of_experience < 2 THEN
RETURN 'too bad';
ELSIF self.years_of_experience = 2 THEN
RETURN 'OK';
ELSE
RETURN 'great!';
END IF;
END evaluate_qualification;
MEMBER FUNCTION salary_fraction (n INT) RETURN NUMBER IS
BEGIN
RETURN self.salary_amount/n;
END salary_fraction; 
END;

SELECT s.salary_fraction(2) FROM job2_table s where s.job_id='0';
SELECT s.evaluate_qualification() FROM job2_table s where s.job_id='0';

---2---

ALTER TYPE employee
ADD MEMBER FUNCTION print_name RETURN STRING
CASCADE;

CREATE OR REPLACE TYPE BODY employee AS
MEMBER FUNCTION print_name RETURN STRING IS
BEGIN
RETURN CONCAT (CONCAT(self.pname.first,CONCAT(' ',self.pname.middle)),CONCAT(' ',self.pname.last));
END print_name; 
END;

SELECT p.print_name() "Nombre Completo" FROM employee_table p;

ALTER TYPE employee
ADD MEMBER FUNCTION count_phone RETURN NUMBER
CASCADE;





CREATE OR REPLACE TYPE BODY employee AS
MEMBER FUNCTION print_name RETURN STRING IS
BEGIN
RETURN CONCAT (CONCAT(self.pname.first,CONCAT(' ',self.pname.middle)),CONCAT(' ',self.pname.last));
END print_name; 
MEMBER FUNCTION count_phone RETURN INTEGER IS
  v_ultima_fila INTEGER DEFAULT 0;
  v_homeph VARCHAR2(30);
  v_businessph VARCHAR2(30);
  v_mobileph VARCHAR2(30);
  v_total INTEGER DEFAULT 0;
BEGIN
		IF self.pphone.homeph is not null THEN
			v_total:=v_total+1;
		END IF;
		IF self.pphone.businessph is not null THEN
			v_total:=v_total+1;
		END IF;
		IF self.pphone.mobileph is not null THEN
			v_total:=v_total+1;
		END IF;
RETURN v_total;
END count_phone; 
END;
  
 SELECT p.count_phone() FROM employee_table p;
 