package principal;

public class Stockage {

	/**
	 * Atributos declarados a utilizar
	 */
	int cantidad1 = 0;
	private int stock;
	private int stock1[] = new int[30];


	/**
	 * Getters and Setters
	 */
	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	/**
	 * Método para rellenar el stock, teniedno un array declarado
	 */
	public void rellenarStock(Producto producto) {
		for (int i = 0; i < stock1.length; i++) {
			stock1[i] = 1;
		}
	}

	
	/**
	 * Método para mostrar el stock que queda de acuerdo a algún producto
	 * 
	 * @return
	 */
	public int mostrarStock(Producto producto) {
		cantidad1 = 0; // si no inicializamos, da erro
		for (int i = 0; i < stock1.length; i++) {
			cantidad1++;
		}

		return cantidad1;
	}


	/**
	 * Método que va a actualizar la cantidad del producto después de realizar un pedido
	 * 
	 * @param cantidad
	 */
	public void realizarPedido(int cantidad) {
		cantidad1 = cantidad1 - cantidad;
	}
}
