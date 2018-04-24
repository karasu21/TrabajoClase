package manejoFicheros;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DesdeHasta {

	public static void main(String[] args) throws IOException {
		System.out.println("Introduce numero (desde)");
		int desde = Entrada.entero();
		System.out.println("Introduce numero (hasta)");
		int hasta = Entrada.entero();
		PrintWriter pw = new PrintWriter(new FileWriter(new File("E:\\PROGRAMACION\\Prueba\\desdeHasta.txt"), false));
		DataOutputStream dos = new DataOutputStream(
				new FileOutputStream(new File("E:\\PROGRAMACION\\Prueba\\desdeHasta.bin")));
		for (int i = desde; i <= hasta; i++) {
			dos.writeInt(i);
			pw.println(i);
		}
		dos.close();
		pw.close();
		String contenido;
		System.out.println("Introduce ruta de archivo a leer: ");
		String rutaBin = Entrada.cadena();
		DataInputStream dis = new DataInputStream(new FileInputStream(new File(rutaBin)));
		try {
			while (true) {
				int numero = dis.readInt();
				System.out.println(numero);
			}
		} catch (Exception e) {

			dis.close();
		}

	}

}
