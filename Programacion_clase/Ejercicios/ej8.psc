Algoritmo sin_titulo
	Definir num, contmenor, contentre, contmayor, cont Como Real
	contmenor = 0
	contentre = 0
	contmayor = 0
	cont = 0
	Repetir
		Escribir "Introduzca un numero"
		Leer num
		cont = cont+1
		Si num < 25 Entonces
			contmenor = contmenor+1
		SiNo
			Si num >= 25 && num < 70 Entonces
				contentre = contentre+1
			SiNo
				Si num >= 70 Entonces
					contmayor = contmayor+1
				Fin Si
			Fin Si
		Fin Si
	Mientras Que cont != 10
	Escribir "Numeros menores que 25 " contmenor
	Escribir "Numeros mayores o iguales que 25 y menores de 70 " contentre
	Escribir "Numeros mayores o iguales que 70 " contmayor
FinAlgoritmo

