Algoritmo Factorial
	Definir n, ini, producto como Real
	Escribir "Introduzca Numero"
	Leer n
	Si n < 0 Entonces
		Escribir "Error, numero negativo"
	SiNo
		ini = n
		producto = 1
		Mientras ini >= 1 Hacer
			producto = producto * ini
		    ini = ini - 1
		Fin Mientras
		Escribir n "!=" producto	
	Fin Si
	
	
FinAlgoritmo
