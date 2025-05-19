package Cliente;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Cliente.InterfazCargaRealizarPedido;
import Cliente.ConexionMySQL;

public class InterfazInicioSesion extends JFrame {

	// VARIABLES

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreField;
	private int xMouse, yMouse;
	public static int mesaCopy;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				InterfazInicioSesion frame = new InterfazInicioSesion();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
////////////////////////////////////////////////////////////////////////////

	// INTERFAZ

	public InterfazInicioSesion() {
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

		// CONFIGURACIÓN DE CONTENTPANE

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TITULO PÁGINA

		JLabel lblTITULO = new JLabel("¡Localiza tu mesa!");
		lblTITULO.setBackground(new Color(0, 128, 128));
		lblTITULO.setForeground(new Color(238, 221, 128));
		lblTITULO.setFont(new Font("Arial", Font.PLAIN, 25));
		lblTITULO.setBounds(134, 11, 384, 100);
		contentPane.add(lblTITULO);

		// MENSAJE PARA INTRODUCIR NOMBRE

		JLabel lblNOMBRE = new JLabel("Introduce tu nombre:");
		lblNOMBRE.setForeground(new Color(238, 221, 128));
		lblNOMBRE.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNOMBRE.setBounds(86, 108, 176, 14);
		contentPane.add(lblNOMBRE);

		nombreField = new JTextField();
		nombreField.setBounds(230, 105, 201, 20);
		contentPane.add(nombreField);
		nombreField.setColumns(10);

		// MENSAJE PARA INTRODUCIR EL NÚMERO DE LA MESA

		JLabel lblNOMBRE_1 = new JLabel("Introduce el número de tu mesa:");
		lblNOMBRE_1.setForeground(new Color(238, 221, 128));
		lblNOMBRE_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNOMBRE_1.setBounds(86, 152, 176, 14);
		contentPane.add(lblNOMBRE_1);

		// AÑADIR LOS VALORES DEL DESPLEGABLE

		JComboBox<Integer> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox.setBounds(320, 150, 111, 18);
		contentPane.add(comboBox);

		// BOTÓN CONFIRMAR

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(new Color(238, 221, 128));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				

        		ConexionMySQL conexion = new ConexionMySQL("root", "", "pruebas_local");

                try {
                	

                   // CONEXION A LA BASE DE DATOS
                	
                    conexion.conectar();

                    // SENTENCIA
                    
                    String nombre = nombreField.getText(); 
                    int mesa = (int) comboBox.getSelectedItem();
                    mesaCopy = mesa;

                    if((nombre.isEmpty() || nombre.length() < 3) && mesa == 0) {
                        JOptionPane.showMessageDialog(null, "ERROR: El nombre está vacío y no has seleccionado mesa, introduce un nombre de al menos 4 letras y una mesa");
                    }else if (mesa == 0) {
                        JOptionPane.showMessageDialog(null, "ERROR: Debes seleccionar una mesa válida.");
                        return;
                    }else if (nombre.isEmpty() || nombre.length() < 3) {
                        JOptionPane.showMessageDialog(null, "ERROR: Debes introducir un nombre válido, un nombre de al menos 4 letras .");
                        return;
                    }
                    
                 // VERFICAR OCUPACIÓN DE MESA
                    
                    String consulta = "SELECT mesa FROM clientes WHERE mesa = " + mesa;
        			conexion.ejecutarSelect(consulta);
        			ResultSet mesaAfectada = conexion.ejecutarSelect(consulta);
                    if (mesaAfectada.next()) {
                        JOptionPane.showMessageDialog(null, "ERROR: Esta mesa está ocupada.");
                        return;
                    }

                    // REALIZAR SENTENCIA
                    
                    String sql2 = "INSERT INTO clientes (nombre, mesa) VALUES ('" + nombre + "', '" + mesa + "')";
                    conexion.ejecutarInsertDeleteUpdate(sql2);
                    //TRANSICIÓN A LA SIGUIENTE VENTANA
                    dispose();
        			conexion.desconectar();
                    InterfazCargaCarta a = new InterfazCargaCarta();
                    a.setVisible(true);
                   

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                } finally {
                    //DESCONECTAR
                    if (conexion != null) {
                        try {
                            conexion.desconectar();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + ex.getMessage());
                        }
                    }
                }
			}
		});
		btnConfirmar.setBackground(new Color(0, 128, 128));
		btnConfirmar.setBounds(188, 215, 111, 23);
		contentPane.add(btnConfirmar);

		JMenuBar menuBar_1_1 = new JMenuBar();
		menuBar_1_1.setForeground(new Color(0, 128, 128));
		menuBar_1_1.setBackground(new Color(0, 128, 128));
		menuBar_1_1.setBounds(0, 0, 540, 25);
		contentPane.add(menuBar_1_1);

		// ESPACIO
		JLabel lblEspacio_4 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_4);

		// MENSAJE DE LOCALIZAR MESA EN MENU

		JLabel lblInicio = new JLabel("Localizar tu mesa");
		lblInicio.setForeground(new Color(238, 221, 128));
		menuBar_1_1.add(lblInicio);

		// ESPACIADO

		JLabel lblEspacio = new JLabel("            ");
		menuBar_1_1.add(lblEspacio);

		JLabel lblEspacio_5_4 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_5_4);

		// CLICKABLE DE REALIZAR PEDIDO

		JLabel lblPedir = new JLabel("Realiza tu pedido");
		lblPedir.setForeground(new Color(238, 221, 128));
		menuBar_1_1.add(lblPedir);
		
		// ESPACIADO

		JLabel lblEspacio_1 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_1);

		JLabel lblEspacio_5_3 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_5_3);

		// CLICKABLE DE PAGAR PEDIDO

		JLabel lblPagar = new JLabel("Paga tu pedido");
		lblPagar.setForeground(new Color(238, 221, 128));
		menuBar_1_1.add(lblPagar);

		JLabel lblEspacio_5_1 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_5_1);

		JLabel lblEspacio_5_2 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_5_2);
		lblPagar.addMouseListener(new MouseAdapter() {


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
	});
	}
}