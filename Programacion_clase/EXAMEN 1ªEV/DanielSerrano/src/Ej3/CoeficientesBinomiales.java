package Ej3;

public class CoeficientesBinomiales {

	public static void main(String[] args) {
		int n;
		int k;
		int coeficiente;
		do {
			System.out.println("introduzca valor de n (n,k)");
			n = Entrada.entero();
			System.out.println("introduzca valor de k (n,k)");
			k = Entrada.entero();
		} while (n < 0 || k < 0);

		coeficiente=coeficienteBinomial(n,k);
		System.out.println(coeficiente);
		
	}

	private static int coeficienteBinomial(int n, int k) {
		int nf=factorial(n);
		int kf=factorial(k);
		int nk=factorial(n-k);
		int cof = nf/(kf*(nk));
		return cof;
	}

	private static int factorial(int n) {
		int cnt = n;
		int factorial = n;
		if (n==0) {
			factorial=1;
		}
		while (cnt > 1) {
			cnt = cnt - 1;
			factorial = factorial * cnt;
		}
		return factorial;
	}

}
