package profesorGUI;

public class ParejaPalabraVeces implements Comparable<ParejaPalabraVeces> {
	private String palabra;
	private int veces;
	
	public ParejaPalabraVeces(String palabra, int veces) {
		super();
		this.palabra = palabra;
		this.veces = veces;
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public int getVeces() {
		return veces;
	}
	public void setVeces(int veces) {
		this.veces = veces;
	}
	
	public int compareTo(ParejaPalabraVeces o) {
		//Orden de menor a mayor. Si el n�mero de veces es igual se ordena por orden alfab�tico 
		int dif = getVeces()-o.getVeces(); 
		if (dif==0)
			return getPalabra().compareTo(o.getPalabra());
		else
			return dif;
	}
}
