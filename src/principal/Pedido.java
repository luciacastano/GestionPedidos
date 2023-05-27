package principal;

import java.util.Date;

public class Pedido {
	
	Cliente cliente;
	Producto producto1;
	Producto producto2;
	double importeTotal;
	PasarelaDePago pago;
	Estado estado;
	String codigoPedido;
	
	
	/**
	 * Constructor vacío
	 */
	public Pedido() {
		
	}


	/**
	 * Constructor con parámetros
	 * 
	 * @param cliente
	 * @param producto1
	 * @param producto2
	 * @param importeTotal
	 * @param pago
	 * @param estado
	 * @param codigoPedido
	 */
	public Pedido(Cliente cliente, Producto producto1, Producto producto2, double importeTotal, PasarelaDePago pago, Estado estado) {
		this.cliente = cliente;
		this.producto1 = producto1;
		this.producto2 = producto2;
		this.importeTotal = importeTotal;
		this.pago = pago;
		this.estado = estado;
		this.codigoPedido = generarCodigoPedido();
	}


	/**
	 * Getters and Setters
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido() {

		this.codigoPedido = generarCodigoPedido();
	}

	public Producto getProducto1() {
		return producto1;
	}

	public void setProducto1(Producto producto1) {
		this.producto1 = producto1;
	}

	public Producto getProducto2() {
		return producto2;
	}

	public void setProducto2(Producto producto2) {
		this.producto2 = producto2;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public PasarelaDePago getPago() {
		return pago;
	}

	public void setPago(PasarelaDePago pago) {
		this.pago = pago;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public boolean isPagoRealizado() {
		return pagoRealizado;
	}

	public void setPagoRealizado(boolean pagoRealizado) {
		this.pagoRealizado = pagoRealizado;
	}

	
	/**
	 * Método que nos va a indicar el estado del producto
	 * 
	 * clase enum, para la enumeración del estado
	 * 
	 * @author Lucía Castaño
	 *
	 */
	public enum Estado {
		PAGADO, PREPARANDO, LISTO, SERVIDO
	}


	/**
	 * Método que nos va a indicar el tipo de pago
	 * 
	 * clase enum, para la enumeración del tipo de pago
	 * 
	 * @author Lucía Castaño
	 *
	 */
	public enum TipoPago {
		EFECTIVO, TARJETA, CUENTA
	}


	private boolean pagoRealizado = false;

	/**
	 * Método pagar, indica si el pago ha sido realizado
	 * 
	 * @param tipoPago
	 */
	public void pagar(TipoPago tipoPago) {
		if (pagoRealizado == false) {
			pagoRealizado = true;
		}
	}


	/**
	 * Método agregarCliente, añade el cliente al crearlo
	 * 
	 * @param cliente
	 */
	public void agregarCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	/**
	 * Método agregarProducto1, añade el producto al crearlo
	 * 
	 * @param producto1
	 */
	public void agregarProducto1(Producto producto1) {
		this.producto1 = producto1;
	}


	/**
	 * Método agregarProducto2, añade el producto al crearlo
	 * 
	 * @param producto2
	 */
	public void agregarProducto2(Producto producto2) {
		if (this.producto1 != null) {
			this.producto2 = producto2;
		}
	}


	/**
	 * Método eliminarProducto, borra el producto
	 * 
	 * @param producto
	 * @return
	 */
	public Producto eliminarProducto(Producto producto) {
		producto = null;
		return producto;
	}


	/**
	 * Método generarCodigoPedido, crea un código al finalizar un pedido
	 * y nos muestra la fecha
	 * 
	 * @return
	 */
	public String generarCodigoPedido() {
		return String.valueOf(new Date().getTime());

	}


	/**
	 * Método toString, imprime el ticket por pantalla al realizar el pedido
	 */
	@Override
	public String toString() {
		double totalProducto1 = producto1.getCantidad() * producto1.getPrecio();
		double totalProducto2 = producto2.getCantidad() * producto2.getPrecio();
		double totalPedido = totalProducto1 + totalProducto2;

		return " CANTIDAD		PRODUCTO		PRECIO/UD		TOTAL \n" 
				+ producto1.getCantidad() + "               " + producto1.getNombre() + "             " + producto1.getPrecio() + "           " + totalProducto1 + " € \n" 
				+ producto2.getCantidad() + "               " + producto2.getNombre() + "             "	+ producto2.getPrecio() + "           " + totalProducto2 + " € \n"
				+ " TOTAL ------------------------------- " + totalPedido + " € \n ";
	}

	
	/**
	 * Método toString2, encargado de calcular el valor de los productos
	 * 
	 * @return
	 */
	public double toString2() {
		double totalProducto1 = producto1.getCantidad() * producto1.getPrecio();
		double totalProducto2 = producto2.getCantidad() * producto2.getPrecio();
		double totalPedido = totalProducto1 + totalProducto2;

		return totalPedido;
	}
}
