Algoritmo sin_titulo
	Definir num Como Entero
	Escribir "Introduzca numero de la semana"
	Leer num
	Si num>=1 && num<=7 Entonces
		Segun num Hacer
			1:
				Escribir "Lunes"
			2:
				Escribir "Martes"
			3:
				Escribir "Miercoles"
			4:
				Escribir "Jueves"
			5:
				Escribir "Viernes"
			6:
				Escribir "Sabado"
			7:
				Escribir "Domingo"
		Fin Segun
	SiNo
		Escribir "Error, escriba un numero entre 1 y 7"
	Fin Si
	
FinAlgoritmo
