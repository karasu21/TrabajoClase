CREATE TYPE IntArray AS VARRAY(25) OF INTEGER;

CREATE TYPE Stack AS OBJECT (
 top INTEGER,--indica el extremo de la pila
 max_size INTEGER,--Indica el tamaño máximo como tope 25
 position IntArray,--varray donde se van a guardar los elementos de la pila
 CONSTRUCTOR FUNCTION Stack(longitud INTEGER)
 RETURN SELF AS RESULT,
 MEMBER FUNCTION full RETURN BOOLEAN,
 MEMBER FUNCTION empty RETURN BOOLEAN,
 MEMBER PROCEDURE push (n IN INTEGER),
 MEMBER PROCEDURE pop (n OUT INTEGER)
);
/ 

--quitar comentttarios
Select * from Stack


---Ejercicio 1-----------------------------------------------------------
Se pide crear el TYPE BODY que permita implementar el constructor y esas funciones y
procedimientos. Alguna pista:
a. El constructor se debe encargar de poner el extremo de la pila con valor 0. Además
verifica que la longitud de la pila no excede su tamaño máximo (usar LIMIT) y si
excede se pone el valor máximo en lugar del valor pasado. Además se inicializan a nulo
todos los elementos de la pila.
-----------------------------------------------------------------------




CREATE OR REPLACE TYPE BODY STACK AS
CONSTRUCTOR FUNCTION STACK(longitud INTEGER)
RETURN SELF AS RESULT
AS
BEGIN	
SELF.top:=1;
IF(longitud >= 25) THEN
SELF.max_size := 25;
ELSE
SELF.max_size := longitud;
END IF;
self.position:=intarray();
SELF.position.EXTEND(self.max_size);
RETURN; 
END;


MEMBER FUNCTION full RETURN BOOLEAN IS
BEGIN
IF (top <= max_size) THEN
return false;
ELSE
return true;
END IF;
END full;


MEMBER FUNCTION empty RETURN BOOLEAN IS
BEGIN
IF (top = position.First) THEN
return true;
ELSE
return false;
END IF;
END empty;


MEMBER PROCEDURE push (n IN INTEGER) IS
BEGIN
	IF(full()=false) THEN
	position(top) := n;
	top:=top+1;	
	ELSE
	RAISE_APPLICATION_ERROR(-20010, 'La pila está llena no se pueden introducir mas valores.');
	END IF;
 END push;


MEMBER PROCEDURE pop (n OUT INTEGER) IS
BEGIN
	IF(empty()=false) THEN 
	top:=top-1;
	n := position(top);
	ELSE
	RAISE_APPLICATION_ERROR(-20011, 'La pila está vacía no se pueden sacar valores.');
	END IF;
END pop;

END;
/ 




-----------------------------------------------------------------------
b. Las funciones full y empty devolverán verdadero a falso según la pila este llena o vacía
respectivamente
c. Los procedimientos push y pop deben usar las funciones full y empty cuando
corresponda y lanzar una excepción en el caso de que no se pueda realizar la acción de
introducir y/o extraer un elemento de la pila.
-----------------------------------------------------------------------










---Ejercicio 2---------------------------------------------------------
2. Se pide crear un bloque anónimo de PL que permita probar lo siguiente: 
----------------------------------------------------------------------








DECLARE
pila1 Stack:= Stack(5);
num INTEGER;
BEGIN
for i in 1 .. pila1.max_size
loop
pila1.push(i);
dbms_output.put_line(pila1.position(i));
end loop;

for i in 1 .. pila1.max_size
loop
pila1.pop(num);
dbms_output.put_line(num);
end loop;
END;
/






DECLARE
pila1 Stack:= Stack(5);
pila2 Stack:= Stack(10);
--pila3 Stack:= Stack(100);
num INTEGER;
--1 llenar y mostrar pila 1
BEGIN
for i in 1 .. pila1.max_size
loop
pila1.push(i);
dbms_output.put_line(pila1.position(i));
end loop;

--2 llenar y mostrar pila 2
for i in 1 .. pila2.max_size
loop
pila2.push(i);
dbms_output.put_line(pila2.position(i));
end loop;

--3 error en pila 1
--pila1.push(6);

--4 error al acar de pila vacia
for i in 1 .. pila2.max_size
loop
pila2.pop(num);
end loop;
--pila2.pop(num);--causa el error


--5 pasar de pila 1 a la 2

for i in 1 .. pila1.max_size
loop
pila1.pop(num);
pila2.push(num);
dbms_output.put_line(pila2.position(i));
end loop;

END;
/

















