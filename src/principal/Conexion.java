package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	/**
	 * creación de atributos para la localización de la base de datos
	 */
	private static final String NOMBRE_BD = "gestionpedidosed";
	private static final String UBICACION = "localhost";
	private static final String PUERTO = "3306";
	private static final String USUARIO = "root";
	private static final String CLAVE = "Qwerty";

	// Para versión mysql-conector-java-5.1.6.jar + mysql Server 5.7
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://" + UBICACION + ":" + PUERTO + "/" + NOMBRE_BD
			+ "?useUnicode=true&characterEncoding=utf-8";

	static {

		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			// * TODO Auto-generated catch block
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}


	/**
	 * Método conectar 
	 * Esto nos va a permitir la prueba de la conexion con la base
	 * de datos de mysql, lo llamaremos desde la clase TestConexion
	 * 
	 * @return
	 */
	public Connection conectar() {
		Connection conexion = null;

		try {

			// Establecemos la conexión para eso java nos prporciona conexion =
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

			System.out.println("Conexión correctamente establecida con la base de datos " + NOMBRE_BD);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return conexion;
	}
}
