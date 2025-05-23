package Administrador.Logs;

import Conexion.ConexionMySQL;
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
import javax.swing.border.EmptyBorder;

public class ListaLogsEmplSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;
	private JTextField textField;
	private TextArea textArea;
	ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ListaLogsEmplSQL frame = new ListaLogsEmplSQL();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ListaLogsEmplSQL() {

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

		// CONFIGURACIÓN DE CONTENTPANE

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TITULO

		JLabel lblTitulo = new JLabel("REGISTRO DE EMPLEADOS");
		lblTitulo.setBounds(120, 26, 300, 34);
		lblTitulo.setForeground(new Color(238, 221, 128));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		contentPane.add(lblTitulo);

		// CAMPO TEXTO PARA FILTRO

		textField = new JTextField();
		textField.setBounds(63, 80, 223, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		// BOTÓN BUSCAR

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(311, 78, 89, 23);
		btnBuscar.setBackground(new Color(0, 128, 128));
		btnBuscar.setForeground(new Color(231, 221, 128));
		contentPane.add(btnBuscar);

		// ÁREA DE TEXTO PARA MOSTRAR LOGS

		textArea = new TextArea();
		textArea.setCaretPosition(1);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea.setForeground(new Color(231, 221, 128));
		textArea.setBackground(new Color(0, 128, 128));
		textArea.setBounds(63, 120, 380, 190);
		contentPane.add(textArea);

		// ACCIÓN AL PULSAR BUSCAR

		btnBuscar.addActionListener(e -> {
			String texto = textField.getText().trim();
			if (!texto.isEmpty()) {
				buscarLogs(texto);
			} else {
				cargarTodosLosLogs();
			}
		});

		// CARGAR TODOS LOS LOGS AL INICIO

		cargarTodosLosLogs();
	}

	// FUNCIÓN PARA CARGAR TODOS LOS LOGS

	private void cargarTodosLosLogs() {
	    textArea.setText("");
	    try {
	        conexion.conectar();
	        ResultSet rs = conexion.ejecutarSelect("SELECT * FROM log_empleados ORDER BY fecha_log DESC");
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String accion = rs.getString("accion");
	            String nombre = rs.getString("nombre");
	            String primerApellido = rs.getString("primer_apellido");
	            String segundoApellido = rs.getString("segundo_apellido");
	            int edad = rs.getInt("edad");
	            String sexo = rs.getString("sexo");
	            String fechaEntrada = rs.getString("fecha_entrada");
	            String fechaLog = rs.getString("fecha_log");

	            // Línea 1: ID, ACCIÓN, EMPLEADO
	            String linea1 = String.format("ID: %d | ACCIÓN: %-6s | EMPLEADO: %s %s %s",
	                id, accion, nombre, primerApellido, segundoApellido);

	            // Línea 2: EDAD, SEXO, FECHA DE ENTRADA, FECHA DEL LOG
	            String linea2 = String.format("   EDAD: %d | SEXO: %s | FECHA ENTRADA: %s | FECHA LOG: %s",
	                edad, sexo, fechaEntrada, fechaLog);

	            textArea.append(linea1 + "\n" + linea2 + "\n\n");
	        }
	        conexion.desconectar();
	    } catch (Exception e) {
	        textArea.setText("ERROR AL CARGAR LOGS: " + e.getMessage());
	    }
	}


	// FUNCIÓN PARA BUSCAR LOGS POR NOMBRE O ACCIÓN

	private void buscarLogs(String filtro) {
	    textArea.setText("");
	    try {
	        conexion.conectar();
	        String consulta = "SELECT * FROM log_empleados WHERE nombre LIKE '%" + filtro +
	            "%' OR accion LIKE '%" + filtro + "%' ORDER BY fecha_log DESC";
	        ResultSet rs = conexion.ejecutarSelect(consulta);
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String accion = rs.getString("accion");
	            String nombre = rs.getString("nombre");
	            String primerApellido = rs.getString("primer_apellido");
	            String segundoApellido = rs.getString("segundo_apellido");
	            int edad = rs.getInt("edad");
	            String sexo = rs.getString("sexo");
	            String fechaEntrada = rs.getString("fecha_entrada");
	            String fechaLog = rs.getString("fecha_log");

	            // Línea 1: ID, ACCIÓN, EMPLEADO
	            String linea1 = String.format("ID: %d | ACCIÓN: %-6s | EMPLEADO: %s %s %s",
	                id, accion, nombre, primerApellido, segundoApellido);

	            // Línea 2: EDAD, SEXO, FECHA ENTRADA, FECHA LOG
	            String linea2 = String.format("   EDAD: %d | SEXO: %s | FECHA ENTRADA: %s | FECHA LOG: %s",
	                edad, sexo, fechaEntrada, fechaLog);

	            textArea.append(linea1 + "\n" + linea2 + "\n\n");
	        }
	        conexion.desconectar();
	    } catch (Exception e) {
	        textArea.setText("ERROR EN LA BÚSQUEDA: " + e.getMessage());
	    }
	}


}
