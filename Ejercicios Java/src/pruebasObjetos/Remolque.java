package pruebasObjetos;

public class Remolque {
	int capacidad;
	int numruedas;
	Neumatico rueda;

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
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

	@Override
	public String toString() {
		return "Remolque [capacidad=" + capacidad + ", numruedas=" + numruedas + ", rueda=" + rueda + "]";
	}

	public Remolque(int capacidad, int numruedas, Neumatico rueda) {
		super();
		this.capacidad = capacidad;
		this.numruedas = numruedas;
		this.rueda = rueda;
	}

}
