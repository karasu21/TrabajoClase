package algoritmosJava;

import java.util.Random;

public class Aleatorio {

	public static void main(String[] args) {
		System.out.println(tirarDado());

	}

	private static int tirarDado() {
		Random r= new Random();
		int n= r.nextInt(6);
		return n+1;
	}

}
