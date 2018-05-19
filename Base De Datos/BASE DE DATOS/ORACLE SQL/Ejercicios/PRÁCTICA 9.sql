---1---

SQL Scripts --> Upload

BDpedidos.sql
script_insert_clientes.sql
script_insert_empleados.sql
script_insert_proveedores.sql
script_insert_productos.sql
script_insert_pedidos.sql
script_insert_detalles_pedido.sql
script_foreign_keys.sql

---2---

CREATE TYPE t_direccion AS OBJECT (
Direccion VARCHAR2(60),
Ciudad VARCHAR2(15),
Region VARCHAR2(15),
CodPostal VARCHAR2(10),
Pais VARCHAR2(15)
);
/

CREATE TABLE direccion_t OF t_direccion;

CREATE TYPE t_empleado AS OBJECT (
idEmpleado INT(10),
Apellidos VARCHAR2(20),
Nombre VARCHAR2(10),
Cargo VARCHAR2(30),
Tratamiento VARCHAR2(25),
FechaNacimiento DATE,
FechaContratacion DATE,
direccion t_direccion,
TelDomicilio VARCHAR2(24),
Extension VARCHAR2(4),
Foto VARCHAR2(255),
Notas VARCHAR2(500),
jefe ref t_empleado
);
/

CREATE TABLE empleado_t OF t_empleado;

CREATE TYPE t_cliente AS OBJECT (
idCliente VARCHAR2(5),
NombreCompania VARCHAR2(40),
NombreContacto VARCHAR2(30),
CargoContacto VARCHAR2(30),
direccion t_direccion,
Telefono VARCHAR2(24),
Fax VARCHAR2(24)
);
/

CREATE TABLE cliente_t OF t_cliente;

CREATE TYPE t_proveedor AS OBJECT (
idProveedor INT(10),
NombreCompania VARCHAR2(40),
NombreContacto VARCHAR2(30),
CargoContacto VARCHAR2(30),
direccion t_direccion,
Telefono VARCHAR2(24),
Fax VARCHAR2(24),
PaginaPrincipal VARCHAR2(500)
);
/

CREATE TABLE proveedor_t OF t_proveedor;

CREATE TYPE t_categoria AS OBJECT (
idCategoria INT(10),
NombreCategoria VARCHAR2(40),
Descripcion VARCHAR2(500),
Imagen CLOB
);
/

CREATE TABLE categoria_t OF t_categoria;

CREATE TYPE t_poducto AS OBJECT (
IdProducto    NUMBER(10)
NombreProducto VARCHAR2(40),
idProveedor ref t_proveedor,
idCategoria ref t_categoria,
CantidadPorUnidad VARCHAR2(20),
PrecioUnidad DECIMAL(19,4),
UnidadesEnExistencias SMALLINT(5),
UnidadesEnPedido SMALLINT(5),
NivelNuevoPedido INT(10),
Suspendido NUMBER(1)
);
/

CREATE TABLE producto_t OF t_poducto;

CREATE TYPE t_detalle_pedido AS OBJECT (
idProducto ref t_poducto,
PrecioUnidad NUMBER(19,4),
Cantidad SMALLINT(5),
Descuento NUMBER(7,2)
);
/

CREATE TABLE detalle_pedido_t OF t_detalle_pedido;

CREATE TYPE nt_detalle_pedido AS TABLE OF t_detalle_pedido;

CREATE TYPE t_empresa_transporte AS OBJECT (
idCompaniaEnvios INT(10),
NombreCompania VARCHAR2(40),
Telefono VARCHAR2(24)
);
/

CREATE TABLE empresa_transporte_t OF t_empresa_transporte;

CREATE TYPE t_pedido AS OBJECT (
IdPedido INT(10),
Cliente ref t_cliente,
Empleado ref t_empleado,
Transporte ref t_empresa_transporte,
FechaPedido CHAR(10),
FechaEntrega CHAR(10),
FechaEnvio CHAR(10),
FormaEnvio INT(10),
Cargo NUMBER(19,4),
Destinatario VARCHAR2(40),
DireccionDestinatario VARCHAR2(60),
CiudadDestinatario VARCHAR2(15),
RegionDestinatario VARCHAR2(15),
CodPostalDestinatario VARCHAR2(10),
PaisDestinatario VARCHAR2(15)
);
/

CREATE TABLE pedido_t OF t_pedido;

CREATE TABLE pedidos_t(
pedido t_pedido,
detalles nt_detalle_pedido)
NESTED TABLE detalles STORE AS detalles_nr_table;
/

---3---

--Tabla categoria_t--
DECLARE
		CURSOR c_categoria IS
		SELECT idCategoria, NombreCategoria, Descripcion, Imagen
		FROM categorias;	
		
BEGIN
FOR opcion IN c_categoria LOOP
  INSERT INTO categoria_t VALUES (opcion.idCategoria,opcion.NombreCategoria,opcion.Descripcion,opcion.Imagen);
 END LOOP;
END;
/

--Tabla proveedor_t--
DECLARE
		CURSOR c_proveedor IS
		SELECT idProveedor, NombreCompania, NombreContacto, CargoContacto,Direccion, Ciudad, Region, CodPostal,Pais, Telefono,Fax,PaginaPrincipal
		FROM proveedores;	
BEGIN
FOR opcion IN c_proveedor LOOP
  INSERT INTO proveedor_t VALUES (opcion.idProveedor,opcion.NombreCompania,opcion.NombreContacto,opcion.CargoContacto,t_direccion(opcion.Direccion,opcion.Ciudad, opcion.Region, opcion.CodPostal,opcion.Pais),opcion.Telefono,opcion.Fax,opcion.PaginaPrincipal);
 END LOOP;

END;
/

--Tabla producto_t--
DECLARE
		CURSOR c_productos IS
		SELECT idProducto, NombreProducto, idProveedor, idCategoria,CantidadPorUnidad, PrecioUnidad, UnidadesEnExistencia, UnidadesEnPedido,NivelNuevoPedido, Suspendido
		FROM productos;	
BEGIN
FOR opcion IN c_productos LOOP
  INSERT INTO producto_t VALUES (opcion.idProducto,opcion.NombreProducto,(select ref(p) from proveedor_t p where p.idProveedor=opcion.idProveedor),(select ref(c) from categoria_t c where c.idCategoria=opcion.idCategoria),opcion.CantidadPorUnidad,
								opcion.PrecioUnidad,opcion.UnidadesEnExistencia,opcion.UnidadesEnPedido,opcion.NivelNuevoPedido,opcion.Suspendido);
 END LOOP;
END;
/

--Tabla empresa_transporte_t--

DECLARE
		CURSOR c_empresas_transporte IS
		SELECT idCompaniaEnvios, NombreCompania, Telefono
		FROM empresas_transporte;	
		
BEGIN
FOR opcion IN c_empresas_transporte LOOP
  INSERT INTO empresa_transporte_t VALUES (opcion.idCompaniaEnvios,opcion.NombreCompania,opcion.Telefono);
 END LOOP;
END;
/

--Tabla empleado_t--

DECLARE
		CURSOR c_empleados IS
		SELECT idEmpleado,Apellidos,Nombre,Cargo,Tratamiento,FechaNacimiento,FechaContratacion,Direccion,Ciudad,Region,CodPostal,Pais,TelDomicilio,Extension,Foto, Notas, Jefe
		FROM empleados;	
		
BEGIN
FOR opcion IN c_empleados LOOP
  INSERT INTO empleado_t VALUES (opcion.idEmpleado,opcion.Apellidos,opcion.Nombre,opcion.Cargo,opcion.Tratamiento,opcion.FechaNacimiento,opcion.FechaContratacion,t_direccion(opcion.Direccion,opcion.Ciudad, opcion.Region, opcion.CodPostal,opcion.Pais),opcion.TelDomicilio,opcion.Extension,opcion.Foto,opcion.Notas,null);
 END LOOP;
END;
/

DECLARE
		CURSOR c_empleados IS
		SELECT idEmpleado, Jefe
		FROM empleados;	
		
BEGIN
FOR opcion IN c_empleados LOOP
UPDATE empleado_t e set e.jefe=(select ref(e) from empleado_t e where e.idEmpleado=opcion.Jefe) where e.idEmpleado=opcion.idEmpleado;
END LOOP;
END;
/


--Tabla cliente_t--

DECLARE
		CURSOR c_clientes IS
		SELECT idCliente, NombreCompania, NombreContacto, CargoContacto, Direccion,Ciudad,Region,CodPostal,Pais,Telefono,Fax
		FROM clientes;	
		
BEGIN
FOR opcion IN c_clientes LOOP
  INSERT INTO cliente_t VALUES (opcion.idCliente, opcion.NombreCompania, opcion.NombreContacto, opcion.CargoContacto,t_direccion(opcion.Direccion,opcion.Ciudad, opcion.Region, opcion.CodPostal,opcion.Pais),opcion.Telefono,opcion.Fax);
 END LOOP;
END;
/

--Tabla pedido_t--

DECLARE
		CURSOR c_pedidos IS 
		SELECT idPedido,idCliente,idEmpleado ,FechaPedido ,FechaEntrega ,FechaEnvio,FormaEnvio ,Cargo ,Destinatario ,DireccionDestinatario ,CiudadDestinatario ,RegionDestinatario ,CodPostalDestinatario ,PaisDestinatario 
		FROM pedidos;	
		
BEGIN
FOR opcion IN c_pedidos LOOP
INSERT INTO pedido_t VALUES (opcion.idPedido,(SELECT ref(c) FROM cliente_t c where c.idCliente=opcion.idCliente),(SELECT ref(e) FROM empleado_t e where e.idEmpleado=opcion.idEmpleado) ,(SELECT ref(t) FROM  empresa_transporte_t t where t.idCompaniaEnvios=opcion.formaEnvio),opcion.FechaPedido ,opcion.FechaEntrega ,opcion.FechaEnvio,opcion.FormaEnvio ,opcion.Cargo ,opcion.Destinatario ,opcion.DireccionDestinatario ,opcion.CiudadDestinatario ,opcion.RegionDestinatario ,opcion.CodPostalDestinatario ,opcion.PaisDestinatario );
END LOOP;
END;
/

--Tabla detalle_pedido_t--

DECLARE
		CURSOR c_detalles_pedido IS
		SELECT idPedido, idProducto, precioUnidad, cantidad, descuento
		FROM detalles_pedido;	
		
BEGIN
FOR opcion IN c_detalles_pedido LOOP
INSERT INTO detalle_pedido_t VALUES (opcion.idPedido, opcion.CodPostalDestinatario, opcion.PaisDestinatario);

END LOOP;
END;
/

--Tabla pedidos_t--

DECLARE
		
		CURSOR c_pedidos IS
		SELECT p.idPedido, p.cliente,p.empleado,p.transporte,p.fechaPedido,p.fechaEntrega,p.fechaEnvio,p.formaEnvio,p.cargo,p.destinatario,p.direccionDestinatario,p.ciudadDestinatario,p.regionDestinatario,p.codPostalDestinatario,p.paisDestinatario
		FROM pedido_t p;	

		CURSOR c_detalles_pedido IS
		SELECT idPedido, idProducto, precioUnidad, cantidad, descuento
		FROM detalles_pedido;	
		
BEGIN
FOR opcion IN c_detalles_pedido LOOP
INSERT INTO detalle_pedido_t VALUES (opcion.idPedido, opcion.CodPostalDestinatario, opcion.PaisDestinatario);

END LOOP;
END;
/




--Tabla pedidos_t_otro--

DECLARE
	CURSOR c_pedidos IS
	SELECT value (p) AS ped
	FROM pedido_t p;
	
	CURSOR c_detalles_pedido IS
		SELECT idPedido, idProducto, precioUnidad, cantidad, descuento
		FROM detalles_pedido;
	
BEGIN
FOR opcion IN c_pedidos LOOP
	for opcion2 IN c_detalles_pedido LOOP
		INSERT INTO nt_detalle_pedido VALUES ((select ref(p) from producto_t p where p.idProducto=(select idProducto from opcion2.idProducto)));
	END LOOP;
	INSERT INTO pedidos_t VALUES (opcion.ped,nt_detalle_pedido (,null));
END LOOP;
END;
/