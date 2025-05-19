package PruebasAntesDeInicio.PruebasLocal;

import java.sql.SQLException;

public class usardatos {

	public static void main(String[] args) {
		ConexionMySQL conexion = new ConexionMySQL("root", "", "futbol");
		try {
			conexion.conectar();
			
			String sentencia = "SELECT * FROM futbolista"; //SENTENCIA
			conexion.ejecutarInsertDeleteUpdate(sentencia);
			conexion.desconectar();
		
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

}
