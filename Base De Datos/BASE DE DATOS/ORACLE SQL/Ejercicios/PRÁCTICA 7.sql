CREATE TYPE Racional AS OBJECT (
num INTEGER,
den INTEGER,
MAP MEMBER FUNCTION valor RETURN REAL,
MEMBER PROCEDURE simplificar,
MEMBER FUNCTION reciproco RETURN Racional,
MEMBER FUNCTION suma (x Racional) RETURN Racional,
MEMBER FUNCTION resta (x Racional) RETURN Racional,
MEMBER FUNCTION multiplicacion (x Racional) RETURN Racional,
MEMBER FUNCTION division (x Racional) RETURN Racional,
MEMBER PROCEDURE imprimir
);
/

CREATE OR REPLACE TYPE BODY Racional AS
MAP MEMBER FUNCTION valor RETURN REAL IS
BEGIN
RETURN num/den;
END;

MEMBER PROCEDURE simplificar IS
resp INTEGER;
BEGIN
IF (den <= num) AND (num MOD den = 0) THEN
resp := den;
ELSIF num < den THEN
resp := mcd(den, num); -- llamadada recursiva
ELSE
resp := mcd(den, num MOD den); -- llamadada recursiva
END IF;
num:=num/resp;
den:=den/resp;
END;

MEMBER FUNCTION reciproco RETURN Racional IS
x INTEGER;
y INTEGER;
fraccion_r Racional;
BEGIN
y:=num;
x:=den;
fraccion_r :=Racional(x,y);
RETURN fraccion_r;
END;

MEMBER FUNCTION suma (x Racional) RETURN Racional IS
n_num INTEGER;
n_den INTEGER;
fraccion_s Racional;
BEGIN
n_num:=(num*x.den) + (x.num*den);
n_den:=(den * x.den);
fraccion_s:=Racional(n_num,n_den);
fraccion_s.simplificar();
Return fraccion_s;
END;

MEMBER FUNCTION resta (x Racional) RETURN Racional IS
n_num INTEGER;
n_den INTEGER;
fraccion_res Racional;
BEGIN
n_num:=(num*x.den) - (x.num*den);
n_den:=(den * x.den);
fraccion_res:=Racional(n_num,n_den);
fraccion_res.simplificar();
Return fraccion_res;
END;

MEMBER FUNCTION multiplicacion (x Racional) RETURN Racional IS
n_num INTEGER;
n_den INTEGER;
fraccion_m Racional;
BEGIN
n_num:=(num*x.num);
n_den:=(den * x.den);
fraccion_m:=Racional(n_num,n_den);
fraccion_m.simplificar();
Return fraccion_m;

END;

MEMBER FUNCTION division (x Racional) RETURN Racional IS
n_num INTEGER;
n_den INTEGER;
fraccion_d Racional;
BEGIN
n_num:=(num*x.den);
n_den:=(den * x.num);
fraccion_d:=Racional(n_num,n_den);
fraccion_d.simplificar();
Return fraccion_d;
END;

MEMBER PROCEDURE imprimir IS
BEGIN
DBMS_OUTPUT.PUT_LINE(num/den);
END;

END;
/

DECLARE
racional1 Racional:= Racional(4,2);
BEGIN
racional1.reciproco();
racional1.imprimir();
END;
/
