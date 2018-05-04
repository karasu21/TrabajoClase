package tuberias;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PruebaErrOut {

	public static void main(String[] args) {
		String palabra = " ";
		do {
			System.out.println("Introduce palabras(blanco para salir)");
			InputStreamReader flujo = new InputStreamReader(System.in);
			BufferedReader teclado = new BufferedReader(flujo);
			try {
				palabra = teclado.readLine().toUpperCase();
			} catch (Exception e) {
				System.out.append("Entrada incorrecta)");
			}
			System.out.println(palabra);
		} while (palabra.length() != 0);
	}

}
