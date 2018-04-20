package herenciaEj;

public class Animal {
	
	double peso;
	int numPatas;
	boolean vuela;
	public double getPeso() {
		return peso;
	}
	
	public Animal(double peso, int numPatas, boolean vuela) {
		super();
		this.peso = peso;
		this.numPatas = numPatas;
		this.vuela = vuela;
	}

	public int getNumPatas() {
		return numPatas;
	}
	public boolean isVuela() {
		return vuela;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setNumPatas(int numPatas) {
		this.numPatas = numPatas;
	}
	public void setVuela(boolean vuela) {
		this.vuela = vuela;
	}
	
	public void comer (int gramos) {
		double gana =  0.005*gramos;
		this.setPeso(gana+this.peso);
		
	}

	@Override
	public String toString() {
		return "Animal [peso=" + peso + ", numPatas=" + numPatas + ", vuela=" + vuela + "]";
	}
	
}
