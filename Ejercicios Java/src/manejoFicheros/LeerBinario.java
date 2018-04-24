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
		String rutaBin = "E:\\PROGRAMACION\\Prueba\\Personas.bin";
		DataInputStream dis = new DataInputStream(new FileInputStream(new File(rutaBin)));
		try {
			while (true) {
				String dni = dis.readUTF();
				String nombre = dis.readUTF();
				char sexo = dis.readChar();
				String fecha = dis.readUTF();
				double altura = dis.readDouble();
				double peso = dis.readDouble();
				System.out.println(dni + ";" + nombre + ";" + sexo + ";" + fecha + ";" + altura + ";" + peso);
			}
		} catch (Exception e) {

			dis.close();
		}

	}

}
