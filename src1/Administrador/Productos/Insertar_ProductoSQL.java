package Administrador.Productos;

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Conexion.ConexionMySQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Insertar_ProductoSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Insertar_ProductoSQL frame = new Insertar_ProductoSQL();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Insertar_ProductoSQL() {

		// CONFIGURACIÓN GENERAL DEL FRAME
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

		// PANEL PRINCIPAL
		contentPane = new JPanel();
		contentPane.setForeground(new Color(238, 221, 128));
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TÍTULO
		JLabel lblTitulo = new JLabel("INSERTAR PRODUCTO");
		lblTitulo.setBackground(new Color(0, 128, 128));
		lblTitulo.setForeground(new Color(238, 221, 128));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 11, 487, 48);
		contentPane.add(lblTitulo);

		// CAMPO NOMBRE
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(131, 70, 200, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblNewNombre = new JLabel("Nombre:");
		lblNewNombre.setForeground(new Color(238, 221, 128));
		lblNewNombre.setBackground(new Color(0, 128, 128));
		lblNewNombre.setBounds(67, 73, 67, 14);
		contentPane.add(lblNewNombre);

		// SLIDER DE PRECIO
		JSlider BarraEuros = new JSlider(0, 5000, 1000); // VALORES ENTRE 0 Y 50 €
		BarraEuros.setPaintTicks(true);
		BarraEuros.setForeground(new Color(238, 221, 128));
		BarraEuros.setBackground(new Color(0, 128, 128));
		BarraEuros.setBounds(43, 134, 400, 50);
		BarraEuros.setPaintLabels(true);
		BarraEuros.setMajorTickSpacing(1000);
		BarraEuros.setMinorTickSpacing(100);

		// PRECIOS DE LA BARRA
		Hashtable<Integer, JLabel> etiquetas = new Hashtable<>();
		for (int i = 0; i <= 5000; i += 1000) {
		    JLabel etiqueta = new JLabel(String.format("%.2f €", i / 100.0));
		    etiqueta.setForeground(new Color(238, 221, 128)); // Establecer color de la etiqueta
		    etiquetas.put(i, etiqueta);
		}
		BarraEuros.setLabelTable(etiquetas);
		contentPane.add(BarraEuros);

		// LABEL QUE MUESTRA EL VALOR DINÁMICAMENTE
		JLabel labelPrecioActual = new JLabel("Precio: " + (BarraEuros.getValue() / 100.0) + " €");
		labelPrecioActual.setBounds(67, 102, 200, 20);
		labelPrecioActual.setForeground(new Color(238, 221, 128));
		contentPane.add(labelPrecioActual);

		// ESCUCHA CAMBIOS EN EL SLIDER
		BarraEuros.addChangeListener(e -> {
			double precio = BarraEuros.getValue() / 100.0;
			labelPrecioActual.setText("Precio:     " + precio + " €");
		});

		// BOTÓN AÑADIR PRODUCTO
		JButton btnNewButtonAñadir = new JButton("Añadir");
		btnNewButtonAñadir.setForeground(new Color(238, 221, 128));
		btnNewButtonAñadir.setBackground(new Color(0, 128, 128));
		btnNewButtonAñadir.setBounds(199, 273, 89, 23);
		btnNewButtonAñadir.addActionListener(e -> {
			ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
			double precio = BarraEuros.getValue() / 100.0;
			boolean encontrado = false;
			
			if(lblNewNombre.getText().equals("")) {
				
				JOptionPane.showMessageDialog(null, "El nombre está vacío, inserte nombre");
			}else {
			try {
				conexion.conectar();
				String sentencia = "SELECT * FROM productos;";
				ResultSet rs = conexion.ejecutarSelect(sentencia);
				while(rs.next()){
					if(!(textFieldNombre.getText().equalsIgnoreCase(rs.getString("Nombre")))) {
						encontrado=true;
						JOptionPane.showMessageDialog(null, "Se ha añadido correctamente el producto");
						break;
					}
				}
				if(encontrado) {
					String sentencia1 = "INSERT INTO `productos`(`Nombre`, `Precio`) VALUES ('" +
					textFieldNombre.getText() + "','" + precio + "')";
					conexion.ejecutarInsertDeleteUpdate(sentencia1);
					// CREAR TRIGGERS
					String triggerInsert = "CREATE TRIGGER log_producto_insert AFTER INSERT ON productos " +
							"FOR EACH ROW " +
							"INSERT INTO log_productos (accion, nombre_producto, fecha_cambio) " +
							"VALUES ('INSERT', NEW.Nombre, NOW());";

					String triggerUpdate = "CREATE TRIGGER log_producto_update AFTER UPDATE ON productos " +
							"FOR EACH ROW " +
							"INSERT INTO log_productos (accion, nombre_producto, fecha_cambio) " +
							"VALUES ('UPDATE', NEW.Nombre, NOW());";

					String triggerDelete = "CREATE TRIGGER log_producto_delete AFTER DELETE ON productos " +
							"FOR EACH ROW " +
							"INSERT INTO log_productos (accion, nombre_producto, fecha_cambio) " +
							"VALUES ('DELETE', OLD.Nombre, NOW());";

					conexion.ejecutarInsertDeleteUpdate(triggerInsert);
					conexion.ejecutarInsertDeleteUpdate(triggerUpdate);
					conexion.ejecutarInsertDeleteUpdate(triggerDelete);
				}else {
					JOptionPane.showMessageDialog(null, "ERROR: El producto ya existe, introduce otro");

				}
				conexion.desconectar();
				ListaProductosSQL a = new ListaProductosSQL();
				a.setVisible(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			}});
		contentPane.add(btnNewButtonAñadir);

		// ETIQUETA INFORMATIVA
		JLabel labelinfo = new JLabel("Pulsar a la izquierda o a la derecha de la barra para sumar o restar 0,01 al precio");
		labelinfo.setFont(new Font("Arial", Font.BOLD, 10));
		labelinfo.setForeground(new Color(238, 221, 128));
		labelinfo.setBounds(32, 196, 450, 20);
		contentPane.add(labelinfo);
	}
}
