package algoritmosJava;

public class TableroAjedrez {

	public static void main(String[] args) {
		String tablero[][] = new String[8][8];
		crearTablero(tablero);
		mostrarTablero(tablero);
	}

	private static void mostrarTablero(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				System.out.print(tablero[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void crearTablero(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if ((i + j) % 2 == 0) {
					tablero[i][j] = "B";

				} else {
					tablero[i][j] = "N";
				}
			}
		}
	}

}
