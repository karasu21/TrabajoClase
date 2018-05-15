package profesorGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

public class EjemploGUIMapaPalabras extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRuta;
	private JTextArea textAreaOrdenAlfabetico;
	private JTextArea textAreaOrdenRepeticiones;
	private JCheckBox chckbxIgnorarMayculasminsculas;
	private JTextArea textAreaContenidoFichero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploGUIMapaPalabras frame = new EjemploGUIMapaPalabras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EjemploGUIMapaPalabras() {
		setTitle("Estad\u00EDstica de palabras en fichero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680,  471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSe = new JButton("Seleccionar Fichero");
		btnSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					botonSelecionarFichero();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSe.setBounds(10, 53, 210, 23);
		contentPane.add(btnSe);
		
		textFieldRuta = new JTextField();
		textFieldRuta.setEditable(false);
		textFieldRuta.setBounds(239, 54, 415, 20);
		contentPane.add(textFieldRuta);
		textFieldRuta.setColumns(10);
		
		JLabel lblRutaSeleccionada = new JLabel("Ruta Seleccionada");
		lblRutaSeleccionada.setBounds(239, 29, 172, 14);
		contentPane.add(lblRutaSeleccionada);
		
		JButton btnObtenerPalabras = new JButton("Obtener palabras");
		btnObtenerPalabras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					botonObtenerPalabras();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnObtenerPalabras.setBounds(10, 87, 210, 23);
		contentPane.add(btnObtenerPalabras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 275, 302, 147);
		contentPane.add(scrollPane);
		
		textAreaOrdenAlfabetico = new JTextArea();
		scrollPane.setViewportView(textAreaOrdenAlfabetico);
		
		JLabel lblListadoPorOrden = new JLabel("Listado por orden alfab\u00E9tico");
		lblListadoPorOrden.setBounds(10, 250, 172, 14);
		contentPane.add(lblListadoPorOrden);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(353, 276, 301, 146);
		contentPane.add(scrollPane_1);
		
		textAreaOrdenRepeticiones = new JTextArea();
		scrollPane_1.setViewportView(textAreaOrdenRepeticiones);
		
		JLabel lblListadoPorNmero = new JLabel("Listado por n\u00FAmero de repeticiones");
		lblListadoPorNmero.setBounds(353, 250, 234, 14);
		contentPane.add(lblListadoPorNmero);
		
		chckbxIgnorarMayculasminsculas = new JCheckBox("Ignorar May\u00FAculas/Min\u00FAsculas");
		chckbxIgnorarMayculasminsculas.setSelected(true);
		
		chckbxIgnorarMayculasminsculas.setBounds(239, 87, 240, 23);
		contentPane.add(chckbxIgnorarMayculasminsculas);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 135, 644, 104);
		contentPane.add(scrollPane_2);
		
		textAreaContenidoFichero = new JTextArea();
		scrollPane_2.setViewportView(textAreaContenidoFichero);
		
		JLabel lblContenidoDelFichero = new JLabel("Contenido del fichero");
		lblContenidoDelFichero.setBounds(10, 114, 125, 14);
		contentPane.add(lblContenidoDelFichero);
	}

	protected void botonObtenerPalabras() throws IOException {
		//Se obtienen las palabra y sus repeticiones como un mapa ordenado por palabra
		Map<String,Integer> m=estadisticaPalabras(new File(textFieldRuta.getText()), chckbxIgnorarMayculasminsculas.isSelected());
		
		//Listado por orden alfab�tico
		String texto="";
		for(String pal:m.keySet()) {
			texto+=pal+" ("+m.get(pal)+")\n";
			
		}
		textAreaOrdenAlfabetico.setText(texto);
		
		//Listado por n�mero de repeticiones
		//Se crea un ArrayList de objetos ParejaPalabraVeces a partir del mapa para hacer una ordenaci�n por n�mero de repeticiones
		ArrayList<ParejaPalabraVeces> al=new ArrayList<ParejaPalabraVeces>();
		texto="";
		for(String pal:m.keySet()) {
			al.add(new ParejaPalabraVeces(pal, m.get(pal)));
		}
		//Ordenamos ArrayList
		Collections.sort(al);
		//Mostramos el ArrayList en la segunda textArea
		for(ParejaPalabraVeces p:al) {
			texto+=p.getPalabra()+" ("+p.getVeces()+")\n";
		}
		textAreaOrdenRepeticiones.setText(texto);
	}

	protected void botonSelecionarFichero() throws IOException{
		JFileChooser fc=new JFileChooser("/");
		fc.setDialogTitle("Seleccione fichero de texto");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int seleccion = fc.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION)
		{
			textFieldRuta.setText(fc.getSelectedFile().getAbsolutePath());
			mostrarTexto(fc.getSelectedFile(),textAreaContenidoFichero);
		}
	}
	private void mostrarTexto(File rutaFich, JTextArea textArea) throws IOException {
		BufferedReader bfr=new BufferedReader(new FileReader(rutaFich));
		String linea;
		String texto="";
		while((linea=bfr.readLine())!=null){
			texto+=linea+"\n";
		}
		bfr.close();
		textArea.setText(texto);
	}

	private static Map<String,Integer> estadisticaPalabras(File rutaFich, boolean ignorarMayMin) throws IOException {
		//Genera un mapa(tabla) donde la clave es cada palabra del fichero y el valor es el n�mero de veces que se repite dicha palabra
		Map<String,Integer> mapa=new TreeMap<String,Integer>();
		BufferedReader bfr=new BufferedReader(new FileReader(rutaFich));
		String linea;
		while((linea=bfr.readLine())!=null){
			for (String pal:partirPalabras(linea)){
				if (ignorarMayMin)
					pal=pal.toUpperCase();
				//A�ade palabra al mapa con contador 1 o incrementando si ya existe
				if (mapa.containsKey(pal))
					mapa.put(pal,mapa.get(pal)+1);
				else
					mapa.put(pal,1);
			}
		}
			
		bfr.close();
		return mapa;
	}
	
	private static ArrayList<String> partirPalabras(String linea) {
		String[] pals=linea.split("[ ,.:;()�!�?]+");
		ArrayList<String> al=new ArrayList<String>();
		//Copia array a arrayList quitando cadenas vac�as que a veces deja split
		for (String pal:pals) {
			if (pal.length()>0)
				al.add(pal);
		}
		
		return al;
	}
}
