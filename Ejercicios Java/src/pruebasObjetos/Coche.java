package pruebasObjetos;

public class Coche {
	int velocidad;
	String color;
	String marca;
	int cc;
	int numruedas;
	Neumatico rueda;
	Remolque remolque;

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public int getNumruedas() {
		return numruedas;
	}

	public void setNumruedas(int numruedas) {
		this.numruedas = numruedas;
	}

	public Neumatico getRueda() {
		return rueda;
	}

	public void setRueda(Neumatico rueda) {
		this.rueda = rueda;
	}

	public Remolque getRemolque() {
		return remolque;
	}

	public void setRemolque(Remolque remolque) {
		this.remolque = remolque;
	}

	@Override
	public String toString() {
		return "Coche [velocidad=" + velocidad + ", color=" + color + ", marca=" + marca + ", cc=" + cc + ", numruedas="
				+ numruedas + ", rueda=" + rueda + ", remolque=" + remolque + "]";
	}

	public Coche(int velocidad, String color, String marca, int cc, int numruedas, Neumatico rueda, Remolque remolque) {
		super();
		this.velocidad = velocidad;
		this.color = color;
		this.marca = marca;
		this.cc = cc;
		this.numruedas = numruedas;
		this.rueda = rueda;
		this.remolque = remolque;
	}

}
