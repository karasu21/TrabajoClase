package Ej2;

public class Menu {

	public static void main(String[] args) {
		double num;
		int op;
		boolean salir = true;
		Separador numero = new Separador();
		System.out.println("Introduce un numero");
		num = Entrada.real();

		do {
			System.out.println("\nElija opcion");
			System.out.println(" Obtener parte entera--->1");
			System.out.println(" Obtener parte decimal--->2");
			System.out.println("\nPara salir introduzca 0");
			op = Ej3.Entrada.entero();
			switch (op) {
			case 1:
				System.out.println("Parte entera: " + numero.getParteEntera(num));
				break;
			case 2:
				System.out.println("Parte decimal: " + numero.getParteDecimal(num));
				break;
			case 0:
				salir = false;
				break;
			}
		} while (salir);

	}

}
