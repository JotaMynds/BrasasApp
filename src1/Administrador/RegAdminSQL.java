package Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.ConexionMySQL;
import PantallasDeCarga.CargaStaff;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

public class RegAdminSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;
	private JTextField textCorreo;
	private JPasswordField textPass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegAdminSQL frame = new RegAdminSQL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

////////////////////////////////////////////////////////////////////////////////

	// INTERFAZ

	public RegAdminSQL() {
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

		JLabel lblNewLabel = new JLabel("INICIO ADMINISTRADOR");
		lblNewLabel.setBounds(104, 27, 369, 34);
		lblNewLabel.setForeground(new Color(238, 221, 128));
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		getContentPane().add(lblNewLabel);

		JLabel lblCopyRight = new JLabel("");
		lblCopyRight.setBounds(173, 310, 134, 26);
		lblCopyRight.setIcon(new ImageIcon(RegAdminSQL.class.getResource("/Imagenes/copy.png")));
		getContentPane().add(lblCopyRight);
		
		JLabel lblNewLabel_1 = new JLabel("CORREO");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(231, 221, 128));
		lblNewLabel_1.setBackground(new Color(0, 128, 128));
		lblNewLabel_1.setBounds(193, 73, 156, 34);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1_1.setForeground(new Color(231, 221, 128));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1.setBackground(new Color(0, 128, 128));
		lblNewLabel_1_1.setBounds(172, 165, 156, 34);
		getContentPane().add(lblNewLabel_1_1);
		
		textCorreo = new JTextField();
		textCorreo.setText("\"admin@prueba.com\"/ \"1234\"");
		textCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textCorreo.setText("");
			}
		});
		textCorreo.setBounds(143, 121, 191, 20);
		getContentPane().add(textCorreo);
		textCorreo.setColumns(10);
		
		textPass = new JPasswordField();
		textPass.setBounds(143, 200, 191, 20);
		getContentPane().add(textPass);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					boolean encontrado = false;
					conexion.conectar();
					String sentencia = "SELECT * FROM registro";
					ResultSet rs = conexion.ejecutarSelect(sentencia);
						while(rs.next()) {
						       if (textCorreo.getText().equals(rs.getString("Correo")) &&
						           textPass.getText().equals(rs.getString("Contraseña"))) {
						           encontrado = true;
							        JOptionPane.showMessageDialog(null, "Acceso garantizado");
						           break;
						        }
						    }

					    if (encontrado) {
					        dispose();
					        CargaStaff a = new CargaStaff();
					        a.setVisible(true);
					    } else {
					        JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectos");
					    }
					conexion.desconectar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setForeground(new Color(231, 221, 128));
		btnNewButton.setBounds(193, 242, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
					boolean encontrado = false;
					conexion.conectar();
					String sentencia = "SELECT Correo FROM registro";
					ResultSet rs = conexion.ejecutarSelect(sentencia);
					while(rs.next()) {
						if (!(textCorreo.getText().equals(rs.getString("Correo")))) {
							JOptionPane.showMessageDialog(null, "El usuario ha sido registrado");
							encontrado = true;
							break;
						}
					}
				    if (encontrado) {
				        String sentencia2 = "INSERT INTO `registro`(`Correo`, `Contraseña`) VALUES ('" + textCorreo.getText() + "', '" + textPass.getText() + "')";
						conexion.ejecutarInsertDeleteUpdate(sentencia2);
				    } else {
						JOptionPane.showMessageDialog(null, "El correo ya existe");
				    }
				conexion.desconectar();
			} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegistro.setForeground(new Color(231, 221, 128));
		btnRegistro.setBackground(new Color(0, 128, 128));
		btnRegistro.setBounds(193, 277, 89, 23);
		getContentPane().add(btnRegistro);
		
		
		
		
	}
}
