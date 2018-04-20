package manejoFicheros;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import baseDeDatos.Entrada;

public class Binario {

	public static void main(String[] args) throws IOException {
		System.out.println("Introduzca numero");
		int n = manejoFicheros.Entrada.entero();
		long l= manejoFicheros.Entrada.entero();
		short s= 25;
		PrintWriter pw = new PrintWriter(new FileWriter(new File("E:\\PROGRAMACION\\Prueba\\numero.txt"), false));
		pw.print(n);
		pw.print(l);
		pw.print(s);
		pw.close();
		DataOutputStream dos = new DataOutputStream(
				new FileOutputStream(new File("E:\\PROGRAMACION\\Prueba\\numero.bin")));
		dos.writeInt(n);
		dos.writeLong(l);
		dos.writeShort(s);
		dos.close();
	}

}
