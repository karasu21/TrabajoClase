package figurasGeometricas;

public class Triangulo {

	String elemento;
	int numfilas;
	boolean macizo;

	@Override
	public String toString() {
		return "Triangulo [elemento=" + elemento + ", longlado=" + numfilas + ", macizo=" + macizo + "]";
	}

	public Triangulo(String elemento, int longlado, boolean macizo) {
		super();
		this.elemento = elemento;
		this.numfilas = longlado;
		this.macizo = macizo;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public int getLonglado() {
		return numfilas;
	}

	public void setLonglado(int longlado) {
		this.numfilas = longlado;
	}

	public boolean isMacizo() {
		return macizo;
	}

	public void setMacizo(boolean macizo) {
		this.macizo = macizo;
	}

	public static void main(String[] args) {
		Triangulo t = new Triangulo("*", 5, true);
		t.dibujar();

	}

	private void dibujar() {
		boolean contorno;
		for (int fila = 1; fila <= numfilas; fila++) {
			for (int j = 1; j <= numfilas - fila; j++) {
				System.out.print("");
			}
			for (int aster = 1; aster <= (fila + fila) - 1; aster++) {
				contorno = aster == 1 || fila == numfilas || aster == (fila + fila) - 1;
				if (macizo || contorno) {
					System.out.print(elemento);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
