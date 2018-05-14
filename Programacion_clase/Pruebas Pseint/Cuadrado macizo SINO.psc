Algoritmo sin_titulo
	Definir lado, cnt1, cnt2 Como Entero
	Definir pintura como caracter
	Definir respuesta como caracter
	Definir contorno como logico
	
	pintura="*"
	Repetir
		Escribir "¿Lado del cuadrado?"
		Leer lado
		Si lado<=0 Entonces
			Escribir "Error numero negativo"
		Fin Si
	Mientras Que lado<=0
	Repetir
		Escribir "¿Es Macizo? (SI/NO)"
		Leer respuesta
		Si respuesta!="SI" && respuesta!="NO" Entonces
			Escribir "Introduzca SI o NO"
		Fin Si
	Mientras Que respuesta!="SI" && respuesta!="NO"
	Para cnt1<-1 Hasta lado Con Paso 1 Hacer
		Para cnt2<-1 Hasta lado Con Paso 1 Hacer
			contorno=cnt1==1 || cnt1==lado || cnt2==1 || cnt2==lado
				Si respuesta=="SI" || contorno Entonces
					Escribir sin saltar pintura
				SiNo
					Escribir sin saltar " "
				Fin Si
			Fin Para
			Escribir " "
		Fin Para	
FinAlgoritmo
