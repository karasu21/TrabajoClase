package pruebasObjetos;



public class Punto {

	
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}

	double x;
	double y;

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

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Punto() {
		this(0,0);
	}
	
	public static double calcularDistancia(Punto a, Punto b) {
		 return Math.sqrt(Math.pow(a.getX()-b.getX(),2)+Math.pow(a.getY()-b.getY(),2));
		
	}

	

}
