---Ejercicio 1---
CREATE DEFINER=`root`@`localhost` PROCEDURE `procalm_1`(IN p_ndep int)
BEGIN
SELECT * FROM empleados WHERE numde=p_ndep;
END

---Ejercicio 2---
CREATE PROCEDURE `procalm_2` ()
BEGIN
DECLARE v_col1 FLOAT(9,2) DEFAULT 1;
DECLARE v_col2 FLOAT(9,2) DEFAULT 100;
DECLARE MSG VARCHAR(40);
DECLARE FECHA DATE DEFAULT "21/1/09";
SET MSG= CONCAT(v_col1,' es impar');
mibucle :REPEAT
INSERT INTO temp(COL1, COL2, MSG, FECHA) VALUES (v_col1,v_col2,MSG,FECHA);
SET v_col1=v_col1+1;
SET v_col2=v_col1*100;
IF v_col1%2=0 THEN
SET MSG = CONCAT(v_col1,' es par');
ELSE
SET MSG =  CONCAT(v_col1,' es impar');
END IF;
UNTIL v_col1=11
END REPEAT mibucle;
END

---Ejercicio 3---
CREATE DEFINER=`root`@`localhost` PROCEDURE `procalm_3`(IN cod_emp INT)
BEGIN
DECLARE categoria CHAR(1);
DECLARE v_id_emp INT;
DECLARE v_empleado VARCHAR(10);
DECLARE v_salario INT;
SELECT numem, nomem,salario
	INTO v_id_emp, v_empleado, v_salario
	FROM empleados
WHERE numem=cod_emp;
IF v_salario > 400 THEN
SET categoria = 'A';
ELSEIF v_salario < 400 AND v_salario >=300 THEN
SET categoria = 'B';
ELSE
SET categoria = 'C';
END IF;
INSERT INTO cat_emp(ID_EMP, EMPLEADO, CATEG) VALUES (v_id_emp,v_empleado,categoria);
END



