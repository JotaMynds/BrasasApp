package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Conexion.ConexionMySQL;
import Plantillas.Empleado;
import Plantillas.EmpleadoService;

class EmpleadoServiceTest 
{
	 private EmpleadoService servicio;

	    @BeforeEach
	    public void setUp() {
	        // Pasamos `null` porque no vamos a usar la conexión en estos tests
	        servicio = new EmpleadoService(null);
	    }

	    @Test
	    public void testValidarEdadCorrecta() {
	        assertTrue(servicio.validarEdad("25"));
	        assertTrue(servicio.validarEdad("99"));
	        assertTrue(servicio.validarEdad("16")); // Límite inferior
	        assertTrue(servicio.validarEdad("100")); // Límite superior
	    }

	    @Test
	    public void testValidarEdadIncorrecta() {
	        assertFalse(servicio.validarEdad("abc"));
	        assertFalse(servicio.validarEdad("-1"));
	        assertFalse(servicio.validarEdad("120"));
	        assertFalse(servicio.validarEdad(""));
	        assertFalse(servicio.validarEdad(null));
	    }

	    @Test
	    public void testEmpleadoCreacionDatosCorrectos() {
	        Empleado emp = new Empleado(1, "Juan", "Perez", "Gomez", 30, "2024-01-01");

	        assertEquals("Juan", emp.getNombre());
	        assertEquals("Perez", emp.getApe1());
	        assertEquals("Gomez", emp.getApe2());
	        assertEquals(30, emp.getEdad());
	        assertEquals("2024-01-01", emp.getFecha());
	    }
}
