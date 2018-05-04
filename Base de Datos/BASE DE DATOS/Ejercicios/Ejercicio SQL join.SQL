--1

SELECT P.nombre nombre, P.saldo_deudor saldo 
FROM PROVEEDOR P JOIN ARTICULO A ON P.id_prov =  A.PROVEEDOR
WHERE A.id_art = "R3";

--2

SELECT A.id_alm id_alm, A.direccion direccion
FROM ALMACEN A JOIN STOCK S 
ON A.id_alm = S.id_alm 
JOIN ARTICULO AR ON AR.id_art = S.id_art
WHERE AR.id_art = "P5";

--3

SELECT DISTINCT(S.id_art) Id_art
FROM STOCK S JOIN ALMACEN A
ON S.id_alm = A.id_alm
WHERE A.direccion LIKE 'CALLE 34,%%';

--4

SELECT AR.descripcion
FROM ARTICULO AR JOIN STOCK S
ON AR.id_art = S.id_art
JOIN ALMACEN A
ON S.id_alm = A.id_alm
WHERE A.id_alm="A1";

--5

SELECT SUM(AR.precio_vent*S.cant)-SUM(AR.precio_comp*S.cant) "beneficio total"
FROM ARTICULO AR JOIN STOCK S
ON AR.id_art = S.id_art 
WHERE AR.id_art="P3";

--6

SELECT A.id_art id_art, SUM(S.cant) STOCK
FROM ARTICULO A JOIN STOCK S
ON A.id_art = S.id_art
WHERE A.ord_pte>0
GROUP BY S.id_art;

--7

SELECT AR.descripcion descripcion,A.direccion direccion, S.cant cant
FROM ARTICULO AR JOIN STOCK S
ON AR.id_art = S.id_art
JOIN ALMACEN A
ON S.id_alm = A.id_alm
ORDER BY 3 DESC;

--8

SELECT P.nombre
FROM PROVEEDOR P JOIN ARTICULO A
ON P.id_prov = A.PROVEEDOR
WHERE P.saldo_deudor ;


--extra

SELECT E1.APELLIDO 'NOMBRE EMPLEADO', E2.APELLIDO 'NOMBRE JEFE' 
FROM EMPLEADOS E1 JOIN EMPLEADOS E2 ON E1.DIRECTOR=E2.EMP_NO;



























