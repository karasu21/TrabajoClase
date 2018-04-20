package rutasArchivosPruebas;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;

public class SeleccionarFicheros {

	public static void main(String[] args) {
		JFileChooser fc=new JFileChooser("/");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setDialogTitle("Seleccione fichero origen");
		int opcion=fc.showOpenDialog(null);
		if (opcion==JFileChooser.APPROVE_OPTION){
			File ruta=fc.getSelectedFile();
			mostrarDirectorio(ruta);
			
		}
	}

	private static void mostrarDirectorio(File ruta) {
		File[] contenido;
		contenido = ruta.listFiles();
		for (int i = 0; i < contenido.length; i++) {
			
			System.out.format("%-40s", contenido[i].getName());
			if (contenido[i].isDirectory()) {
				System.out.format("%-20s","Directorio");
			} else {
				System.out.format("%-20s","Fichero");
				System.out.format("%-20s","Tamaño: " + contenido[i].length());
				long fechaMs = contenido[i].lastModified();
				Date fecha = new Date(fechaMs);
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String ultimaModificacion = sdf.format(fecha);
				System.out.format("%-20s","Última modificacion: "+ultimaModificacion);
				
			}
			
			System.out.println("");
		}
		
		
	}

}
