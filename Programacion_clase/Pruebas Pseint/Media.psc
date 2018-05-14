Algoritmo sin_titulo
	Definir n, a, m, s, t Como Real
	Escribir "Pulse un numero para continuar"
	Leer n
	Si n == -1000000 Entonces
		Escribir "Adios"
	SiNo
		a = n
		t = a
		m = 0
		Mientras !n == -1000000 Hacer
			Escribir "Introduzca numero"
			Leer n
			m = m+1
			s = a + t
		Fin Mientras
		Escribir "La media es" s/m
		
		Escribir m
		Escribir s
		
	Fin Si
FinAlgoritmo

	
	
