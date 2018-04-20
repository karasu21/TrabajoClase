package pruebasObjetos;

public class SerializacionPuntos {
	double x;
	double y;
	int serie;
	static int cnt;
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		SerializacionPuntos p1 = new SerializacionPuntos(3,4);
		

	}
	@Override
	public String toString() {
		return "SerializacionPuntos [x=" + x + ", y=" + y + ", serie=" + serie + "]";
	}
	public SerializacionPuntos(double x, double y, int serie) {
		super();
		this.x = x;
		this.y = y;
		this.serie = serie;
	}
	public SerializacionPuntos(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}

	public static int getCnt() {
		return cnt;
	}
	public static void setCnt(int cnt) {
		SerializacionPuntos.cnt = cnt;
	}

}
