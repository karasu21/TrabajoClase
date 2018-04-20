package pruebasEntrada;

import java.text.ParseException;
import java.util.Date;

public class EntradaTest {

	public static void main(String[] args) throws ParseException {
		
		
		System.out.println("Introduzca fecha(dd-MM-yyyy)");
		Date d=Entrada.fecha("dd-MM-yyyy","Formato fecha incorrecto", false);
		System.out.println(d);
	

	}

}
