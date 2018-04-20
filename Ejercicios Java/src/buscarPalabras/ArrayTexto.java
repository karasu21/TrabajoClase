package buscarPalabras;

public class ArrayTexto {

	public static void main(String[] args) {
		int posicion;
		String[] pal = { "perro", "gato", "pez", "rana" };
		pal[2] = null;
		posicion = buscar(pal, "rana");
		System.out.println(posicion);
		pal=aniadirPalabra(pal, "puente");
		for (int i = 0; i < pal.length; i++) {
			System.out.println(pal[i]);
			
		}
		borrarPalabra(pal,"gato");
		for (int i = 0; i < pal.length; i++) {
			System.out.println(pal[i]);
			
		}
		
		eliminarPalabra(pal,"perro");

	}



	private static void eliminarPalabra(String[] pal, String string) {
		String pal2[]=new String[pal.length-1];
		for (int i = 0; i < pal2.length; i++) {
			
		}
		
	}



	private static void borrarPalabra(String[] pal, String palabra) {
		int posicion=buscar(pal,palabra);
		if (posicion!=-1) {
			pal[posicion]=null;
			
		} 
	}

	private static String[] aniadirPalabra(String[] pal, String npalabra) {
		String[] pal2 = new String[pal.length + 1];
		for (int i = 0; i < pal2.length; i++) {
			if (i == pal2.length - 1) {
				pal2[i] = npalabra;

			} else {
				if (pal[i] != null) {
					pal2[i] = pal[i];

				}

			}

		}
		return pal2;

	}

	private static int buscar(String[] pal, String palabra) {
		int posicion = -1;
		for (int i = 0; i < pal.length; i++) {
			if (pal[i] != null) {
				if (pal[i].equals(palabra)) {
					posicion = i;

				}

			}

		}

		return posicion;

	}

}
