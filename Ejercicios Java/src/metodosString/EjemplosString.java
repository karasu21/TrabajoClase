package metodosString;

public class EjemplosString {

	public static void main(String[] args) {
		// charAt
		System.out.println("===charAT===");
		String texto = "palabra";
		for (int i = 0; i < texto.length(); i++) {
			char texto2 = texto.charAt(i);
			System.out.println(texto2);
		}

		// subString
		System.out.println("===subString===");
		String texto2 = texto.substring(2, 6);
		System.out.println(texto2);

		// equals
		System.out.println("===equals===");
		texto2 = "palabra";
		if (texto.equals(texto2)) {
			System.out.println("Es igual");

		} else {
			System.out.println("No es igual");

		}
		// compareTo
		System.out.println("===compareTo===");
		String textocompara = "palabra";
		System.out.println("Introduce palabra");
		String textoentrada = Entrada.cadena();
		if (textoentrada.compareTo(textocompara) == 0) {
			System.out.println("Texto introducido es igual");

		} else {
			if (textoentrada.compareTo(textocompara) > 0) {
				System.out.println("Texto introducido es mayor");

			} else {
				if (textoentrada.compareTo(textocompara) < 0) {
					System.out.println("Texto introducido es menor");

				}

			}

		}

		// replace
		System.out.println("===replace===");
		texto2 = texto.replace("p", "b");
		System.out.println(texto2);

		// replaceAll
		System.out.println("===replaceAll===");
		texto2 = texto.replaceAll("pal", "cad");
		System.out.println(texto2);

		// toLowerCase y toUppercase
		System.out.println("===toLowerCase===");
		texto="Frase De Prueba";
		texto2= texto.toLowerCase();
		System.out.println(texto2);
		
		System.out.println("===toUpperCase===");
		texto2= texto.toUpperCase();
		System.out.println(texto2);
	}

}
