package rutasFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroCaracter {

	public static void main(String[] args) throws IOException {
		boolean mal = true;
		String ruta;
		File fichero;
		do {

			System.out.println("Ruta de fichero txt: ");
			ruta = Entrada.cadena();
			fichero = new File(ruta);
			if (fichero.exists() && fichero.isFile()) {
				mal = false;
			}
		} while (mal);
		int contenido;
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		int cnt = 0;
		// Leemos y mostramos linea a linea
		while ((contenido = br.read()) != -1) {
			System.out.print("Codigo Unicode: " + contenido);

			switch (contenido) {
			case 13:
				System.out.println(" Caracter:[\\r]");
				cnt++;
				break;
			case 10:
				System.out.println(" Caracter:[\\n]");
				cnt++;
				break;
			case 9:
				System.out.println(" Caracter:[\\t]");
				cnt++;
				break;
			default:
				System.out.println(" Caracter:[" + (char) contenido + "]");
				cnt++;
				break;
			}
			
		}
		// Cerramos fichero
		br.close();

		System.out.println("\nSe han leido " + cnt + " caracteres");
	}
}
