package colecciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JFileChooser;

public class MapEstadistica {

	public static void main(String[] args) {
		Map estadistica = null;
		Parejas p;
		ArrayList<Parejas> cadena = new ArrayList<Parejas>();
		JFileChooser fc = new JFileChooser("/");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("Seleccione fichero origen");
		int opcion = fc.showOpenDialog(null);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			File ruta = fc.getSelectedFile();
			estadistica = estadisticaPalabras(ruta, true);
		}
		Set<String> claves = estadistica.keySet();

		for (String palabra : claves) {
			System.out.println(palabra + " " + estadistica.get(palabra));
		}
		for (String palabra : claves) {
			p = new Parejas(palabra, (Integer) estadistica.get(palabra));
			cadena.add(p);
		}
		System.out.println(" ");
		Collections.sort(cadena);
		for (Parejas pareja : cadena) {
			System.out.println(pareja.getPalabra() + " " + pareja.getRepeticiones());
		}

	}

	private static Map<String, Integer> estadisticaPalabras(File ruta, boolean ignorar) {
		String contenido = null;
		BufferedReader br;
		Map<String, Integer> mapa = new TreeMap<String, Integer>();
		try {
			br = new BufferedReader(new FileReader(ruta));

			while ((contenido = br.readLine()) != null) {
				String[] palabras = contenido.split("[ .,;()¿?!¡]+");
				for (String palabra : palabras) {
					if (ignorar) {
						palabra = palabra.toLowerCase();
					}
					if (mapa.containsKey(palabra)) {
						mapa.put(palabra, mapa.get(palabra) + 1);
					} else {
						mapa.put(palabra, 1);
					}
				}
			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapa;
	}
}
