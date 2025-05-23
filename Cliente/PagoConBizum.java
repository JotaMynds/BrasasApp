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

public class PagoConBizum extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagoConBizum frame = new PagoConBizum();
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
	public PagoConBizum() {
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
		
		JLabel lblPAGO = new JLabel("¡Pago con bizum!");
		lblPAGO.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPAGO.setBounds(143, 23, 241, 59);
		contentPane.add(lblPAGO);
		
		JLabel lblEFECTIVO = new JLabel("");
		lblEFECTIVO.addMouseListener(new MouseAdapter() {
		});
		
		// IMÁGENES
		lblEFECTIVO.setIcon(new ImageIcon(PagoConBizum.class.getResource("/Imagenes/bizum.png")));
		lblEFECTIVO.setBounds(83, 20, 106, 66);
		contentPane.add(lblEFECTIVO);
		
		JLabel lblEfectivo = new JLabel("Su comanda será cobrada con bizum en breves");
		lblEfectivo.setBounds(97, 110, 508, 14);
		contentPane.add(lblEfectivo);
		
		JLabel lblEFECTIVO_1 = new JLabel("");
		lblEFECTIVO_1.setIcon(new ImageIcon(PagoConBizum.class.getResource("/Imagenes/bizum.png")));
		lblEFECTIVO_1.setBounds(355, 23, 106, 66);
		contentPane.add(lblEFECTIVO_1);
		
		JLabel lblEsperePacientementeA = new JLabel("Espere pacientemente a que se le redirija a la plataforma de pago");
		lblEsperePacientementeA.setBounds(63, 135, 440, 14);
		contentPane.add(lblEsperePacientementeA);
	}
}
