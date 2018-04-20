package pruebasObjetos;

import metodosString.Entrada;

public class CrearPuntos {

	public static void main(String[] args) {
		Punto [] puntos=new Punto[5];
		for (int i = 0; i < puntos.length; i++) {
			System.out.format("Punto %d: cordenada X:", i);
			double coordx=Entrada.real();
			System.out.format("Punto %d: cordenada Y:", i);
			double coordy=Entrada.real();
			puntos[i]=new Punto(coordx,coordy);
		}
		for (int i = 0; i < puntos.length; i++) {
			System.out.println(puntos[i]);
		}
		
		System.out.println(Punto.calcularDistancia(puntos[0],puntos[4]));
	

	}

}
