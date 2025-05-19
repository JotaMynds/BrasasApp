package PruebasAntesDeInicio.TESTEOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PruebasAntesDeInicio.PruebasLocal.ConexionMySQL;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Formulario_Insertar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FieldNombre;
	private JTextField FieldEdad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario_Insertar frame = new Formulario_Insertar();
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
	public Formulario_Insertar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFUTBOLISTA = new JLabel("AÑADIR FUTBOLISTA");
		lblFUTBOLISTA.setFont(new Font("Arial", Font.BOLD, 25));
		lblFUTBOLISTA.setBounds(65, 23, 369, 52);
		contentPane.add(lblFUTBOLISTA);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdad.setBounds(87, 131, 132, 14);
		contentPane.add(lblEdad);
		
		FieldNombre = new JTextField();
		FieldNombre.setBounds(219, 88, 86, 20);
		contentPane.add(FieldNombre);
		FieldNombre.setColumns(10);
		
		FieldEdad = new JTextField();
		FieldEdad.setBounds(219, 130, 86, 20);
		contentPane.add(FieldEdad);
		FieldEdad.setColumns(10);
		
		JButton BtnValida = new JButton("Confirmar");
		BtnValida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ConexionMySQL conexion = new ConexionMySQL("root", "", "futbol");
				try {
					conexion.conectar();
					String sentencia = "INSERT INTO futbolista (Nombre, Edad) VALUES ('" + FieldNombre.getText() + "' ," +  FieldEdad.getText() + ")";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					conexion.desconectar();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		BtnValida.setBounds(162, 175, 96, 23);
		contentPane.add(BtnValida);
		
		JLabel lblNOMBRE_1 = new JLabel("NOMBRE");
		lblNOMBRE_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNOMBRE_1.setBounds(77, 89, 132, 14);
		contentPane.add(lblNOMBRE_1);
	}
}
