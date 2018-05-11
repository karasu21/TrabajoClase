package profesorFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFileChooser;
import javax.swing.SingleSelectionModel;


public class ObtenerMapaDePalabrasFichero {

	public static void main(String[] args) throws IOException {
		JFileChooser fc=new JFileChooser("/");
		fc.setDialogTitle("Seleccione fichero de texto");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int seleccion = fc.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION)
		{
			Map<String,Integer> m=estadisticaPalabras(fc.getSelectedFile(),false);
			System.out.println("=== Listado de palabras (orden alfabético) ===");
			for (String pal:m.keySet()){
				System.out.println(pal+"\t"+m.get(pal));
			}
		}

	}

	private static Map<String,Integer> estadisticaPalabras(File rutaFich, boolean ignorarMayMin) throws IOException {
		Map<String,Integer> mapa=new TreeMap<String,Integer>();
		BufferedReader bfr=new BufferedReader(new FileReader(rutaFich));
		String linea;
		while((linea=bfr.readLine())!=null){
			for (String pal:partirPalabras(linea)){
				if (ignorarMayMin)
					pal=pal.toUpperCase();
				//Añade palabra al mapa con contador 1 o incrementando si ya existe
				if (mapa.containsKey(pal))
					mapa.put(pal,mapa.get(pal)+1);
				else
					mapa.put(pal,1);
			}
		}
			
		bfr.close();
		return mapa;
	}
	
	private static String[] partirPalabras(String linea) {
		return linea.split("[ ,.:;()¡!¿?]+");
	}
}
