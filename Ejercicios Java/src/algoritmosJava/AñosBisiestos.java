package algoritmosJava;

import metodosString.Entrada;

public class A�osBisiestos {

	public static void main(String[] args) {

		System.out.println("Introduzca un a�o");
		int a�o = Entrada.entero();
		if (esBisiesto(a�o)) {
			System.out.println("Es bisiesto");

		} else {
			System.out.println("No es bisiesto");

		}
	}

	private static boolean esBisiesto(int a�o) {
		return a�o % 4 == 0 && a�o % 100 != 0 || a�o % 400 == 0;
	}

}
