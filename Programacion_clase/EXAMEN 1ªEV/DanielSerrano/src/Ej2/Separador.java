package Ej2;

public class Separador {
	int getParteDecimal(double num) {
		char digito;
		boolean bien = false;
		String completo = String.valueOf(num);
		String decimalCadena = "";

		for (int i = 0; i < completo.length(); i++) {
			digito = completo.charAt(i);
			if (digito == '.') {
				bien = true;
			}
			if (bien && digito != '.') {
				decimalCadena = decimalCadena + String.valueOf(digito);
			}

		}

		Integer decimal = Integer.valueOf(decimalCadena);
		return decimal;

	}

	int getParteEntera(double num) {
		int cnt = 0;
		char digito;
		boolean bien = true;
		String completo = String.valueOf(num);
		String enteroCadena = "";
		do {

			digito = completo.charAt(cnt);
			if (digito == '.') {
				bien = false;
			} else {
				enteroCadena = enteroCadena + String.valueOf(digito);
			}
			cnt = cnt + 1;

		} while (bien);
		Integer entero = Integer.valueOf(enteroCadena);
		return entero;

	}

}
