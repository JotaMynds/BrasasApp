package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import Conexion.ConexionMySQL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import java.awt.Canvas;
import java.awt.Label;
import javax.swing.JMenuBar;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

public class CartaSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCantidadGambas;
	private JTextField textFieldCantidadCroquetas;
	private JButton btnMenosGambas;
	private JTextField textFieldCantidadQuesos;
	private JTextField textFieldCantidadEnsaladilla;
	private JTextField textFieldCantidadPatatas;
	int cantidadGambas = 0;
	int cantidadCroquetas = 0;
	int cantidadQuesos = 0;
	int cantidadEnsaladilla = 0;
	int cantidadPatatas = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartaSQL frame = new CartaSQL();
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
	public CartaSQL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(6, 106, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Eliminar la barra para cerrar, maximizar y minimizar la pantalla
		setUndecorated(true);
		
		//Abre la pantalla en el centro 
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try {
			        conexion.conectar();
			        String sentencia = "DELETE FROM clientes WHERE ID_mesa = " + InicioSesionSQL.mesaCopy + ";";
			        conexion.ejecutarInsertDeleteUpdate(sentencia);
			    	conexion.desconectar();
			    	dispose();
			    } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e1.getMessage()); 
			    }
			}		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setForeground(new Color(231, 221, 128));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(260, 252, 61, 22);
		contentPane.add(btnNewButton);
		
		JLabel lblCroquetas = new JLabel("Croquetas de jamón");
		lblCroquetas.setForeground(new Color(236, 197, 87));
		lblCroquetas.setBounds(38, 105, 197, 14);
		contentPane.add(lblCroquetas);
		
		JLabel lblGambas = new JLabel("Plato de gambas");
		lblGambas.setForeground(new Color(236, 197, 87));
		lblGambas.setBounds(38, 72, 228, 14);
		contentPane.add(lblGambas);
		
		JLabel lblQuesos = new JLabel("Tabla de quesos");
		lblQuesos.setForeground(new Color(236, 197, 87));
		lblQuesos.setBounds(38, 140, 197, 14);
		contentPane.add(lblQuesos);
		
		JLabel lblEnsaladilla = new JLabel("Tapa de ensaladilla");
		lblEnsaladilla.setForeground(new Color(236, 197, 87));
		lblEnsaladilla.setBounds(39, 176, 213, 14);
		contentPane.add(lblEnsaladilla);
		
		JLabel lblPatatas = new JLabel("Tapa de patatas aliñadas");
		lblPatatas.setForeground(new Color(236, 197, 87));
		lblPatatas.setBounds(38, 213, 239, 14);
		contentPane.add(lblPatatas);
		
		//Botón de pedir
		JButton btnPedir = new JButton("Pedir");
		btnPedir.setForeground(new Color(236, 197, 87));
		btnPedir.setBackground(new Color(6, 106, 105));
		btnPedir.setSize(114, 20);
		btnPedir.setLocation(102, 253);
		contentPane.add(btnPedir);
		
		JLabel lblPrecioGambas = new JLabel("7,50");
		lblPrecioGambas.setForeground(new Color(236, 197, 87));
		lblPrecioGambas.setBounds(189, 72, 46, 14);
		contentPane.add(lblPrecioGambas);
		
		JLabel lblPrecioJamon = new JLabel("4,00");
		lblPrecioJamon.setForeground(new Color(236, 197, 87));
		lblPrecioJamon.setBounds(178, 105, 46, 14);
		contentPane.add(lblPrecioJamon);
		
		JLabel lblPrecioQuesos = new JLabel("10,00");
		lblPrecioQuesos.setForeground(new Color(236, 197, 87));
		lblPrecioQuesos.setBounds(178, 140, 46, 14);
		contentPane.add(lblPrecioQuesos);
		
		JLabel lblPrecioPatatas = new JLabel("3,50");
		lblPrecioPatatas.setForeground(new Color(236, 197, 87));
		lblPrecioPatatas.setBounds(189, 213, 46, 14);
		contentPane.add(lblPrecioPatatas);
		
		JLabel lblPrecioEnsaladilla = new JLabel("3,00");
		lblPrecioEnsaladilla.setForeground(new Color(236, 197, 87));
		lblPrecioEnsaladilla.setBounds(178, 176, 46, 14);
		contentPane.add(lblPrecioEnsaladilla);
		
		JButton btnMasGambas = new JButton("+");
		btnMasGambas.setBackground(new Color(0, 128, 128));
		btnMasGambas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(cantidadGambas >= 0 && cantidadGambas < 10) 
				{
					cantidadGambas ++;
					textFieldCantidadGambas.setText(String.valueOf(cantidadGambas));
				} 
					else 
					{
						String mensaje = "Solo se pueden pedir 10 platos a la vez";
						
						String titulo = "Error";
						
						JOptionPane.showMessageDialog(btnMasGambas, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		btnMasGambas.setBounds(370, 70, 41, 19);
		contentPane.add(btnMasGambas);
		
		btnMenosGambas = new JButton("-");
		btnMenosGambas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(cantidadGambas <= 0) 
				{
					String mensaje = "No se puede realizar esta acción";
					
					String titulo = "Error";
					
					JOptionPane.showMessageDialog(btnMenosGambas, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
				}
					else 
					{
						cantidadGambas --;
						textFieldCantidadGambas.setText(String.valueOf(cantidadGambas));
					}				
			}
		});
		btnMenosGambas.setBackground(new Color(0, 128, 128));
		btnMenosGambas.setBounds(280, 70, 41, 19);
		contentPane.add(btnMenosGambas);
		
		textFieldCantidadGambas = new JTextField();
		textFieldCantidadGambas.setText("0");
		textFieldCantidadGambas.setForeground(new Color(0, 128, 128));
		textFieldCantidadGambas.setBounds(331, 69, 29, 20);
		contentPane.add(textFieldCantidadGambas);
		textFieldCantidadGambas.setColumns(10);
		
		textFieldCantidadCroquetas = new JTextField();
		textFieldCantidadCroquetas.setText("0");
		textFieldCantidadCroquetas.setForeground(new Color(0, 128, 128));
		textFieldCantidadCroquetas.setColumns(10);
		textFieldCantidadCroquetas.setBounds(331, 102, 29, 20);
		contentPane.add(textFieldCantidadCroquetas);
		
		textFieldCantidadEnsaladilla = new JTextField();
		textFieldCantidadEnsaladilla.setText("0");
		textFieldCantidadEnsaladilla.setForeground(new Color(0, 128, 128));
		textFieldCantidadEnsaladilla.setColumns(10);
		textFieldCantidadEnsaladilla.setBounds(331, 173, 29, 20);
		contentPane.add(textFieldCantidadEnsaladilla);
		
		textFieldCantidadQuesos = new JTextField();
		textFieldCantidadQuesos.setText("0");
		textFieldCantidadQuesos.setForeground(new Color(0, 128, 128));
		textFieldCantidadQuesos.setColumns(10);
		textFieldCantidadQuesos.setBounds(331, 137, 29, 20);
		contentPane.add(textFieldCantidadQuesos);
		
		textFieldCantidadPatatas = new JTextField();
		textFieldCantidadPatatas.setText("0");
		textFieldCantidadPatatas.setForeground(new Color(0, 128, 128));
		textFieldCantidadPatatas.setColumns(10);
		textFieldCantidadPatatas.setBounds(331, 210, 29, 20);
		contentPane.add(textFieldCantidadPatatas);
		
		JButton btnMasCroquetas = new JButton("+");
		btnMasCroquetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(cantidadCroquetas >= 0 && cantidadCroquetas < 10) 
				{
					cantidadCroquetas ++;
					textFieldCantidadCroquetas.setText(String.valueOf(cantidadCroquetas));
				}
					else 
					{
						String mensaje = "Solo se pueden pedir 10 platos a la vez";
						
						String titulo = "Error";
						
						JOptionPane.showMessageDialog(btnMasCroquetas, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		btnMasCroquetas.setBackground(new Color(0, 128, 128));
		btnMasCroquetas.setBounds(370, 103, 41, 19);
		contentPane.add(btnMasCroquetas);
		
		JButton btnMasQuesos = new JButton("+");
		btnMasQuesos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(cantidadQuesos >= 0 && cantidadQuesos < 10)
				{
					cantidadQuesos ++;
					textFieldCantidadQuesos.setText(String.valueOf(cantidadQuesos));
				}
					else 
					{
						String mensaje = "Solo se pueden pedir 10 platos a la vez";
						
						String titulo = "Error";
						
						JOptionPane.showMessageDialog(btnMasQuesos, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		btnMasQuesos.setBackground(new Color(0, 128, 128));
		btnMasQuesos.setBounds(370, 138, 41, 19);
		contentPane.add(btnMasQuesos);
		
		JButton btnMasEnsaladilla = new JButton("+");
		btnMasEnsaladilla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(cantidadEnsaladilla >= 0 && cantidadEnsaladilla < 10) 
				{
					cantidadEnsaladilla ++;
					textFieldCantidadEnsaladilla.setText(String.valueOf(cantidadEnsaladilla));
				}
					else 
					{
						String mensaje = "Solo se pueden pedir 10 platos a la vez";
						
						String titulo = "Error";
						
						JOptionPane.showMessageDialog(btnMasEnsaladilla, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		btnMasEnsaladilla.setBackground(new Color(0, 128, 128));
		btnMasEnsaladilla.setBounds(370, 174, 41, 19);
		contentPane.add(btnMasEnsaladilla);
		
		JButton btnMasPatatas = new JButton("+");
		btnMasPatatas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(cantidadPatatas >= 0 && cantidadPatatas < 10) 
				{
					cantidadPatatas ++;
					textFieldCantidadPatatas.setText(String.valueOf(cantidadPatatas));
				}
					else 
					{
						String mensaje = "Solo se pueden pedir 10 platos a la vez";
						
						String titulo = "Error";
						
						JOptionPane.showMessageDialog(btnMasPatatas, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		btnMasPatatas.setBackground(new Color(0, 128, 128));
		btnMasPatatas.setBounds(370, 211, 41, 19);
		contentPane.add(btnMasPatatas);
		
		JButton btnMenosCroquetas = new JButton("-");
		btnMenosCroquetas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(cantidadCroquetas <= 0) 
				{
					String mensaje = "No se puede realizar esta acción";
					
					String titulo = "Error";
					
					JOptionPane.showMessageDialog(btnMenosCroquetas, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
				}
					else 
					{
						cantidadCroquetas --;
						textFieldCantidadCroquetas.setText(String.valueOf(cantidadCroquetas));
					}				
			}
		});
		
		btnMenosCroquetas.setBackground(new Color(0, 128, 128));
		btnMenosCroquetas.setBounds(280, 103, 41, 19);
		contentPane.add(btnMenosCroquetas);
		
		JButton btnMenosEnsaladilla = new JButton("-");
		btnMenosEnsaladilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMenosEnsaladilla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(cantidadEnsaladilla <= 0) 
				{
					String mensaje = "No se puede realizar esta acción";
					
					String titulo = "Error";
					
					JOptionPane.showMessageDialog(btnMenosEnsaladilla, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
				}
					else 
					{
						cantidadEnsaladilla --;
						textFieldCantidadEnsaladilla.setText(String.valueOf(cantidadEnsaladilla));
					}				
			}
		});
		btnMenosEnsaladilla.setBackground(new Color(0, 128, 128));
		btnMenosEnsaladilla.setBounds(280, 174, 41, 19);
		contentPane.add(btnMenosEnsaladilla);
		
		JButton btnMenosQuesos = new JButton("-");
		btnMenosQuesos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(cantidadQuesos <= 0) 
				{
					String mensaje = "No se puede realizar esta acción";
					
					String titulo = "Error";
					
					JOptionPane.showMessageDialog(btnMenosQuesos, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
				}
					else 
					{
						cantidadQuesos --;
						textFieldCantidadQuesos.setText(String.valueOf(cantidadQuesos));
					}				
			}
		});
		
		btnMenosQuesos.setBackground(new Color(0, 128, 128));
		btnMenosQuesos.setBounds(280, 138, 41, 19);
		contentPane.add(btnMenosQuesos);
		
		JButton btnMenosPatatas = new JButton("-");
		btnMenosPatatas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(cantidadPatatas <= 0) 
				{
					String mensaje = "No se puede realizar esta acción";
					
					String titulo = "Error";
					
					JOptionPane.showMessageDialog(btnMenosPatatas, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
				}
					else 
					{
						cantidadPatatas --;
						textFieldCantidadPatatas.setText(String.valueOf(cantidadPatatas));
					}				
			}
		});
		btnMenosPatatas.setBackground(new Color(0, 128, 128));
		btnMenosPatatas.setBounds(280, 211, 41, 19);
		contentPane.add(btnMenosPatatas);
		
		final JLabel lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon(CartaSQL.class.getResource("/Imagenes/ChatGPT Image 14 may 2025, 12_35_53.png")));
		lblFondo.setBounds(-51, 0, 254, 300);
		contentPane.add(lblFondo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CartaSQL.class.getResource("/Imagenes/ChatGPT Image 2.png")));
		lblNewLabel.setBounds(281, 0, 419, 300);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CartaSQL.class.getResource("/Imagenes/ChatGPT Image 3.png")));
		lblNewLabel_1.setBounds(173, 0, 125, 300);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCarta = new JLabel("CARTA");
		lblCarta.setFont(new Font("Poor Richard", Font.PLAIN, 20));
		lblCarta.setForeground(new Color(236, 197, 87));
		lblCarta.setBounds(189, 34, 88, 14);
		contentPane.add(lblCarta);
		
		ImageIcon icon = new ImageIcon("/Imagenes/ChatGPT Image 5 may 2025, 10_40_27.png");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(2, 1, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(newImg);
		
		ImageIcon icon2 = new ImageIcon("/Imagenes/ChatGPT Image 14 may 2025, 12_35_53.png");
		Image img2 = icon2.getImage();
		Image newImg2 = img2.getScaledInstance(439, 291, java.awt.Image.SCALE_SMOOTH);
		ImageIcon resizedIcon2 = new ImageIcon(newImg2);
		
		btnPedir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnPedir,
				"¿Desea realizar este pedido?", "Pregunta", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + textFieldCantidadGambas.getText() + ", Croquetas = " + textFieldCantidadCroquetas.getText() + ", Quesos = " + textFieldCantidadQuesos.getText() + ", Ensaladilla = " + textFieldCantidadEnsaladilla.getText() + ", Patatas = " + textFieldCantidadPatatas.getText() + ", Estado = 'Pendiente'  WHERE ID_mesa = '" + InicioSesionSQL.mesaCopy + "'";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
						PagoSQL a = new PagoSQL();
						a.setVisible(true);
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
	}
}

