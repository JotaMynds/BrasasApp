package Administrador.Productos;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaProductosSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;
	private JTextField textField;
	private TextArea textArea;
	ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				ListaProductosSQL frame = new ListaProductosSQL();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ListaProductosSQL() {
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
		
		// ELEMENTOS DE LA PANTALLA

		JLabel lblTitulo = new JLabel("LISTADO DE PRODUCTOS");
		lblTitulo.setBounds(78, 26, 515, 34);
		lblTitulo.setForeground(new Color(238, 221, 128));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
		getContentPane().add(lblTitulo);

		textField = new JTextField();
		textField.setBounds(63, 71, 223, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnBUSCAR = new JButton("Buscar");
		btnBUSCAR.setBounds(311, 69, 89, 23);
		btnBUSCAR.setBackground(new Color(0, 128, 128));
		btnBUSCAR.setForeground(new Color(231, 221, 128));
		getContentPane().add(btnBUSCAR);

		JLabel lblTodos = new JLabel("Todos los productos");
		lblTodos.setBounds(62, 107, 143, 14);
		lblTodos.setForeground(new Color(231, 221, 128));
		lblTodos.setFont(new Font("Arial", Font.PLAIN, 11));
		getContentPane().add(lblTodos);

		textArea = new TextArea();
		textArea.setCaretPosition(1);
		textArea.setFont(new Font("Arial", Font.PLAIN, 11));
		textArea.setForeground(new Color(231, 221, 128));
		textArea.setBackground(new Color(0, 128, 128));
		textArea.setBounds(63, 132, 342, 166);
		getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Modificar productos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ModificarProductoSQL a = new ModificarProductoSQL();
				a.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(238, 221, 128));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(105, 310, 239, 23);
		getContentPane().add(btnNewButton);
		btnBUSCAR.addActionListener(e -> {
			String texto = textField.getText().trim();
			if (!texto.isEmpty()) {
				buscarProducto(texto);
			} else {
				cargarTodosLosProductos();
			}
		});
		cargarTodosLosProductos();
	}

	private void cargarTodosLosProductos() {
	    textArea.setText("");
	    try {
	        conexion.conectar();
	        ResultSet rs = conexion.ejecutarSelect("SELECT Id, Nombre, Precio FROM productos");
	        while (rs.next()) {
	            int id = rs.getInt("Id");
	            String nombre = rs.getString("Nombre");
	            double precio = rs.getDouble("Precio");
	            textArea.append(id + " - " + nombre + " - " + String.format("%.2f", precio) + "€\n");
	        }
	        conexion.desconectar();
	    } catch (Exception e) {
	        textArea.setText("Error al cargar productos: " + e.getMessage());
	    }
	}


	private void buscarProducto(String input) {
	    textArea.setText("");
	    try {
	        conexion.conectar();
	        String consulta;
	        if (input.matches("^\\d+$")) { // CADENA, DIGITO, UNO O MAS, FIN DE CADENA
	            // BUSCAR POR ID
	            consulta = "SELECT Id, Nombre, Precio FROM productos WHERE Id = " + input;
	        } else if (input.matches("^\\d+\\.\\d+$")) {
	            
	        	// BUSCAR POR PRECIO
	            consulta = "SELECT Id, Nombre, Precio FROM productos WHERE Precio = " + input;
	        } else {
	            // BUSCAR POR NOMBRE
	            consulta = "SELECT Id, Nombre, Precio FROM productos WHERE Nombre LIKE '%" + input + "%'";
	        }
	        ResultSet rs = conexion.ejecutarSelect(consulta);
	        while (rs.next()) {
	            int id = rs.getInt("Id");
	            String prodNombre = rs.getString("Nombre");
	            double precio = rs.getDouble("Precio");
	            textArea.append(id + " - " + prodNombre + " - $" + String.format("%.2f", precio) + "\n");
	        }
	        conexion.desconectar();
	    } catch (Exception e) {
	        textArea.setText("Error en la búsqueda: " + e.getMessage());
	    }
	}
}
