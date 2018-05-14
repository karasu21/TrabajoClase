Algoritmo sin_titulo
	Definir num1, num2, opc, resultado como real
	Repetir
		Escribir " "
		Escribir "¿Que operacion desea realizar?"
		Escribir "1-suma"
		Escribir "2-resta"
		Escribir "3-multiplicacion"
		Escribir "4-division"
		Escribir " "
		Escribir "0-Salir"
		Leer opc
		Si opc==0 Entonces
			Escribir "Adios"
		SiNo
				Escribir "Introduzca primer número"
				Leer num1
				Escribir "Introduzca segundo número"
				Leer num2
				Segun opc Hacer
					1:
						resultado=num1+num2
						Escribir "El resultado es " resultado 
					2:
						resultado=num1-num2
						Escribir "El resultado es " resultado 
					3:
						resultado=num1*num2
						Escribir "El resultado es " resultado 
					4:
						resultado=num1/num2
						Escribir "El resultado es " resultado 
					De Otro Modo:
						Escribir num1 " y " num2	
				Fin Segun
			
		Fin Si
	Hasta Que opc==0
FinAlgoritmo

