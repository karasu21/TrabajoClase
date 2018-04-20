package herenciaPruebasInterface;

public class Futbolista extends Persona implements AccionesDeportista {
	
	String equipo;
	int goles;

	public Futbolista(String nif, String nombre, int edad, String equipo, int goles) {
		super(nif, nombre, edad);
		this.equipo=equipo;
		this.goles=goles;
	}

	public Futbolista() {
		
	}

	@Override
	public String toString() {
		return "Futbolista [equipo=" + equipo + ", goles=" + goles + ", nif=" + nif + ", nombre=" + nombre + ", edad="
				+ edad + "]";
	}

	public String getEquipo() {
		return equipo;
	}

	public int getGoles() {
		return goles;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	@Override
	public void mover(int direccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double recibirPremio(int dinero) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}


	
}
