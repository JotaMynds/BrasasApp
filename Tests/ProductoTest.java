package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Plantillas.Producto;

class ProductoTest {
	 @Test
	    public void testConstructorAndGetters() {
	        Producto producto = new Producto(1, "Agua", 1.0);

	        assertEquals(1, producto.getId());
	        assertEquals("Agua", producto.getNombre());
	        assertEquals(1.0, producto.getPrecio(), 0.001);
	    }

	    @Test
	    public void testToString() {
	        Producto producto = new Producto(1, "Café", 2.5);
	        String expected = "1 - Café - 2.5€";
	        assertEquals(expected, producto.toString());
	    }
}
