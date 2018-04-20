package algoritmosJava;

import java.util.Random;

import metodosString.Entrada;

public class MonedaRandom {

	public static void main(String[] args) {
		System.out.println("Escribe \"tirar\"para lanzar moneda" );
		String accion = Entrada.cadena();
		if (accion.equals("tirar")) {
			System.out.println(tirarMoneda());
			
		}
		else {
			System.out.println("Adios");
		}
		
		
	}

	private static String tirarMoneda() {
		Random r = new Random();
		int n = r.nextInt(2);
		
		@SuppressWarnings("unused")
		String posicion;
		if (n==0) {
			return posicion= "Cara";
			
			
		} else {
			
			return posicion= "Cruz";
		}

		};
	}


