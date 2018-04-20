//Lee un path por teclado, que debe exisir y ser un directorio
//Muestra el  tipo:Fich o Dir, nombre, tama�o y fecha-hora de modificaci�n de cada elemento del path
package rutasFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class InformacionDeUnaRuta {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.print("Introduzca ruta:");
		String path = Entrada.cadena();
		File d = new File(path);
		if (!d.exists()) {
			System.out.println(d.getCanonicalPath()+" no existe");
		}
		else {
			if (d.isDirectory())
				System.out.println("Directorio");
			else 
				System.out.println("Fichero");
			System.out.println("Tama�o en bytes: "+d.length());
			Date t=new Date();
			t.setTime(d.lastModified());
			String fh = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(t);
			System.out.println("Fecha/hora ultima modificacion: " + fh);
		}

		}
	};

