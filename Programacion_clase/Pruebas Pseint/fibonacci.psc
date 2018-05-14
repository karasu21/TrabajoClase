Algoritmo sin_titulo
	Definir numserie, serie, long como entero
	Dimension serie[1000]
	Escribir "Introduzca la longitud de la serie"
	Leer long
	Si long==1 Entonces
		Escribir sin saltar "0"
	SiNo
		Si long==1 Entonces
			Escribir sin saltar "0 1"
		SiNo
			serie[1]=0
			serie[2]=1
			Para numserie<-3 Hasta long Con Paso 1 Hacer
				serie[numserie]=serie[numserie-1]+serie[numserie-2]
				
			Fin Para
			Para numserie<-1 Hasta long Con Paso 1 Hacer
				Escribir Sin Saltar serie[numserie]
			Fin Para
			
		Fin Si
	Fin Si
FinAlgoritmo
