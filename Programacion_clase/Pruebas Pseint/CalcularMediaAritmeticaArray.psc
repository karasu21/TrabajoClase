Algoritmo CalcularMediaDevariosNumeros
	//	El algoritmo solicita n�meros al usuario hasta que �ste introduce "fin" y muestra
	//  la media aritm�tica de los n�meros introducidos
	Definir cnt, i, maximo Como Entero //Contador de n�meros introducidos
	Definir suma Como Real //Va acumulando(sumando) los n�meros introducidos
	Definir salir Como Logico //Tomara el valor true cuando el usuario escriba "fin". La utilizaremos como condici�n del bucle
	Definir n Como Real //Numero leido
	Definir dato, num Como Caracter
	suma=0
	cnt=0
	maximo=5
	Dimension n[maximo]
	Repetir
		Escribir "Introduzca n�mero (fin-para salir):"
		Leer dato
		salir = dato=="fin"
		Si !salir Entonces
			n[cnt]=ConvertirANumero(dato)//Convertimos texto a n�mero
			suma=suma+n[cnt]
			cnt=cnt+1
			Fin Si
	Mientras Que !salir && cnt<maximo
	Si cnt>0 Entonces
		Escribir Sin Saltar "La media de "
		Para i<-0 Hasta cnt-1 Con Paso 1 Hacer
			Escribir sin saltar n[i]," "
		Fin Para
		Escribir "es ",suma/cnt
	Fin Si
FinAlgoritmo
