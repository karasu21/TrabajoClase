package baseDeDatos;

import java.util.ArrayList;

import algoritmosJava.Entrada;

public class Menu1DAM {
	String titulo;
	boolean numerico;
	ArrayList<String> opciones;
	ArrayList<String> valorOpciones;

	public Menu1DAM(String titulo, boolean numerico) {
		super();
		this.titulo = titulo;
		this.numerico = numerico;
		opciones = new ArrayList<String>();

	}

	@Override
	public String toString() {
		return "Menu1DAM [titulo=" + titulo + ", numerico=" + numerico + ", opciones=" + opciones + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isNumerico() {
		return numerico;
	}

	public void setNumerico(boolean numerico) {
		this.numerico = numerico;
	}

	public ArrayList<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(ArrayList<String> opciones) {
		this.opciones = opciones;
	}

	public void agregarOpcion(String opcion) {

		opciones.add(opcion);

	}

	public void mostrar() {
		valorOpciones = new ArrayList<String>();
		System.out.println(titulo);
		if (numerico) {

			for (int i = 0; i < opciones.size(); i++) {

				if (i == opciones.size() - 1) {
					System.out.println(("\n" + 0 + "-" + opciones.get(i) + "\n"));
					valorOpciones.add("0");

				} else {
					System.out.println((i + 1) + "-" + opciones.get(i));
					String valor = String.valueOf(i + 1);// convierte i+1 en String
					valorOpciones.add(valor);

				}

			}

		} else {

			char c = 'a';
			for (int i = 0; i < opciones.size(); i++) {
				if (i == opciones.size() - 1) {
					System.out.println(("\n" + 'z' + "-" + opciones.get(i) + "\n"));
					valorOpciones.add("z");
				} else {
					System.out.println((c + "-" + opciones.get(i)));
					String valor = String.valueOf(c);
					valorOpciones.add(valor);
					c = (char) (c + 1);

				}

			}

		}

	}

	public String leerOpcion() {
		boolean bien;
		String opcion;
		do {
			bien = false;
			System.out.println("Elija opcion");
			opcion = Entrada.cadena().trim().toLowerCase();
			if (valorOpciones.contains(opcion)) {
				bien = true;

			} else {
				System.out.println("Opcion incorrecta");

			}
		} while (!bien);

		return opcion;
	}

}
