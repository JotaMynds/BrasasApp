package Administrador.Empleados;

import Conexion.ConexionMySQL;
import PantallasDeCarga.CargaModEmpleado;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaEmpleadosSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;
	private JTextField textField;
	private TextArea textArea;
	ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ListaEmpleadosSQL frame = new ListaEmpleadosSQL();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ListaEmpleadosSQL() {
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setForeground(new Color(0, 128, 128));
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
		getContentPane().setLayout(null);

		// Elementos de la pantalla

		JLabel lblTitulo = new JLabel("LISTADO DE EMPLEADOS");
		lblTitulo.setBounds(69, 20, 515, 34);
		lblTitulo.setForeground(new Color(238, 221, 128));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
		getContentPane().add(lblTitulo);

		textField = new JTextField();
		textField.setBounds(60, 65, 223, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnBUSCAR = new JButton("Buscar");
		btnBUSCAR.setBounds(308, 63, 89, 23);
		btnBUSCAR.setBackground(new Color(0, 128, 128));
		btnBUSCAR.setForeground(new Color(231, 221, 128));
		getContentPane().add(btnBUSCAR);

		JLabel lblTodos = new JLabel("Todos los productos");
		lblTodos.setBounds(63, 97, 143, 14);
		lblTodos.setForeground(new Color(231, 221, 128));
		lblTodos.setFont(new Font("Arial", Font.PLAIN, 11));
		getContentPane().add(lblTodos);

		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 11));
		textArea.setForeground(new Color(231, 221, 128));
		textArea.setBackground(new Color(0, 128, 128));
		textArea.setBounds(64, 122, 342, 166);
		getContentPane().add(textArea);

		JButton btnNewButton = new JButton("Modificar empleado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CargaModEmpleado a = new CargaModEmpleado();
				a.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setForeground(new Color(238, 221, 128));
		btnNewButton.setBounds(120, 299, 207, 26);
		getContentPane().add(btnNewButton);
		btnBUSCAR.addActionListener(e -> {
			String texto = textField.getText().trim();
			if (!texto.isEmpty()) {
				buscarEmpleado(texto);
			} else {
				cargarTodosLosEmpleados();
			}
		});
		cargarTodosLosEmpleados();
		
	}

	private void cargarTodosLosEmpleados() {
		textArea.setText("");
		try {
			conexion.conectar();

			ResultSet rs = conexion.ejecutarSelect("SELECT * FROM empleados");

			while (rs.next()) {
				int id = rs.getInt("Id");
				String nombre = rs.getString("Nombre");
				String apellido1 = rs.getString("Primer_apellido");
				String apellido2 = rs.getString("Segundo_apellido");
				int edad = rs.getInt("Edad");
				String sexo = rs.getString("Sexo");
				String fechaEntrada = rs.getString("Fecha_entrada");

				textArea.append(id + " - " + nombre + " " + apellido1 + " " + apellido2 + " | Edad: " + edad
						+ ", Entrada: " + fechaEntrada + "\n");
			}

			conexion.desconectar();
		} catch (Exception e) {
			textArea.setText("Error al cargar empleados: " + e.getMessage());
		}
	}

	private void buscarEmpleado(String input) {
	    textArea.setText("");
	    
	    try {
	        conexion.conectar();
	        String consulta;

	        if (input.toLowerCase().startsWith("id:")) {
	            int id = Integer.parseInt(input.substring(3).trim());
	            consulta = "SELECT * FROM empleados WHERE Id = " + id;

	        } else if (input.toLowerCase().startsWith("edad:")) {
	            int edad = Integer.parseInt(input.substring(5).trim());
	            consulta = "SELECT * FROM empleados WHERE Edad = " + edad;

	        } else if (input.matches("^\\d+$")) {
	            int valor = Integer.parseInt(input);
	            consulta = "SELECT * FROM empleados WHERE Id = " + valor +
	                       " OR Edad = " + valor;

	        } else {
	            consulta = "SELECT * FROM empleados WHERE " +
	                       "Nombre LIKE '%" + input + "%' OR " +
	                       "Primer_apellido LIKE '%" + input + "%' OR " +
	                       "Segundo_apellido LIKE '%" + input + "%'";
	        }

	        ResultSet rs = conexion.ejecutarSelect(consulta);
	        boolean hayResultados = false;

	        while (rs.next()) {
	            hayResultados = true;
	            int id = rs.getInt("Id");
	            String nombre = rs.getString("Nombre");
	            String ape1 = rs.getString("Primer_apellido");
	            String ape2 = rs.getString("Segundo_apellido");
	            int edad = rs.getInt("Edad");
	            String sexo = rs.getString("Sexo");
	            String fecha = rs.getString("Fecha_entrada");

	            textArea.append(
	                id + " - " + nombre + " " + ape1 + " " + ape2 +
	                " | Edad: " + edad + ", Sexo: " + sexo +
	                ", Entrada: " + fecha + "\n"
	            );
	        }

	        if (!hayResultados) {
	            textArea.setText("No se encontraron empleados.");
	        }

	        conexion.desconectar();

	    } catch (Exception e) {
	        textArea.setText("Error en la búsqueda: " + e.getMessage());
	    }
	}


}
