package GUI;

public class Parejas implements Comparable<Parejas> {
	String palabra;
	Integer repeticiones;

	public String getPalabra() {
		return palabra;
	}

	public Integer getRepeticiones() {
		return repeticiones;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public void setRepeticiones(Integer repeticiones) {
		this.repeticiones = repeticiones;
	}

	public Parejas(String palabra, Integer repeticiones) {
		super();
		this.palabra = palabra;
		this.repeticiones = repeticiones;
	}

	@Override
	public int compareTo(Parejas o) {
		return o.getRepeticiones() - this.getRepeticiones();
	}

}
