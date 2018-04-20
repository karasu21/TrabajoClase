package rutasFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

	public static void main(String[] args) throws IOException {
		boolean mal = true;
		String ruta;
		File fichero;
		do {

			System.out.println("Ruta de fichero CSV: ");
			ruta = Entrada.cadena();
			fichero = new File(ruta);
			if (fichero.exists() && fichero.isFile()) {
				mal = false;
			}
		} while (mal);
		String contenido;
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		contenido = br.readLine();// Lineas de cabecera
		Integer total = 0;
		int cnt = 0;
		// Leemos y mostramos linea a linea
		while ((contenido = br.readLine()) != null) {
			System.out.println(contenido);
			String[] campos = contenido.split("[;]");
			total += Integer.valueOf(campos[2]);
			cnt++;

		}
		// Cerramos fichero
		br.close();
		System.out.println("Precio total de " + cnt + " coches: " + total);

	}

}
