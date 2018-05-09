CREATE DEFINER=`root`@`localhost` PROCEDURE `nforme_pedido`(IN id_ped char(6))
BEGIN
DECLARE v_error_id_ped char(6);
DECLARE v_existe INT DEFAULT 0;
DECLARE  v_ultima_fila INT DEFAULT 0;

DECLARE c_lenguaje CURSOR FOR
	SELECT Language, IsOfficial,Percentage
		FROM countrylanguage WHERE CountryCode=cod_pais;
DECLARE c_error CURSOR FOR
	SELECT IdPedido
		FROM pedidos;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila=1;
OPEN c_error;
	bucle_error:LOOP
		FETCH c_error INTO v_error_id_ped;
		IF v_ultima_fila=1 THEN
			LEAVE bucle_error;
		END IF;
		IF v_error_id_ped=id_ped THEN
			SET v_existe=1;
		END IF;
	END LOOP bucle_error;
CLOSE c_error;

IF v_existe=1 THEN
	SELECT ('***********************************************');
	SELECT CONCAT('************Informe Pedido:', id_ped, '***************');
	SELECT ('***********************************************');
	SELECT ('');
	SELECT CONCAT('Detalles del pedido con Numero:', id_ped); 
	SELECT CONCAT('Fecha del pedido: ',FechaPedido) FROM pedidos WHERE IdPedido=id_ped;
	SELECT CONCAT('Nombre del Cliente: ',Destinatario) FROM pedidos WHERE IdPedido=id_ped;
	SELECT CONCAT('Empresa de Envio: ',NombreCompania) 
	FROM empresas_transporte WHERE IdCompaniaEnvios=(SELECT FormaEnvio FROM pedidos WHERE IdPedido=id_ped); 
	SELECT ('');
	SELECT('************** Lineas de pedido ******************');
	SELECT ('');
	SELECT  CONCAT(RPAD(" Producto", 33, " "), "Cant.", "     " "Precio", "    " "Desc.", "    " "Total");						
	SELECT CONCAT(RPAD("*", 29, "*"), "    ", "******", "   ", "*******", "   ","*****", "   ", "********" ); 
		SELECT CONCAT(RPAD(P.NombreProducto, 38, " "), RPAD(D.Cantidad, 7, " "), RPAD(ROUND(D.PrecioUnidad,2), 8, " "), RPAD(D.Descuento, 9, " "), ROUND(SUM((D.PrecioUnidad*D.Cantidad)-Descuento*(D.PrecioUnidad*D.Cantidad)),2) )  
	FROM detalles_pedido D JOIN productos P ON D.IdProducto = P.IdProducto WHERE IdPedido=id_ped GROUP BY P.NombreProducto ; 
    SELECT ('');
	SELECT CONCAT('************** El total del pedidos es:',ROUND(SUM((D.PrecioUnidad*D.Cantidad)-Descuento*(D.PrecioUnidad*D.Cantidad)),2) ,'******************')FROM detalles_pedido D JOIN productos P ON D.IdProducto = P.IdProducto WHERE IdPedido=id_ped GROUP BY D.IdPedido ;
    
ELSE
	SELECT ('***********************************************');
	SELECT CONCAT('************Informe Pedido:', id_ped, '***************');
	SELECT ('***********************************************');
	SELECT ('');
	SELECT CONCAT('Detalles del pedido con Numero:', id_ped); 
	SELECT ('');
	SELECT ('El codigo de ese pedido no esta en la base de datos !!!!');
END IF;
END










