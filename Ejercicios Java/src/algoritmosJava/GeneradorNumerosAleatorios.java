package algoritmosJava;

import java.util.Random;

import metodosString.Entrada;

public class GeneradorNumerosAleatorios {

	public static void main(String[] args) {
		int desde, hasta;
		System.out.println("Introduzca hasta que numero");
		hasta = Entrada.entero();
		System.out.println("Introduzca desde que numero");
		desde = Entrada.entero();
		for (int i = 0; i <= 10; i++) {
			System.out.println("\n" + generarAleatorio(desde, hasta));
		}

	}

	private static int generarAleatorio(int desde, int hasta) {
		if (hasta < desde) {
			return 0;

		}
		Random r = new Random();
		int n = r.nextInt((hasta-desde)+1);
		return n+desde;
	}

}
