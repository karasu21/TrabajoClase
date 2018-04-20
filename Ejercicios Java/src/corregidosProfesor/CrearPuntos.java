package corregidosProfesor;

public class CrearPuntos {

	public static void main(String[] args) {
		Punto [] puntos=new Punto[10];
		for (int i = 0; i < puntos.length; i++) {
			puntos[i]=new Punto(i,i);
		}
		for (int i = 0; i < puntos.length; i++) {
			System.out.println(puntos[i]);
		}
		
		Punto p1=new Punto();
		Punto p2=new Punto(5,6);
		puntos[3].calcularDistancia(puntos[5]);
		p1.calcularDistancia(p2);
		p2.calcularDistancia(p1);
		//Punto.calcularDistancia(p1,p2);
	}

}
