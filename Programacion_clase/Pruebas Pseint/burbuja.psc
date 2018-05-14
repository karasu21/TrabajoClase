Algoritmo sin_titulo
	Definir num, cnt, i, j, principal, aux Como Entero
	Definir dato Como Caracter
	Dimension principal[1000]
	cnt=0
	Repetir
		Escribir "Introduzca un numero"
		Leer dato
		Si dato=="fin" Entonces
			Escribir " "
		SiNo
			num=ConvertirANumero(dato)
			principal[cnt]=num
			cnt=cnt+1
		Fin Si
	Mientras Que dato!="fin"
	Para i<-0 Hasta cnt-1 Con Paso 1 Hacer
		Para j<-0 Hasta cnt-(i+1) Con Paso 1 Hacer
			Si principal[i]<principal[j] Entonces
				aux = principal[i]
				principal[i] = principal[j]
				principal[j] = aux
				
			Fin Si
		Fin Para
	Fin Para
	Para i<-0 Hasta cnt-1 Con Paso 1 Hacer
		Escribir sin saltar principal[i] " "
	Fin Para
	
FinAlgoritmo
