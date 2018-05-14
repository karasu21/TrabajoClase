Algoritmo sin_titulo
	Definir n, m, s Como Real
        s = 0
		m = -1
	Mientras !n == -1000000 Hacer
		m = m+1
		s = s + n
		Escribir "Introduzca numero, para finalizar operacion escriba -1000000"
		Leer n
	Fin Mientras
	Si m == 0 Entonces
		Escribir "Adios"    
	SiNo
		Escribir "La media es " s/m
	Fin Si
FinAlgoritmo

	
	
