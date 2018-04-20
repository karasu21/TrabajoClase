package herenciaPruebasInterface;

public class Tenista extends Persona implements AccionesDeportista {
	
	int ranking;

	public Tenista(String nif, String nombre, int edad, int ranking) {
		super(nif,nombre,edad);
		super.edad=edad;
		super.nombre=nombre;
		this.ranking = ranking;
	}

	public Tenista() {
		
		
	}

	@Override
	public String toString() {
		return "Tenista [ranking=" + ranking + ", nif=" + nif + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
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
