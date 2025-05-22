package Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PantallasDeCarga.*;
import Administrador.*;
 
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class StaffMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffMenu frame = new StaffMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

////////////////////////////////////////////////////////////////////////////////

	// INTERFAZ

	public StaffMenu() {
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

		// BOTONES DE ADMINISTRADOR

		JButton btnListadoProducto = new JButton("Productos");
		btnListadoProducto.setBackground(new Color(0, 128, 128));
		btnListadoProducto.setForeground(new Color(231, 221, 128));
		btnListadoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaProductos a = new CargaProductos();
				a.setVisible(true);
			}
		});
		btnListadoProducto.setBounds(44, 103, 176, 26);
		getContentPane().add(btnListadoProducto);

		JButton btnModificarProducto = new JButton("Modificar producto");
		btnModificarProducto.setBackground(new Color(0, 128, 128));
		btnModificarProducto.setForeground(new Color(231, 221, 128));
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaModProductos a = new CargaModProductos();
				a.setVisible(true);
			}
		});
		btnModificarProducto.setBounds(299, 103, 163, 26);
		getContentPane().add(btnModificarProducto);
		setBackground(new Color(0, 128, 128));
		setTitle("BRASAS APP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 367);
		setUndecorated(true);
		setLocationRelativeTo(null);

		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setForeground(new Color(0, 128, 128));
		getContentPane().setLayout(null);

		// TITULO

		JLabel lblNewLabel = new JLabel("ADMINISTRADOR");
		lblNewLabel.setBounds(136, 27, 295, 34);
		lblNewLabel.setForeground(new Color(238, 221, 128));
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		getContentPane().add(lblNewLabel);

		JLabel lblCopyRight = new JLabel("");
		lblCopyRight.setIcon(new ImageIcon(StaffMenu.class.getResource("/Imagenes/copy.png")));
		lblCopyRight.setBounds(173, 310, 134, 26);
		getContentPane().add(lblCopyRight);
		
		JButton btnListadoDeEmpleados = new JButton("Empleados");
		btnListadoDeEmpleados.setBackground(new Color(0, 128, 128));
		btnListadoDeEmpleados.setForeground(new Color(231, 221, 128));
		btnListadoDeEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaEmpleados a = new CargaEmpleados();
				a.setVisible(true);
			}
		});
		btnListadoDeEmpleados.setBounds(44, 211, 176, 26);
		getContentPane().add(btnListadoDeEmpleados);
		
		JButton btnModificarEmpleados = new JButton("Modificar empleados");
		btnModificarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaModEmpleado a = new CargaModEmpleado();
				a.setVisible(true);
			}
		});
		btnModificarEmpleados.setBackground(new Color(0, 128, 128));
		btnModificarEmpleados.setForeground(new Color(231, 221, 128));
		btnModificarEmpleados.setBounds(299, 211, 163, 26);
		getContentPane().add(btnModificarEmpleados);
		
		JButton btnMesas = new JButton("Gestor de comandas");
		btnMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargaGestorComandas a = new CargaGestorComandas();
				a.setVisible(true);
			}
		});
		btnMesas.setBackground(new Color(0, 128, 128));
		btnMesas.setForeground(new Color(231, 221, 128));
		btnMesas.setBounds(173, 155, 176, 26);
		getContentPane().add(btnMesas);
		
		

	}
}
