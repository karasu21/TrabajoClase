Algoritmo sin_titulo
	Definir a�o como Entero
	Definir cont Como Caracter
	cont = 'y'
	Mientras cont == 'y' Hacer
		Escribir "Introduzca el a�o"
		Leer a�o
		Mientras a�o <= 0 Hacer
			Escribir "El a�o tiene que ser positivo, introduzca un a�o valido"
			Leer a�o
		FinMientras
		Si a�o%4==0 && !a�o%100==0|| a�o%400==0 Entonces
			Escribir "El a�o es bisiesto"
		SiNo 
			Escribir "El a�o no es bisiesto"
		FinSi
		Escribir "Desea introducir otro a�o?(y/n)"
		Leer cont
		Mientras cont != 'y' && cont != 'n' Hacer
			Escribir "Valor no valido. Introduzca un valor valido"
			Leer cont
		FinMientras
	FinMientras
FinAlgoritmo
