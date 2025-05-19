package Inicial;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Administrador.InterfazStaffMenu;
import Cliente.InterfazInicioSesion;
import Cliente.InterfazPago;

public class InterfazCargaStaff extends JFrame {

	// VARIABLES

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				InterfazCargaStaff frame = new InterfazCargaStaff();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
////////////////////////////////////////////////////////////////////////////

	// INTERFAZ

	public InterfazCargaStaff() {
		setTitle("BRASAS APP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 267, 151);

		// ELIMINAR BARRA ESTANDAR DE WINDOWS

		setUndecorated(true);

		// REDIRECCIONAR LA APERTURA DE LA PESTAÑA

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

		JLabel lblEspacio_2 = new JLabel("    ");
		menuBar_1.add(lblEspacio_2);

		// ESPACIO
		JLabel lblEspacio_4 = new JLabel("BRASAS APP");
		lblEspacio_4.setBackground(new Color(0, 128, 128));
		lblEspacio_4.setForeground(new Color(238, 221, 128));
		menuBar_1.add(lblEspacio_4);

		// ESPACIADO

		JLabel lblEspacio = new JLabel("            ");
		menuBar_1.add(lblEspacio);

		// BOTÓN MINIMIZAR

		JButton btnMinimizar = new JButton(" _ ");
		btnMinimizar.addActionListener(e -> setState(Frame.ICONIFIED));

		JLabel lblEspacio_1 = new JLabel("            ");
		menuBar_1.add(lblEspacio_1);
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

		// CONFIGURAR BARRA DE PROGRESO

		JProgressBar BarraCarga = new JProgressBar();
		BarraCarga.setBounds(37, 54, 177, 20);
		BarraCarga.setMinimum(0);
		BarraCarga.setMaximum(100);

		// MUESTRA EL PORCENTAJE DE LA CARGA

		BarraCarga.setStringPainted(true);
		contentPane.add(BarraCarga);

		JLabel lblCargando = new JLabel("Cargando pantalla staff...");
		lblCargando.setForeground(new Color(238, 221, 128));
		lblCargando.setBackground(new Color(0, 128, 128));
		lblCargando.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCargando.setBounds(37, 11, 208, 32);
		contentPane.add(lblCargando);

		// CONFIGURAR CARGA DE LA BARRA

		// LOCALIZAR PROGRESO

		int[] progress = { 0 };

		// CREACIÓN DE TIMER PARA LA CARGA DE LA BARRA

		Timer timer = new Timer(100, e -> {
			// SI EL PROGRESO ES MENOR O IGUAL A 100, LO IGUALA AL VALOR ANTERIOR Y LE SUMA
			// 5
			if (progress[0] <= 100) {
				BarraCarga.setValue(progress[0]);
				progress[0] += 10;
			} else {

				// DETIENE EL TIMER SI LA BARRA ES MAYOR A 100

				((Timer) e.getSource()).stop();

				// MOSTRAR NUEVA PÁGINA
				InterfazStaffMenu a = new InterfazStaffMenu();
				a.setVisible(true);

				// CERRAR LA PESTAÑA

				dispose();
			}
		});

		// INICIA EL TIMER

		timer.start();
	}

	// GRABADOR DE INTERACCIONES CON EL RATÓN

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}