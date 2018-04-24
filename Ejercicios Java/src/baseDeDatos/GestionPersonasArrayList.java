package baseDeDatos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class GestionPersonasArrayList {

	private static ArrayList<Persona> bd;

	public static void main(String[] args) throws ParseException, IOException {
		// Crea array bd don se almacenaran las personas. Contiene referencias a objetos
		// de clase Persona
		// Estas referencias inicialmente estan con valor null
		Date d;
		bd = new ArrayList<Persona>();
		Collections.sort(bd);
		Persona a = new Persona("Ana", d = new Date(), 'H', 70, 200);
		Persona b = new Persona("Pepe", d = new Date(), 'H', 80, 100);
		Persona c = new Persona("Ana", d = new Date(), 'M', 50, 100);
		Persona e = new Persona("Ines", d = new Date(), 'M', 70, 100);
		bd.add(a);
		bd.add(b);
		bd.add(c);
		bd.add(e);

		Collections.sort(bd, new OrdenacionPorPeso());
		Menu1DAM m = new Menu1DAM("\n== Gestión de Personas ==", true);
		m.agregarOpcion("Altas");
		m.agregarOpcion("Bajas");
		m.agregarOpcion("Modificaciones");
		m.agregarOpcion("Consultas");
		m.agregarOpcion("Listado (ordenado por Nombre)");
		m.agregarOpcion("Listado (ordenado por Edad)");
		m.agregarOpcion("Listado (ordenado por Altura)");
		m.agregarOpcion("Listado (ordenado por DNI)");
		m.agregarOpcion("Exportar a fichero txt");
		m.agregarOpcion("Importar desde fichero txt");
		m.agregarOpcion("Exportar a Personas.html");
		m.agregarOpcion("Exportar a Personas.bin");
		m.agregarOpcion("Importar desde Personas.bin");

		m.agregarOpcion("Salir");
		String op;
		do {
			m.mostrar();
			op = m.leerOpcion();
			switch (op) {
			case "1":
				altas();
				break;
			case "2":
				bajas();
				break;
			case "3":
				modificaciones();
				break;
			case "4":
				consultas();
				break;
			case "5":
				listadoPorNombre();
				break;
			case "6":
				listadoPorEdad();
				break;
			case "7":
				listadoPorAltura();
				break;
			case "8":
				listadoPorDNI();
				break;
			case "9":
				exportarBD();
				break;
			case "10":
				importarFichero();
				break;
			case "11":
				exportarAHtml();
				break;
			case "12":
				exportarABin();
				break;
			case "13":
				importarBin();
				break;
			}
		} while (!op.equals("0"));
		System.out.println("ADIOS.");
	}

	private static void listado() {
		System.out.println("--> Listado de personas");

		for (int i = 0; i < bd.size(); i++) {
			System.out.println(bd.get(i));

		}
	}

	private static void consultas() {
		System.out.println("--> Consulta de persona");
		String dni;
		do {
			System.out.println("DNI de prueba: " + ValidarDni.generarNIFAleatorio(false));
			System.out.println("DNI?");
			dni = Entrada.cadena();
			if (!ValidarDni.esNIF(dni)) {
				System.out.println("Introduzca DNI valido");
			}
		} while (!ValidarDni.esNIF(dni));
		if (buscar(dni) != -1) {
			int posicion = buscar(dni);
			System.out.println(bd.get(posicion));
		} else {
			System.out.println("DNI no registrado");
		}

	}

	private static void modificaciones() {

	}

	private static void bajas() {
		System.out.println("--> Baja de persona");
		String dni;
		do {
			System.out.println("DNI de prueba: " + ValidarDni.generarNIFAleatorio(false));
			System.out.println("DNI?");
			dni = Entrada.cadena();
			if (!ValidarDni.esNIF(dni)) {
				System.out.println("Introduzca DNI valido");
			}
		} while (!ValidarDni.esNIF(dni));

		if (buscar(dni) != -1) {
			int posicion = buscar(dni);
			bd.remove(posicion);
		} else {
			System.out.println("DNI no registrado");
		}
	}

	private static void altas() {

		// DNI
		String dni;
		boolean existe;
		do {
			existe = false;
			do {

				System.out.println("DNI de prueba: " + ValidarDni.generarNIFAleatorio(false));
				System.out.println("DNI?");
				dni = Entrada.cadena();
				if (!ValidarDni.esNIF(dni)) {
					System.out.println("Introduzca DNI valido");
				}
			} while (!ValidarDni.esNIF(dni));
			if (buscar(dni) != -1) {
				existe = true;
				System.out.println("DNI ya existe");
			}
		} while (existe);

		// Nombre

		String nombre = Entrada.cadenaVal("Nombre?", "Nombre incorrecto", "[A-Za-z].*", false);

		// Sexo

		String sexo2 = Entrada.cadenaVal("Sexo(HMO)?", "Sexo incorrecto", "[HMO]", false);
		char sexo = sexo2.charAt(0);

		// Fecha de nacimiento

		Date fecha = Entrada.fechaVal("Fecha de nacimiento(dd-mm-aaaa)?", "Fecha incorrecta", "dd-MM-yyyy", false);

		// Peso

		double peso = Entrada.realVal("Peso?", "Peso incorrecto", 20, 200, false);

		// Altura

		double altura = Entrada.realVal("Altura?", "Altura incorrecta", 10, 500, false);

		Persona p = new Persona(nombre, fecha, sexo, peso, altura);
		bd.add(p);
	}

	// Devuelve posicion del array donde se encuentra el dni . Devuelve -1 si no
	// existe
	private static int buscar(String dni) {
		for (int i = 0; i < bd.size(); i++) {
			if (bd.get(i).getDni().equals(dni)) {
				return i;
			}
		}
		return -1;
	}

	private static void listadoPorAltura() {
		System.out.println("--> Listado de personas por altura (descentente)");
		// Ordena por Altura(Comparator)
		Collections.sort(bd, new OrdenacionPorAltura());
		for (int i = 0; i < bd.size(); i++)
			System.out.println(bd.get(i));

	}

	private static void listadoPorDNI() {
		System.out.println("--> Listado de personas por DNI");
		// Ordena por Edad(Comparator)
		Collections.sort(bd, new OrdenacionPorDNI());
		for (int i = 0; i < bd.size(); i++)
			System.out.println(bd.get(i));

	}

	private static void listadoPorEdad() {
		System.out.println("--> Listado de personas por edad (descentente)");
		// Ordena por Edad(Comparator)
		Collections.sort(bd, new OrdenacionPorEdad());
		for (int i = 0; i < bd.size(); i++)
			System.out.println(bd.get(i));

	}

	private static void listadoPorNombre() {
		System.out.println("--> Listado de personas por nombre");
		// Ordena con criterio por defecto(Comparable)
		Collections.sort(bd);
		for (int i = 0; i < bd.size(); i++)
			System.out.println(bd.get(i));
	}

	private static void importarFichero() {
		// TODO Auto-generated method stub

	}

	private static void exportarBD() throws IOException {
		System.out.println("Introduce ruta donde se creara el archivo: ");
		String ruta = Entrada.cadena();
		PrintWriter pw = new PrintWriter(new FileWriter(new File(ruta), true));
		for (int i = 0; i < bd.size(); i++) {
			pw.println(bd.get(i).getNombre() + ";" + bd.get(i).getDni() + ";" + bd.get(i).getSexo() + ";"
					+ bd.get(i).getAnios() + ";" + bd.get(i).getAltura() + ";" + bd.get(i).getPeso());
		}

		pw.close();

		System.out.println("Base de datos guardada en " + ruta);
	}

	private static void exportarAHtml() throws IOException {
		System.out.println("Introduce ruta donde se creara el archivo: ");
		String ruta = "E:\\PROGRAMACION\\Prueba\\Personas.html";
		PrintWriter pw = new PrintWriter(new FileWriter(new File(ruta), false));
		pw.println("<!DOCTYPE HTML>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Base de datos Personas</title>\r\n" + "<style>\r\n" + "table { margin-left: auto;\r\n"
				+ "margin-right: auto;" +

				"margin-left: auto;\r\n" + "margin-right: auto;\r\n" + "text-align: center;\r\n"
				+ "border: 1px solid black;\r\n" + "width: 800px;\r\n" + "height: auto;}\r\n"
				+ "td { border: 1px solid black;\r\n" + "width: 30%;\r\n" + "}" + "</style>\r\n" + "</head>\r\n"
				+ "<body>");
		pw.println("<table>\r\n" + "<tr>\r\n" + "<td>DNI</td>\r\n" + "<td>Nombre</td>\r\n" + "<td>Sexo</td>\r\n"
				+ "<td>Edad</td>\r\n" + "<td>Altura</td>\r\n" + "<td>Peso</td>\r\n" + "</tr>");

		for (int i = 0; i < bd.size(); i++) {
			pw.println("<tr>\r\n" + "<td>" + bd.get(i).getDni() + "</td>\r\n" + "<td>" + bd.get(i).getNombre()
					+ "</td>\r\n" + "<td>" + bd.get(i).getSexo() + "</td>\r\n" + "<td>" + bd.get(i).getAnios()
					+ "</td>\r\n" + "<td>" + bd.get(i).getAltura() + "</td>\r\n" + "<td>" + bd.get(i).getPeso()
					+ "</td>\r\n" + "</tr>");
		}

		pw.println("</table>\r\n" + "</body>\r\n" + "</html>");
		pw.close();
		System.out.println("\nPersona.html creado");
	}

	private static void importarBin() throws IOException {
		String rutaBin = "E:\\PROGRAMACION\\Prueba\\Personas.bin";
		DataInputStream dis = new DataInputStream(new FileInputStream(new File(rutaBin)));
		Persona p = null;
		try {
			while (true) {
				String dni = dis.readUTF();
				String nombre = dis.readUTF();
				char sexo = dis.readChar();
				String fechaC = dis.readUTF();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				sdf.setLenient(false);
				Date d;
				d = sdf.parse(fechaC);
				double altura = dis.readDouble();
				double peso = dis.readDouble();
				p = new Persona(nombre, d, sexo, peso, altura);
				bd.add(p);
			}
		} catch (Exception e) {

			dis.close();
		}
		
	}

	private static void exportarABin() throws IOException {
		String ruta = "E:\\PROGRAMACION\\Prueba\\Personas.bin";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(ruta)));
		for (int i = 0; i < bd.size(); i++) {
			dos.writeUTF(bd.get(i).getNombre());
			dos.writeUTF(bd.get(i).getDni());
			dos.writeChar(bd.get(i).getSexo());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = sdf.format(bd.get(i).getFechaNac());
			dos.writeUTF(fecha);
			dos.writeDouble(bd.get(i).getAltura());
			dos.writeDouble(bd.get(i).getPeso());
		}

		dos.close();

		System.out.println("Base de datos guardada en " + ruta);

	}

}