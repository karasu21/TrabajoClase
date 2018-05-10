---1---

CREATE DEFINER=`root`@`localhost` PROCEDURE `repaso_1`()
BEGIN
DECLARE v_id INT;
DECLARE v_en_pedido INT;
DECLARE  v_ultima_fila INT DEFAULT 0;
DECLARE c_pedidos CURSOR FOR
	SELECT idproducto, UnidadesEnPedido
		FROM productos;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
OPEN c_pedidos;
	bucle_pedidos:LOOP
		FETCH c_pedidos INTO v_id, v_en_pedido;
		IF v_ultima_fila=1 THEN
			LEAVE bucle_pedidos;
		END IF;
		SELECT SUM(Cantidad) INTO v_en_pedido 
        FROM detalles_pedido 
        WHERE IdProducto=v_id GROUP BY IdProducto;
		UPDATE productos SET UnidadesEnPedido=v_en_pedido WHERE IdProducto=v_id;
	END LOOP bucle_pedidos;
CLOSE c_pedidos;
END

---2---

CREATE DEFINER = CURRENT_USER 
TRIGGER `pedidos1`.`detalles_pedido_BEFORE_UPDATE` 
BEFORE INSERT ON `detalles_pedido` FOR EACH ROW
BEGIN
DECLARE v_id INT;
DECLARE v_existencias INT;
DECLARE v_validador INT DEFAULT 0;
DECLARE v_pedido INT;
DECLARE v_error VARCHAR(100);
DECLARE  v_ultima_fila INT DEFAULT 0;
DECLARE ERR_IDENTIFICADOR_NO_VALIDO CONDITION FOR SQLSTATE '45000';
DECLARE c_pedidos CURSOR FOR
	SELECT idproducto, UnidadesEnPedido,UnidadesEnExistencia 
		FROM productos;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
OPEN c_pedidos;
	bucle_pedidos:LOOP
		FETCH c_pedidos INTO v_id, v_pedido, v_existencias;
		IF v_ultima_fila=1 THEN
			LEAVE bucle_pedidos;
		END IF;
		IF NEW.IdProducto=v_id THEN
		IF v_existencias >= NEW.Cantidad THEN
		SET v_validador=1;
		SET v_pedido = v_pedido+NEW.Cantidad;
		SET v_existencias = v_existencias-NEW.Cantidad;
		UPDATE productos SET UnidadesEnPedido=v_pedido WHERE NEW.IdProducto=v_id;
		UPDATE productos SET UnidadesEnExistencia=v_existencias WHERE NEW.IdProducto=v_id;
		END IF;
		END IF;
	END LOOP bucle_pedidos;
CLOSE c_pedidos;
IF v_validador=0 THEN
	SET v_error = "No quedan existencias";
	SIGNAL ERR_IDENTIFICADOR_NO_VALIDO 
	SET MESSAGE_TEXT = v_error;
END IF;
END