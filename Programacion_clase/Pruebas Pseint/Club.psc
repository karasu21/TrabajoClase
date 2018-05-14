Algoritmo Club
	Definir edad Como Entero
	Escribir "Introduzca Edad"
	Leer edad
	Si edad <= 0 Entonces
		Escribir "Error, Edad Incorrecta"
	SiNo
		Si edad >=150 Entonces
			Escribir "Error, Edad Incorrecta"
		SiNo
			Si edad <10 Entonces
				Escribir "No inscribible"
			SiNo
				Si edad <13 Entonces
					Escribir "Alevín"
				SiNo
					Si edad <16 Entonces
						Escribir "Infantil"
					SiNo
						Si edad <18 Entonces
							Escribir "Juvenil"
						SiNo
							Si edad >= 18 Entonces
								Escribir "Senior"
							SiNo
								
							Fin Si
						Fin Si
					Fin Si
				Fin Si
			Fin Si
		Fin Si
	Fin Si
FinAlgoritmo
