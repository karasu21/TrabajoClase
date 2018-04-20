package time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ComprobarTiempo {

	public static void main(String[] args) throws InterruptedException {
		for (;;) {
			Date hora=new Date();
			SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
			String relojd=formato.format(hora);
			System.out.println(relojd);
			Thread.sleep(1000);
		}
		

	}

}
