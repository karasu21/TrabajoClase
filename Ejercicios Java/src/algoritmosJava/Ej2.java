package algoritmosJava;

import metodosString.Entrada;

public class Ej2 {

	public static void main(String[] args) {
		double nump, nums;
		System.out.println("Introduzca numero");
		nump=Entrada.real();
		System.out.println("Introduzca numero");
		nums=Entrada.real();
		if(nump>nums) {
			System.out.println("1�: "+nump);
			System.out.println("2�: "+nums);
		} else {
			System.out.println("1�: "+nums);
			System.out.println("2�: "+nump);
		}
		
	}

}
