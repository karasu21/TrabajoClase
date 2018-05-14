Algoritmo sin_titulo
	Definir n, divisor Como Real
	Definir esprimo Como Logico
	divisor=2
	esprimo=Verdadero
	leer n
	Mientras divisor<=n-1 && esprimo Hacer
		Si n%divisor==0 Entonces
			esprimo=falso
		Fin Si
		divisor=divisor+1
	Fin Mientras
	Si esprimo Entonces
		Escribir n " es primo"
	SiNo
		Escribir n " no es primo"
	Fin Si
FinAlgoritmo
