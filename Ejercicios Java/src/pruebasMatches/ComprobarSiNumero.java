package pruebasMatches;

import time.Entrada;

public class ComprobarSiNumero {

	public static void main(String[] args) {
		String cadena;
		do {
			System.out.println("Introduzca numero");
			cadena = Entrada.cadena();
			boolean num = esNumero(cadena);
			boolean matricula = esMatricula(cadena);
			boolean telefono = esTelefono(cadena);
			boolean email = esEmail(cadena);
			boolean nif = esNif(cadena);

			if (telefono) {
				System.out.println("Es un telefono");

			} else {
				System.out.println("No es un telefono");

			}

			if (matricula) {
				System.out.println("Es una matricula");

			} else {
				System.out.println("No es un matricula");

			}
			if (cadena.matches("[9]{1}[0-9]{8}") || (cadena.matches("[6]{1}[0-9]{8}"))) {
				System.out.println("No es un numero");

			} else {
				if (num) {
					System.out.println("Es un numero");

				} else {
					System.out.println("No es un numero");

				}

			}
			if (email) {
				System.out.println("Es un email");

			} else {
				System.out.println("No es un email");

			}
			if (nif) {
				System.out.println("Es un DNI");

			} else {
				System.out.println("No es un DNI");

			}

		} while (!cadena.equals("salir") && !cadena.equals("SALIR"));

	}

	private static boolean esNif(String nif) {
		if (nif.matches("[0-9]{1,8}[A-Za-z]")) {
			return true;

		} else {

			return false;
		}
	}

	private static boolean esEmail(String email) {
		if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})")) {
			return true;

		} else {

			return false;
		}
	}

	private static boolean esTelefono(String telefono) {
		if (telefono.matches("[9]{1}[0-9]{8}") || (telefono.matches("[6]{1}[0-9]{8}"))) {
			return true;

		} else {

			return false;
		}
	}

	private static boolean esMatricula(String matricula) {
		if (matricula.matches("[0-9]{4}[ -]?[B-DF-HJ-NPR-TV-Z]{3}")) {
			return true;

		} else {

			return false;
		}
	}

	private static boolean esNumero(String numero) {
		if (numero.matches("[-+]?[0-9]+[.]?[0-9]*")) {
			if (numero.charAt(numero.length() - 1) == '.') {
				return false;

			} else {
				return true;

			}

		} else {

			return false;
		}

	}
}
