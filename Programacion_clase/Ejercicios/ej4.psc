Algoritmo sin_titulo
	Definir nump, nums, cont como Real
	Definir divisor como Logico
	Escribir "Introduzca numero"
	Leer nump
	Escribir "Introduzca numero"
	Leer nums
	Si nump==nums Entonces
		Escribir nump " y " nums " son iguales"
	SiNo
		Si nump>nums Entonces
			Escribir nump " es mayor que " nums
		SiNo
			Escribir nums " es mayor que " nump
		Fin Si
	Fin Si
	Si nums>nump Entonces
		cont = nump
		nump = nums
		nums = cont
	Fin Si
	divisor = nump%nums==0 && nump!=nums
	Si nump==nums Entonces
		Escribir "Division entre el mismo numero no aceptadas"
	SiNo
		Si divisor Entonces
			Escribir nums " es divisor de " nump
		Sino
			Escribir nums " no es divisor de " nump	
		Fin Si	
	Fin Si
FinAlgoritmo
