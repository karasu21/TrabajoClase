Algoritmo MaximoMinimo
	Definir max, min Como Entero
	Definir act Como Caracter
	Definir ter Como Logico
	ter = Verdadero
	Escribir "Escriba un numero (fin para salir):"
	Leer act
	min =  ConvertirANumero(act)
	max = min
	Repetir
		Escribir "Escriba un numero (fin para salir):"
		Leer act
		Si act = "fin" entonces
			ter = Falso
		FinSi
		Si ter Y ConvertirANumero(act)<min Entonces
			min = ConvertirANumero(act)
		FinSi
		Si ter Y max<ConvertirANumero(act) Entonces
			max = ConvertirANumero(act)
		FinSi
	Mientras Que ter
	Escribir "El maximo es: ", max
	Escribir "El minimo es: ", min
FinAlgoritmo
