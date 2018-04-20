package manejoFicheros;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerBinario {

	public static void main(String[] args) throws IOException {
		System.out.println("Introduzca ruta archivo txt a leer");
		String rutaInt = Entrada.cadena();
		BufferedReader bfr = new BufferedReader(new FileReader(new File(rutaInt)));
		System.out.println("Numero Int:" + bfr.readLine());
		bfr.close();
		System.out.println("Introduzca ruta archivo bin a leer");
		String rutaBin = Entrada.cadena();
		DataInputStream dis = new DataInputStream(new FileInputStream(new File(rutaBin)));
		System.out.println("Numero Int:" +dis.readInt()+ dis.readLong()+dis.readShort());
		dis.close();

	}

}
