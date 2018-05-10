---Ejercicio 1---

CREATE PROCEDURE procalm_emp()
BEGIN
DECLARE v_apellido VARCHAR(8);
DECLARE v_oficio VARCHAR(10);	
DECLARE v_fecha_alta DATE;
DECLARE v_años INT;
DECLARE v_num_trienios INT;
DECLARE v_trienios FLOAT(6,2);
DECLARE v_salario FLOAT(6,2);
DECLARE v_comision FLOAT(6,2);
DECLARE v_total FLOAT(6,2);
DECLARE v_responsabilidad FLOAT(6,2);
DECLARE  v_emp_no INT(4);
DECLARE  v_a_cargo INT(4);
DECLARE  v_dep_no INT(2);
DECLARE  v_ultima_fila INT DEFAULT 0;
DECLARE c_empleados CURSOR FOR
	SELECT EMP_NO,APELLIDO,OFICIO,FECHA_ALTA,SALARIO,COMISION,DEP_NO
		FROM empleados;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;	
OPEN c_empleados;
	bucle_empleados:LOOP
		FETCH c_empleados INTO v_emp_no,v_apellido, v_oficio, v_fecha_alta,v_salario,v_comision,v_dep_no;
		IF v_ultima_fila=1 THEN
			LEAVE bucle_empleados;
		END IF;	
		SELECT TIMESTAMPDIFF(YEAR,  v_fecha_alta,CURRENT_DATE()) AS years INTO  v_años;
		SET v_num_trienios= TRUNCATE((v_años/3),0);
		SET v_trienios=50*v_num_trienios;
		SELECT COUNT(EMP_NO) FROM empleados WHERE DIRECTOR=v_emp_no INTO v_a_cargo;
		SET v_responsabilidad=v_a_cargo*100;
		IF v_comision IS NULL THEN
			SET v_comision=0;
		END IF;
		SET v_total= v_trienios + v_responsabilidad + v_comision + v_salario; 
		INSERT INTO t_liquidacion VALUES (v_apellido,v_dep_no,v_oficio,v_salario,v_trienios,v_responsabilidad,v_comision,v_total);
	END LOOP bucle_empleados;
CLOSE c_empleados;
END

---Ejercicio 2---

CREATE FUNCTION `comprobar_pg`(v_local CHAR(8)) RETURNS INT(1)
BEGIN
DECLARE v_visitante CHAR(8);
DECLARE v_res_local INT(9);
DECLARE v_res_visitante INT(9);
DECLARE v_ganado_v INT(2);
DECLARE v_ganado INT(2);
DECLARE v_si INT(1) DEFAULT 0;
DECLARE  v_ultima_fila INT DEFAULT 0;
DECLARE c_liga CURSOR FOR
	SELECT local,visitante,reslocal,resvisit FROM partido;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
OPEN c_liga;
	bucle_liga:LOOP
		FETCH c_liga INTO v_local,v_visitante,v_res_local,v_res_visitante;
		IF v_ultima_fila=1 THEN
			LEAVE bucle_liga;
		END IF;
		SELECT COUNT(local) FROM partido WHERE v_res_local>v_res_visitante && local=v_local INTO v_ganado_v;
		SELECT pg FROM equipo WHERE nombre = v_local INTO v_ganado;
		IF v_ganado_v=v_ganado THEN 
		RETURN 1;
		ELSE
		RETURN 0;
		END IF;
		END LOOP bucle_liga;
CLOSE c_liga;
END

