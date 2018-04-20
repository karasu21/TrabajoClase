package algoritmosJava;

import metodosString.Entrada;

public class Ej4 {

	public static void main(String[] args) {
		double nump, nums, cnt;
		boolean divisor;
		System.out.println("Introduzca numero");
		nump = Entrada.real();
		System.out.println("Introduzca numero");
		nums = Entrada.real();
		if (nump == nums) {
			System.out.println(nump + " y " + nums + " son iguales");
		} else {
			if (nump > nums) {
				System.out.println(nump + " es mayor que " + nums);
			} else {
				System.out.println(nums + " es mayor que " + nump);

			}
			if (nums > nump) {
				cnt = nump;
				nump = nums;
				nums = cnt;
			}

		}
		divisor = nump%nums==0 && nump!=nums;
		if (nump==nums) {
			System.out.println("Division entre el mismo numero no aceptadas");
		} else {
			if (divisor) {
				System.out.println(nums+ " es divisor de " +nump);
			} else {
				System.out.println( nums+" no es divisor de "+nump);
			}
		}
		
	}

}
