package rutasFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BuscarArchivos {

	public static void main(String[] args) throws IOException {
		boolean salir = true;
		File carpeta;
		String nombre;
		ArrayList <File> encontrado=new ArrayList<File>();
		do {
			System.out.println("Ruta donde buscar:");
			String ruta = Entrada.cadena();
			carpeta = new File(ruta);
			if (carpeta.exists() && carpeta.isDirectory()) {
				salir = false;
			} else {
				System.out.println("Ruta introducida no es una carpeta o no existe\n");
			}
		} while (salir);
		salir = true;
		do {
			System.out.println("Archivos cuyo nombre contenga:");
			nombre = Entrada.cadena();
			if (nombre.length() > 0) {
				salir = false;
			} else {
				System.out.println("No ha introducido ningun nombre\n");
			}
		} while (salir);
		ArrayList <File> archivos=buscarPorNombre(carpeta, nombre,encontrado);
		for (int i = 0; i <archivos.size(); i++) {
			System.out.println("");
			System.out.print(archivos.get(i).getCanonicalPath());
			System.out.print("\t(" + archivos.get(i).length()+" bytes)");
		}
		System.out.println("\n\nArchivos encontrados: "+ archivos.size());

	}

	private static ArrayList<File> buscarPorNombre(File donde, String que, ArrayList<File> encontrado) throws IOException {
		File[] lista = donde.listFiles();
		
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].isDirectory()) {
				buscarPorNombre(lista[i],que, encontrado);
			}
			if (lista[i].isFile()&& lista[i].toString().toLowerCase().indexOf(que.toLowerCase())!=-1) {
				encontrado.add(lista[i]);
			}
		}
		return encontrado;
	}

}
