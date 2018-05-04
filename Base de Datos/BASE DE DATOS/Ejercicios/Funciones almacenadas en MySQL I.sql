---1---

CREATE DEFINER=`root`@`localhost` FUNCTION `funciones_1`(dep INT) RETURNS int(1)
BEGIN
DECLARE v_dep INT;
DECLARE v_si INT;
DECLARE  v_ultima_fila INT DEFAULT 0;
DECLARE c_dep CURSOR FOR
	SELECT DEP_NO FROM departamentos;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
OPEN c_dep;
bucle_dep:LOOP
FETCH c_dep INTO v_dep;
IF v_ultima_fila=1 THEN
			LEAVE bucle_dep;
END IF;
IF v_dep = dep THEN
SET v_si=1;
END IF;
END LOOP bucle_dep;
CLOSE c_dep;
IF v_si=1 THEN
RETURN 1;
ELSE
RETURN 0;
END IF;
END
---2---
CREATE DEFINER=`root`@`localhost` FUNCTION `funciones_2`(dep INT) RETURNS int(11)
BEGIN
	DECLARE v_existe INT;
	SET v_existe =  funciones_1(dep);
	IF v_existe=0 THEN
		RETURN -1;
	ELSE
	SELECT SUM(SALARIO) FROM empleados WHERE dep_no = dep;
		
	END IF;
END

---3---
CREATE DEFINER=`root`@`localhost` FUNCTION `funciones_3`(n_reserva INT) RETURNS int(11)
BEGIN
DECLARE v_reserva INT;
DECLARE v_apart DATE;
DECLARE v_dias INT;
DECLARE v_total_dias INT;
DECLARE v_grupo INT;
DECLARE v_precio_dia INT;
DECLARE v_precio INT;
DECLARE v_si INT DEFAULT 0;
DECLARE  v_ultima_fila INT DEFAULT 0;
DECLARE c_reserva CURSOR FOR
	SELECT RESERVA FROM reservas;
DECLARE c_precio CURSOR FOR
	SELECT R.RESERVA, R.APARTAMENTO,  DATEDIFF(R.SALIDA, R.ENTRADA) AS days , A.GRUPO_PRECIO, P.PRECIO_DIA
	FROM reservas R JOIN apartamentos A
	ON R.APARTAMENTO=A.APARTAMENTO
	JOIN precios P ON P.GRUPO=A.GRUPO_PRECIO WHERE RESERVA = n_reserva;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
OPEN c_reserva;
bucle_reserva:LOOP
FETCH c_reserva INTO v_reserva;
IF v_ultima_fila=1 THEN
			LEAVE bucle_reserva;
END IF;
IF v_reserva = n_reserva THEN
SET v_si=1;
END IF;
END LOOP bucle_reserva;
CLOSE c_reserva;
IF v_si=0 THEN
RETURN -1;
ELSE
OPEN c_precio;
bucle_precio:LOOP
FETCH c_precio INTO v_reserva, v_apart,v_dias,v_grupo,v_precio_dia;
SET v_total_dias=v_dias+1;
SET v_precio=v_precio_dia*v_total_dias;
RETURN v_precio;
END LOOP bucle_precio;
CLOSE c_precio;
END IF;
END



