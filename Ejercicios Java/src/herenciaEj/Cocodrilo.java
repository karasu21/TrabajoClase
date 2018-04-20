package herenciaEj;

public class Cocodrilo extends Animal {


	public Cocodrilo(double peso,  int longitud) {
		super(peso, 4, false);
		this.longitud = longitud;
	}

	double longitud;

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public void comer(int gramos) {
		double gana = 0.01 * gramos;
		this.setPeso(gana+this.peso);
	}
	
	public void nadar(int metros) {
		double pierde = 0.01 * metros;
		this.setPeso(this.peso-pierde);
	}

	@Override
	public String toString() {
		return "Cocodrilo [longitud=" + longitud + ", peso=" + peso + ", numPatas=" + numPatas + ", vuela=" + vuela
				+ "]";
	}
}
