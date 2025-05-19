package Cliente;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartaProductos extends JFrame {

	ConexionMySQL conexion = new ConexionMySQL("root", "", "pruebas_local");
    public CartaProductos() {
        setTitle("Carta de Productos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 20, 20));
        getContentPane().setBackground(new Color(250, 250, 250));
        setSize(600, 400);
        setLocationRelativeTo(null);		
        cargarProductos();
        setVisible(true);
    }

    private void cargarProductos() {
        try {
            conexion.conectar();

            String consulta = "SELECT nombre, precio FROM productos1";
            ResultSet rs = conexion.ejecutarSelect(consulta);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");

                JButton boton = crearBotonProducto(nombre, precio);
                add(boton);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar productos: " + e.getMessage());
        } finally {
            try {
                conexion.desconectar();
            } catch (SQLException e) {
                System.err.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    private JButton crearBotonProducto(String nombre, double precio) {
        JButton boton = new JButton("<html><center>" + nombre + "<br>" + precio + " €</center></html>");
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setBackground(new Color(230, 240, 255));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        return boton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CartaProductos::new);
    }
}
