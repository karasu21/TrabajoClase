package pruebasObjetos;

public class Persona {

	// Atributos
	String dni;
	String nombre;
	String apellido;
	int edad;
	boolean gafas;

	// Metodos
	public static void main(String[] args) {

		Persona p1 = new Persona();
		p1.setDni("1A");
		p1.setNombre("Julia");
		p1.setApellido("Gutierrez");
		p1.setEdad(-2);
		p1.setGafas(true);
		Persona p2 = new Persona();
		p2.setDni("2B");
		p2.setNombre("Antonio");
		p2.setApellido("Lopez");
		p2.setEdad(41);
		p2.setGafas(false);

		Persona p3 = new Persona("30k", "Ramon", "Pérez", 40, false);

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

	}

	public Persona(String dni, String nombre, String apellido, int edad, boolean gafas) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.gafas = gafas;
	}

	public Persona() {
		this("30k", "Julia", "", 30, true);
	}

	@Override
	public String toString() {
		String llevaGafas;
		if (gafas == true) {
			llevaGafas = "Lleva gafas";
		} else {
			llevaGafas = "No lleva gafas";

		}
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", gafas="
				+ llevaGafas + "]";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad < 0) {
			edad = 0;
		}
		this.edad = edad;
	}

	public boolean isGafas() {
		return gafas;
	}

	public void setGafas(boolean gafas) {
		this.gafas = gafas;
	}

}
