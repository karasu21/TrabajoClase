CREATE TYPE cuenta_bancaria AS OBJECT (
num_cuenta  INTEGER,
saldo REAL,
estado INTEGER,
CONSTRUCTOR FUNCTION cuenta_bancaria RETURN SELF AS RESULT,
MEMBER PROCEDURE verificar,
MEMBER PROCEDURE cerrar (cantidad OUT REAL),
MEMBER PROCEDURE ingresar (cantidad IN REAL),
MEMBER PROCEDURE retirar (cantidad IN REAL),
MEMBER FUNCTION saldo_actual RETURN REAL
);
/

CREATE SEQUENCE numeroCuenta
INCREMENT BY 100
START WITH 100;
/

CREATE TABLE cuentas OF cuenta_bancaria;/

---1---

CREATE OR REPLACE TYPE BODY cuenta_bancaria AS
CONSTRUCTOR FUNCTION cuenta_bancaria
RETURN SELF AS RESULT
AS
BEGIN
num_cuenta:= numeroCuenta.NEXTVAL;
saldo:=0;
estado:=1;
RETURN;
END; 

MEMBER PROCEDURE verificar  IS
BEGIN
IF estado=0 THEN
	RAISE_APPLICATION_ERROR(-20011,'La cuenta está cerrada');
END IF;
END; 

MEMBER PROCEDURE cerrar (cantidad OUT REAL) IS
BEGIN
verificar();
estado:=0;
cantidad:=saldo;
END; 

MEMBER PROCEDURE ingresar (cantidad IN REAL) IS
BEGIN
verificar();
IF cantidad>0 THEN
	saldo:=saldo+cantidad;
ELSE
	RAISE_APPLICATION_ERROR(-20012,'La cantidad introducida es negativa');
END IF;
END; 

MEMBER PROCEDURE retirar (cantidad IN REAL) IS
BEGIN
verificar();
IF cantidad>saldo THEN
	RAISE_APPLICATION_ERROR(-20013,'La cantidad introducida es mayor que el saldo disponible');
ELSE
saldo:=saldo-cantidad;
END IF;
END; 

MEMBER FUNCTION saldo_actual RETURN REAL IS
BEGIN
RETURN saldo;
END; 

END;
/

---2---

DECLARE

BEGIN
FOR i in 1..100
LOOP
	insert into cuentas values (cuenta_bancaria());
	END LOOP;
END;
/

---3---

DECLARE
v_num_cuenta INTEGER;
Cursor c_cuenta is SELECT c.num_cuenta FROM cuentas c;
BEGIN
OPEN c_cuenta;
LOOP
FETCH c_cuenta INTO v_num_cuenta;
EXIT WHEN c_cuenta%NOTFOUND;
UPDATE cuentas c set c.estado=0 where (MOD(c.num_cuenta,10)=0);
END LOOP;
CLOSE c_cuenta;
END;
/

---4---

DECLARE
cuenta cuenta_bancaria:=cuenta_bancaria();
restante Real;
Cursor c_cuenta is SELECT c.num_cuenta, c.saldo, c.estado FROM cuentas c;
BEGIN
OPEN c_cuenta;
LOOP
FETCH c_cuenta INTO cuenta.num_cuenta,cuenta.saldo,cuenta.estado;
EXIT WHEN c_cuenta%NOTFOUND;
IF (MOD(cuenta.num_cuenta,10)=0) THEN
cuenta.cerrar(restante);
UPDATE cuentas c set c.estado=cuenta.estado;
END IF;
END LOOP;
CLOSE c_cuenta;
END;
/

---5---


DECLARE
cuenta cuenta_bancaria:=cuenta_bancaria();
Cursor c_cuenta is SELECT c.num_cuenta, c.saldo, c.estado FROM cuentas c;
BEGIN
OPEN c_cuenta;
LOOP
FETCH c_cuenta INTO cuenta.num_cuenta,cuenta.saldo,cuenta.estado;
EXIT WHEN c_cuenta%NOTFOUND;
cuenta.ingresar(50);
UPDATE cuentas c set c.saldo=cuenta.saldo;
END LOOP;
CLOSE c_cuenta;
END;
/


