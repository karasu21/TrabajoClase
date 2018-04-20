package baseDeDatos;

import java.util.Comparator;

public class OrdenacionPorPeso implements Comparator<Persona> {

	

	@Override
	public int compare(Persona o1, Persona o2) {
		if (o1.getPeso()==o2.getPeso()) {
			return (int) (o1.getAltura()-o2.getAltura());
		} else {
			return (int) (o1.getPeso()-o2.getPeso());
		}
		
	}

}
