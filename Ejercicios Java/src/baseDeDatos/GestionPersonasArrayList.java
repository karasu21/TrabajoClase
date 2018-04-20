package baseDeDatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
		m.agregarOpcion("Exportar a fichero");
		m.agregarOpcion("Importar desde fichero");
		m.agregarOpcion("Listado");

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
			pw.println(bd.get(i));
		}

		pw.close();
	}

}