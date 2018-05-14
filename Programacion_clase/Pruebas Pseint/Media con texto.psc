Algoritmo sin_titulo
	Definir n, m, s Como Real
	Definir txt Como caracter
        s = 0
		m = 0
		n = 0
		Repetir
			Escribir "Introduzca numero, para finalizar operacion escriba salir"
			Leer txt
			Si txt != "salir" Entonces
				n=ConvertirANumero(txt)
				m = m+1
				s = s + n
		    Fin Si
		Mientras Que txt != "salir"
	Si m == 0 Entonces
		Escribir "Adios"    
	SiNo
		Escribir "La media es " s/m
		Escribir "Adios"
	Fin Si
FinAlgoritmo

	
	
