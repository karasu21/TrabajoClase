Algoritmo sin_titulo
	Definir año como Entero
	Definir cont Como Caracter
	cont = 'y'
	Mientras cont == 'y' Hacer
		Escribir "Introduzca el año"
		Leer año
		Mientras año <= 0 Hacer
			Escribir "El año tiene que ser positivo, introduzca un año valido"
			Leer año
		FinMientras
		Si año%4==0 && !año%100==0|| año%400==0 Entonces
			Escribir "El año es bisiesto"
		SiNo 
			Escribir "El año no es bisiesto"
		FinSi
		Escribir "Desea introducir otro año?(y/n)"
		Leer cont
		Mientras cont != 'y' && cont != 'n' Hacer
			Escribir "Valor no valido. Introduzca un valor valido"
			Leer cont
		FinMientras
	FinMientras
FinAlgoritmo
