package Cliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import Conexion.ConexionMySQL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.DropMode;

public class PagoSQL extends JFrame {

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
					PagoSQL frame = new PagoSQL();
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
	public PagoSQL() {
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

		// CONTENIDO DE LA PÁGINA

		JLabel lblPAGO = new JLabel("¡Confirma tu pedido!");
		lblPAGO.setFont(new Font("Arial", Font.PLAIN, 25));
		lblPAGO.setBounds(112, 11, 337, 59);
		contentPane.add(lblPAGO);

		JLabel lblEFECTIVO = new JLabel("");
		lblEFECTIVO.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					conexion.conectar();
					String sentencia = "DELETE FROM clientes WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					String sentencia2 = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia2);

					conexion.desconectar();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al realizar sentencia: " + e1.getMessage());
				}
				dispose();
				PagoEnEfectivo a = new PagoEnEfectivo();
				a.setVisible(true);
			}
		});

		// IMÁGENES
		lblEFECTIVO.setIcon(new ImageIcon(PagoSQL.class.getResource("/Imagenes/efetivo.png")));
		lblEFECTIVO.setBounds(122, 113, 60, 59);
		contentPane.add(lblEFECTIVO);

		JLabel lblBIZUM = new JLabel("");
		lblBIZUM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					conexion.conectar();
					String sentencia = "DELETE FROM clientes WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					String sentencia2 = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + ", Estado = 'Pendiente' WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia2);
					conexion.desconectar();
					dispose();
					PagoConBizum a = new PagoConBizum();
					a.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al realizar sentencia: " + e1.getMessage());
				}
			}
		});
		lblBIZUM.setIcon(new ImageIcon(getClass().getResource("/Imagenes/bizum.png")));
		lblBIZUM.setBounds(122, 207, 60, 33);
		contentPane.add(lblBIZUM);

		JLabel lblMASTERCARD = new JLabel("");
		lblMASTERCARD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					conexion.conectar();
					String sentencia = "DELETE FROM clientes WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					String sentencia2 = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia2);
					conexion.desconectar();
					dispose();
					PagoConTarjeta a = new PagoConTarjeta();
					a.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al realizar sentencia: " + e1.getMessage());
				}

			}
		});
		lblMASTERCARD.setIcon(new ImageIcon(getClass().getResource("/Imagenes/mastercard.png")));
		lblMASTERCARD.setBounds(340, 125, 60, 33);
		contentPane.add(lblMASTERCARD);

		JLabel lblVISA = new JLabel("");
		lblVISA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					conexion.conectar();
					String sentencia = "DELETE FROM clientes WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					String sentencia2 = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia2);
					conexion.desconectar();
					dispose();
					PagoConTarjeta a = new PagoConTarjeta();
					a.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al realizar sentencia: " + e1.getMessage());
				}

			}
		});
		lblVISA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/visa.png")));
		lblVISA.setBounds(291, 113, 60, 33);
		contentPane.add(lblVISA);

		JLabel lblPAYPAL = new JLabel("");
		lblPAYPAL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					conexion.conectar();
					String sentencia = "DELETE FROM clientes WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					String sentencia2 = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia2);
					conexion.desconectar();
					dispose();
					PagoConPaypal a = new PagoConPaypal();
					a.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al realizar sentencia: " + e1.getMessage());
				}

			}
		});
		lblPAYPAL.setIcon(new ImageIcon(PagoSQL.class.getResource("/Imagenes/Paypal.png")));
		lblPAYPAL.setBounds(315, 208, 57, 32);
		contentPane.add(lblPAYPAL);

		JLabel lblOPCIONES = new JLabel("Selecciona la opcion que mejor le venga:");
		lblOPCIONES.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOPCIONES.setBounds(112, 54, 337, 47);
		contentPane.add(lblOPCIONES);

		// PAGO EN EFECTIVO
		
		JLabel lblEfectivo = new JLabel("Efectivo");
		lblEfectivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					conexion.conectar();
					String sentencia = "DELETE FROM clientes WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					String sentencia2 = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia2);
					conexion.desconectar();
					dispose();
					PagoEnEfectivo a = new PagoEnEfectivo();
					a.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al realizar sentencia: " + e1.getMessage());
				}
			}
		});
		lblEfectivo.setBounds(122, 171, 60, 14);
		contentPane.add(lblEfectivo);

		//PAGO CON BIZUM
		
		JLabel lblBizum = new JLabel("Bizum");
		lblBizum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					conexion.conectar();
					String sentencia = "DELETE FROM clientes WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					String sentencia2 = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia2);
					conexion.desconectar();
					dispose();
					PagoConBizum a = new PagoConBizum();
					a.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al realizar sentencia: " + e1.getMessage());
				}
			}
		});
		lblBizum.setBounds(132, 251, 60, 14);
		contentPane.add(lblBizum);
		
		// PAGO CON PAYPAL
		
		JLabel lblPaypal = new JLabel("Paypal");
		lblPaypal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					conexion.conectar();
					String sentencia = "DELETE FROM clientes WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					String sentencia2 = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia2);
					conexion.desconectar();
					dispose();
					PagoConPaypal a = new PagoConPaypal();
					a.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al realizar sentencia: " + e1.getMessage());
				}

			}
		});
		lblPaypal.setBounds(317, 251, 60, 14);
		contentPane.add(lblPaypal);

		//PAGO CON TARJETA
		
		JLabel lblTarjetaso = new JLabel("Tarjeta");
		lblTarjetaso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					conexion.conectar();
					String sentencia = "DELETE FROM clientes WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia);
					String sentencia2 = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
					conexion.ejecutarInsertDeleteUpdate(sentencia2);
					conexion.desconectar();
					dispose();
					PagoConTarjeta a = new PagoConTarjeta();
					a.setVisible(true);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error al realizar sentencia: " + e1.getMessage());
				}

			}
		});
		lblTarjetaso.setBounds(317, 171, 60, 14);
		contentPane.add(lblTarjetaso);
	}
}
//DESPUES DE DARLE A LAS DE BIZUM Y PAYPAL NO REDIRIGE PUESTO QUE NO HEMOS LINKEADO LA APLICACION CON LAS RESPECTIVAS PLATAFORMAS DE PAGO







