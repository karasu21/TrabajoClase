package Ej4;

import Ej1.Entrada;

public class ConjeturaUllman {

	public static void main(String[] args) {
		int num;
		do {
			System.out.println("Introduce un numero(nº>1)");
			num =Entrada.entero();
		} while (num<=1);
		do {
			System.out.print(num+",");
			if (num%2==0) {
				num=num/2;
			} else {
				num=num*3+1;
			}
			
		} while (num>1);
		System.out.println(num);
		
	}

}
