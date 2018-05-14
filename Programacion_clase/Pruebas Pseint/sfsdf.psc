Algoritmo sin_titulo
	Definir num, numenor, numayor como entero	
	Definir text Como Caracter
	Escribir "Introduzca un numero"
	Escribir " "
	Escribir "Para salir introduzca fin"
	Leer text
	Si text=="fin" Entonces
		Escribir "Adios"
	SiNo
		num=ConvertirANumero(text)
		numenor=num
		numayor=num
	Fin Si
	Repetir
		Escribir "Introduzca un numero"
		Escribir " "
		Escribir "Para salir introduzca fin"
		Leer text
		Si text=="fin" Entonces
			Escribir "Adios"
		SiNo
			num=ConvertirANumero(text)
			Si num<numenor Entonces
				numenor=num
			Fin Si
			Si num>numayor Entonces
				numayor=num
			Fin Si
		Fin Si
		
		
	Mientras Que text!="fin"
	Escribir "El mayor es " numayor
	Escribir "El menor es " numenor
	
FinAlgoritmo
