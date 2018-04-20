package herenciaEj;

public class Tortuga extends Animal {
	
	public Tortuga(double peso, int precio) {
		super(peso, 4, false);
		this.precio = precio;
	}

	int precio;

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public  void nadar(int metros) {
		
		double totalPierde=0;
		if (metros>=100) {
			int veces=metros/100;
			double pierde = 0.005 * this.peso;
			 totalPierde = pierde*veces;
		}
		this.setPeso(this.peso-totalPierde);
	}

	@Override
	public String toString() {
		return "Tortuga [precio=" + precio + ", peso=" + peso + ", numPatas=" + numPatas + ", vuela=" + vuela + "]";
	}
}
