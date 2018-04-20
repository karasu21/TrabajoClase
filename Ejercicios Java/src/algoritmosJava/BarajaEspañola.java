package algoritmosJava;

public class BarajaEspañola {

	public static void main(String[] args) {
		String baraja[] = new String[40];
		rellenarBaraja(baraja);
		mostrarBaraja(baraja);
	}

	private static void mostrarBaraja(String b []) {
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		
	}

	private static void rellenarBaraja(String b[]) {
		for (int i = 0; i <= b.length; i++) {
			if (i >= 0 && i <= 9) {
				if (i > 6) {
					b[i] = i + 3 + "O";
				} else {
					b[i] = i + 1 + "O";
				}
			} else {
				if (i >= 10 && i <= 19) {
					if (i > 16) {
						b[i] = (i%10 + 3) + "C";
					} else {
						b[i] = (i%10 + 1) + "C";
					}

				} else {
					if (i >= 20 && i <= 29) {
						if (i > 26) {
							b[i] = (i%10 + 3) + "E";
						} else {
							b[i] = (i%10 + 1) + "E";
						}
					} else {
						if (i >= 30 && i <= 39) {
							if (i > 36) {
								b[i] = (i%10 + 3) + "B";
							} else {
								b[i] = (i%10 + 1) + "B";

							}
						}
					}
				}
			}
		}
	}
}
