Algoritmo sin_titulo
	Definir a, b, c, n, i Como Entero
	a = 0
	b = 1
	Escribir "Introduzca el numero de elementos de la sucesion a visualizar:"
	Repetir
		Leer n
		si n<1
			Escribir "Numero minimo 1!"
		FinSi
	Mientras Que n<1
	Para i=0 Hasta n-1 Con Paso 1 Hacer
		Escribir Sin Saltar a," "
		c = a
		a = b
		b = b+c
	FinPara
FinAlgoritmo
