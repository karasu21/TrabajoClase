package geometria;

import ejemplos.Entrada;

public class CrearPuntos {

	public static void main(String[] args) {
		Punto [] puntos=new Punto[5]; //Array que contiene 5 referencias a objetos Punto (los objetos se crear�n con new)
		for (int i = 0; i < puntos.length; i++) {
			System.out.format("Punto %d: coordenada X:",i);
			double coordX=Entrada.real();
			System.out.format("Punto %d: coordenada Y:",i);
			double coordY=Entrada.real();
			puntos[i]=new Punto(coordX,coordY);
		}
		//Mostrar Puntos del array
		for (int i = 0; i < puntos.length; i++) {
			System.out.println(puntos[i]);
		}
		//Calculamos distancia entre primer y ultimo punto en el array
		//Con m�todo est�tico
		System.out.println(Punto.calcularDistancia(puntos[0], puntos[puntos.length-1]));
		//Con m�todo NO est�tico
		System.out.println(puntos[0].calcularDistancia(puntos[puntos.length-1]));
	
		
	}

}
