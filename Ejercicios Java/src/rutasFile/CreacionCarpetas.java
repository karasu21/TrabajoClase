package rutasFile;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CreacionCarpetas {

	public static void main(String[] args) throws IOException {
		String nueva;
		int que;
		do {
			System.out.println("1 - Crear carpeta");
			System.out.println("2 - Crear archivo");
			System.out.println("3 - Renombrar");
			System.out.println("4 - Borrar archivos");
			System.out.println("0- Salir");
			que = Entrada.entero();
			if (que != 0) {
				JFileChooser fc = new JFileChooser("/");
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.setDialogTitle("Seleccione carpeta");
				int opcion = fc.showOpenDialog(null);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					File ruta = fc.getSelectedFile();
					System.out.println("Origen: " + ruta.getAbsolutePath());
					switch (que) {
					case 1:
						System.out.println("Nombre de nueva carpeta: ");
						nueva = Entrada.cadena();
						crearCarpeta(ruta, nueva);
						break;
					case 2:
						System.out.println("Nombre de nuevo archivo: ");
						nueva = Entrada.cadena();
						crearArchivo(ruta, nueva);
						break;
					case 3:
						int aceptar = JOptionPane.showConfirmDialog(null, "¿Quiere renombrar los archivos de " + ruta.getAbsolutePath() + "?",
								"Borrar fichero", JOptionPane.OK_CANCEL_OPTION);
						switch (aceptar) {
						case JOptionPane.OK_OPTION:
							renombrarArchivo(ruta);
							break;

						case JOptionPane.CANCEL_OPTION:

							break;
						case JOptionPane.CLOSED_OPTION:
							
							break;
						}
						
						break;
					case 4:
						borrarArchivo(ruta);
						break;
					}
				}
			}
		} while (que != 0);
	}

	private static void borrarArchivo(File ruta) {
		File[] lista = ruta.listFiles();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].isDirectory()) {
				borrarArchivo(lista[i]);
			}
			if (lista[i].isFile()) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Quiere borrar " + lista[i].getAbsolutePath() + "?",
						"Borrar fichero", JOptionPane.OK_CANCEL_OPTION);
				switch (opcion) {
				case JOptionPane.OK_OPTION:
					lista[i].delete();
					break;

				case JOptionPane.CANCEL_OPTION:

					break;
				case JOptionPane.CLOSED_OPTION:
					
					break;
				}
			}
		}

	}

	private static void renombrarArchivo(File ruta) {
		File[] lista = ruta.listFiles();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].isDirectory()) {
				renombrarArchivo(lista[i]);
			}
			if (lista[i].isFile()) {
				File ruta2 = new File(lista[i].getAbsolutePath() + ".bk");
				lista[i].renameTo(ruta2);
			}
		}
	}

	private static void crearArchivo(File ruta, String nueva) throws IOException {
		File ruta2 = new File(ruta, nueva);
		if (!ruta2.createNewFile()) {
			System.out.println("Error al crear nuevo archivo");
		}
	}

	private static void crearCarpeta(File ruta, String nueva) {
		File ruta2 = new File(ruta, nueva);
		if (!ruta2.mkdirs()) {
			System.out.println("Error al crear nueva carpeta");
		}
	}
}
