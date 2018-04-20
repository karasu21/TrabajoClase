package algoritmosJava;

import metodosString.Entrada;

public class Matriz {

	public static void main(String[] args) {
		int filas;
		int columnas;
		filas = leerFilas();
		columnas = leerColumnas();
		int matriz[][] = new int[filas][columnas];
		if (esCuadrada(matriz)) {
			crearMatrizIdentidad(matriz);
			mostrarMatriz(matriz);
			crearMatrizTriangularSuperior(matriz);
			mostrarMatriz(matriz);
			crearMatrizTriangularInferior(matriz);
			mostrarMatriz(matriz);

		} else {
			crearMatriz(matriz);
			mostrarMatriz(matriz);
		}

	}
	

	private static void crearMatrizTriangularInferior(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (j<=i) {
					matriz[i][j] = 1;

				} else {
					matriz[i][j] = 0;
				}

			}

		}		
	}


	private static void crearMatrizTriangularSuperior(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (j>=i) {
					matriz[i][j] = 1;

				} else {
					matriz[i][j] = 0;
				}

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


	private static void crearMatrizIdentidad(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (i == j) {
					matriz[i][j] = 1;

				} else {
					matriz[i][j] = 0;
				}

			}

		}
	}


	private static boolean esCuadrada(int[][] matriz) {
		return matriz.length == matriz[0].length;

	}

	private static void mostrarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");

			}
			System.out.println();

		}
		System.out.println();
	}

	private static void crearMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = 0;

			}

		}
	}

}
