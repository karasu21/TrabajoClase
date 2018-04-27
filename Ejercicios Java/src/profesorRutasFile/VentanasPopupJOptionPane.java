package profesorRutasFile;

import javax.swing.JOptionPane;

public class VentanasPopupJOptionPane {

	public static void main(String[] args) {
		
		//Mensaje informativo
		JOptionPane.showMessageDialog(null,"MENSAJE EN VENTANA POPUP");
		
		//Mensaje error
		JOptionPane.showMessageDialog(null, "MENSAJE DE ERROR", "TITULO DE LA VENTANA", JOptionPane.ERROR_MESSAGE);
		
		//Mensaje de confirmacion
		int opcion=JOptionPane.showConfirmDialog(null, "Quiere sobreescribir?","Fichero ya existe!!",JOptionPane.OK_CANCEL_OPTION);
		switch(opcion)
		{
		case JOptionPane.OK_OPTION:
			System.out.println("OK");
			break;

		case JOptionPane.CANCEL_OPTION:
			System.out.println("CANCEL");
			break;
		case JOptionPane.CLOSED_OPTION:
			System.out.println("CERRAR");
			break;
		}

	}

}
