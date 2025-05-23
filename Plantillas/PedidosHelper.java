package Plantillas;

import java.util.Arrays;
import java.util.List;

public class PedidosHelper 
{
	 private static final List<String> ESTADOS_VALIDOS = Arrays.asList("Pendiente", "En preparación", "Servido");

	    // Calcula el total de unidades pedidas
	    public static int calcularTotalPlatos(Pedidos pedido) {
	        return pedido.getGambas() + pedido.getCroquetas() + pedido.getQuesos()
	             + pedido.getEnsaladilla() + pedido.getPatatas();
	    }

	    // Devuelve true si el pedido tiene al menos un plato
	    public static boolean pedidoTieneContenido(Pedidos pedido) {
	        return calcularTotalPlatos(pedido) > 0;
	    }

	    // Verifica si el estado es válido
	    public static boolean estadoValido(String estado) {
	        return ESTADOS_VALIDOS.contains(estado);
	    }
}
