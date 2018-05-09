--Operados EXIST
/*** 1- ***/
SELECT APELLIDO FROM EMPLEADOS A
WHERE EXISTS (SELECT * FROM EMPLEADOS B WHERE B.EMP_NO= A.DIRECTOR AND 
B.SALARIO < A.SALARIO);

/*** 2- ***/
SELECT direccion, id_alm FROM ALMACEN A
WHERE EXISTS (SELECT S.id_alm FROM STOCK S
WHERE id_art='P2' and S.id_alm=A.id_alm);

/*** 3- ***/
SELECT id_art, descripcion FROM ARTICULO A
WHERE EXISTS (SELECT * FROM STOCK S WHERE A.id_art=S.id_art group by A.id_art
HAVING COUNT(id_alm) > (SELECT COUNT(id_alm) FROM ALMACEN)/2);

/*** 4- ***/

-- A NOT IN
SELECT distinct(P.nombre) FROM PROVEEDOR P, ARTICULO AR WHERE P.id_prov = AR.proveedor 
AND AR.id_art NOT IN (SELECT S.id_art FROM STOCK S WHERE S.id_art=AR.id_art);

-- B NOT EXISTS
SELECT distinct(P.nombre) FROM PROVEEDOR P, ARTICULO AR WHERE P.id_prov = AR.proveedor
AND NOT EXISTS (SELECT * FROM STOCK S WHERE S.id_art=AR.id_art);

/*** 5- ***/
-- Sin EXISTS
SELECT Name FROM country A
WHERE Population > (SELECT sum(Population)/2 FROM country B WHERE B.continent=A.continent);

--Con EXISTS
SELECT Name FROM country A WHERE EXISTS (SELECT * FROM country B WHERE B.continent=A.continent
GROUP BY continent
HAVING A.population > sum(B.Population)/2);
