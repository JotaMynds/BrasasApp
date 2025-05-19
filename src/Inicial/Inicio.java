package Inicial;

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
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
////////////////////////////////////////////////////////////////////////////////

	// INTERFAZ

	public Inicio() {
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
	
	// TITULO INICIO
	
	JLabel lblNewLabel = new JLabel("BRASAS BAR");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
	lblNewLabel.setBackground(new Color(0, 128, 128));
	lblNewLabel.setForeground(new Color(238, 221, 128));
	lblNewLabel.setBounds(150, 11, 196, 68);
	getContentPane().add(lblNewLabel);
	
	JTextPane txtpnBienvenidoABrasas = new JTextPane();
	txtpnBienvenidoABrasas.setForeground(new Color(238, 221, 128));
	txtpnBienvenidoABrasas.setBackground(new Color(0, 128, 128));
	txtpnBienvenidoABrasas.setText("Bienvenido a Brasas Bar, donde la única norma es pasarlo bien y comer mucho");
	txtpnBienvenidoABrasas.setBounds(105, 87, 296, 44);
	getContentPane().add(txtpnBienvenidoABrasas);
	
	// BOTON STAFF
	
	JButton btnNewButton = new JButton("STAFF");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			InterfazCargaStaff a = new InterfazCargaStaff();
			a.setVisible(true);
			dispose();
		}
	});
	btnNewButton.setForeground(new Color(238, 221, 128));
	btnNewButton.setBackground(new Color(0, 128, 128));
	btnNewButton.setBounds(81, 163, 110, 44);
	getContentPane().add(btnNewButton);
	
	// BOTON CLIENTES
	
	JButton btnCliente = new JButton("CLIENTE");
	btnCliente.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			InterfazCargaClientes a = new InterfazCargaClientes();
			a.setVisible(true);
			dispose();
		}
	});
	btnCliente.setForeground(new Color(238, 221, 128));
	btnCliente.setBackground(new Color(0, 128, 128));
	btnCliente.setBounds(283, 163, 110, 44);
	getContentPane().add(btnCliente);
	
	// DERECHOS DE AUTOR
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/copy.png")));
	lblNewLabel_1.setBounds(195, 306, 144, 36);
	getContentPane().add(lblNewLabel_1);
	
	JTextPane txtpnRealizadoPorIvn = new JTextPane();
	txtpnRealizadoPorIvn.setText("Realizado por Iván Sánchez y Miguel Ángel Pérez");
	txtpnRealizadoPorIvn.setForeground(new Color(238, 221, 128));
	txtpnRealizadoPorIvn.setBackground(new Color(0, 128, 128));
	txtpnRealizadoPorIvn.setBounds(120, 251, 281, 44);
	getContentPane().add(txtpnRealizadoPorIvn);

}
}
