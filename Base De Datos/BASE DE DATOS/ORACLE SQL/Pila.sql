CREATE TYPE IntArray AS VARRAY(25) OF INTEGER;

CREATE TYPE Stack AS OBJECT ( 
   max_size INTEGER, 
   top      INTEGER,
   position IntArray,
   MEMBER PROCEDURE initialize,
   MEMBER FUNCTION full RETURN BOOLEAN,
   MEMBER FUNCTION empty RETURN BOOLEAN,
   MEMBER PROCEDURE push (n IN INTEGER),
   MEMBER PROCEDURE pop (n OUT INTEGER)
);

CREATE TYPE BODY Stack AS 
   MEMBER PROCEDURE initialize IS
   -- fill stack with nulls
   BEGIN
      top := 0;
      -- call constructor for varray and set element 1 to NULL 
      position := IntArray(NULL);
      max_size := position.LIMIT;  -- use size constraint (25)
      position.EXTEND(max_size - 1, 1);  -- copy element 1
   END initialize;

   MEMBER FUNCTION full RETURN BOOLEAN IS 
   -- return TRUE if stack is full
   BEGIN
      RETURN (top = max_size);
   END full;

   MEMBER FUNCTION empty RETURN BOOLEAN IS 
   -- return TRUE if stack is empty
   BEGIN
      RETURN (top = 0);
   END empty;

   MEMBER PROCEDURE push (n IN INTEGER) IS 
   -- push integer onto stack
   BEGIN
      IF NOT full THEN
         top := top + 1;
         position(top) := n;
      ELSE  -- stack is full
         RAISE_APPLICATION_ERROR(-20101, 'stack overflow');
      END IF;
   END push;

   MEMBER PROCEDURE pop (n OUT INTEGER) IS
   -- pop integer off stack and return its value
   BEGIN
      IF NOT empty THEN
         n := position(top);
         top := top - 1;
      ELSE  -- stack is empty
         RAISE_APPLICATION_ERROR(-20102, 'stack underflow');
      END IF;
   END pop;
END;
