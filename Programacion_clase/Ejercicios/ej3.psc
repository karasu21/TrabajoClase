Algoritmo sin_titulo
	Definir nump, nums, cont Como Real
	Definir divisor Como Logico
	Escribir "Introduzca un numero"
	Leer nump
	Escribir "Introduzca un numero"
	Leer nums
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
