package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextoAHora {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
		String nacimiento = leerFecha();
		formato.setLenient(false);
		Date fecha = convertirADate(nacimiento, formato);
		SimpleDateFormat dia = new SimpleDateFormat("EEEE dd/MM/yy");
		String fechabien = dia.format(fecha);
		System.out.println(fechabien);

		// Suma de dias
		System.out.println("\nIntroduzca dias a sumar");
		int sumadias = Entrada.entero();
		Date nueva = desplazarDia(fecha, sumadias);
		String diasuma = dia.format(nueva);
		System.out.println("===Nueva fecha===");
		System.out.println(diasuma);

		// Bucle restar dias
		String plantilla = "EEEE,dd/MM";
		imprimirDias(fecha, 100, plantilla);
	}

	private static void imprimirDias(Date fecha, int i, String plantilla) {
		boolean avanza=true;
		SimpleDateFormat dia = new SimpleDateFormat(plantilla);
		Date nueva = new Date(fecha.getTime());
		long dias=0;
		System.out.println("Retroceder o avanzar");
		String opcion=Entrada.cadena();
		if (opcion.matches("retroceder, Retroceder")) {
			avanza=false;
		}
		System.out.println("===Bucle Dias===");
		for (int j = 0; j < i; j++) {
			nueva.setTime(fecha.getTime() + dias);
			System.out.println(dia.format(nueva));
			if (avanza) {
				dias=dias+(24L * 3600L * 1000L);
			} else {
				dias=dias-(24L * 3600L * 1000L);

			}
			

		}

	}

	private static Date desplazarDia(Date fecha, int sumadias) {
		long ms = (long) sumadias * 24L * 3600L * 1000L;
		Date nueva = new Date(fecha.getTime() + ms);
		return nueva;
	}

	private static Date convertirADate(String nacimiento, SimpleDateFormat formato) throws ParseException {
		Date h = formato.parse(nacimiento);
		return h;

	}

	private static String leerFecha() {
		System.out.println("Introduzca su fecha de nacimiento(DD/MM/YYYY)");
		String fecha = Entrada.cadena();
		return fecha;
	}

}
