package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Lucía Castaño
 *
 */
public class TestConexion {

	private static String selectTableSQL;
	private static String insertTableSQL;
	private static String updateTableSQL;

	
	/**
	 * Método cerrar_conexion3
	 * Este nos va a servir para que, una vez que tengamos acceso a la bbdd,
	 * se cierren cada una de las conexiones para que no surgan problemas
	 * 
	 * @param cn
	 * @param stm
	 * @param rs
	 */
	public static void cerrar_conexion3(Connection cn, Statement stm, ResultSet rs) {
		// Liberar recursos revisar el orden en el que se cierran, orden inverso
		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (cn != null) {
				cn.close();
			}
			System.out.println("La conexión se ha cerrado con éxito");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

	}

	
	/**
	 * Método consulta_select
	 * Cuando llamemos a este método desde el main haremos el select
	 */
	public static void consulta_select() {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		selectTableSQL = "SELECT * FROM USUARIO";

		try {
			// Abrimos la conexion con la base de datos
			cn = conexion.conectar();
			stm = cn.createStatement();
			// Pasamos la consulta al ResultSet
			rs = stm.executeQuery(selectTableSQL);

			while (rs.next()) {
				int idUsuario = rs.getInt(1);
				String usuario = rs.getString(2);
				String clave = rs.getString(3);

				System.out.println(idUsuario + " " + usuario + " " + clave);
			}
		} catch (SQLException e) { // TODO: handle exception

		} finally {
			cerrar_conexion3(cn, stm, rs);
			/*
			 * try { if (rs != null) { rs.close(); } if (stm != null) { stm.close(); } if
			 * (cn != null) { cn.close(); }
			 * 
			 * } catch (Exception e2) {
			 * 
			 * }
			 */

		}

	}

	
	/**
	 * Método consulta_insert
	 * Cuando llamemos a este método desde el main haremos el insert
	 * 
	 * métodos adaptados a mis necesidades
	 * 
	 * @param usuario
	 * @param clave
	 */
	public static void consulta_insertCliente(String nombre, String apellido, String telefono, String direccion) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		String insertTableSQL = "INSERT INTO cliente (nombre, apellidos, telefono, direccion) VALUES (?, ?, ?, ?)";

		try {
			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, telefono);
			ps.setString(4, direccion);
			ps.executeUpdate();

			System.out.println("El registro ha sido insertado con éxito en la base de datos");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void consulta_insertProducto(String nombre, double precio) {
		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		String insertTableSQL = "INSERT INTO producto (nombre, precio) VALUES (?, ?)";

		try {
			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			ps.setString(1, nombre);
			ps.setDouble(2, precio);
			ps.executeUpdate();

			System.out.println("El registro ha sido insertado con éxito en la base de datos");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}


	/**
	 * Método consulta_update
	 * Cuando llamemos a este método desde el main haremos el update
	 * 
	 * @param id_usuario
	 * @param usuario
	 * @param clave
	 */
	public static void consulta_update(int id_usuario, String usuario, String clave) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;

		// Crear sentencia SQL para insertar en la base de datos
		updateTableSQL = "UPDATE usuario set usuario ='" + usuario + "', clave='" + clave + "' where idusuario="
				+ id_usuario;

		try {

			cn = conexion.conectar();
			stm = cn.createStatement();
			int valor = stm.executeUpdate(updateTableSQL);
			if (valor == 1) {
				System.out.println("El usuario ha sido actualizado correctamente");
			} else {
				System.out.println("No existe usuario con el id_usuario referido");
			}

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

	}

	public static void main(String[] args) {

		consulta_select();
		// consulta_insert("Lucas", "123");
		// consulta_update(7, "alvaro", "123");

	}
}
