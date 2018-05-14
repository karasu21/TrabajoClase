Algoritmo sin_titulo
	Definir text Como Caracter
	Definir cnt25, cnt2570, cnt70, menos25, entre2570, mas70, cnt, a, num como entero
	Dimension menos25[1000]
	Dimension entre2570[1000]
	Dimension mas70[1000]
	cnt=1
	cnt25=0
	cnt2570=0
	cnt70=0
	Repetir
		Escribir "Numero " cnt "?"
		Escribir " "
		Escribir "Para salir introduzca fin"
		Leer text
		cnt=cnt+1
		Si text=="fin" || cnt==1000 Entonces
			Escribir "Adios"
		SiNo
			num=ConvertirANumero(text)
			Si num<25 Entonces
				menos25[cnt25]=num
				cnt25=cnt25+1
			SiNo
				Si num>=25 && num<70 Entonces
					entre2570[cnt2570]=num
					cnt2570=cnt2570+1
				SiNo
					Si num>70 Entonces
						mas70[cnt70]=num
						cnt70=cnt70+1
					Fin Si
				Fin Si
			Fin Si
		Fin Si
	Mientras Que text!="fin" && cnt!=1000
	Escribir ""
	Escribir sin saltar cnt25 " menores de 25: "
	Para a<-0 Hasta cnt25-1 Con Paso 1 Hacer
		Escribir sin saltar menos25[a], ","
	Fin Para
	Escribir ""
	Escribir sin saltar cnt2570 " entre 25 y 70: "
	Para a<-0 Hasta cnt2570-1 Con Paso 1 Hacer
		Escribir sin saltar entre2570[a], ","
	Fin Para
	Escribir ""
	Escribir Sin Saltar cnt70 " mayores de 70: "
	Para a<-0 Hasta cnt70-1 Con Paso 1 Hacer
		Escribir sin saltar mas70[a], ","
	Fin Para
	Escribir ""
	
FinAlgoritmo
