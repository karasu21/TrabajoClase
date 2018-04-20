package algoritmosJava;

public class NumerosEnLetras {

	public static void main(String[] args) {
		int n = 0;
		do {

			do {
				System.out.println(" ");
				System.out.println("Introduzca un numero entre 1 y 999 (-1 para salir)");

				n = Entrada.entero();
			} while (n == 0 || n > 999 || n < -1);
			int ndigitos = numeroDigitos(n);
			int digitos[] = extraerDigitos(n, ndigitos);

			System.out.println(convertirEnteroEnTexto(digitos));

		} while (n != -1);

	}

	private static int[] extraerDigitos(int cifra, int ndigitos) {
		int cociente = cifra;
		int digitos[] = new int[ndigitos];
		for (int i = 0 ; i < digitos.length; i++) {
			digitos[i] = cociente % 10;
			cociente = cociente / 10;
		}

		return digitos;
	}

	private static int numeroDigitos(int n) {
		int cociente = n;
		int cnt = 0;
		do {
			cociente = cociente / 10;
			cnt = cnt + 1;
		} while (cociente != 0);
		return cnt;
	}

	private static String convertirEnteroEnTexto(int digitos[]) {
		String numero = "";

		if (digitos.length == 3) {
			switch (digitos[2]) {

			case 1:
				numero = " ciento";
				break;
			case 2:
				numero = " doscientos";
				break;
			case 3:
				numero = " trescientos";
				break;
			case 4:
				numero = " cuatrocientos";
				break;
			case 5:
				numero = " quinientos";
				break;
			case 6:
				numero = " seiscientos";
				break;
			case 7:
				numero = " setecientos";
				break;
			case 8:
				numero = " ochocientos";
				break;
			case 9:
				numero = " novecientos";
				break;

			default:
				numero = "";
				break;

			}
			switch (digitos[1]) {

			case 1:
				numero = numero + " diez";
				break;
			case 2:
				numero = numero + " veinti";
				break;
			case 3:
				numero = numero + " treinta";
				break;
			case 4:
				numero = numero + " cuarenta";
				break;
			case 5:
				numero = numero + " cincuenta";
				break;
			case 6:
				numero = numero + " sesenta";
				break;
			case 7:
				numero = numero + " setenta";
				break;
			case 8:
				numero = numero + " ochenta";
				break;
			case 9:
				numero = numero + " noventa";
				break;

			default:
				numero = numero + "";
				break;
			}
			switch (digitos[0]) {

			case 1:
				numero = numero + " uno";
				break;
			case 2:
				numero = numero + " dos";
				break;
			case 3:
				numero = numero + " tres";
				break;
			case 4:
				numero = numero + " cuatro";
				break;
			case 5:
				numero = numero + " cinco";
				break;
			case 6:
				numero = numero + " seis";
				break;
			case 7:
				numero = numero + " siete";
				break;
			case 8:
				numero = numero + " ocho";
				break;
			case 9:
				numero = numero + " nueve";
				break;
			default:
				numero = numero + "";
				break;

			}
			return numero;

		} else {
			if (digitos.length == 2) {
				switch (digitos[1]) {

				case 1:
					numero = " diez";
					break;
				case 2:
					numero = " veinti";
					break;
				case 3:
					numero = " treinta";
					break;
				case 4:
					numero = " cuarenta";
					break;
				case 5:
					numero = " cincuenta";
					break;
				case 6:
					numero = " sesenta";
					break;
				case 7:
					numero = " setenta";
					break;
				case 8:
					numero = " ochenta";
					break;
				case 9:
					numero = " noventa";
					break;

				default:
					numero = "";
					break;
				}
				switch (digitos[0]) {

				case 1:
					numero = numero + " uno";
					break;
				case 2:
					numero = numero + " dos";
					break;
				case 3:
					numero = numero + " tres";
					break;
				case 4:
					numero = numero + " cuatro";
					break;
				case 5:
					numero = numero + " cinco";
					break;
				case 6:
					numero = numero + " seis";
					break;
				case 7:
					numero = numero + " siete";
					break;
				case 8:
					numero = numero + " ocho";
					break;
				case 9:
					numero = numero + " nueve";
					break;
				default:
					numero = numero + "";
					break;

				}
				return numero;

			} else {
				if (digitos.length == 1) {
					switch (digitos[0]) {

					case 1:
						numero = " uno";
						break;
					case 2:
						numero = " dos";
						break;
					case 3:
						numero = " tres";
						break;
					case 4:
						numero = " cuatro";
						break;
					case 5:
						numero = " cinco";
						break;
					case 6:
						numero = " seis";
						break;
					case 7:
						numero = " siete";
						break;
					case 8:
						numero = " ocho";
						break;
					case 9:
						numero = " nueve";
						break;
					default:
						numero = "";
						break;

					}
					return numero;

				}
				return numero;
			}

		}

	}
}
