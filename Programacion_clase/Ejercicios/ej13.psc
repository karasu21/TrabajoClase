Algoritmo sin_titulo
	Definir n, digito, dividendo como Entero
	Escribir "Introduzca numero"
	digito=0
	leer n
	dividendo=n
	Repetir
		dividendo = TRUNC(dividendo / 10)
		digito = digito+1
	Mientras Que dividendo != 0
	Escribir n " tiene " digito " digitos" 
FinAlgoritmo
