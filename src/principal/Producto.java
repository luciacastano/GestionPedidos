package principal;

import java.util.Scanner;

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
	
	
	// creamos las variables a utilizar en los métodos posteriores
	private String[] nombresProductos = new String[5]; // almcena todos los nombres
	private double[] preciosProductos = new double[5]; // almcena todos los precios

	
	/**
	 * Método creaProducto(), nos va a permitir crear los 5 productos
	 */
	public void creaProducto() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n#####MENU PRODUCTOS#####" + "\nVamos a crear 5 productos"
				+ "\n¡ADVERTENCIA! no pueden haber dos productos con el mismo nombre");

		// creamos primer producto
		System.out.println("\n##Primer producto##");
		System.out.println("Nombre: ");
		String prod1 = sc.next();
		System.out.println("Precio (tomado en euros, si es decimal usar la coma):");
		double prodprec1 = sc.nextDouble();
		nombresProductos[0] = prod1; // almacena el nombre
		preciosProductos[0] = prodprec1; // almacena el precio

		TratamientoFicheros.EscribeFicheroProducto(prod1, prodprec1);
		TestConexion.consulta_insertProducto(prod1, prodprec1);

		// creamos segundo producto
		System.out.println("\n##Segundo producto##");
		System.out.println("Nombre: ");
		String prod2 = sc.next();
		System.out.println("Precio (tomado en euros, si es decimal usar la coma):");
		double prodprec2 = sc.nextDouble();
		nombresProductos[1] = prod2; // almacena el nombre
		preciosProductos[1] = prodprec2; // almacena el precio

		TratamientoFicheros.EscribeFicheroProducto(prod2, prodprec2);
		TestConexion.consulta_insertProducto(prod2, prodprec2);

		// creamos tercer producto
		System.out.println("\n##Tercer producto##");
		System.out.println("Nombre: ");
		String prod3 = sc.next();
		System.out.println("Precio (tomado en euros, si es decimal usar la coma):");
		double prodprec3 = sc.nextDouble();
		nombresProductos[2] = prod3; // almacena el nombre
		preciosProductos[2] = prodprec3; // almacena el precio

		TratamientoFicheros.EscribeFicheroProducto(prod3, prodprec3);
		TestConexion.consulta_insertProducto(prod3, prodprec3);

		// creamos cuarto producto
		System.out.println("\n##Cuarto producto##");
		System.out.println("Nombre: ");
		String prod4 = sc.next();
		System.out.println("Precio (tomado en euros, si es decimal usar la coma):");
		double prodprec4 = sc.nextDouble();
		nombresProductos[3] = prod4; // almacena el nombre
		preciosProductos[3] = prodprec4; // almacena el precio

		TratamientoFicheros.EscribeFicheroProducto(prod4, prodprec4);
		TestConexion.consulta_insertProducto(prod4, prodprec4);

		// creamos quinto producto
		System.out.println("\n##Producto##");
		System.out.println("Nombre: ");
		String prod5 = sc.next();
		System.out.println("Precio (tomado en euros, si es decimal usar la coma):");
		double prodprec5 = sc.nextDouble();
		nombresProductos[4] = prod5; // almacena el nombre
		preciosProductos[4] = prodprec5; // almacena el precio

		TratamientoFicheros.EscribeFicheroProducto(prod5, prodprec5);
		TestConexion.consulta_insertProducto(prod5, prodprec5);
	}


	/**
	 * Método muestraProducto(), nos va a mostrar los productos que hemos creado
	 * anteriormente
	 */
	public void muestraProducto() {
		System.out.println("###Seleccione el producto que desea:");

		for (int i = 0; i < 5; i++) {
			int numeroProducto = i + 1;
			System.out.println("Producto " + numeroProducto + ": " + nombresProductos[i] + " " + preciosProductos[i] + "€");
		}
	}


	/**
	 * Método infoProducto(), cantidad y stock del productos
	 */
	public void infoProducto() {
		Scanner sc = new Scanner(System.in);
		boolean repCliente1 = false;
	    boolean repCliente2 = false;
	    boolean repCliente3 = false;

	    Cliente cliente1 = new Cliente();
	    Cliente cliente2 = new Cliente();
	    Cliente cliente3 = new Cliente();

	    // Creamos instancia de los productos
	    Producto producto1 = new Producto(nombresProductos[0], preciosProductos[0], cantidad);
	    Producto producto2 = new Producto(nombresProductos[1], preciosProductos[1], cantidad);
	    Producto producto3 = new Producto(nombresProductos[2], preciosProductos[2], cantidad);
	    Producto producto4 = new Producto(nombresProductos[3], preciosProductos[3], cantidad);
	    Producto producto5 = new Producto(nombresProductos[4], preciosProductos[4], cantidad);

	    int prod;
	    Pedido pedido = new Pedido();
	    Stockage stockage = new Stockage(); // creamos instancia
	    

	    int stockRestante = 0;
	    String totalEfectivo = "";

	    do {
	        if (stockRestante < 0) {
	            break;
	        } else {
	            System.out.println("Inserte valor del pedido");
	            prod = sc.nextInt();

				switch (prod) {

				case 0: {

					if (repCliente1) {
						cliente1.realizarPedido(pedido);
					} else if (repCliente2) {
						cliente2.realizarPedido(pedido);
					} else if (repCliente3) {
						cliente3.realizarPedido(pedido);
					}

	                    // realizamos el ticket del pedido
						totalEfectivo = String.valueOf(pedido.toString2()); // convertimos el valor numérico en cadena de texto
	                    System.out.println(pedido.toString());
	                    break;
	                }

	                /**
	                 * comprobación stock; resta 30 al stock, menor de 5, mensaje por pantalla
	                 */
	                case 1: {
	                    System.out.println("Cantidad del " + producto1.getNombre() + " deseada");
	                    int cantidad = sc.nextInt();
	                    int i;
	                    producto1.realizarPedido(cantidad);
	                    producto1.setCantidad(cantidad);

	                    stockRestante = stockage.mostrarStock(producto1) - cantidad;

	                    if (stockRestante > 5 && stockRestante <= 30) {
	                        System.out.println("Stock restante de " + producto1.getNombre() + ": " + stockRestante);
	                    } else if (stockRestante <= 5 && stockRestante >= 0) {
	                        System.out.println("Quedan menos de 5 unidades de " + producto1.getNombre());
	                    } else {
	                        System.out.println("No hay suficiente Stock");
	                        break;
	                    }

	                    if (pedido.getProducto1() == null) {
	                        pedido.agregarProducto1(producto1);
	                    } else if (pedido.getProducto2() == null) {
	                        pedido.agregarProducto2(producto1);
	                    }

	                    break;
	                }
	                case 2: {
	                    System.out.println("Cantidad del " + producto2.getNombre() + " deseada");
	                    int cantidad = sc.nextInt();
	                    int i;
	                    producto2.realizarPedido(cantidad);
	                    producto2.setCantidad(cantidad);

	                    stockRestante = stockage.mostrarStock(producto2) - cantidad;

	                    if (stockRestante > 5 && stockRestante <= 30) {
	                        System.out.println("Stock restante de " + producto2.getNombre() + ": " + stockRestante);
	                    } else if (stockRestante <= 5 && stockRestante >= 0) {
	                        System.out.println("Quedan menos de 5 unidades de " + producto2.getNombre());
	                    } else {
	                        System.out.println("No hay suficiente Stock");
	                        break;
	                    }

	                    if (pedido.getProducto1() == null) {
	                        pedido.agregarProducto1(producto2);
	                    } else if (pedido.getProducto2() == null) {
	                        pedido.agregarProducto2(producto2);
	                    }
	                    break;
	                }
	                case 3: {
	                    System.out.println("Cantidad del " + producto3.getNombre() + " deseada");
	                    int cantidad = sc.nextInt();
	                    int i;
	                    producto3.realizarPedido(cantidad);
	                    producto3.setCantidad(cantidad);

	                    stockRestante = stockage.mostrarStock(producto3) - cantidad;

	                    if (stockRestante > 5 && stockRestante <= 30) {
	                        System.out.println("Stock restante de " + producto3.getNombre() + ": " + stockRestante);
	                    } else if (stockRestante <= 5 && stockRestante >= 0) {
	                        System.out.println("Quedan menos de 5 unidades de " + producto3.getNombre());
	                    } else {
	                        System.out.println("No hay suficiente Stock");
	                    }

	                    if (pedido.getProducto1() == null) {
	                        pedido.agregarProducto1(producto3);
	                    } else if (pedido.getProducto2() == null) {
	                        pedido.agregarProducto2(producto3);
	                    }
	                    break;
	                }
	                case 4: {
	                    System.out.println("Cantidad del " + producto4.getNombre() + " deseada");
	                    int cantidad = sc.nextInt();
	                    int i;
	                    producto4.realizarPedido(cantidad);
	                    producto4.setCantidad(cantidad);

	                    stockRestante = stockage.mostrarStock(producto4) - cantidad;

	                    if (stockRestante > 5 && stockRestante <= 30) {
	                        System.out.println("Stock restante de " + producto4.getNombre() + ": " + stockRestante);
	                    } else if (stockRestante <= 5 && stockRestante >= 0) {
	                        System.out.println("Quedan menos de 5 unidades de " + producto4.getNombre());
	                    } else {
	                        System.out.println("No hay suficiente Stock");
	                    }

	                    if (pedido.getProducto1() == null) {
	                        pedido.agregarProducto1(producto4);
	                    } else if (pedido.getProducto2() == null) {
	                        pedido.agregarProducto2(producto4);
	                    }
	                    break;
	                }
	                case 5: {
	                    System.out.println("Cantidad del " + producto5.getNombre() + " deseada");
	                    int cantidad = sc.nextInt();
	                    int i;
	                    producto5.realizarPedido(cantidad);
	                    producto5.setCantidad(cantidad);

	                    stockRestante = stockage.mostrarStock(producto5) - cantidad;

	                    if (stockRestante > 5 && stockRestante <= 30) {
	                        System.out.println("Stock restante de " + producto5.getNombre() + ": " + stockRestante);
	                    } else if (stockRestante <= 5 && stockRestante >= 0) {
	                        System.out.println("Quedan menos de 5 unidades de " + producto5.getNombre());
	                    } else {
	                        System.out.println("No hay suficiente Stock");
	                    }

	                    if (pedido.getProducto1() == null) {
	                        pedido.agregarProducto1(producto5);
	                    } else if (pedido.getProducto2() == null) {
	                        pedido.agregarProducto2(producto5);
	                    }
	                    break;
	                }

	                default:
	                    break;
				}
	        }
	    } while (prod != 0);
	}

}
