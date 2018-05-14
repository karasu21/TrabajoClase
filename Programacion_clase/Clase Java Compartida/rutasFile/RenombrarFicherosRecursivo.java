//Lee un path por teclado, que debe exisir y ser un directorio
//Añade(renombra) .bk a todos los ficheros que cuelguen del path
package rutasFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JFileChooser;

public class RenombrarFicherosRecursivo {

	public static void main(String[] args) throws IOException {
		System.out.print("Carpeta dónde están los ficheros a renombrar: ");
		String t=Entrada.cadena();
		File donde=new File(t);
		if (!donde.exists()) {
			System.out.println(donde.getCanonicalPath()+" no existe");
			return;//En main equivale a terminar el programa
		}
		if (!donde.isDirectory()) {
			System.out.println(donde.getCanonicalPath()+" no es una carpeta");
			return;//En main equivale a terminar el programa
		}
		renombrarFicheros(donde,".bk");
		System.out.println("Finalizado.");
	}

	private static void renombrarFicheros(File donde, String sufijo) throws IOException {
		File[] lista = donde.listFiles();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].isDirectory()) {
				renombrarFicheros(lista[i], sufijo);
			} else{//Fichero
				File nuevaRuta=new File(lista[i].getCanonicalPath()+sufijo);//Nuevo nombre:ruta actual + sufijo
				if (!lista[i].renameTo(nuevaRuta))
					throw new RuntimeException("Error al renombrar fichero. "+lista[i].getCanonicalPath()+" a "+nuevaRuta.getCanonicalPath());
			}
		}
	}
}
