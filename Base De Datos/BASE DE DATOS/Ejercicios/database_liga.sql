CREATE PROCEDURE procalm_liga()
BEGIN 
	DECLARE v_local VARCHAR(5);
	DECLARE v_visitante VARCHAR(5);	
	DECLARE v_reslocal INT;
	DECLARE v_resvisit INT;
	DECLARE v_pg INT DEFAULT 0;
	DECLARE v_pp INT DEFAULT 0;
	DECLARE v_pf INT DEFAULT 0;
	DECLARE v_pc INT DEFAULT 0;
	DECLARE v_dif INT DEFAULT 0;
	DECLARE  v_ultima_fila INT DEFAULT 0;
	DECLARE c_liga CURSOR FOR
	SELECT local, visitante, reslocal,resvisit
		FROM partido;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
	OPEN c_liga;
	bucle_aumento:LOOP
		FETCH c_liga INTO v_local, v_visitante, v_reslocal, v_resvisit;
		IF v_ultima_fila=1 THEN
			LEAVE bucle_aumento;
		END IF;
		IF v_reslocal - v_resvisit > 0 then
			UPDATE equipo SET pg = pg+1 WHERE nombre = v_local;
			UPDATE equipo SET PP = PP+1 WHERE nombre = v_visitante;
			UPDATE equipo SET pf = v_reslocal + pf WHERE nombre=v_local;
			UPDATE equipo SET pc = v_resvisit + pc WHERE nombre=v_local;
			UPDATE equipo SET pf = v_resvisit + pf WHERE nombre=v_visitante;
			UPDATE equipo SET pc = v_reslocal + pc WHERE nombre=v_visitante;
		ELSE
			UPDATE equipo SET pp = pp+1 WHERE nombre = v_local;
			UPDATE equipo SET pg = pg+1 WHERE nombre = v_visitante;
			UPDATE equipo SET pf = v_reslocal + pf WHERE nombre=v_local;
			UPDATE equipo SET pc = v_resvisit + pc WHERE nombre=v_local;
			UPDATE equipo SET pf = v_resvisit + pf WHERE nombre=v_visitante;
			UPDATE equipo SET pc = v_reslocal + pc WHERE nombre=v_visitante;
		END IF;
	END LOOP bucle_aumento;
	CLOSE c_liga;
	UPDATE equipo SET dif = pf - pc;
	
	
	
	
CREATE PROCEDURE procalm_puesto()
	BEGIN
    DECLARE v_ultima_fila INT;
	DECLARE v_nombre VARCHAR(5);
	DECLARE v_puesto INT DEFAULT 0;
	DECLARE c_equipo CURSOR FOR
	SELECT nombre 
		FROM equipo ORDER BY pg DESC, dif DESC;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
	OPEN c_equipo;
	bucle_puesto:LOOP
	FETCH c_equipo INTO v_nombre;
	IF v_ultima_fila=1 THEN
		LEAVE bucle_puesto;
	END IF;
	SET v_puesto=v_puesto+1;
	UPDATE equipo SET puesto = v_puesto WHERE nombre=v_nombre;
	END LOOP bucle_puesto;
	CLOSE c_equipo;
END
