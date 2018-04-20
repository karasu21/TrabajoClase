package algoritmosJava;

import metodosString.Entrada;

public class AñosBisiestos {

	public static void main(String[] args) {

		System.out.println("Introduzca un año");
		int año = Entrada.entero();
		if (esBisiesto(año)) {
			System.out.println("Es bisiesto");

		} else {
			System.out.println("No es bisiesto");

		}
	}

	private static boolean esBisiesto(int año) {
		return año % 4 == 0 && año % 100 != 0 || año % 400 == 0;
	}

}
