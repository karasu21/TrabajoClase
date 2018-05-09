---1---

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


CREATE OR REPLACE TYPE BODY Stack AS
CONSTRUCTOR FUNCTION Stack(longitud INTEGER)
RETURN SELF AS RESULT
AS
BEGIN
SELF.top := 0;
SELF.position:=IntArray();
IF longitud > SELF.position.limit THEN
	SELF.max_size := 25;
ELSE
	SELF.max_size := longitud;
END IF;
SELF.position.extend(max_size);
RETURN;
END;
MEMBER FUNCTION full RETURN BOOLEAN IS
BEGIN
IF SELF.top = SELF.max_size THEN
RETURN TRUE;
ELSE
RETURN FALSE;
END IF;
END;
MEMBER FUNCTION empty RETURN BOOLEAN IS
BEGIN
IF SELF.top = 0 THEN
RETURN TRUE;
ELSE
RETURN FALSE;
END IF;
END;
MEMBER PROCEDURE push (n IN INTEGER) IS
BEGIN
IF self.full() THEN
RAISE_APPLICATION_ERROR(-20010,'Pila llena');
ELSE
SELF.top:=SELF.top+1;
SELF.position(top):=n;
END IF;
END;
MEMBER PROCEDURE pop (n OUT INTEGER) IS
IF self.empty() THEN
RAISE_APPLICATION_ERROR(-20011,'Pila vacia');
ELSE
n:=SELF.position(top);
SELF.top:=top-1;
END IF;
END;
END;
/





DECLARE
r3 Stack:= Stack(2);
BEGIN
DBMS_OUTPUT.PUT_LINE(r3.max_size);
END;
/


