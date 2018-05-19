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
FechaNacimiento DATETIME,
FechaContratacion DATETIME,
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
idProveedore INT(10),
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
NombreProducto VARCHAR2(40),
idProveedore ref t_proveedor,
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

DECLARE
		CURSOR c_categoria IS
		SELECT idCategoria, NombreCategoria, Descripcion, Imagen
		FROM categorias;	
		
		CURSOR c_proveedor IS
		SELECT idProveedore, NombreCompania, NombreContacto, CargoContacto,Direccion, Ciudad, Region, CodPostal,Pais, Telefono,Fax,PaginaPrincipal
		FROM proveedores;	
BEGIN
FOR opcion IN c_categoria LOOP
  INSERT INTO categoria_t VALUES (opcion.idCategoria,opcion.NombreCategoria,direcopcion.Descripcion,opcion.Imagen);
 END LOOP;
END;

FOR opcion IN c_proveedor LOOP
  INSERT INTO proveedor_t VALUES (opcion.idProveedor,opcion.NombreCompania,opcion.NombreContacto,opcion.CargoContacto,t_direccion(null,null,null,null,null),opcion.Telefono,opcion.Fax,opcion.PaginaPrincipal);
 END LOOP;

END;
/



