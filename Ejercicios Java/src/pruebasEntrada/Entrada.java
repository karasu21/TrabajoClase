package pruebasEntrada;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Entrada {
	static String inicializar() {
		String buzon = "";
		InputStreamReader flujo = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(flujo);
		try {
			buzon = teclado.readLine();
		} catch (Exception e) {
			System.out.append("Entrada incorrecta)");
		}
		return buzon;
	}

	public static int entero() {
		int valor = Integer.parseInt(inicializar());
		if (valor <= -273) {
			System.out.println("Temperatura incorecta");
		}
		return valor;
	}

	public static double real() {
		double valor = Double.parseDouble(inicializar());
		return valor;
	}

	public static String cadena() {
		String valor = inicializar();
		return valor;
	}

	public static char caracter() {
		String valor = inicializar();
		return valor.charAt(0);
	}

	public static Date fecha(String formato, String error, boolean exc) {
		boolean bien;
		Date d = null;
		do {
			bien = true;
			String valor = inicializar();
			if (valor.length() == 0 && exc) {
				throw new RuntimeException("ENTER(cadena vacia)");

			} else if (valor.length() == 0 && !exc) {
				System.out.println("Valor en blanco");
				bien = false;
			}

			else {
				SimpleDateFormat sdf = new SimpleDateFormat(formato);
				sdf.setLenient(false);
				d = new Date();
				try {
					d = sdf.parse(valor);
				} catch (ParseException e) {
					bien = false;
					System.out.println(error);
				}

			}
			

		} while (!bien);

		return d;

	}

	public static int enteroVal(String newSolicitud, String newError, int min, int max) {
		boolean bien = true;
		String valor;
		int num = 0;
		do {
			bien = true;
			System.out.println(newSolicitud);
			valor = inicializar();
			if (valor.length() == 0) {
				System.out.println("Valor en blanco");
				bien = false;

			} else {
				try {
					num = Integer.valueOf(valor);

				} catch (Exception e) {
					System.out.println("Valor no numérico");
					bien = false;
				}
				if ((num < min || num > max) && bien) {
					System.out.println(newError);
					bien = false;
				}

			}

		} while (!bien);

		return num;
	}

	public static double realVal(String newSolicitud, String newError, int min, int max, boolean exc) {
		boolean bien = true;
		String valor;
		double num = 0;
		do {
			bien = true;
			System.out.println(newSolicitud);
			valor = inicializar();
			if (valor.length() == 0 && exc) {
				throw new RuntimeException("ENTER(cadena vacia)");

			} else if (valor.length() == 0 && !exc) {
				System.out.println("Valor en blanco");
				bien = false;
			}

			else {
				try {
					num = Double.parseDouble(valor);

				} catch (Exception e) {
					System.out.println("Valor no numérico");
					bien = false;
				}
				if ((num < min || num > max) && bien) {
					System.out.println(newError);
					bien = false;
				}

			}

		} while (!bien);

		return num;
	}
}