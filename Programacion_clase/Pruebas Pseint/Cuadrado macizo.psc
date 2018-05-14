Algoritmo sin_titulo
	Definir lado, cnt1, cnt2 Como Entero
	Definir pintura como caracter
	pintura="*"
	Repetir
		Escribir "¿Lado del cuadrado?"
		Leer lado
		Si lado<=0 Entonces
			Escribir "Error numero negativo"
		Fin Si
	Mientras Que lado<=0
	Para cnt1<-1 Hasta lado Con Paso 1 Hacer
		Para cnt2<-1 Hasta lado Con Paso 1 Hacer
			Escribir sin saltar pintura
		Fin Para
		Escribir " "
	Fin Para
	
	
	
	
	
	
	
FinAlgoritmo
