package Ej5;

import Ej4.Entrada;

public class MetodoCesar {

	public static void main(String[] args) {
		String texto;
		do {
			System.out.println("Intoduce texto a cifrar(mayusculas)");
			texto = Entrada.cadena();
		} while (!texto.matches("[A-Z]*"));

		Cifrado palabra = new Cifrado(texto);
		System.out.print("Palabra cifrada: ");
		System.out.print(palabra.cifradoCesar());

	}

}
