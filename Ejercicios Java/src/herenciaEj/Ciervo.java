package herenciaEj;

public class Ciervo extends Animal{
	int puntas;

	public Ciervo(double peso,  int puntas) {
		super(peso, 4, false);
		this.puntas = puntas;
	}

	public int getPuntas() {
		return puntas;
	}

	public void setPuntas(int puntas) {
		this.puntas = puntas;
	}
	
	public void comer(int gramos) {
		int gana = (int) (0.01 * gramos); //1punto cada 20kg
		this.setPeso(gana+this.peso);
		
		

	}

	@Override
	public String toString() {
		return "Ciervo [puntas=" + puntas + ", peso=" + peso + ", numPatas=" + numPatas + ", vuela=" + vuela + "]";
	}
}
