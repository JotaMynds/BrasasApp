package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Plantillas.Pedidos;
import Plantillas.PedidosHelper;

class PedidosHelperTest {
	 @Test
	    public void testCalcularTotalPlatos() {
	        Pedidos pedido = new Pedidos(1, 2, 1, 3, 0, 4, "Pendiente");
	        int total = PedidosHelper.calcularTotalPlatos(pedido);
	        assertEquals(10, total);
	    }

	    @Test
	    public void testPedidoTieneContenido() {
	        Pedidos pedidoConPlatos = new Pedidos(2, 0, 0, 1, 0, 0, "Pendiente");
	        assertTrue(PedidosHelper.pedidoTieneContenido(pedidoConPlatos));

	        Pedidos pedidoVacio = new Pedidos(3, 0, 0, 0, 0, 0, "Pendiente");
	        assertFalse(PedidosHelper.pedidoTieneContenido(pedidoVacio));
	    }

	    @Test
	    public void testEstadoValido() {
	        assertTrue(PedidosHelper.estadoValido("Pendiente"));
	        assertTrue(PedidosHelper.estadoValido("En preparación"));
	        assertTrue(PedidosHelper.estadoValido("Servido"));

	        assertFalse(PedidosHelper.estadoValido("Cancelado"));
	        assertFalse(PedidosHelper.estadoValido(""));
	        assertFalse(PedidosHelper.estadoValido(null));
	    }
}
