package Plantillas;

import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.ConexionMySQL;

public class EmpleadoService 
{
	 private ConexionMySQL conexion;

	    public EmpleadoService(ConexionMySQL conexion) {
	        this.conexion = conexion;
	    }

	    public boolean empleadoExiste(Empleado emp) throws SQLException {
	        conexion.conectar();
	        String query = "SELECT * FROM empleados WHERE " +
	                "Nombre = '" + emp.getNombre() + "' AND " +
	                "Primer_apellido = '" + emp.getApe1() + "' AND " +
	                "Segundo_apellido = '" + emp.getApe2() + "' AND " +
	                "Edad = " + emp.getEdad();

	        ResultSet rs = conexion.ejecutarSelect(query);
	        boolean existe = rs.next();
	        rs.close();
	        return existe;
	    }

	    public void insertarEmpleado(Empleado emp) throws SQLException {
	        String insert = "INSERT INTO empleados(Nombre, Primer_apellido, Segundo_apellido, Edad, Sexo, Fecha_entrada) VALUES ('" +
	                emp.getNombre() + "', '" +
	                emp.getApe1() + "', '" +
	                emp.getApe2() + "', " +
	                emp.getEdad() + ", '" +
	                emp.getFecha() + "')";
	        conexion.ejecutarInsertDeleteUpdate(insert);
	    }

	    public static boolean validarEdad(String edadTexto) {
	        try {
	            int edad = Integer.parseInt(edadTexto);
	            return edad >= 16 && edad <= 100;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
	}

