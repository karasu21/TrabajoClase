Algoritmo sin_titulo
	Definir  num, serie, i, ceros, cnt Como Entero
	Dimension serie[101]
	Para ceros<-0 Hasta 100 Con Paso 1 Hacer
		serie[ceros]=0
	Fin Para
	Repetir
		Escribir "Introduzca numero entre 100 y 200(0-para salir)"
		Leer num
		Si num !=0 && (num<100 || num>200) Entonces
			Escribir "Error"
		SiNo
			Si num>=100 && num<=200
				serie[num-100]=serie[num-100]+1
				Escribir "n= " serie[num-100]
			FinSi
		Fin Si
	Mientras Que num!=0
	Para i<-0 Hasta 100 Con Paso 1 Hacer
		Si serie[i]!=0 Entonces
			Escribir "El numero " i+100 " se repite " serie[i] " veces"
		Fin Si
	Fin Para
FinAlgoritmo
