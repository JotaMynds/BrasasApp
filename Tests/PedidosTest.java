package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Plantillas.Pedidos;

class PedidosTest {
	@Test
    public void testConstructorAndGetters() {
        Pedidos pedido = new Pedidos(1, 2, 3, 4, 5, 6, "pendiente");

        assertEquals(1, pedido.getId_mesa());
        assertEquals(2, pedido.getGambas());
        assertEquals(3, pedido.getCroquetas());
        assertEquals(4, pedido.getQuesos());
        assertEquals(5, pedido.getEnsaladilla());
        assertEquals(6, pedido.getPatatas());
        assertEquals("pendiente", pedido.getEstado());
    }

    @Test
    public void testSetters() {
        Pedidos pedido = new Pedidos(0, 0, 0, 0, 0, 0, "");

        pedido.setId_mesa(10);
        pedido.setGambas(1);
        pedido.setCroquetas(2);
        pedido.setQuesos(3);
        pedido.setEnsaladilla(4);
        pedido.setPatatas(5);
        pedido.setEstado("servido");

        assertEquals(10, pedido.getId_mesa());
        assertEquals(1, pedido.getGambas());
        assertEquals(2, pedido.getCroquetas());
        assertEquals(3, pedido.getQuesos());
        assertEquals(4, pedido.getEnsaladilla());
        assertEquals(5, pedido.getPatatas());
        assertEquals("servido", pedido.getEstado());
    }

    @Test
    public void testToString() {
        Pedidos pedido = new Pedidos(2, 1, 1, 1, 1, 1, "pendiente");
        String expected = "Mesa: 2 | Gambas: 1 | Croquetas: 1 | Quesos: 1 | Ensaladilla: 1 | Patatas: 1";
        assertEquals(expected, pedido.toString());
    }
}
