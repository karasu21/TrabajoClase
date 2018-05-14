package examen;


public class Ejercicio1 {

	public static void main(String[] args) {
		boolean valido=false;
		int n=0;
		int resto[]=new int[1000];
		do {
		System.out.println("Introduzca un numero positivo de tres cifras");
		 n=Entrada.entero();
		
		 valido=validarNumero(n);
		} while (valido);
		int cnt=descomponerNumero(n,resto);
		potencia(resto,cnt);
	}
	

	private static void potencia(int[] resto, int cnt) {
		@SuppressWarnings("unused")
		int potencia=0;
		for (int i = 0; i <= cnt; i++) {
			for (int j = 0; j <= cnt; i++) {
				potencia= resto[i] * resto[i];
			}
		}
		
	}


	private static int descomponerNumero(int n, int resto[]) {
		int dividendo=n;
		int cnt=0;
		do {
			resto[cnt]=dividendo%10;
			dividendo=dividendo/10;
			cnt = cnt+1;
			} while (dividendo!=0);
		return cnt;
		
	}


	private static boolean validarNumero(int n) {
		 boolean valido=false;
		if (n<100 || n>999 || n<0) {
			System.out.println("¡Número no válido!");
			valido = true;
		} else {
			 
		}
		
		return valido;
	}

}
