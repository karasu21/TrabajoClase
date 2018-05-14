Algoritmo Calificacion
	Definir nota Como Entero
	Escribir "Introduzca nota"
	Leer nota
	Si nota<0 || nota>10 Entonces
		Escribir "Error, Nota Incorrecta"
	SiNo
		Si nota>=0 && nota<=4  Entonces
			Escribir "SUSPENSO"
		SiNo
			Si nota=5 || nota=6 Entonces
				Escribir "BIEN"
			SiNo
				Si nota=7 || nota=8 Entonces
					Escribir "NOTABLE"
				SiNo
					Si nota>8 Entonces
						Escribir "SOBRESALIENTE"
					Fin Si
				Fin Si
			Fin Si
		Fin Si
	Fin Si
FinAlgoritmo
