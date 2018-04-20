package p2;

import p1.C1;
import p1.C4;

public class C2 extends p1.C1 {
	private int c2Private;
	int c2;
	protected int c2protected;
	public int c2public;

	public static void main(String[] args) {

		C1 c1 = new C1();
		C3 c3 = new C3();
		C4 c4 = new C4();
		C2 c2 = new C2();
		
		c3.c3=0;
		c2.c1Protected=2;
		c3.c3Protected=3;
	}
}
