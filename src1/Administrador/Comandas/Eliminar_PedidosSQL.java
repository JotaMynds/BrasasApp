package Administrador.Comandas;

import java.awt.EventQueue;
import Conexion.ConexionMySQL;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Eliminar_PedidosSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eliminar_PedidosSQL frame = new Eliminar_PedidosSQL();
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
	public Eliminar_PedidosSQL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Selecciona la mesa que quieres borrar");
		lblTitulo.setBounds(56, 11, 260, 28);
		contentPane.add(lblTitulo);
		
		JLabel lblMesa1 = new JLabel("1");
		lblMesa1.setIcon(new ImageIcon(Eliminar_PedidosSQL.class.getResource("/Imagenes/mesa.png")));
		lblMesa1.setBounds(28, 50, 50, 50);
		contentPane.add(lblMesa1);
		
		JLabel lblMesa2 = new JLabel("2");
		lblMesa2.setIcon(new ImageIcon(Eliminar_PedidosSQL.class.getResource("/Imagenes/mesa.png")));
		lblMesa2.setBounds(110, 50, 50, 50);
		contentPane.add(lblMesa2);
		
		JLabel lblMesa3 = new JLabel("3");
		lblMesa3.setIcon(new ImageIcon(Eliminar_PedidosSQL.class.getResource("/Imagenes/mesa.png")));
		lblMesa3.setBounds(187, 50, 50, 50);
		contentPane.add(lblMesa3);
		
		JLabel lblMesa4 = new JLabel("4");
		lblMesa4.setIcon(new ImageIcon(Eliminar_PedidosSQL.class.getResource("/Imagenes/mesa.png")));
		lblMesa4.setBounds(266, 50, 50, 50);
		contentPane.add(lblMesa4);
		
		JLabel lblMesa5 = new JLabel("5");
		lblMesa5.setIcon(new ImageIcon(Eliminar_PedidosSQL.class.getResource("/Imagenes/mesa.png")));
		lblMesa5.setBounds(344, 50, 50, 50);
		contentPane.add(lblMesa5);
		
		JLabel lblMesa6 = new JLabel("6");
		lblMesa6.setIcon(new ImageIcon(Eliminar_PedidosSQL.class.getResource("/Imagenes/mesa.png")));
		lblMesa6.setBounds(28, 159, 50, 50);
		contentPane.add(lblMesa6);
		
		JLabel lblMesa7 = new JLabel("7");
		lblMesa7.setIcon(new ImageIcon(Eliminar_PedidosSQL.class.getResource("/Imagenes/mesa.png")));
		lblMesa7.setBounds(110, 159, 50, 50);
		contentPane.add(lblMesa7);
		
		JLabel lblMesa8 = new JLabel("8");
		lblMesa8.setIcon(new ImageIcon(Eliminar_PedidosSQL.class.getResource("/Imagenes/mesa.png")));
		lblMesa8.setBounds(187, 159, 50, 50);
		contentPane.add(lblMesa8);
		
		JLabel lblMesa9 = new JLabel("9");
		lblMesa9.setIcon(new ImageIcon(Eliminar_PedidosSQL.class.getResource("/Imagenes/mesa.png")));
		lblMesa9.setBounds(266, 159, 50, 50);
		contentPane.add(lblMesa9);
		
		JLabel lblMesa10 = new JLabel("10");
		lblMesa10.setIcon(new ImageIcon(Eliminar_PedidosSQL.class.getResource("/Imagenes/mesa.png")));
		lblMesa10.setBounds(344, 159, 50, 50);
		contentPane.add(lblMesa10);
		
		JButton btnMesa1 = new JButton("1");
		btnMesa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnMesa1,
				"¿Quiere borrar el pedido de esta mesa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "pedidos_prueba");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = 1";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
		
		btnMesa1.setBounds(28, 111, 50, 23);
		contentPane.add(btnMesa1);
		
		JButton btnMesa2 = new JButton("2");
		btnMesa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnMesa2,
				"¿Quiere borrar el pedido de esta mesa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "pedidos_prueba");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = 2";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
		
		btnMesa2.setBounds(110, 111, 50, 23);
		contentPane.add(btnMesa2);
		
		JButton btnMesa3 = new JButton("3");
		btnMesa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnMesa3,
				"¿Quiere borrar el pedido de esta mesa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "pedidos_prueba");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = 3";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
		
		btnMesa3.setBounds(187, 111, 50, 23);
		contentPane.add(btnMesa3);
		
		JButton btnMesa4 = new JButton("4");
		btnMesa4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnMesa4,
				"¿Quiere borrar el pedido de esta mesa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "pedidos_prueba");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = 4";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
		
		btnMesa4.setBounds(266, 111, 50, 23);
		contentPane.add(btnMesa4);
		
		JButton btnMesa5 = new JButton("5");
		btnMesa5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnMesa5,
				"¿Quiere borrar el pedido de esta mesa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "pedidos_prueba");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = 5";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
		
		btnMesa5.setBounds(344, 111, 50, 23);
		contentPane.add(btnMesa5);
		
		JButton btnMesa6 = new JButton("6");
		btnMesa6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnMesa6,
				"¿Quiere borrar el pedido de esta mesa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "pedidos_prueba");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = 6";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
		
		btnMesa6.setBounds(28, 220, 50, 23);
		contentPane.add(btnMesa6);
		
		JButton btnMesa7 = new JButton("7");
		btnMesa7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnMesa7,
				"¿Quiere borrar el pedido de esta mesa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "pedidos_prueba");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = 7";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
		
		btnMesa7.setBounds(110, 220, 50, 23);
		contentPane.add(btnMesa7);
		
		JButton btnMesa8 = new JButton("8");
		btnMesa8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnMesa8,
				"¿Quiere borrar el pedido de esta mesa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "pedidos_prueba");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = 8";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
		
		btnMesa8.setBounds(187, 220, 50, 23);
		contentPane.add(btnMesa8);
		
		JButton btnMesa9 = new JButton("9");
		btnMesa9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnMesa9,
				"¿Quiere borrar el pedido de esta mesa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "pedidos_prueba");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = 9";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
		
		btnMesa9.setBounds(266, 220, 50, 23);
		contentPane.add(btnMesa9);
		
		JButton btnMesa10 = new JButton("10");
		btnMesa10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object[] opciones = {"Sí", "No"};
				
				int respuesta = JOptionPane.showOptionDialog(btnMesa10,
				"¿Quiere borrar el pedido de esta mesa?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				
				null, opciones, opciones[0]);
				
				if(respuesta == 0) 
				{
					ConexionMySQL conexion = new ConexionMySQL("root", "", "pedidos_prueba");
					try 
					{
						conexion.conectar();
						String sentencia = "UPDATE pedidos SET Gambas = " + 0 + ", Croquetas = " + 0 + ", Quesos = " + 0 + ", Ensaladilla = " + 0 + ", Patatas = " + 0 + "  WHERE ID_mesa = 10";
						conexion.ejecutarInsertDeleteUpdate(sentencia);
						conexion.desconectar();
						dispose();
					} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
				}
			}
		});
		
		btnMesa10.setBounds(344, 220, 50, 23);
		contentPane.add(btnMesa10);
	}
}
