package baseDeDatos;

import java.text.ParseException;
import java.util.Date;

public class GestionPersonasArray {

	private static Persona[] bd;
	private final static int MAX_PERSONAS = 100;

	public static void main(String[] args) throws ParseException {
		// Crea array bd donde se almacenaran las personas. Contiene referencias a
		// objetos de clase Persona
		// Estas referencias inicialmente estan con valor null
		bd = new Persona[MAX_PERSONAS];

		Menu1DAM m = new Menu1DAM("\n== Gestión de Personas ==", true);
		m.agregarOpcion("Altas");
		m.agregarOpcion("Bajas");
		m.agregarOpcion("Modificaciones");
		m.agregarOpcion("Consultas");
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
				listado();
				break;
			}
		} while (!op.equals("0"));
		System.out.println("ADIOS.");
	}

	private static void listado() {
		System.out.println("--> Listado de personas");
		for (int i = 0; i < bd.length; i++) {
			if (bd[i] != null) {
				System.out.println(bd[i]);

			}
		}
	}

	private static void consultas() {
		System.out.println("--> Consulta de persona");
		int pos = 0;
		String dni;
		do {
			System.out.println("DNI?");
			dni = Entrada.cadena();
			if (!ValidarDni.esNIF(dni)) {
				System.out.println("Introduzca DNI valido");
			}
		} while (!ValidarDni.esNIF(dni));
		for (int i = 0; i < bd.length; i++) {

			if (buscar(dni) != -1) {

				pos = buscar(dni);

			} else {
				pos = -1;
			}
		}
		if (pos == -1) {
			System.out.println("DNI no registrado");
		} else {
			System.out.println(bd[pos]);
		}
	}

	private static void modificaciones() {
		System.out.println("--> Modificacion de persona ");
		int pos = 0;
		String dni;
		do {
			System.out.println("DNI?");
			dni = Entrada.cadena();
			if (!ValidarDni.esNIF(dni)) {
				System.out.println("Introduzca DNI valido");
			}
		} while (!ValidarDni.esNIF(dni));
		for (int i = 0; i < bd.length; i++) {

			if (buscar(dni) != -1) {

				pos = buscar(dni);

			} else {
				pos = -1;
			}
		}
		if (pos == -1) {
			System.out.println("DNI no registrado");
		} else {
			Persona p = bd[pos];
			// Nombre
			try {
				p.setNombre(Entrada.cadenaVal("Nombre?" + "(" + p.getNombre() + ")", "Nombre incorrecto", "[A-Za-z].*",
						true));
			} catch (Exception e) {
				// Usuario ha pulsado ENTER
			}

			// Sexo
			try {
				String sexo2 = Entrada.cadenaVal("Sexo(HMO)?" + "(" + p.getSexo() + ")", "Sexo incorrecto", "[HMO]",
						true);
				char sexo = sexo2.charAt(0);
				p.setSexo(sexo);
			} catch (Exception e) {
				// Usuario ha pulsado ENTER
			}

			// Fecha de nacimiento
			try {
				p.setFechaNac(Entrada.fechaVal("Fecha de nacimiento(dd-mm-aaaa)?" + "(" + p.getFechaNac() + ")",
						"Fecha incorrecta", "dd-MM-yyyy", true));
			} catch (Exception e) {
				// Usuario ha pulsado ENTER
			}

			// Peso
			try {
				p.setPeso(Entrada.realVal("Peso?" + "(" + p.getPeso() + ")", "Peso incorrecto", 20, 200, true));
			} catch (Exception e) {
				// Usuario ha pulsado ENTER
			}

			// Altura
			try {
				p.setAltura(Entrada.realVal("Altura?" + "(" + p.getAltura() + ")", "Altura incorrecta", 10, 500, true));
			} catch (Exception e) {
				// Usuario ha pulsado ENTER
			}

		}

	}

	private static void bajas() {
		System.out.println("--> Baja de persona");
		int pos = 0;
		String dni;
		do {
			System.out.println("DNI?");
			dni = Entrada.cadena();
			if (!ValidarDni.esNIF(dni)) {
				System.out.println("Introduzca DNI valido");
			}
		} while (!ValidarDni.esNIF(dni));
		for (int i = 0; i < bd.length; i++) {

			if (buscar(dni) != -1) {

				pos = buscar(dni);

			} else {
				pos = -1;
			}
		}
		if (pos == -1) {
			System.out.println("DNI no registrado");
		} else {
			bd[pos] = null;

		}

	}

	private static void altas() throws ParseException {

		System.out.println("--> Alta de persona");
		if (buscar(null) == -1) {
			System.out.println("Base de datos llena");

		} else {

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
			if (buscar(null) != -1) {
				int pos = buscar(null);
				bd[pos] = p;
			}
		}

	}

	// Devuelve persona del array donde se encuentra el dni. null si no existe
	private static int buscar(String dni) {
		for (int i = 0; i < bd.length; i++) {
			if (bd[i] == null) {
				if (dni == null) {
					return i;
				}
			} else {
				if (bd[i].getDni().equals(dni)) {
					return i;
				}

			}

		}
		return -1;

	}
}