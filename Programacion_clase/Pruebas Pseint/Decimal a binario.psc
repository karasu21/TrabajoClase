Algoritmo sin_titulo
	Definir n, resto, dividendo, cnt como enteros
	Escribir "¿Numero base 10?"
	Leer n
	Dimension resto[1000]
	dividendo=n
	cnt=0
	Repetir
		resto[cnt]=dividendo%2
		dividendo=TRUNC(dividendo/2)
		cnt=cnt+1
	Mientras Que dividendo>0
	Para cnt<-cnt-1 Hasta 0 Con Paso -1 Hacer
		Escribir sin saltar resto[cnt]
	Fin Para
FinAlgoritmo
