package principal;

/**
 * 
 * @author Lucía Castaño
 *
 */
public class Producto {

	/**
	 * Atributos declarados a utilizar
	 */
	String nombre;
	double precio;
	int cantidad;
	

	/**
	 * Constructor vacío
	 */
	public Producto() {

	}
	
	/**
	 * Constructor con parámetros
	 * 
	 * @param nombre
	 * @param precio
	 * @param cantidad
	 */
	public Producto(String nombre, double precio, int cantidad) {
		this.nombre = nombre.toUpperCase(); // guardado en mayusculas
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	
	/**
	 * Getters ans Setters
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int setCantidad(int cantidad) {
		return this.cantidad = cantidad;
	}

	
	/**
	 * método creado para poder realizar el pedido en GestionPedidos
	 * 
	 * @param cantidad2
	 */
	public void realizarPedido(int cantidad2) {
		// TODO Auto-generated method stub
		
	}
}
