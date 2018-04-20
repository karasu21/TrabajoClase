package rutasFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class EstadisticaTexto {

	public static void main(String[] args) throws NumberFormatException, IOException {
		JFileChooser fc = new JFileChooser("/");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("Seleccione fichero");
		int opcion = fc.showOpenDialog(null);
		File ruta = new File("a");
		if (opcion == JFileChooser.APPROVE_OPTION) {
			ruta = fc.getSelectedFile();
		}
		String contenido;
		BufferedReader br = new BufferedReader(new FileReader(ruta));
		Integer total = 0;
		String[] cadena = new String[0];
		int palabras = 0;
		int vocal = 0;
		int consonante = 0;
		// Leemos y mostramos linea a linea
		while ((contenido = br.readLine()) != null) {
			cadena = contenido.split("[ ]");
			for (int i = 0; i < cadena.length; i++) {
				if (cadena[i].length() != 0) {
					palabras++;
					for (int j = 0; j < cadena[i].length(); j++) {
						char letra = (char) cadena[i].codePointAt(j);
						
						if (esVocal(letra)) {
							vocal++;

						} else {
							consonante++;
						}
					}

				}
			}

		}
		System.out.println("Palabras: " + palabras);
		System.out.println("Vocales: " + vocal);
		System.out.println("Consonantes: " + consonante);
	}

	private static boolean esVocal(char letra) {
		if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
			return true;

		}
		return false;

	}

	private static boolean esConsonante(char letra) {
		if (letra != 'a' || letra != 'e' || letra != 'i' || letra != 'o' || letra != 'u') {
			return true;
		}
		return false;

	}
	private static boolean esDigito(char letra) {
		String cadenaLetra="a";
		cadenaLetra.valueOf(letra);
		if (cadenaLetra.matches("[0-9]")) {
			return true;
		}
		return false;

	}
}
