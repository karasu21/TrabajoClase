package algoritmosJava;

import metodosString.Entrada;

public class SumarMatrices {

	public static void main(String[] args) {
		int filas;
		int columnas;
		do {
			filas = leerFilas();
			columnas = leerColumnas();
			if (filas!=columnas) {
				System.out.println("Numero de filas y columnas distinto");
				
			}
		} while (filas!=columnas);
		
		int matriz1[][] = new int[filas][columnas];
		int matriz2[][] = new int[filas][columnas];
		int matriz3[][] = new int[filas][columnas];
		rellenarMatriz(matriz1, matriz2);
		sumarMatrices(matriz1, matriz2, matriz3);
		mostrarMatrizSuma(matriz3);
		

	}

	
	private static void sumarMatrices(int[][] matriz1, int[][] matriz2, int [][] matriz3) {
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[0].length; j++) {
				matriz3[i][j]=matriz1[i][j] + matriz2[i][j];
				
			}
	
		}
		
			
	}


	private static void mostrarMatrizSuma(int [][] matriz3) {
		for (int i = 0; i < matriz3.length; i++) {
			for (int j = 0; j < matriz3[0].length; j++) {
				System.out.print(matriz3[i][j] + " ");
	
			}
			System.out.println();
	
		}
		System.out.println();
	
	}


	private static void rellenarMatriz(int[][] matriz1, int[][] matriz2) {
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[0].length; j++) {
				System.out.println("Introduce numero matriz 1(fila "+(i+1)+" columna "+(j+1)+")");
				matriz1[i][j] = Entrada.entero();
				System.out.println("Introduce numero matriz 2(fila "+(i+1)+" columna "+(j+1)+")");
				matriz2[i][j] = Entrada.entero();

			}

		}
	}
	private static int leerFilas() {
		int filas;
		do {
			System.out.println("¿Nº de Filas?");
			filas = Entrada.entero();
			if (filas < 0) {
				System.out.println("Introduzca numero mayor de 0");
			}
		} while (filas < 0);
		return filas;
	}


	private static int leerColumnas() {
		int columnas;
		do {
			System.out.println("¿Nº de Columnas?");
			columnas = Entrada.entero();
			if (columnas < 0) {
				System.out.println("Introduzca numero mayor de 0");
			}
		} while (columnas < 0);
		return columnas;
	}
	}
	
	
	
	


