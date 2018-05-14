Algoritmo sin_titulo
	Definir hueco, fila, nfilas, cnt1, aster Como Entero
	Definir respuesta como caracter
	Definir contorno como logico
	Repetir
		Escribir "¿Filas del triangulo?"
		Leer nfilas
		Si nfilas<=0 Entonces
			Escribir "Error numero negativo"
		Fin Si
	Mientras Que nfilas<=0
	Repetir
		Escribir "¿Es Macizo? (SI/NO)"
		Leer respuesta
		Si respuesta!="SI" && respuesta!="NO" Entonces
			Escribir "Introduzca SI o NO"
		Fin Si
	Mientras Que respuesta!="SI" && respuesta!="NO"
	
	Para fila<-1 Hasta nfilas Con Paso 1 Hacer //Este "para" establecer el numero de filas que especificó el usuario
			Para cnt1<-1 Hasta nfilas-fila Con Paso 1 Hacer
				Escribir Sin Saltar " "
			Fin Para
			Para aster<-1 Hasta fila+fila-1 Con Paso 1 Hacer
				Si respuesta=="SI" || aster==1 || fila==nfilas || aster==fila+fila-1   Entonces
					Escribir sin saltar "*"
				SiNo
					Escribir Sin Saltar " "
				Fin Si
			Fin Para
		Escribir " "
	Fin Para
	
		
FinAlgoritmo


