package principal;

import java.util.Scanner;

/**
 * 
 * @author Lucía Castaño
 *
 */
public class GestionPedidos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();


		Producto producto1 = new Producto();
		Producto producto2 = new Producto();
		Producto producto3 = new Producto();
		Producto producto4 = new Producto();
		Producto producto5 = new Producto();
		
		double totalEfectivo = 0;
		
		
		/**
		 * creamos los clientes
		 */
		System.out.println("#####MENU INICIAL#####" 
				+ "\nVamos a crear 3 clientes" 
				+ "\n¡ADVERTENCIA! no pueden haber dos clientes con el mismo numero de telefono");
		
		
		// creamos el primer cliente
		System.out.println("\n##Primer cliente##");
		System.out.print("Nombre: ");
		String nombre1 = sc.nextLine();
		System.out.print("Apellidos: ");
		String apellido1 = sc.nextLine();
		System.out.print("Telefono: ");
		String telefono1 = sc.nextLine();
		System.out.print("Direccion: ");
		String direccion1 = sc.nextLine();

				
		// creamos el segundo cliente
		System.out.println("\n##Segundo cliente##");
		System.out.print("Nombre: ");
		String nombre2 = sc.nextLine();
		System.out.print("Apellidos: ");
		String apellido2 = sc.nextLine();
		System.out.print("Telefono: ");
		String telefono2 = sc.nextLine();
		System.out.print("Direccion: ");
		String direccion2 = sc.nextLine();

				
		// creamos el tercer cliente
		System.out.println("\n##Tercer cliente##");
		System.out.print("Nombre: ");
		String nombre3 = sc.nextLine();
		System.out.print("Apellidos: ");
		String apellido3 = sc.nextLine();
		System.out.print("Telefono: ");
		String telefono3 = sc.nextLine();
		System.out.print("Direccion: ");
		String direccion3 = sc.nextLine();
		
		
		/**
		 * creamos los productos
		 */
		System.out.println("\n#####MENU PRODUCTOS#####"
				+ "\nVamos a crear 5 productos" 
				+ "\n¡ADVERTENCIA! no pueden haber dos productos con el mismo nombre");
		
		
		// creamos porducto1
		System.out.println("\n##Primer producto##");
	    System.out.println("Nombre: ");
		String prodnomb1 = sc.next();
		System.out.println("Precio (tomado en euros, si es decimal usar la coma):");
		double prodprec1 = sc.nextDouble();
		

		// creamos porducto2
		System.out.println("\n##Segundo producto##");
	    System.out.println("Nombre: ");
		String prodnomb2 = sc.next();
		System.out.println("Precio (tomado en euros, si es decimal usar la coma):");
		double prodprec2 = sc.nextDouble();
		

		// creamos porducto3
		System.out.println("\n##Tercer producto##");
	    System.out.println("Nombre: ");
		String prodnomb3 = sc.next();
		System.out.println("Precio (tomado en euros, si es decimal usar la coma):");
		double prodprec3 = sc.nextDouble();
		

		// creamos porducto4
		System.out.println("\n##Cuarto producto##");
	    System.out.println("Nombre: ");
		String prodnomb4 = sc.next();
		System.out.println("Precio (tomado en euros, si es decimal usar la coma):");
		double prodprec4 = sc.nextDouble();
		

		// creamos porducto5
		System.out.println("\n##Quinto producto##");
	    System.out.println("Nombre: ");
		String prodnomb5 = sc.next();
		System.out.println("Precio (tomado en euros, si es decimal usar la coma):");
		double prodprec5 = sc.nextDouble();
		
		
		/**
		 * en este caso, vamos a pedir el numero de telefono para identificar a cada cliente 
		 * y, posteriormente, procedxeremos a la realizacion del pedido
		 */
		System.out.println("\n\n#####MENU PEDIDOS#####" 
				+ "\n1.Realizar Pedidos" + "\nIntroduzca el telefono del cliente");

		String telefono = sc.nextLine();
		// se  crean boolean para la identificacion
		boolean repCliente1 = false;
		boolean repCliente2 = false;
		boolean repCliente3 = false;

		if (telefono.equals(cliente1.getTelefono())) {
			System.out.println("Hola Cliente1:");
			repCliente1 = true;
		} else if (telefono.equals(cliente2.getTelefono())) {
			System.out.println("Hola Cliente2:");
			repCliente2 = true;
		} else if (telefono.equals(cliente3.getTelefono())) {
			System.out.println("Hola Cliente3:");
			repCliente3 = true;
		} else {
			System.out.println("No existe ese cliente");
		}

		if (repCliente1 || repCliente2 || repCliente3) {

			System.out.println("###Seleccione el producto que desea:");

			System.out.println("1.Producto 1: " + producto1.getNombre() + " " + producto1.getPrecio() + "€");
			System.out.println("2.Producto 2: " + producto2.getNombre() + " " + producto2.getPrecio() + "€");
			System.out.println("3.Producto 3: " + producto3.getNombre() + " " + producto3.getPrecio() + "€");
			System.out.println("4.Producto 4: " + producto4.getNombre() + " " + producto4.getPrecio() + "€");
			System.out.println("5.Producto 5: " + producto5.getNombre() + " " + producto5.getPrecio() + "€");
			
			int prod;
			Pedido pedido = new Pedido();

			do {
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
					totalEfectivo = pedido.toString2();
					System.out.println(pedido.toString());
					break;
				}

				case 1: {
					System.out.println("Cantidad del " + producto1.getNombre() + "deseada");
					int suma = sc.nextInt();
					suma = producto1.setCantidad(suma);

					if (pedido.getProducto1() == null) {
						pedido.agregarProducto1(producto1);
					} else if (pedido.getProducto2() == null) {
						pedido.agregarProducto2(producto1);
					}
					break;
				}
				case 2: {
					System.out.println("Cantidad del " + producto2.getNombre() + "deseada");
					int suma = sc.nextInt();
					suma = producto2.setCantidad(suma);

					if (pedido.getProducto1() == null) {
						pedido.agregarProducto1(producto2);
					} else if (pedido.getProducto2() == null) {
						pedido.agregarProducto2(producto2);
					}
					break;
				}
				case 3: {
					System.out.println("Cantidad del " + producto3.getNombre() + "deseada");
					int suma = sc.nextInt();
					suma = producto3.setCantidad(suma);

					if (pedido.getProducto1() == null) {
						pedido.agregarProducto1(producto3);
					} else if (pedido.getProducto2() == null) {
						pedido.agregarProducto2(producto3);
					}
					break;
				}
				case 4: {
					System.out.println("Cantidad del " + producto4.getNombre() + "deseada");
					int suma = sc.nextInt();
					suma = producto4.setCantidad(suma);

					if (pedido.getProducto1() == null) {
						pedido.agregarProducto1(producto4);
					} else if (pedido.getProducto2() == null) {
						pedido.agregarProducto2(producto4);
					}
					break;
				}
				case 5: {
					System.out.println("Cantidad del " + producto5.getNombre() + "deseada");
					int suma = sc.nextInt();
					suma = producto5.setCantidad(suma);

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
			} while (prod != 0);
		}

		PasarelaDePago efectivo = new PasarelaDePago();
		efectivo.efectivopago(totalEfectivo);
	}
}
