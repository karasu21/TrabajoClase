package algoritmosJava;

import java.util.Random;

public class EnPlan {

	public static void main(String[] args) {
		System.out.println("Que significa \"en plan\"?");
		for (int i = 1; i <= 5; i++) {
			System.out.println(enPlan());

		}

	}

	private static String enPlan() {
		Random r = new Random();
		int n = r.nextInt(5);
		String significado = "";
		switch (n) {
		case 0:
			significado = "Es decir";

			break;
		case 1:
			significado = "Por ejemplo";

			break;
		case 2:
			significado = "Como..";

			break;
		case 3:
			significado = "Hamburguesa con queso";

			break;
		case 4:
			significado = "Me voy de viaje";

			break;

		}
		return significado;
	}
}
