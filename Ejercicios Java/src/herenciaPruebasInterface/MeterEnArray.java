package herenciaPruebasInterface;

public class MeterEnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Persona[] pers = new Persona[5];

		pers[0] = new Persona("1", "Uno", 11);
		pers[1] = new Futbolista("2", "Dos", 22, "At.Madrid", 20);
		pers[2] = new Futbolista("3", "Tres", 33, "Valencia", 3);
		pers[3] = new Tenista("4", "Cuatro", 44, 4);
		pers[4] = new Tenista("5", "Cinco", 55, 5);
		
		Futbolista uno=new Futbolista();
		System.out.println(uno);
		uno.setNombre("Juan");
		System.out.println(uno);
		System.out.println(uno.getNombre());
		listarSoloPersonas(pers);
		
	}

	private static void listarSoloPersonas(Persona[] pers) {
		for (int i = 0; i < pers.length; i++) {
			if (pers[i] instanceof Persona && !(pers[i] instanceof Futbolista || pers[i] instanceof Tenista)) {
				System.out.println(pers[i]);
			}

		}
	}

}
