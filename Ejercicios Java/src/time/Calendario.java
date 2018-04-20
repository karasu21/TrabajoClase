package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.text.ParseException;

import corregidosProfesor.Entrada;

public class Calendario {

	public static void main(String[] args) throws ParseException {

		// CASO 1
		System.out.println("Introduzca dia");
		int dia = Entrada.entero();
		System.out.println("Introduzca mes");
		int mes = Entrada.entero();
		mes = mes - 1;
		System.out.println("Introduzca año");
		int año = Entrada.entero();
		Calendar fecha = new GregorianCalendar(año, mes, dia);
		int nombredia = fecha.get(Calendar.DAY_OF_WEEK);

		switch (nombredia) {
		case 1:
			System.out.println("Domingo");
			break;
		case 2:
			System.out.println("Lunes");
			break;
		case 3:
			System.out.println("Martes");
			break;
		case 4:
			System.out.println("Miercoles");
			break;
		case 5:
			System.out.println("Jueves");
			break;
		case 6:
			System.out.println("Viernes");
			break;
		case 7:
			System.out.println("Sabado");
			break;
		}

		// CASO 2

		System.out.println("Introduzca fecha(DD/MM/YYYY)");
		String fecha2 = Entrada.cadena();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
		Date d = formato.parse(fecha2);
		SimpleDateFormat dia2 = new SimpleDateFormat("EEEE");
		String nombredia2 = dia2.format(d);
		System.out.println(nombredia2);
		
		
		//CASO 3
		Calendar gchora = new GregorianCalendar();
		System.out.println(gchora.getTime());
		System.out.println("Zona horaria?(UCT)");
		@SuppressWarnings("unused")
		String zh=Entrada.cadena();
		gchora.setTimeZone(TimeZone.getTimeZone("zh"));
		System.out.println(gchora.getTime());
		
		

	}

}
