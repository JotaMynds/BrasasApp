package PruebasAntesDeInicio.TESTEOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PruebasAntesDeInicio.PruebasLocal.ConexionMySQL;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Formulario_Leer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FieldBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario_Leer frame = new Formulario_Leer();
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
	public Formulario_Leer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNOMBRE = new JLabel("NOMBRE");
		lblNOMBRE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNOMBRE.setBounds(88, 42, 200, 34);
		contentPane.add(lblNOMBRE);
		
		FieldBuscar = new JTextField();
		FieldBuscar.setBounds(184, 49, 174, 25);
		contentPane.add(FieldBuscar);
		FieldBuscar.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(47, 99, 417, 159);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("BUSCAR FUTBOLISTA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ConexionMySQL conexion = new ConexionMySQL("root", "", "futbol");
				try {
					conexion.conectar();
					String sentencia = "SELECT * FROM futbolista WHERE NOMBRE = '" + FieldBuscar.getText() + "'";
					ResultSet resultado = conexion.ejecutarSelect(sentencia);
					
					while(resultado.next()) 
					{
						String temp_Nombre = resultado.getString("Nombre");
						int temp_Edad = resultado.getInt("Edad");
					
						textArea.setText( /*textArea.getText() + "\n" + */ "Nombre: " + temp_Nombre +
										"\nEdad: " + temp_Edad + " años");
					}
					conexion.desconectar();
					//dispose();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(148, 273, 206, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblTITULO = new JLabel("BUSCAR FUTBOLISTA");
		lblTITULO.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTITULO.setBounds(146, -11, 488, 69);
		contentPane.add(lblTITULO);
	}
}
