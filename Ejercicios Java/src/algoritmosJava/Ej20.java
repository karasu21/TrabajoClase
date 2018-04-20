package algoritmosJava;

import metodosString.Entrada;

public class Ej20 {

	public static void main(String[] args) {
		int opcion;
		do {
			mostrarMenu();
			opcion = Entrada.entero();
			if (opcionCorrecta(opcion)) {
				switch (opcion) {
				case 1:
					circulo();

					break;
				case 2:
					circunferencia();
					break;
				case 3:
					esfera();
					break;

				}

			} else {
				System.out.println("Opcion Incorrecta");

			}

		} while (opcion != 0);

	}

	private static void esfera() {
		System.out.println("Introduzca radio");
		@SuppressWarnings("unused")
		double radio = Entrada.real();
		System.out.println("El volumen de la esfera es: " + redondear(3, 2));

	}

	private static void circunferencia() {
		System.out.println("Introduzca radio");
		double radio = Entrada.real();
		System.out.println("La superficie de la circunferencia es: " + redondear((double) 2 * Math.PI * radio, 2));
	}

	private static void circulo() {
		System.out.println("Introduzca radio");
		double radio = Entrada.real();
		System.out.println("La longitud del circulo es; " + redondear(Math.PI * radio * radio, 2));
	}

	private static boolean opcionCorrecta(int opcion) {
		return opcion >= 0 && opcion <= 3;
	}

	private static void mostrarMenu() {
		System.out.println("\n1-Longitud del circulo");
		System.out.println("2-Superficie de la circunferencia");
		System.out.println("3-Volumen de la esfera");
		System.out.println("0-Salir");

		System.out.println("Elija una opcion:");

	}

	private static double redondear(double numero, int decimales) {
		return Math.rint(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
	}

}
