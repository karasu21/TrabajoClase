Algoritmo sin_titulo
	Definir n Como Entero
	Escribir "Introduzca número:"
	Leer n
	Si n<-10000 || n>10000  Entonces
		Escribir "SOlo se admiten numeros entre -10000 y 10000"
	SiNo
		Si n>=1000 || n<=-1000 Entonces
			Escribir "Tiene 4 digitos"
		SiNo
			Si n>=100 || n<=-100 Entonces
				Escribir "Tiene 3 digitos"
			SiNo	
				Si n>=10 || n<=-10 Entonces
					Escribir "Tiene 2 digitos"
				SiNo	
				Si n>-10 Entonces
			Escribir "Tiene 1 digito"
		SiNo 
			
			
				
				
						
					Fin Si
				Fin Si
			Fin Si
		Fin Si
	Fin Si
FinAlgoritmo
