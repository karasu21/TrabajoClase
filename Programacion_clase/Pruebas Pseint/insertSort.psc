Algoritmo InsertSort
	Definir cnt, i, j, arr, max, num, aux Como Entero
	Definir in como Texto
	max = 100
	cnt = 0
	Dimension arr[max]
	Repetir
		Escribir "Numero " cnt "?"
		Escribir " "
		Escribir "Para salir introduzca fin"
		Leer in
		Si in=="fin" || cnt==max Entonces
			Escribir "Adios"
		SiNo
			num=ConvertirANumero(in)
			arr[cnt] = num
			cnt = cnt + 1
		Fin Si
	Mientras Que in!="fin" && cnt!=1000
	i = 1
	Mientras i<cnt Hacer
		j = i
		Mientras j>0 && arr[j-1] > arr[j] Hacer
			aux = arr[j-1]
			arr[j-1]=arr[j]
			arr[j]=aux
			j = j-1
		FinMientras
		i = i + 1
	FinMientras
	Escribir ""
	Para i = 0 Hasta cnt-1 Con Paso 1 Hacer
		Escribir Sin Saltar arr[i], " "
	FinPara
	Escribir ""
FinAlgoritmo
