Algoritmo seriearitmetica
	Definir p, f, ini, temp, cont, mov Como Entero
	Repetir
		Escribir "paso:"
		Leer p
		Si p == 0 Entonces
			Escribir "paso no valido"
		FinSi
	Hasta Que p != 0
	Escribir "inicio:"
	Leer ini
	Repetir
		Escribir "fin:"
		Leer f
		Si ini * ABS(p)/p > f
			Escribir "valor no valido"
		FinSi
	Hasta Que ini * ABS(p)/p < f
	cont = 0
	temp = ABS((f - ini - (f - ini)%ABS(p))/p)
	mov = ini
	Mientras cont <= temp Hacer
		Escribir Sin Saltar mov, " "
		mov = mov + p
		cont = cont + 1
	FinMientras
FinAlgoritmo
