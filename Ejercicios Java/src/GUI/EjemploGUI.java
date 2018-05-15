package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import colecciones.Parejas;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

public class EjemploGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textAreaAlfabetico;
	private JTextArea textAreaRepeticiones;
	private JCheckBox chckbxMayMin;
	private JTextArea textAreaContenido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploGUI frame = new EjemploGUI();
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
	public EjemploGUI() {
		setTitle("Estadistica de palabras");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 478, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Seleccionar Fichero");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lanzarFileChooser();
			}
		});
		btnNewButton.setBounds(10, 29, 156, 23);
		contentPane.add(btnNewButton);

		JLabel lblRuta = new JLabel("Ruta de fichero:");
		lblRuta.setBounds(176, 11, 96, 14);
		contentPane.add(lblRuta);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(176, 30, 249, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1 = new JButton("Obtener Palabras");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarContenido(textAreaContenido);
				mostrarPalabrasOrdenadas(textAreaAlfabetico, textAreaRepeticiones);
			}
		});
		btnNewButton_1.setBounds(10, 63, 156, 23);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 252, 196, 88);
		contentPane.add(scrollPane);

		textAreaAlfabetico = new JTextArea();
		scrollPane.setViewportView(textAreaAlfabetico);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(256, 252, 196, 88);
		contentPane.add(scrollPane_1);

		textAreaRepeticiones = new JTextArea();
		scrollPane_1.setViewportView(textAreaRepeticiones);

		chckbxMayMin = new JCheckBox("Ignorar Mayusculas/Minusculas");
		chckbxMayMin.setBounds(175, 63, 175, 23);
		contentPane.add(chckbxMayMin);

		JLabel lblNewLabel = new JLabel("Listado por orden alfabetico");
		lblNewLabel.setBounds(10, 227, 196, 14);
		contentPane.add(lblNewLabel);

		JLabel lblListadoPorNumero = new JLabel("Listado por numero de repeticiones");
		lblListadoPorNumero.setBounds(256, 227, 196, 14);
		contentPane.add(lblListadoPorNumero);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 97, 442, 115);
		contentPane.add(scrollPane_2);

		textAreaContenido = new JTextArea();
		scrollPane_2.setViewportView(textAreaContenido);
	}

	protected void mostrarPalabrasOrdenadas(JTextArea textAreaAlfabetico, JTextArea textAreaRepeticiones) {
		try {
			// Ordenado alfabeticamente
			Map<String, Integer> mapa = estadisticaPalabras(new File(textField.getText()), chckbxMayMin.isSelected());
			String texto = "";
			for (String pal : mapa.keySet()) {
				texto += pal + " " + mapa.get(pal) + "\n";
			}
			textAreaAlfabetico.setText(texto);

			// Ordenado por repeticion de palabras
			ArrayList<Parejas> cadena = new ArrayList<Parejas>();
			for (String pal : mapa.keySet()) {
				cadena.add(new Parejas(pal, (Integer) mapa.get(pal)));
			}
			Collections.sort(cadena);
			texto = "";
			for (Parejas pareja : cadena) {
				texto += pareja.getPalabra() + " " + pareja.getRepeticiones() + "\n";
			}
			textAreaRepeticiones.setText(texto);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	protected void mostrarContenido(JTextArea textAreaContenido) {
		BufferedReader bfr = null;
		try {
			bfr = new BufferedReader(new FileReader(new File(textField.getText())));
			String contenido;
			String texto = "";
			while ((contenido = bfr.readLine()) != null) {
				texto += contenido + "\n";
			}
			textAreaContenido.setText(texto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bfr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected void lanzarFileChooser() {
		JFileChooser fc = new JFileChooser("/");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("Seleccione fichero origen");
		int opcion = fc.showOpenDialog(null);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			textField.setText(fc.getSelectedFile().getAbsolutePath());

		}

	}

	private static Map<String, Integer> estadisticaPalabras(File rutaFich, boolean ignorarMayMin) throws IOException {
		Map<String, Integer> mapa = new TreeMap<String, Integer>();
		BufferedReader bfr = new BufferedReader(new FileReader(rutaFich));
		String linea;
		while ((linea = bfr.readLine()) != null) {
			for (String pal : partirPalabras(linea)) {
				if (ignorarMayMin)
					pal = pal.toUpperCase();
				// Añade palabra al mapa con contador 1 o incrementando si ya existe
				if (mapa.containsKey(pal))
					mapa.put(pal, mapa.get(pal) + 1);
				else
					mapa.put(pal, 1);
			}
		}

		bfr.close();
		return mapa;
	}

	private static String[] partirPalabras(String linea) {
		return linea.split("[ ,.:;()¡!¿?]+");
	}
}
