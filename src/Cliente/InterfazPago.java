package Cliente;

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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.DropMode;

public class InterfazPago extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPago frame = new InterfazPago();
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
	public InterfazPago() {
		setTitle("BRASAS APP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 367);
		setUndecorated(true);
		setLocationRelativeTo(null);


		// BARRA DE MENU

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(new Color(255, 255, 255));
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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CONTENIDO DE LA PÁGINA
		
		JLabel lblPAGO = new JLabel("¡Confirma tu pedido!");
		lblPAGO.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPAGO.setBounds(112, 11, 337, 59);
		contentPane.add(lblPAGO);
		
		JLabel lblEFECTIVO = new JLabel("");
		lblEFECTIVO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		// IMÁGENES
		lblEFECTIVO.setIcon(new ImageIcon(getClass().getResource("/Imagenes/efetivo.png")));
		lblEFECTIVO.setBounds(61, 228, 60, 59);
		contentPane.add(lblEFECTIVO);

		JLabel lblBIZUM = new JLabel("");
		lblBIZUM.setIcon(new ImageIcon(getClass().getResource("/Imagenes/bizum.png")));
		lblBIZUM.setBounds(155, 244, 60, 33);
		contentPane.add(lblBIZUM);

		JLabel lblMASTERCARD = new JLabel("");
		lblMASTERCARD.setIcon(new ImageIcon(getClass().getResource("/Imagenes/mastercard.png")));
		lblMASTERCARD.setBounds(353, 81, 60, 33);
		contentPane.add(lblMASTERCARD);

		JLabel lblVISA = new JLabel("");
		lblVISA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/visa.png")));
		lblVISA.setBounds(353, 125, 60, 33);
		contentPane.add(lblVISA);
		
		JLabel lblPAYPAL = new JLabel("");
		lblPAYPAL.setIcon(new ImageIcon("C:\\Users\\Alumno1\\Documents\\GitHub\\ProyectoJava\\src\\Imagenes\\Paypal.png"));
		lblPAYPAL.setBounds(235, 244, 95, 32);
		contentPane.add(lblPAYPAL);
		
		// COMPONENTES DE TEXTO
		
		JLabel lblTarjeta = new JLabel("Numero de la tarjeta:");
		lblTarjeta.setBounds(38, 89, 187, 14);
		contentPane.add(lblTarjeta);
		
		textField = new JTextField();
		textField.setBounds(192, 86, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblExpiracion = new JLabel("Fecha de expiración:");
		lblExpiracion.setBounds(38, 114, 236, 14);
		contentPane.add(lblExpiracion);
		
		JLabel lblCVV = new JLabel("CVV");
		lblCVV.setBounds(38, 139, 117, 14);
		contentPane.add(lblCVV);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(192, 111, 137, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(192, 135, 137, 20);
		contentPane.add(textField_2);
		
		JLabel lblOPCIONES = new JLabel("Otras opciones:");
		lblOPCIONES.setBounds(38, 203, 124, 14);
		contentPane.add(lblOPCIONES);
		
		JLabel lblEfectivo = new JLabel("Efectivo");
		lblEfectivo.setBounds(71, 288, 60, 14);
		contentPane.add(lblEfectivo);
		
		JLabel lblBizum = new JLabel("Bizum");
		lblBizum.setBounds(165, 288, 60, 14);
		contentPane.add(lblBizum);
		
		JLabel lblPaypal = new JLabel("Paypal");
		lblPaypal.setBounds(245, 287, 60, 14);
		contentPane.add(lblPaypal);
		
		JButton btnCONFIRMAR = new JButton("Confirmar");
		btnCONFIRMAR.setBounds(155, 169, 95, 23);
		contentPane.add(btnCONFIRMAR);
	}
}
