Algoritmo sin_titulo
	Definir num, cont, numpositivo, numnegativo Como Real
	numpositivo=0
	numnegativo=0
	Para cont<-1 Hasta 10 Con Paso 1 Hacer
		Escribir "Introduzca numero" 
		Leer num
		Si num>=0 Entonces
			numpositivo=numpositivo+1
		Fin Si
		Si num<0 Entonces
			numnegativo=numnegativo+1
		Fin Si
	Fin Para
	Escribir "Total de números positivos " numpositivo
	Escribir "Total de números negativos " numnegativo
FinAlgoritmo
