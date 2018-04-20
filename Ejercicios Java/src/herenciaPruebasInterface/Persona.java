package herenciaPruebasInterface;

public class Persona implements AccionesDeportista {
	String nif;
	String nombre;
	int edad;
	
	public Persona() {
		
	}
	
	public Persona(String nif, String nombre, int edad) {
		this.nif = nif;
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [nif=" + nif + ", nombre=" + nombre + ", edad=" + edad
				+ "]";
	}
	public String getNif() {
		return nif;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEdad(int edad) {
		this.edad = edad;
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
