---1---

LOAD DATA INFILE 'C:\\BDlibreria_compradores.csv'
INTO TABLE compradores
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
(nombre, fecha_nacim,telefono,domicilio,poblacion,anotaciones);

LOAD DATA INFILE 'C:\\BDlibreria_libros.csv'
INTO TABLE libros
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
(titulo, escritor,editorial,soporte,fecha_entrada_libreria,pais, importe_euros,anotaciones);

LOAD DATA INFILE 'C:\\BDlibreria_compras.csv'
INTO TABLE compras
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
(id_libro, id_comprador);

---2---

ALTER TABLE compras ADD (CONSTRAINT FK_ID_LIBRO FOREIGN KEY(id_libro) REFERENCES libros(registro));
ALTER TABLE compras ADD (CONSTRAINT FK_id_comprador FOREIGN KEY(id_comprador) REFERENCES compradores(registro));

---3---

SELECT titulo 
FROM libros L JOIN compras C
ON L.registro=C.id_libro 
GROUP BY titulo
ORDER BY COUNT(id_libro) DESC
LIMIT 1; 


SELECT nombre 
FROM compradores 
WHERE registro IN (SELECT id_comprador FROM compras);


SELECT titulo 
FROM libros 
WHERE registro NOT IN (SELECT id_libro FROM compras);

---4---

UPDATE libros 
SET importe_euros =  (importe_euros*1.10)
WHERE soporte = "CD" OR soporte="DVD";
COMMIT;

UPDATE libros 
SET importe_euros =  (importe_euros/1.20)
WHERE registro NOT IN (SELECT id_libro FROM compras);

UPDATE compradores 
SET anotaciones =  









