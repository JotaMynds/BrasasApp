package Administrador.Empleados;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import Plantillas.Empleado;
import Plantillas.Producto;
import Conexion.ConexionMySQL;
import PantallasDeCarga.CargaInsertEmpleado;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.Timer;

public class ModificarEmpleadoSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;
	private DefaultListModel<Empleado> modeloLista = new DefaultListModel<>();
	private JList<Empleado> listaEmpleados;
	public static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarEmpleadoSQL frame = new ModificarEmpleadoSQL();
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
	public ModificarEmpleadoSQL() {
		getContentPane().setBackground(new Color(0, 128, 128));
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

		JButton btnNewButton = new JButton("Añadir empleado");
		btnNewButton.setBounds(61, 301, 141, 26);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CargaInsertEmpleado a = new CargaInsertEmpleado();
				a.setVisible(true);
			}
		});
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Selecciona el empleado para administrarlo:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(238, 221, 128));
		lblNewLabel_1.setBackground(new Color(0, 128, 128));
		lblNewLabel_1.setBounds(51, 68, 363, 18);
		getContentPane().add(lblNewLabel_1);
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setForeground(new Color(238, 221, 128));
		getContentPane().add(btnNewButton);

		JButton btnEliminarProducto = new JButton("Eliminar empleado");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado seleccionado = listaEmpleados.getSelectedValue();

				if (seleccionado != null) {
					id = seleccionado.getId();

					ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
					try {
						conexion.conectar();

						String consulta = "DELETE FROM empleados WHERE Id = " + id;
						conexion.ejecutarInsertDeleteUpdate(consulta);
						conexion.desconectar();
						CogerDatos();
						JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el empleado");

					} catch (SQLException ex) {
						ex.printStackTrace();
					}

				}else {
					JOptionPane.showMessageDialog(null, "Selecciona un empleado para eliminar");

				}
			}
		});
		btnEliminarProducto.setBounds(277, 301, 141, 26);
		btnEliminarProducto.setForeground(new Color(238, 221, 128));
		btnEliminarProducto.setBackground(new Color(0, 128, 128));
		getContentPane().add(btnEliminarProducto);

		JLabel lblNewLabel = new JLabel("Administrar empleados");
		lblNewLabel.setBounds(51, -23, 396, 130);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setForeground(new Color(238, 221, 128));
		getContentPane().add(lblNewLabel);

		listaEmpleados = new JList<>(modeloLista);
		listaEmpleados.setBackground(new Color(0, 128, 128));
		listaEmpleados.setForeground(new Color(238, 221, 128));
		listaEmpleados.setBounds(51, 90, 409, 200);
		getContentPane().add(listaEmpleados);

		// MÉTODO PARA ACTUALIZAR LOS DATOS
		Timer timer = new Timer(3000, e -> CogerDatos());
		CogerDatos();
		timer.start();

	}

	public void CogerDatos() {
		ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
		try {
			conexion.conectar();
			ResultSet rs = conexion.ejecutarSelect("SELECT * FROM empleados");

			modeloLista.clear();

			while (rs.next()) {
				int id = rs.getInt("Id");
				String nombre = rs.getString("Nombre");
				String ape1 = rs.getString("Primer_apellido");
				String ape2 = rs.getString("Segundo_apellido");
				int edad = rs.getInt("Edad");
				String fecha = rs.getString("Fecha_entrada");

				Empleado empleado = new Empleado(id, nombre, ape1, ape2, edad, fecha);
				modeloLista.addElement(empleado);
			}

			conexion.desconectar();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static int getId() {
			return id;
		
	}
}

