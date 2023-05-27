package principal;

import java.sql.Date;

/**
 * 
 * @author Lucía Castaño
 *
 */
public class Cliente {

	/**
	 * Atributos declarados a utilizar
	 */
	String nombre;
	String apellidos;
	Date fechaDeAlta;
	String telefono; // no se pone como int porque lo necesitamos valida y es más cómodo de esta manera
	String direccion;
	String historial;

	
	/**
	 * Constructor vacío
	 */
	public Cliente() {

	}


	/**
	 * Constructor
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param fechaDeAlta
	 * @param telefono
	 * @param direccion
	 * @param historial
	 */
	public Cliente(String nombre, String apellidos, Date fechaDeAlta, String telefono, String direccion, String historial) {
		this.nombre = nombre.toLowerCase(); // guardados en minuscula
		this.apellidos = apellidos.toUpperCase(); // guardados en mayuscula
		this.fechaDeAlta = fechaDeAlta;
		// validacion del numero de telefono, tanto por longitud como por valor inicial
		if (telefono.length() == 9 && (telefono.startsWith("6") || telefono.startsWith("7") || telefono.startsWith("8")	|| telefono.startsWith("9"))) {
			this.telefono = telefono;
		} else {
			System.out.println("Fallo en la escritura del telefono");
		}
		this.direccion = direccion;
		this.historial = historial;
	}
	

	/**
	 * Gettters and Setters
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase(); // guardados en minuscula
	}
	
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos.toUpperCase(); // guardados en mayuscula
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		if (fechaDeAlta == null) {
			this.fechaDeAlta = new Date(0); // si no lleva 0, da error
		} else {
			this.fechaDeAlta = fechaDeAlta;
		}
	}

	public String getTelefono() {
		return telefono;
	}

	/**
	 * Validación del teléfono: restringimos la longitud a 9 y que solo acepte
	 * aquello numeros que empiecen por 6, 7, 8 o 9
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		if (telefono.length() == 9 && (telefono.startsWith("6") || telefono.startsWith("7") || telefono.startsWith("8")	|| telefono.startsWith("9"))) {
			this.telefono = telefono;
		} else {
			System.out.println("Fallo en la escritura del telefono");
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}


	/**
	 * Método realizarPedido
	 * se encargará de que, al realizar un pedido, se añada al historial del cliente
	 * @param pedido
	 */
	public void realizarPedido(Pedido pedido) {
		this.historial = this.historial + pedido.getCodigoPedido();
	}
}
