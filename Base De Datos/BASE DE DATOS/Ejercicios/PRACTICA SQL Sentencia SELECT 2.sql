--1
SELECT COUNT(*) 'Numero Paises' FROM country;

--2
SELECT COUNT(DISTINCT(Region)) 'Numero Regiones' FROM country;

--3
SELECT COUNT(language) 'Idiomas USA' FROM countrylanguage WHERE CountryCode="USA";

--4
SELECT FORMAT(SUM(Population),0, 'de_DE') 'Poblacion Ciudades USA' FROM city WHERE CountryCode="USA";

--5
SELECT Continent Continente, ROUND(SUM(Population)/1000000) "Mill. habitantes" FROM country GROUP BY Continent;

--6
SELECT CountryCode FROM countrylanguage GROUP BY CountryCode HAVING Count(Language)>10;

--7
SELECT GovernmentForm 'Forma de Gobierno', COUNT(Code) "Num. paises" FROM country GROUP BY GovernmentForm HAVING COUNT(Code)>2;

--8
SELECT Continent Continente, ROUND(SUM(SurfaceArea)/1000000) 'Ext. Mill. Km2',  ROUND(AVG(GNP)) 'PIB $', ROUND(AVG(LifeExpectancy)) 'Expectativa de Vida' FROM country GROUP BY Continent;

--9
SELECT Language, COUNT(CountryCode) FROM countrylanguage GROUP BY Language ORDER BY 2 DESC LIMIT 3;





