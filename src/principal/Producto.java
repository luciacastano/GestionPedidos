package principal;

//import java.util.Scanner;

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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Datos a rellenar de los productos (5) Método que llamaremos desde el main
	 
	public static void datosProducto() {
		Scanner sc = new Scanner(System.in);
		
		/**
		 * nos declaramos variable para identificar a los clientes; dependiendo del
		 * número del cliente que sea, mostrará por pantalla el teléfono correspondiente
		
		int num_cliente;
		System.out.println("\n#####MENU PEDIDOS#####" + "\n1. Realizar pedidos"
						 + "\nIdentificador del cliente --> 1, 2 o 3");
		num_cliente = sc.nextInt();

		/**
		 * llamamos al método creado en la clase Cliente que va a comprobar que
		 * dependieno del cliente 1/2/3, nos muestra su telefono correspondiente
		 
		Cliente.identifCliente();

		/**
		 * como queremos 5 productos, bucle for
		 
		for (int i = 0; i < 5; i++) {
			System.out.print("Nombre prodcuto " + (i + 1));
			nombreProd = sc.nextLine();

			System.out.print("Precio prodcuto " + (i + 1));
			precioProd = sc.nextDouble();

			System.out.print("Cantidad prodcuto " + (i + 1));
			cantidadProd = sc.nextInt();
		}

	}*/
}
