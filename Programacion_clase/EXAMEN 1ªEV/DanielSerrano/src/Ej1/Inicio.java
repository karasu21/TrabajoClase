package Ej1;

public class Inicio {

	public static void main(String[] args) {
		Trabajador a = new Trabajador("Juan", 11, 0, 0);
		System.out.println(a);
		System.out.println(a.calcularSueldo());
		a.setAntigŁedad(1);
		System.out.println(a);
		System.out.println(a.calcularSueldo());
		a.setAntigŁedad(2);
		System.out.println(a);
		System.out.println(a.calcularSueldo());
	
		Trabajador d = new Trabajador("Maria", 11, 0,0);
		d.setCategoria(1);
		System.out.println(d);
		System.out.println(d.calcularSueldo());
		d.setCategoria(2);
		System.out.println(d);
		System.out.println(d.calcularSueldo());
		
		Trabajador b = new Trabajador("Pepe", 11, 1, 1);
		System.out.println(b);
		System.out.println(b.calcularSueldo());
		
		Trabajador c = new Trabajador("Marta", 11, 2,2);
		System.out.println(c);
		System.out.println(c.calcularSueldo());
		
		
		Trabajador e = new Trabajador("Marcos", 11, -1, 2); 
		//b.setAntigŁedad(-1); -->produce Exception
		//b.setCategoria(-1); -->produce Exception
		//Trabajador e = new Trabajador("Ana", 11, 2, -1); -->produce Exception
	}

}
