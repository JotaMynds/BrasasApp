package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import Plantillas.Producto;
import Plantillas.ProductoHelper;

class ProductoHelperTest {
	 @Test
	    public void testCalcularPrecioTotal() {
	        List<Producto> productos = Arrays.asList(
	            new Producto(1, "Café", 1.5),
	            new Producto(2, "Tostada", 2.0),
	            new Producto(3, "Zumo", 2.5)
	        );
	        double total = ProductoHelper.calcularPrecioTotal(productos);
	        assertEquals(6.0, total, 0.001);
	    }

	    @Test
	    public void testObtenerProductoMasCaro() {
	        Producto p1 = new Producto(1, "Agua", 1.0);
	        Producto p2 = new Producto(2, "Refresco", 1.8);
	        Producto p3 = new Producto(3, "Copa", 3.5);

	        List<Producto> productos = Arrays.asList(p1, p2, p3);
	        Producto masCaro = ProductoHelper.obtenerProductoMasCaro(productos);
	        assertEquals(p3, masCaro);
	    }

	    @Test
	    public void testObtenerProductoMasCaro_listaVacia() {
	        assertNull(ProductoHelper.obtenerProductoMasCaro(Collections.emptyList()));
	    }

	    @Test
	    public void testNombreValido() {
	        assertTrue(ProductoHelper.nombreValido("Tarta"));
	        assertFalse(ProductoHelper.nombreValido(""));
	        assertFalse(ProductoHelper.nombreValido("   "));
	        assertFalse(ProductoHelper.nombreValido(null));
	    }
}
