Algoritmo sin_titulo
	Definir array, num, cont Como Entero
	Definir text Como Caracter
	Dimension array[1000]
	Repetir
		Escribir "Introduzca un numero"
		Escribir "Para finalizar introduzca fin"
		Leer text
		Si text=="fin" Entonces
			Escribir sin saltar "El orden es: "
		SiNo
			num=ConvertirANumero(text)
			Si num<0 Entonces
				array[num]=num
			SiNo
				array[500+num]=num
			Fin Si
		Fin Si
	Mientras Que text!="fin"
	Para cont<-0 Hasta 999 Con Paso 1 Hacer
		Escribir array[cont] ","
	Fin Para
FinAlgoritmo
