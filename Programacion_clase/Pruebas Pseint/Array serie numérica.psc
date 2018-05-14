Algoritmo sin_titulo
	Definir n,cnt Como Entero
	Dimension n[20]
	n[0]=0
	n[1]=3
	Para cnt<-2 Hasta 19 Con Paso 1 Hacer
		n[cnt]=n[cnt-1]+n[cnt-2]
	Fin Para
	Para cnt<-0 Hasta 19 Con Paso 1 Hacer
		Escribir n[cnt]
	Fin Para
FinAlgoritmo
