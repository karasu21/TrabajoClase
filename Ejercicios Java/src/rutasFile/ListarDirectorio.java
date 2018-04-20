//Lee un path por teclado, que debe exisir y ser un directorio
//Muestra el  tipo:Fich o Dir, nombre, tamaño y fecha-hora de modificación de cada elemento del path
package rutasFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFileChooser;

public class ListarDirectorio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFileChooser fc = new JFileChooser("/");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setDialogTitle("Seleccione carpeta");
		int opcion = fc.showOpenDialog(null);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			File ruta = fc.getSelectedFile();
			System.out.println(ruta.getAbsolutePath());
			mostrarDirectorio(ruta);
		}

	}

	private static void mostrarDirectorio(File d) {

		System.out.println("\nContenido de:" + d.getAbsolutePath());

		File[] lista = d.listFiles();
		for (int i = 0; i < lista.length; i++) {
			// Nombre
			System.out.format(" "+"%-30s", lista[i].getName());
			// Tipo
			if (lista[i].isDirectory()) {
				System.out.print("Directorio");
			} else
				System.out.print("Fichero\t");
			if (lista[i].isFile()) {
				// Tamaño
				System.out.print("Tamaño: " + lista[i].length() + "bytes\t");
				String fh = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(lista[i].lastModified()));
				System.out.print("Fecha/hora modif.: " + fh);
			}
			System.out.println();
		}
		for (int j = 0; j < lista.length; j++) {
			if (lista[j].isDirectory()) {
				mostrarDirectorio(lista[j]);
			}
		}

	}

}
