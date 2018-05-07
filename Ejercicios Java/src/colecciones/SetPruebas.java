package colecciones;

import java.util.Set;
import java.util.TreeSet;

public class SetPruebas {

	public static void main(String[] args) {
		Integer num;
		String dato;
		int repetido = 0;
		Set<Integer> s = new TreeSet<Integer>();
		do {
			System.out.println("Numero(fin)?");
			dato = Entrada.cadena();
			if (!dato.equals("fin") && dato.matches("[-+]?[0-9]+[.]?[0-9]*")) {
				num = Integer.valueOf(dato);
				if (!s.add(num)) {
					System.out.println("Valor ya introducido");
					repetido++;
				}
			}
		} while (!dato.equals("fin"));
		System.out.println("\nValores introducidos:");
		for (Integer i : s) {
			System.out.println(i);
				}
		System.out.println("Intentos duplicadoss: " + repetido);
	}

}
