package algoritmosJava;

import metodosString.Entrada;

public class Ej3 {

	public static void main(String[] args) {
		double nump, nums, cnt;
		boolean divisor;
		System.out.println("Introduzca numero");
		nump = Entrada.real();
		System.out.println("Introduzca numero");
		nums = Entrada.real();
		if (nums > nump) {
			cnt = nump;
			nump = nums;
			nums = cnt;
		}
		divisor = nump % nums == 0 && nump != nums;
		if (nump == nums) {
			System.out.println("Division entre el mismo numero no aceptada");
		} else {
			if (divisor) {
				System.out.println(nums + " es divisor de " + nump);

			} else {
				System.out.println(nums + " no es divisor de " + nump);

			}

		}

	}

}
