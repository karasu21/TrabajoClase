Algoritmo sin_titulo
	Definir nump, nums, numt como Real
	Escribir "introduzca numero"
	Leer nump
	Escribir "introduzca numero"
	Leer nums
	Escribir "introduzca numero"
	Leer numt
	Si nump>nums && nums>numt Entonces
		Escribir nump
		Escribir nums
		Escribir numt
	SiNo
		Si numt>nump && nums>nump Entonces
			Escribir numt
			Escribir nums
			Escribir nump
		SiNo
			Si nums>nump && nump>numt Entonces
				Escribir nums
				Escribir nump
				Escribir numt
			SiNo
				Si nump>numt && numt>nums Entonces
					Escribir nump
					Escribir numt
					Escribir nums
				SiNo
					Si nump>nums && numt>nump Entonces
						Escribir numt
						Escribir nump
						Escribir nums
					SiNo
						Si nums>numt && numt>nump Entonces
							Escribir nums
							Escribir numt
							Escribir nump
						Fin Si
					Fin Si
				Fin Si
			Fin Si
		Fin Si
	Fin Si
FinAlgoritmo
