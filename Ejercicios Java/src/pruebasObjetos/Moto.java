package pruebasObjetos;

public class Moto {
	int velocidad;
	String marca;
	int cc;
	Neumatico rueda1;
	Neumatico rueda2;

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public Neumatico getRueda1() {
		return rueda1;
	}

	public void setRueda1(Neumatico rueda1) {
		this.rueda1 = rueda1;
	}

	public Neumatico getRueda2() {
		return rueda2;
	}

	public void setRueda2(Neumatico rueda2) {
		this.rueda2 = rueda2;
	}

	@Override
	public String toString() {
		return "Moto [velocidad=" + velocidad + ", marca=" + marca + ", cc=" + cc + ", rueda1=" + rueda1 + ", rueda2="
				+ rueda2 + "]";
	}

	public Moto(int velocidad, String marca, int cc, Neumatico rueda1, Neumatico rueda2) {
		super();
		this.velocidad = velocidad;
		this.marca = marca;
		this.cc = cc;
		this.rueda1 = rueda1;
		this.rueda2 = rueda2;
	}

}
