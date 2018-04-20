package algoritmosJava;

import metodosString.Entrada;

public class Ej24 {

	public static void main(String[] args) {
		System.out.println("Introduce temperatura");
		double gradosCelsius = Entrada.real();
		System.out.println(convertirAFahrenheit(gradosCelsius) + "ºF");
		System.out.println(convertirAKelvin(gradosCelsius) + "ºK");
		System.out.println(convertirAReamur(gradosCelsius) + "ºR");

	}

	private static double convertirAKelvin(double gradosCelsius) {
		return gradosCelsius + 273.0;

	}

	private static double convertirAFahrenheit(double gradosCelsius) {
		return ((gradosCelsius * 180.0) / 100.0) + 32;

	}

	private static double convertirAReamur(double gradosCelsius) {
		return (80.0 * gradosCelsius)/100.0;

	}

}
