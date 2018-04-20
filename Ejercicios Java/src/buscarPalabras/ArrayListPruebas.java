package buscarPalabras;

import java.util.ArrayList;
import java.util.Collections;

import Menu.Entrada;

public class ArrayListPruebas {

	public static void main(String[] args) {
		boolean salir = true;
		ArrayList<String> cadena = new ArrayList<String>();
		System.out.println("Cadena(fin-para salir)");
		do {
			String palabra = recogerPalabra();
			if (palabra.equals("fin")) {
				salir = false;
			} else {
				llenarCadena(cadena, palabra);
			}

		} while (salir);
		System.out.println("===Desordenado===");
		mostrarCadena(cadena);
		// Orden ascendente
		Collections.sort(cadena);
		System.out.println("===Orden ascendente===");
		mostrarCadena(cadena);
		// Orden descendente
		Collections.reverse(cadena);
		System.out.println("===Orden descendente===");
		mostrarCadena(cadena);

	}

	private static String aCamello(String palabra) {
		String palabrac = "";
		for (int i = 0; i < palabra.length(); i++) {
			char letra = palabra.charAt(i);
			String car = String.valueOf(letra);
			if (i % 2 == 0) {
				car = car.toUpperCase();

			}
			palabrac = palabrac + car;
		}

		return palabrac;
	}

	private static void mostrarCadena(ArrayList<String> cadena) {
		for (int i = 0; i < cadena.size(); i++) {
			System.out.println(aCamello(cadena.get(i)));

		}

	}

	private static void llenarCadena(ArrayList<String> cadena, String palabra) {
		cadena.add(palabra);
	}

	private static String recogerPalabra() {
		String palabra = Entrada.cadena().trim();

		return palabra;
	}

}
