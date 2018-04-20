package Menu;

public class AplicacionQueUsaMenu {

	public static void main(String[] args) {
		Menu1DAM m = new Menu1DAM("==BANCO==", false);
		m.agregarOpcion("Altas");
		m.agregarOpcion("Cuentas");
		m.agregarOpcion("Salir");
		String op;
		do {
			m.mostrar();
			op = m.leerOpcion();
			switch (op) {
			case "a":
				System.out.println("Altas");
				break;
			case "b":
				System.out.println("Cuentas");
				break;

			
			}
		} while (!op.equals("z"));
	
		
	}
	
	

}

