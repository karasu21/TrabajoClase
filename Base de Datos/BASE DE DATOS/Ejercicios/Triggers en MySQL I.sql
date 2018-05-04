---1---

CREATE DEFINER=`root`@`localhost` TRIGGER `reservas`.`reservas_BEFORE_INSERT` 
AFTER INSERT ON `reservas` FOR EACH ROW
BEGIN
DECLARE v_importe INT;
DECLARE v_precio INT;
DECLARE v_dias INT;
DECLARE v_total_dias INT;
SELECT (DATEDIFF(NEW.SALIDA, NEW.ENTRADA)) INTO v_dias FROM reservas WHERE RESERVA = NEW.RESERVA;
	SELECT P.PRECIO_DIA
	FROM reservas R JOIN apartamentos A
	ON R.APARTAMENTO=A.APARTAMENTO
	JOIN precios P ON P.GRUPO=A.GRUPO_PRECIO  
	WHERE RESERVA = NEW.RESERVA INTO v_precio;
SET v_total_dias=v_dias+1;
SET v_importe=v_total_dias*v_precio;
INSERT INTO facturacion VALUES(NEW.RESERVA, v_importe, NULL, "Pendiente
de pago");
END

---2---

---INSERT---
CREATE DEFINER = CURRENT_USER TRIGGER `practica1`.`Rev_salario_insert` 
BEFORE INSERT ON `empleados` FOR EACH ROW
BEGIN
DECLARE v_valido INT DEFAULT 0;
DECLARE v_dep INT;
DECLARE v_maxsal INT;
DECLARE v_minsal INT;
DECLARE v_mensaje VARCHAR(500);
DECLARE ERR_IDENTIFICADOR_NO_VALIDO CONDITION FOR SQLSTATE '45000';
DECLARE  v_ultima_fila INT DEFAULT 0;
DECLARE c_guia CURSOR FOR
	SELECT DEPARTAMENTO, MINSAL, MAXSAL  FROM guia_sal;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
OPEN c_guia;
bucle_guia:LOOP
FETCH c_guia INTO v_dep,v_minsal,v_maxsal;
IF v_ultima_fila=1 THEN
			LEAVE bucle_guia;
END IF;
IF NEW.numde=v_dep && NEW.salario>=v_minsal && NEW.salario<=v_maxsal THEN
SET v_valido=1;
END IF;
END LOOP bucle_guia;
CLOSE c_guia;
IF v_valido!=1 THEN
SET v_mensaje = CONCAT('¡Salario ', NEW.salario, ' esta fuera de rango de DEPARTAMENTO ', NEW.numde, ' para el empleado ', NEW.nomem, '!');
SIGNAL ERR_IDENTIFICADOR_NO_VALIDO 
SET MESSAGE_TEXT = v_mensaje;
END IF;
END

---UPDATE---
CREATE DEFINER=`root`@`localhost` TRIGGER `practica1`.`Rev_salario_update` 
BEFORE UPDATE ON `empleados` FOR EACH ROW
BEGIN
DECLARE v_valido INT DEFAULT 0;
DECLARE v_dep INT;
DECLARE v_maxsal INT;
DECLARE v_minsal INT;
DECLARE v_mensaje VARCHAR(500);
DECLARE ERR_IDENTIFICADOR_NO_VALIDO CONDITION FOR SQLSTATE '45000';
DECLARE  v_ultima_fila INT DEFAULT 0;
DECLARE c_guia CURSOR FOR
	SELECT DEPARTAMENTO, MINSAL, MAXSAL  FROM guia_sal;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
OPEN c_guia;

bucle_guia:LOOP
FETCH c_guia INTO v_dep,v_minsal,v_maxsal;
IF v_ultima_fila=1 THEN
			LEAVE bucle_guia;
END IF;
IF OLD.numde=v_dep && NEW.salario>=v_minsal && NEW.salario<=v_maxsal THEN
SET v_valido=1;
END IF;
END LOOP bucle_guia;
CLOSE c_guia;
IF v_valido!=1 THEN
SET v_mensaje = CONCAT('¡Salario ', NEW.salario, ' esta fuera de rango de DEPARTAMENTO ', NEW.numde, ' para el empleado ', NEW.nomem, '!');
SIGNAL ERR_IDENTIFICADOR_NO_VALIDO 
SET MESSAGE_TEXT = v_mensaje;
END IF;
END





