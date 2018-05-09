CREATE PROCEDURE procalm_saldo()
BEGIN
	DECLARE v_nuevo_saldo INT;
	DECLARE v_id_a INT;
	DECLARE v_tipo CHAR(1);
	DECLARE  v_ultima_fila INT DEFAULT 0;
	DECLARE v_clave_repetida INT;
	DECLARE v_clave_nula INT;
	DECLARE c_acciones CURSOR FOR
	SELECT id_cuenta, tipo_op, nuevo_saldo
		FROM acciones;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
	DECLARE CONTINUE HANDLER FOR 1062 SET v_clave_repetida=1;
	DECLARE CONTINUE HANDLER FOR 1175 SET v_clave_nula=1;
	OPEN c_acciones;
	bucle_acciones:LOOP
		FETCH c_acciones INTO v_id_a, v_tipo, v_nuevo_saldo;
		IF v_ultima_fila=1 THEN
			LEAVE bucle_acciones;
		END IF;
		IF v_tipo="I" THEN
			INSERT saldos(id_cuenta, saldo_cuenta) VALUES (v_id_a, v_nuevo_saldo);
		END IF;
		IF v_clave_repetida=1 THEN
			UPDATE saldos 
			SET saldo_cuenta = v_nuevo_saldo
			WHERE id_cuenta = v_id_a;
			UPDATE acciones 
			SET incidentes = "UPDATE en lugar de INSERT" WHERE id_cuenta = v_id_a;
		END IF;
		IF v_tipo="U" THEN
			UPDATE saldos 
			SET saldo_cuenta = v_nuevo_saldo
			WHERE id_cuenta = v_id_a;
		END IF;
		IF v_clave_nula=1 THEN
			INSERT saldos(id_cuenta, saldo_cuenta) 
			VALUES (v_id_a, v_nuevo_saldo);
			UPDATE acciones 
			SET incidentes = "INSERT en lugar de UPDATE" WHERE id_cuenta = v_id_a;		
		END IF;
		IF v_tipo!="U" && v_tipo!="I" THEN
			UPDATE acciones 
			SET incidentes = "Operacion invalida" WHERE id_cuenta = v_id_a;
		END IF;
	END LOOP bucle_acciones;
	CLOSE c_acciones;
	END
	
	
	call procalm_saldo();