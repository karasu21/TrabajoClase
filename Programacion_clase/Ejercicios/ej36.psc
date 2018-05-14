Algoritmo sin_titulo
	Definir num, cnt, factorial Como Real
	Repetir
		Escribir "Introduzca un numero, para salir introduzca numero negativo"
		Leer num
		factorial=1
		Si num>=0 Entonces
			Para cnt<-1 Hasta num Con Paso 1 Hacer
				factorial=factorial*cnt
			Fin Para
			Escribir num "! = " factorial
		SiNo
			Escribir "Adios"
		Fin Si
	Hasta Que num<0
	
FinAlgoritmo
