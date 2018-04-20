package algoritmosJava;
import java.util.Random;

public class MatrizAleatoriaTraspuesta {

	public static void main(String[] args) {
		System.out.println("=== Matriz Aleatoria ===");
		int aleatoria[][]=crearAleatoria(2,10);
		mostrarMatriz(aleatoria);
		System.out.println("=== Matriz Traspuesta Aleatoria ===");
		int traspuesta[][] = trasponerMatriz(aleatoria);
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

	private static void mostrarMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.format("%4d", m[i][j]);
			}
			System.out.println();// Salto de linea tras escribir una fila
		}		
	}

	private static int[][] crearAleatoria(int filas, int cols) {
		// Crear la matriz y la rellena con numeros aleatorios del 0 al 9
				Random r = new Random();

				int[][] m = new int [filas][cols];
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m[0].length; j++) {
						m[i][j] = r.nextInt(10);// Genera numero aleatorio de entre 10 posibles: 0..9
					}
				}
				return m;
		
	}

}
