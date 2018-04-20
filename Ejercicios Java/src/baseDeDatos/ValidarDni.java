package baseDeDatos;

import java.util.Random;



public class ValidarDni {

	public static void main(String[] args) {
		System.out.println(generarNIFAleatorio(false));
		
		for(;;) {
			System.out.print("Introduzca cadena:");
			String t=Entrada.cadena();
			if (esNIF(t))
				System.out.println("Es un NIF");
		}
	}


	
	//Calcula la letra que corresponde a los 8 dígitos de un DNI
	public static char calcularLetraDni(String digitosDni){
		if (!digitosDni.matches("[0-9]{1,8}"))
				return '?'; //Devuelve ? si no llegan entre 1 y 8 digitos 
		char letras[]={'T', 'R', 'W', 'A', 'G', 'M', 'Y',
		          'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
		          'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

		return letras[Integer.valueOf(digitosDni)%23];
	}
	
	public static boolean esNIF(String t) {
		if (!t.matches("[0-9]{1,8}[A-Z]"))
			return false;
		String digitos=t.substring(0, t.length()-1);
		char letra=t.charAt(t.length()-1);//La letra es el ultimo caracter de t
				
		return letra==calcularLetraDni(digitos);
	}
		
	public static String generarNIFAleatorio(boolean conCeros) {
		Random r=new Random();
		int n=r.nextInt(100000000);
		String t;
		if (conCeros)
			t=String.format("%08d", n);
		else
			t=String.valueOf(n);
			
		t=t+calcularLetraDni(t);
		
		return t;
	}
}

