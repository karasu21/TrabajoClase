package corregidosProfesor;

import java.util.Random;

import metodosString.Entrada;

public class SolucionMatricesProfesor {

	public static void main(String[] args) {
		System.out.print("Filas?");
		int filas = Entrada.entero();
		System.out.print("Columnas?");
		int cols = Entrada.entero();

		// Creamos matriz mediante un metodo que hace lo mismo que: int[][] m=new
		// int[filas][cols];
		int[][] m = crearMatriz(filas, cols);
		// Rellenar la matriz
		rellenarMatriz(m, 0);
		// Escribir la matriz en consola
		System.out.println("== Matriz a cero ==");
		mostrarMatriz(m);
		// Matrices diagonal, triangular superior e inferior. Solo si la matriz es
		// cuadrada(filas==cols)
		if (esCuadrada(m)) {
			System.out.println("== Matriz diagonal ==");
			int[][] m2 = crearMatrizDiagonal(filas, cols, 1);
			mostrarMatriz(m2);
			System.out.println("== Matriz Triangular Superior ==");
			int[][] m3 = crearMatrizTriangularSuperior(filas, cols, 1);
			mostrarMatriz(m3);
			System.out.println("== Matriz Triangular Inferior ==");
			int[][] m4 = crearMatrizTriangularInferior(filas, cols, 1);
			mostrarMatriz(m4);
		}

		// Aritmetica de matrices
		System.out.println("== ARITMETICA DE MATRICES ==");

		int[][] m6 = { { 7, 8 }, { 9, 10 }, { 11, 12 } };
		int[][] m7 = { { 7, 8, 9 }, { 10, 11, 12 } };

		System.out.println("== m5(valores aleatorios) ==");
		int[][] m5 = crearMatrizAleatoria(2, 3);
		mostrarMatriz(m5);
		System.out.println("== m6(valores fijos) ==");
		mostrarMatriz(m6);
		System.out.println("== m7(valores fijos) ==");
		mostrarMatriz(m7);
		System.out.println("== m5 + m7 ==");
		int[][] res = sumarMatrices(m5, m7);
		mostrarMatriz(res);
		System.out.println("== m5 - m7 ==");
		res = restarMatrices(m5, m7);
		mostrarMatriz(res);
		System.out.println("== m5 x m6 ==");
		res = multiplicarMatrices(m5, m6);
		mostrarMatriz(res);
		System.out.println("== Crea Matriz Aleatoria de 5 filas y 6 columnas ==");
		res = crearMatrizAleatoria(5, 6);
		mostrarMatriz(res);
		System.out.println("== Matriz aleatoria traspuesta ==");
		int traspuesta[][] = trasponerMatriz(res);
		mostrarMatriz(traspuesta);
	}

	private static int[][] trasponerMatriz(int[][] m5) {
		int t[][] = new int[m5[0].length][m5.length];
		for (int i = 0; i < m5.length; i++) {
			for (int j = 0; j < m5[0].length; j++) {
				t[j][i] = m5[i][j];
			}

		}
		return t;
	}

	private static int[][] crearMatrizTriangularInferior(int filas, int cols, int valor) {
		// Creamos matriz
		int[][] m = crearMatriz(filas, cols);
		// Poner valor en los elementos de la diagonal y cero en el resto
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (i >= j)// Elemento en triangulo inferior
					m[i][j] = valor;
				else
					m[i][j] = 0;
			}
		}
		return m;
	}

	private static int[][] crearMatrizTriangularSuperior(int filas, int cols, int valor) {
		// Creamos matriz
		int[][] m = crearMatriz(filas, cols);
		// Poner valor en los elementos de la diagonal y cero en el resto
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (i <= j)// Elemento en triangulo superior
					m[i][j] = valor;
				else
					m[i][j] = 0;
			}
		}
		return m;
	}

	private static int[][] crearMatrizDiagonal(int filas, int cols, int valor) {
		// Creamos matriz
		int[][] m = crearMatriz(filas, cols);
		// Poner valor en los elementos de la diagonal y cero en el resto
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (i == j)// Elemento en diagonal
					m[i][j] = valor;
				else
					m[i][j] = 0;
			}
		}
		return m;
	}

	private static boolean esCuadrada(int[][] m) {
		// Numero de filas igual a numero de columnas
		return m.length == m[0].length;
	}

	private static void mostrarMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.format("%4d", m[i][j]);
			}
			System.out.println();// Salto de linea tras escribir una fila
		}
	}

	private static void rellenarMatriz(int[][] m, int valor) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = valor;
			}
		}
	}

	private static int[][] crearMatriz(int filas, int cols) {
		int[][] matriz = new int[filas][cols];

		return matriz;
	}

	private static int[][] crearMatrizAleatoria(int filas, int cols) {
		// Crear la matriz y la rellena con numeros aleatorios del 0 al 9
		Random r = new Random();

		int[][] m = crearMatriz(filas, cols);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = r.nextInt(10);// Genera numero aleatorio de entre 10 posibles: 0..9
			}
		}
		return m;
	}

	private static int[][] multiplicarMatrices(int[][] a, int[][] b) {
		// Numero de columnas de a debe ser igual a numero de filas de b
		// sin son distintos no multiplicamos
		if (a[0].length != b.length)
			return null;
		// Resultado tiene filas de a y columnas de b
		int[][] m = new int[a.length][b[0].length];
		// Ponemos 0 la matriz recien creada
		rellenarMatriz(m, 0);

		// Vamos generando la matriz resultado: m
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				// Recorremos fila i de a y columna j de b
				for (int k = 0; k < a[0].length; k++) {
					m[i][j] = m[i][j] + a[i][k] * b[k][j];
				}
			}
		}

		return m;
	}

	private static int[][] sumarMatrices(int[][] a, int[][] b) {
		if (!mismaDimension(a, b))
			return null;
		int[][] m = new int[a.length][a[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = a[i][j] + b[i][j];
			}
		}
		return m;
	}

	private static int[][] restarMatrices(int[][] a, int[][] b) {
		if (!mismaDimension(a, b))
			return null;
		int[][] m = new int[a.length][a[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				m[i][j] = a[i][j] - b[i][j];
			}
		}
		return m;
	}

	private static boolean mismaDimension(int[][] a, int[][] b) {

		return a.length == b.length && a[0].length == b[0].length;
	}

}