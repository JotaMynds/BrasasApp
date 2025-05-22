package Administrador.Empleados;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Conexion.ConexionMySQL;
import java.awt.Font;

public class Insertar_EmpleadoSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldSegundoApellido;
	private JTextField textFieldEdad;
	private JTextField textFieldPrimerApellido;
	private JTextField textFieldFechaEntrada;
	private int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertar_EmpleadoSQL frame = new Insertar_EmpleadoSQL();
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
	public Insertar_EmpleadoSQL() {
		setBackground(new Color(0, 128, 128));
		setTitle("BRASAS APP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 367);
		setUndecorated(true);
		setLocationRelativeTo(null);

		// BARRA DE MENU

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(new Color(0, 128, 128));
		menuBar_1.setBackground(new Color(0, 128, 128));
		setJMenuBar(menuBar_1);

		// ARRASTRAR BARRA DE MENÚ

		// DETECTOR PARA SABER SI SE AGARRA LA BARRA

		menuBar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});

		// REALIZAR EL MOVIMIENTO DE LA BARRA A LA PAR QUE EL RATÓN

		menuBar_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen() - xMouse;
				int y = e.getYOnScreen() - yMouse;
				setLocation(x, y);
			}
		});

		// ESPACIADO

		JLabel lblEspacio_5 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5);

		// BOTÓN MINIMIZAR

		JButton btnMinimizar = new JButton(" _ ");
		btnMinimizar.addActionListener(e -> setState(Frame.ICONIFIED));

		JLabel lblEspacio_5_9_1 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_9_1);

		JLabel lblEspacio_5_9 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_9);

		JLabel lblEspacio_5_11 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_11);

		JLabel lblEspacio_5_13 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_13);

		JLabel lblEspacio_5_6_1_1 = new JLabel("BRASAS APP");
		lblEspacio_5_6_1_1.setForeground(new Color(238, 221, 128));
		menuBar_1.add(lblEspacio_5_6_1_1);

		JLabel lblEspacio_5_14 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_14);

		JLabel lblEspacio_5_15 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_15);

		JLabel lblEspacio_5_16 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_16);

		JLabel lblEspacio_5_15_1 = new JLabel("          ");
		menuBar_1.add(lblEspacio_5_15_1);
		menuBar_1.add(btnMinimizar);

		// BOTÓN CERRAR

		JButton btnCerrar = new JButton(" x ");
		btnCerrar.addActionListener(e -> dispose());
		menuBar_1.add(btnCerrar);
		setBackground(new Color(0, 128, 128));
		setTitle("BRASAS APP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 367);
		setUndecorated(true);
		setLocationRelativeTo(null);

		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setForeground(new Color(0, 128, 128));
		getContentPane().setLayout(null);

		// Panel principal
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("INSERTAR EMPLEADO");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 21));
		lblTitulo.setBackground(new Color(0, 128, 128));
		lblTitulo.setForeground(new Color(238, 221, 128));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 487, 65);
		contentPane.add(lblTitulo);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(274, 77, 86, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldPrimerApellido = new JTextField();
		textFieldPrimerApellido.setBounds(274, 108, 86, 20);
		contentPane.add(textFieldPrimerApellido);
		textFieldPrimerApellido.setColumns(10);

		textFieldSegundoApellido = new JTextField();
		textFieldSegundoApellido.setBounds(274, 139, 86, 20);
		contentPane.add(textFieldSegundoApellido);
		textFieldSegundoApellido.setColumns(10);

		textFieldEdad = new JTextField();
		textFieldEdad.setBounds(274, 170, 86, 20);
		contentPane.add(textFieldEdad);
		textFieldEdad.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<>(new String[] {"Hombre", "Mujer"});
		comboBox.setBounds(274, 201, 86, 22);
		contentPane.add(comboBox);

		textFieldFechaEntrada = new JTextField();
		textFieldFechaEntrada.setText("AAAA-MM-DD");
		textFieldFechaEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldFechaEntrada.setText("");
			}
		});
		textFieldFechaEntrada.setBounds(274, 232, 86, 20);
		contentPane.add(textFieldFechaEntrada);
		textFieldFechaEntrada.setColumns(10);

		JLabel lblNewNombre = new JLabel("Nombre:");
		lblNewNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewNombre.setBackground(new Color(0, 128, 128));
		lblNewNombre.setForeground(new Color(238, 221, 128));
		lblNewNombre.setBounds(100, 77, 100, 14);
		contentPane.add(lblNewNombre);

		JLabel lblPrimerApellido = new JLabel("Primer apellido:");
		lblPrimerApellido.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrimerApellido.setBackground(new Color(0, 128, 128));
		lblPrimerApellido.setForeground(new Color(238, 221, 128));
		lblPrimerApellido.setBounds(100, 108, 100, 14);
		contentPane.add(lblPrimerApellido);

		JLabel lblSegundoApellido = new JLabel("Segundo apellido:");
		lblSegundoApellido.setFont(new Font("Arial", Font.BOLD, 12));
		lblSegundoApellido.setBackground(new Color(0, 128, 128));
		lblSegundoApellido.setForeground(new Color(238, 221, 128));
		lblSegundoApellido.setBounds(100, 139, 121, 14);
		contentPane.add(lblSegundoApellido);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Arial", Font.BOLD, 12));
		lblEdad.setBackground(new Color(0, 128, 128));
		lblEdad.setForeground(new Color(238, 221, 128));
		lblEdad.setBounds(100, 170, 100, 14);
		contentPane.add(lblEdad);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Arial", Font.BOLD, 12));
		lblSexo.setBackground(new Color(0, 128, 128));
		lblSexo.setForeground(new Color(238, 221, 128));
		lblSexo.setBounds(100, 201, 100, 14);
		contentPane.add(lblSexo);

		JLabel lblFechaEntrada = new JLabel("Fecha de entrada:");
		lblFechaEntrada.setFont(new Font("Arial", Font.BOLD, 12));
		lblFechaEntrada.setBackground(new Color(0, 128, 128));
		lblFechaEntrada.setForeground(new Color(238, 221, 128));
		lblFechaEntrada.setBounds(100, 232, 121, 14);
		contentPane.add(lblFechaEntrada);

		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.setForeground(new Color(238, 221, 128));
		btnAñadir.setBackground(new Color(0, 128, 128));
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				boolean encontrado = false;

				try {
					conexion.conectar();
					String sentencia = "SELECT * FROM empleados";
					ResultSet rs = conexion.ejecutarSelect(sentencia);

					while (rs.next()) {
						if (
							textFieldNombre.getText().equalsIgnoreCase(rs.getString("Nombre")) &&
							textFieldPrimerApellido.getText().equalsIgnoreCase(rs.getString("Primer_apellido")) &&
							textFieldSegundoApellido.getText().equalsIgnoreCase(rs.getString("Segundo_apellido")) &&
							Integer.parseInt(textFieldEdad.getText()) == rs.getInt("Edad")
						) {
							encontrado = true;
							break;
						}
					}

					if (!encontrado) {
						String sentencia2 = "INSERT INTO empleados(Nombre, Primer_apellido, Segundo_apellido, Edad, Sexo, Fecha_entrada) VALUES ('" +
								textFieldNombre.getText() + "', '" +
								textFieldPrimerApellido.getText() + "', '" +
								textFieldSegundoApellido.getText() + "', " +
								textFieldEdad.getText() + ", '" +
								comboBox.getSelectedItem() + "', '" +
								textFieldFechaEntrada.getText() + "')";

						conexion.ejecutarInsertDeleteUpdate(sentencia2);
						
						dispose();
						ListaEmpleadosSQL a = new ListaEmpleadosSQL();
						a.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "El empleado ya estaba registrado");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Edad no válida. Introduce un número.");
				}
			}
		});
		btnAñadir.setBounds(190, 280, 89, 23);
		contentPane.add(btnAñadir);
	}
}
