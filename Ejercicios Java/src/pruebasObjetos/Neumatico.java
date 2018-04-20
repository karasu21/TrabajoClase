package pruebasObjetos;

public class Neumatico {
	int ancho;
	int radio;
	int perfil;
	String marca;

	public Neumatico(int ancho, int radio, int perfil, String marca) {
		super();
		this.ancho = ancho;
		this.radio = radio;
		this.perfil = perfil;
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Neumatico [ancho=" + ancho + ", radio=" + radio + ", perfil=" + perfil + ", marca=" + marca + "]";
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}



}
