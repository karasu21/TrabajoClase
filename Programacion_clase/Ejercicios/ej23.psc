Algoritmo sin_titulo
	Definir cantidad, conversion Como Reales
	Definir unidad como caracter
	Escribir "Cantidad?"
	Leer cantidad
	Escribir "Unidad?"
	Leer unidad
	Si unidad=="P" || unidad=="C" Entonces
		Si unidad=="P" Entonces
			conversion=cantidad*2.54
			Escribir cantidad "in=" conversion "cm"
		SiNo
			conversion=cantidad/2.54
			Escribir cantidad "cm=" conversion "in"
		Fin Si
	SiNo
		Escribir "Error, introduzca P o C"
	Fin Si
	
FinAlgoritmo
