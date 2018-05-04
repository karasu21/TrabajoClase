package colecciones;

import java.util.Set;
import java.util.TreeSet;

public class SetUnionPrueba {

	public static void main(String[] args) {
		Integer num;
		String dato;
		Set<Integer> s1 = new TreeSet<Integer>();
		Set<Integer> s2 = new TreeSet<Integer>();
		do {
			System.out.println("Numero conjunto 1(fin)?");
			dato = Entrada.cadena();
			if (!dato.equals("fin") && dato.matches("[-+]?[0-9]+[.]?[0-9]*")) {
				num = Integer.valueOf(dato);
				if (!s1.add(num)) {
					System.out.println("Valor ya introducido");
				}
			}
		} while (!dato.equals("fin"));
		do {
			System.out.println("Numero conjunto 2(fin)?");
			dato = Entrada.cadena();
			if (!dato.equals("fin") && dato.matches("[-+]?[0-9]+[.]?[0-9]*")) {
				num = Integer.valueOf(dato);
				if (!s2.add(num)) {
					System.out.println("Valor ya introducido");
				}
			}
		} while (!dato.equals("fin"));
		System.out.println("\n1-Union");
		System.out.println("2-Interseccion");
		System.out.println("\nElija opcion: ");
		int op = Entrada.entero();
		switch (op) {
		case 1:
			s1.addAll(s2);
			System.out.println("\nValores union:");
			for (Integer i : s1) {
				System.out.println(i);
			}
			break;

		case 2:
			s1.retainAll(s2);
			System.out.println("\nValores Interseccion:");
			for (Integer i : s1) {
				System.out.println(i);
			}
			break;
		}

	}

}
