CREATE PROCEDURE procalm_5()
BEGIN
	DECLARE v_cant INT(5);
	DECLARE v_alm CHAR(2);
	DECLARE v_id CHAR(2);
	DECLARE v_ultima_fila INT;
	DECLARE c_aumento CURSOR FOR
	SELECT id_art,id_alm, cant
		FROM stock  
	WHERE id_art = "P1"  OR id_art = "P3"  OR id_art = "P5";
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
	OPEN c_aumento;
	bucle_aumento:LOOP
		FETCH c_aumento INTO v_id, v_alm, v_cant;
		IF v_ultima_fila=1 THEN
			LEAVE bucle_aumento;
		END IF;
		IF v_id="P1" THEN
			SET v_cant=v_cant*1.20;
		ELSEIF v_id="P3" THEN
			SET v_cant=v_cant*1.15;
		ELSEIF v_id="P5" THEN
			SET v_cant=v_cant*1.05;
		END IF;
	SELECT v_id, v_alm, v_cant;
	UPDATE stock SET cant = v_cant WHERE id_art = v_id AND id_alm = v_alm;
	END LOOP bucle_aumento;
CLOSE c_aumento;
END


