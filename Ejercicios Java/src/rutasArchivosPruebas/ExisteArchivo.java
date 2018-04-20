package rutasArchivosPruebas;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExisteArchivo {

	public static void main(String[] args) throws IOException {
		String ruta;
		boolean salir=false;
		do {

			System.out.println("\n"+"Introduce ruta(exit para salir)");
			ruta = Entrada.cadena();
			File archivo = new File(ruta);
			if (ruta.equals("exit")) {
				 salir=true;
			}
			if (archivo.exists()) {
				System.out.println("\nNombre: " + archivo.getName());
				
				if (archivo.isDirectory()) {
					System.out.println("\nEs un directorio");
				} else {
					System.out.println("\nEs un fichero");
				}
				System.out.println("\nCanonicalPath: " + archivo.getCanonicalPath());
				System.out.println("\nAbsolutePath: " + archivo.getAbsolutePath());
				System.out.println("\nTamaño en bytes: " + archivo.length());
				long fechaMs = archivo.lastModified();
				Date fecha = new Date(fechaMs);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String ultimaModificacion = sdf.format(fecha);
				System.out.println("\n"+ultimaModificacion);

			} else {
				System.out.println("No existe esta ruta");
			}

		} while (!salir);

	}
}
