package fechaHora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GregorianAdivinarDiaDeLaSemana {

	public static void main(String[] args) throws ParseException {
		//Leemos fecha como 3 enteros: dia, mes, a�o
		System.out.print("D�a: ");
		int dia=Entrada.entero();
		System.out.print("Mes: ");
		int mes=Entrada.entero();
		System.out.print("A�o: ");
		int anio=Entrada.entero();
		//En GregorianCalendar Enero es 0 y diciembre es 11. Restamos uno al mes, para nosotros Enero es 1 y Diciembre es 12
		GregorianCalendar gc=new GregorianCalendar(anio, mes-1, dia);
		System.out.println("D�a devuelto por gc.get(Calendar.DAY_OF_WEEK):"+gc.get(Calendar.DAY_OF_WEEK));
		System.out.println("D�a devuelto por gc.get(Calendar.DAY_OF_WEEK) convertido:"+nombreDia(gc.get(Calendar.DAY_OF_WEEK)));
		
		//Leemos fecha como un String con plantilla 
		System.out.print("\nIntroduzca fecha (DD/MM/AAAA):");
		String cadena=Entrada.cadena();
		//Creamos plantilla para analizar la cadena leida
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		Date d=sdf.parse(cadena);
		gc=new GregorianCalendar();
		gc.setTime(d);
		System.out.println("D�a de la semana:"+nombreDia(gc.get(Calendar.DAY_OF_WEEK)));
	}

	private static String nombreDia(int dayOfWeek) {
		String nombre="";
		switch(dayOfWeek) {
		case Calendar.MONDAY: nombre="Lunes";
		break;
		case Calendar.TUESDAY: nombre="Martes";
		break;
		case Calendar.WEDNESDAY: nombre="Mi�rcoles";
		break;
		case Calendar.THURSDAY: nombre="Jueves";
		break;
		case Calendar.FRIDAY: nombre="Viernes";
		break;
		case Calendar.SATURDAY: nombre="S�bado";
		break;
		case Calendar.SUNDAY: nombre="Domingo";
		break;
		}
		return nombre;
	}

	
}
