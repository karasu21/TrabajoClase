package examen;


public class Ejercicio2 {

	public static void main(String[] args) {
		int filas=0;
		int columnas=0;
		do {
		System.out.println("Introduce numero de filas");
		filas=Entrada.entero();
		System.out.println("Introduce numero de columnas");
		columnas=Entrada.entero();
		} while (filas<0 || columnas<0);
		int matriz[][]=new int[filas][columnas];
		rellenarMatriz(matriz);
		System.out.println("---Matriz---");
		mostrarMatriz(matriz);
		int matrizt[][]=trasponerMatriz(filas,columnas,matriz);
		System.out.println("---Matriz traspuesta---");
		mostrarMatriz(matrizt);
	}

	private static int[][] trasponerMatriz(int filas, int columnas, int[][] matriz) {
		int matrizt[][]=new int[columnas][filas];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matrizt[j][i]=matriz[i][j];
				
				
			}
			
		}
		
		return matrizt;
	
		
	}

	private static void mostrarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.format("%3d",matriz[i][j]);
				
				
			}
			System.out.println(" ");
		}		
	}

	private static void rellenarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.println("Introduzca numero - posicion("+ (i+1) + "," +(j+1) +")");
				matriz[i][j]=Entrada.entero();
				
			}
			
		}
		
	}

}
