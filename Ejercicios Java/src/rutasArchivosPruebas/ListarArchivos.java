package rutasArchivosPruebas;

import java.io.File;
import java.io.IOException;

public class ListarArchivos {

	public static void main(String[] args) throws IOException {
		String ruta;
		boolean salir = false;
		File[] contenido;

		do {

			System.out.println("\n" + "Introduce ruta(exit para salir)");
			ruta = Entrada.cadena();
			File archivo = new File(ruta);
			if (ruta.equals("exit")) {
				salir = true;
			}
			if (archivo.exists()) {
				contenido = archivo.listFiles();
				for (int i = 0; i < contenido.length; i++) {
					System.out.println(contenido[i].getCanonicalPath());
				}
			} else {
				System.out.println("No existe esta ruta");
			}

		} while (!salir);

	}
}
