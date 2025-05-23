package Plantillas;

import java.util.List;

public class ProductoHelper 
{
	 // Calcula el precio total de una lista de productos
    public static double calcularPrecioTotal(List<Producto> productos) {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    // Encuentra el producto más caro
    public static Producto obtenerProductoMasCaro(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) return null;

        Producto masCaro = productos.get(0);
        for (Producto p : productos) {
            if (p.getPrecio() > masCaro.getPrecio()) {
                masCaro = p;
            }
        }
        return masCaro;
    }

    // Verifica si un producto tiene un nombre válido
    public static boolean nombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
}
