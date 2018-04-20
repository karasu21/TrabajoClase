package p1;

import p2.C2;
import p2.C3;

public class C1 {
	private int c1Private;
	int c1;
	protected int c1Protected;
	public int c1Public;

	public static void main(String[] args) {
		C1 c1 = new C1();
		C2 c2 = new C2();
		C3 c3 = new C3();
		C4 c4 = new C4();
		
		c1.c1Private=1;
		c1.c1=1;
		c4.c4=1;
		

	}

}
