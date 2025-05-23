package Administrador.Comandas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Plantillas.Pedidos;
import Conexion.ConexionMySQL;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JList;

public class Gestor_PedidosSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<Pedidos> modeloLista = new DefaultListModel<>();
	private int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestor_PedidosSQL frame = new Gestor_PedidosSQL();
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
	public Gestor_PedidosSQL() {
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
		
		JLabel lblComandas = new JLabel("COMANDAS");
		lblComandas.setForeground(new Color(238, 221, 128));
		lblComandas.setHorizontalAlignment(SwingConstants.CENTER);
		lblComandas.setFont(new Font("Arial", Font.BOLD, 26));
		lblComandas.setBounds(0, 11, 434, 44);
		contentPane.add(lblComandas);
		
		
		JList <Pedidos> listPedidos = new JList<>(modeloLista);
		listPedidos.setForeground(new Color(238, 221, 128));
		listPedidos.setBackground(new Color(0, 128, 128));
		listPedidos.setBounds(10, 67, 412, 211);
		contentPane.add(listPedidos);
			
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setForeground(new Color(238, 221, 128));
		btnCargar.setBackground(new Color(0, 128, 128));
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
				try 
				{
					conexion.conectar();
					String sentencia = "SELECT COUNT(*) FROM clientes";
					ResultSet resultado =  conexion.ejecutarSelect(sentencia);
					
					if(resultado.next()) 
					{
						int count = resultado.getInt(1);
						
						if(count == 0) 
						{
							JOptionPane.showMessageDialog(null, "No hay comandas disponibles");
						}
						
						else 
						{
							String sentencia2 = "SELECT * FROM pedidos JOIN clientes WHERE clientes.ID_mesa = pedidos.ID_mesa AND Estado = 'Pendiente'";
							ResultSet resultado2 = conexion.ejecutarSelect(sentencia2);
							
							while(resultado2.next()) 
							{
								int tem_Mesa = resultado2.getInt("ID_mesa");
								int tem_Gambas = resultado2.getInt("Gambas");
								int tem_Croquetas = resultado2.getInt("Croquetas");
								int tem_Quesos = resultado2.getInt("Quesos");
								int tem_Ensaladilla = resultado2.getInt("Ensaladilla");
								int tem_Patatas = resultado2.getInt("Patatas");
								String tem_Estado = resultado2.getString("Estado");
								
								Pedidos pedido = new Pedidos(tem_Mesa, tem_Gambas, tem_Croquetas, tem_Quesos, tem_Ensaladilla, tem_Patatas, tem_Estado);
								
								modeloLista.addElement(pedido);
							}
						}
					}
					conexion.desconectar();
					//dispose();
				} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
			}
		});
		btnCargar.setBounds(77, 289, 89, 23);
		contentPane.add(btnCargar);
		
		JButton btnNewButton = new JButton("Listo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Pedidos seleccionado = listPedidos.getSelectedValue();
				
				if(seleccionado != null) 
				{
					 int id = seleccionado.getId_mesa();
					 ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
					 
					 try
					 {
						conexion.conectar();
						
						String sentencia = "UPDATE pedidos SET Estado = 'Listo' WHERE ID_mesa = " + id;
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						obtenerValores();
						
						JOptionPane.showMessageDialog(null, "Comanda marcada como lista");
					 } 
					 
					 catch(SQLException x) 
					 {
						 x.printStackTrace();
					 }
				}
			}
		});
		
		btnNewButton.setForeground(new Color(238, 221, 128));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setBounds(313, 289, 98, 26);
		contentPane.add(btnNewButton);
		
		
		
	}


public void obtenerValores() { 
	ConexionMySQL conexion = new ConexionMySQL("root", "", "BrasasApp");
	
	try 
	{
		conexion.conectar();
		ResultSet rs = conexion.ejecutarSelect("SELECT * FROM pedidos");
		
		modeloLista.clear();
		
		while(rs.next()) 
		{
			int id = rs.getInt("ID_mesa");
			int Gambas = rs.getInt("Gambas");
			int Croquetas = rs.getInt("Croquetas");
			int Quesos = rs.getInt("Quesos");
			int Ensaladilla = rs.getInt("Ensaladilla");
			int Patatas = rs.getInt("Patatas");
			String Estado = rs.getString("Estado");
			
			Pedidos pedido = new Pedidos(id, Gambas, Croquetas, Quesos, Ensaladilla, Patatas, Estado);

		} 
		
		conexion.desconectar();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
}
}

	











