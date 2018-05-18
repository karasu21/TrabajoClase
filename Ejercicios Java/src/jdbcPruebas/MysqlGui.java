package jdbcPruebas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class MysqlGui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIp;
	private JTextField textFieldUsuario;
	private JPasswordField textFieldContrasena;
	private JTextField textFieldBusqueda;
	private JTextField textFieldResultado;
	private JButton btnBuscar;
	private JButton btnNewButton;
	private JLabel lblBusqueda;
	private JLabel lblResultado;
	private Connection cn;
	private ResultSet rs;
	private JRadioButton rdbtnPoblacion;
	private JRadioButton rdbtnCodigo;
	private JPanel panelBusqueda;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MysqlGui frame = new MysqlGui();
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
	public MysqlGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIpMysql = new JLabel("IP MySQL");
		lblIpMysql.setBounds(23, 28, 59, 14);
		contentPane.add(lblIpMysql);
		
		textFieldIp = new JTextField();
		textFieldIp.setText("172.26.104.200");
		textFieldIp.setBounds(92, 25, 129, 20);
		contentPane.add(textFieldIp);
		textFieldIp.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(23, 59, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(23, 90, 66, 14);
		contentPane.add(lblContrasea);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setText("alumno");
		textFieldUsuario.setBounds(92, 56, 86, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContrasena = new JPasswordField();
		textFieldContrasena.setText("alumno");
		textFieldContrasena.setBounds(92, 87, 86, 20);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		
		btnNewButton = new JButton("Conectar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conectar();
				
			}
		});
		btnNewButton.setBounds(200, 106, 89, 23);
		contentPane.add(btnNewButton);
		
		panelBusqueda = new JPanel();
		panelBusqueda.setVisible(false);
		panelBusqueda.setBounds(10, 158, 387, 58);
		contentPane.add(panelBusqueda);
		panelBusqueda.setLayout(null);
		
		lblBusqueda = new JLabel("Codigo|Poblacion");
		lblBusqueda.setBounds(0, 1, 86, 14);
		panelBusqueda.add(lblBusqueda);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(0, 38, 72, 14);
		panelBusqueda.add(lblResultado);
		
		textFieldBusqueda = new JTextField();
		textFieldBusqueda.setBounds(102, 1, 86, 20);
		panelBusqueda.add(textFieldBusqueda);
		textFieldBusqueda.setColumns(10);
		
		textFieldResultado = new JTextField();
		textFieldResultado.setBounds(102, 38, 86, 20);
		panelBusqueda.add(textFieldResultado);
		textFieldResultado.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(216, 34, 89, 23);
		panelBusqueda.add(btnBuscar);
		
		rdbtnCodigo = new JRadioButton("Codigo");
		rdbtnCodigo.setSelected(true);
		buttonGroup.add(rdbtnCodigo);
		rdbtnCodigo.setBounds(205, 0, 72, 23);
		panelBusqueda.add(rdbtnCodigo);
		
		
		rdbtnPoblacion = new JRadioButton("Poblacion");
		buttonGroup.add(rdbtnPoblacion);
		rdbtnPoblacion.setBounds(278, 0, 109, 23);
		panelBusqueda.add(rdbtnPoblacion);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar(rdbtnPoblacion.isSelected(), rdbtnCodigo.isSelected());
				
			}
		});
	}

	protected void buscar(boolean pob, boolean cod) {
		 PreparedStatement pstBuscarCodigo;
		 String sqlBusqueda;
		if (cod) {
			sqlBusqueda = "SELECT poblacion FROM poblaciones WHERE codigo=?";
		} else {
			sqlBusqueda = "SELECT codigo FROM poblaciones WHERE poblacion=?";
		}
		
		    try {
				pstBuscarCodigo = cn.prepareStatement(sqlBusqueda);
				pstBuscarCodigo.setString(1, textFieldBusqueda.getText());
				ResultSet rs = pstBuscarCodigo.executeQuery();
				 if (rs.next())
				    {
				    	String resultado=rs.getString (1);
				    	textFieldResultado.setText(resultado);
				       
				    }  else {
				    	JOptionPane.showMessageDialog(null, "No se encontraron resultados", "Error", JOptionPane.ERROR_MESSAGE);
				    }   
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
	}

	protected void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://"+ textFieldIp.getText() + "/programacion", textFieldUsuario.getText(), textFieldContrasena.getText());
			panelBusqueda.setVisible(true);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al conectar con el servidor", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
