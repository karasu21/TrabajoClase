package algoritmosJava;

public class Metodo {

	public static void main(String[] args) {
		
		saludar(5);
		despedirse(30);
		repetirMensaje("Hola", 5);
		repetirMensaje("Adios", 30);

	}

	private static void repetirMensaje(String texto, int veces) {
		for (int i = 1; i <= veces; i++) {
			System.out.println(texto);
		}
		
	}

	private static void despedirse(int veces) {
		for (int i = 1; i <= veces; i++) {
			System.out.println("Adios");
		}
		
			
	}

	private static void saludar(int veces) {
		for (int i = 1; i <= veces; i++) {
			System.out.println("Hola");
		}
			

	}

}

