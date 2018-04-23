package manejoFicheros;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	}

}
