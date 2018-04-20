package figurasGeometricas;

public class Cuadrado {
	String elemento;
	int longlado;
	boolean macizo;

	@Override
	public String toString() {
		return "Cuadrado [elemento=" + elemento + ", longlado=" + longlado + ", macizo=" + macizo + "]";
	}

	public Cuadrado(String elemento, int longlado, boolean macizo) {
		super();
		this.elemento = elemento;
		this.longlado = longlado;
		this.macizo = macizo;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public int getLonglado() {
		return longlado;
	}

	public void setLonglado(int longlado) {
		this.longlado = longlado;
	}

	public boolean isMacizo() {
		return macizo;
	}

	public void setMacizo(boolean macizo) {
		this.macizo = macizo;
	}
	
	private void dibujarCuadrado() {

		boolean contorno;
		for (int i = 1; i <= longlado; i++) {
			for (int j = 1; j <= longlado; j++) {
				contorno = i == 1 || i == longlado || j == 1 || j == longlado;
				if (macizo  || contorno) {
					System.out.print(elemento);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Cuadrado c = new Cuadrado("*", 5, true);
		c.dibujarCuadrado();
		c.setElemento("X");
		c.setMacizo(false);
		System.out.println("");
		c.dibujarCuadrado();

	}

	

}
