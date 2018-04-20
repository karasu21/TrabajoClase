package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Prueba {

	public static void main(String[] args) {
	Date min=new Date(Long.MIN_VALUE);
	Date max=new Date(Long.MAX_VALUE);
	
	GregorianCalendar gc=new GregorianCalendar();
	gc.setTime(min);
	System.out.println(gc.get(Calendar.YEAR));
	System.out.println(gc.get(Calendar.ERA));
	System.out.println(GregorianCalendar.AD);
	System.out.println(GregorianCalendar.BC);
	}

}
