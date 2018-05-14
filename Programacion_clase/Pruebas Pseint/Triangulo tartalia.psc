Algoritmo sin_titulo
	Definir fila, nfilas, espacio, relleno, nuenumerotriangulo, anumerotriangulo, i Como Entero
	Dimension nuenumerotriangulo[1000]
	Dimension anumerotriangulo[1000]
	Repetir
		Escribir "¿Numero de filas?"
		Leer nfilas
		Si nfilas<=0 Entonces
			Escribir "Error numero negativo"
		Fin Si
	Mientras Que nfilas<=0
	Para fila<-1 Hasta nfilas Con Paso 1 Hacer
		Para espacio<-1 Hasta nfilas-fila Con Paso 1 Hacer
			Escribir Sin Saltar " "
		Fin Para
		Para relleno<-0 Hasta fila+fila-2 Con Paso 1 Hacer
			Si relleno==0 || relleno==fila+fila-2 Entonces
				nuenumerotriangulo[relleno]=1
				anumerotriangulo[relleno]=1
				Escribir sin saltar nuenumerotriangulo[relleno]
			SiNo
				Si relleno%2!=0 Entonces
					nuenumerotriangulo[relleno]=0
					Escribir sin saltar " "
				SiNo
					nuenumerotriangulo[relleno]=anumerotriangulo[relleno-2]+anumerotriangulo[relleno]
					Escribir sin saltar nuenumerotriangulo[relleno]
				Fin Si
			Fin Si
		Fin Para
		Para i<-0 Hasta fila+fila-2 Con Paso 1 Hacer
			Si i!=1 || i!=fila+fila-1 || i%2!=0 Entonces
				anumerotriangulo[i]=nuenumerotriangulo[i]
			Fin Si
			Fin Para
		Escribir " "
	
	Fin Para
	
FinAlgoritmo
