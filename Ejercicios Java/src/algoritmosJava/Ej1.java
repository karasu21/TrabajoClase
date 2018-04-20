package algoritmosJava;

import metodosString.Entrada;

public class Ej1 {

	public static void main(String[] args) {
		double nump, nums, suma, resta, producto, division;
		System.out.println("Introduzca numero");
		nump=Entrada.real();
		System.out.println("Introduzca numero");
		nums=Entrada.real();
		suma=nump+nums;
		resta=nump-nums;
		producto=nump*nums;
		division=nump/nums;
		System.out.println("La suma es " +suma);
		System.out.println("La resta es " +resta);
		System.out.println("El producto es " +producto);
		System.out.println("La division es " +division);

	}

}
