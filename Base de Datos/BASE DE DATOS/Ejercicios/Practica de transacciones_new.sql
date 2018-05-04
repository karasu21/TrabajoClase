CREATE DEFINER=`root`@`localhost` PROCEDURE `ejercicio3_2`()
BEGIN
DECLARE  v_ultima_fila INT DEFAULT 0;
DECLARE  v_numem INT;
DECLARE  v_salario INT;
DECLARE  v_salario_c INT;
DECLARE  v_estrellas VARCHAR(10);
DECLARE  v_cnt INT DEFAULT 0;
DECLARE c_empleados CURSOR FOR 
	SELECT numem, salario FROM empleados;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;	
OPEN c_empleados;
	bucle_empleados:LOOP
		FETCH c_empleados INTO v_numem, v_salario;
		IF v_ultima_fila=1 THEN
			LEAVE bucle_empleados;
		END IF;
	SET v_salario_c= TRUNCATE((v_salario/100),0);
	SET v_estrellas= RPAD("",v_salario_c,"*");
	UPDATE empleados SET estrellas=v_estrellas WHERE numem=v_numem;
	END LOOP bucle_empleados;
	CLOSE c_empleados;
END


CREATE DEFINER=`root`@`localhost` PROCEDURE `ejercicio3_2`()
BEGIN
DECLARE  v_ultima_fila INT DEFAULT 0;
DECLARE  v_numem INT;
DECLARE  v_salario INT;
DECLARE  v_salario_c INT;
DECLARE  v_estrellas VARCHAR(10);
DECLARE  v_cnt INT DEFAULT 0;
DECLARE c_empleados CURSOR FOR 
	SELECT numem, salario FROM empleados;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;	
DECLARE EXIT HANDLER FOR SQLEXCEPTION
SELECT 'Ocurrió un error. Procedimiento terminado'
ROLLBACK;
SET AUTOCOMMIT="OFF";
OPEN c_empleados;
	bucle_empleados:LOOP
		FETCH c_empleados INTO v_numem, v_salario;
		IF v_ultima_fila=1 THEN
			LEAVE bucle_empleados;
		END IF;
	SET v_salario_c= TRUNCATE((v_salario/100),0);
	SET v_estrellas= RPAD("",v_salario_c,"*");
	UPDATE empleados SET estrellaS=v_estrellas WHERE numem=v_numem;
	END LOOP bucle_empleados;
	CLOSE c_empleados;
	COMMIT;
END