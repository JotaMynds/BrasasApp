package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Plantillas.Empleado;

class EmpleadoTest {

    @Test
    public void testConstructorAndGetters() {
        Empleado emp = new Empleado(1, "Laura", "Gómez", "Pérez", 35, "2023-04-01");

        assertEquals(1, emp.getId());
        assertEquals("Laura", emp.getNombre());
        assertEquals("Gómez", emp.getApe1());
        assertEquals("Pérez", emp.getApe2());
        assertEquals(35, emp.getEdad());
        assertEquals("2023-04-01", emp.getFecha());
    }

    @Test
    public void testToString() {
        Empleado emp = new Empleado(2, "Luis", "Martín", "Ruiz", 28, "2022-09-15");
        String expected = "2 - Luis Martín Ruiz -  Edad: 28 - Fecha de entrada: 2022-09-15";
        assertEquals(expected, emp.toString());
    }
}
