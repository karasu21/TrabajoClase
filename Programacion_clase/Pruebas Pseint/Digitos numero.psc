Algoritmo sin_titulo
	Definir num, digito, dividendo, resto como Entero
	Escribir "Introduzca numero"
	digito=0
	leer num
	dividendo=num
	Repetir
		resto = dividendo%10
		dividendo = TRUNC(dividendo / 10)
		digito = digito+1
		Escribir resto
	Mientras Que dividendo != 0
	Escribir digito " Digitos" 
FinAlgoritmo
