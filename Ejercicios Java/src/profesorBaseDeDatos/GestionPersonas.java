package profesorBaseDeDatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class GestionPersonas {

	private static ArrayList<Persona> bd;

	public static void main(String[] args) throws ParseException, IOException {
		//Crea array bd don se almacenaran las personas. Contiene referencias a objetos de clase Persona
		//Estas referencias inicialmente estan con valor null
		bd=new ArrayList<Persona>();
		Collections.sort(bd);//Segun compareTo
		
		Menu1DAM m=new Menu1DAM("\n== Gestión de Personas ==", true);
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
		m.agregarOpcion("Salir");
		String op;
		do {
			m.mostrar();
			op=m.leerOpcion();
			switch(op) {
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
		}while(!op.equals("0"));
		System.out.println("ADIOS.");
	}

	private static void consultas() {
		System.out.println("--> Consulta de persona");
	}

	private static void modificaciones()  {
		System.out.println("--> Modificacion de persona");
	}

	private static void bajas() {
		System.out.println("--> Baja de persona");
	}

		
	private static void altas()  {
		System.out.println("--> Alta de persona");
		String nombre=Entrada.cadenaVal("Nombre?", "El nombre debe comenzar por una letra", "[A-Za-z].*",false);
		Date fechaNac=Entrada.fechaVal("Fecha nacimiento (dd/mm/aaaa?", "Fecha incorrecta", "dd/MM/yyyy",false);
		try {
			double peso=Entrada.realVal("Peso?", "El peso debe ser positivo", 1.0, Double.MAX_VALUE,true);
		}
		catch (RuntimeException e) { 
			System.out.println("No se ha tecleado nada al pedir peso");
		}
	}
	
	
	
	

	//Devuelve posicion del array donde se encuentra el dni . Devuelve -1 si no existe
	private static int buscar(String dni) {
		
		
		return -1;
	}

	private static void listadoPorAltura() {
		System.out.println("--> Listado de personas por altura (descentente)");
		//Ordena por Altura(Comparator)
		Collections.sort(bd,new OrdenacionPorAltura());
		for (int i=0;i<bd.size();i++)
			System.out.println(bd.get(i));
		
	}

	private static void listadoPorDNI() {
		System.out.println("--> Listado de personas por DNI");
		//Ordena por Edad(Comparator)
		Collections.sort(bd,new OrdenacionPorDNI());
		for (int i=0;i<bd.size();i++)
			System.out.println(bd.get(i));
		
	}

	private static void listadoPorEdad() {
		System.out.println("--> Listado de personas por edad (descentente)");
		//Ordena por Edad(Comparator)
		Collections.sort(bd,new OrdenacionPorEdad());
		for (int i=0;i<bd.size();i++)
			System.out.println(bd.get(i));
		
	}

	private static void listadoPorNombre() {
		System.out.println("--> Listado de personas por nombre");
		//Ordena con criterio por defecto(Comparable)
		Collections.sort(bd);
		for (int i=0;i<bd.size();i++)
			System.out.println(bd.get(i));
	}

	private static void importarFichero() {
		// TODO Auto-generated method stub
		
	}

	private static void exportarBD() throws IOException {
	System.out.println("Introduce ruta donde se creara el archivo: ");	
	String ruta=Entrada.cadena();
	PrintWriter pw=new PrintWriter(new FileWriter(new File(ruta),true));
	for (int i = 0; i<bd.size(); i++) {
		pw.println(bd.get(i));
	}
	
	pw.close();	
	}
	
}