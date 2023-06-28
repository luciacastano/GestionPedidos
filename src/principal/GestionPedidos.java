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

		Cliente cliente = new Cliente();
		Producto producto = new Producto();

		double totalEfectivo = 0;
		
		cliente.creaCliente(); // llamada al método para crear los clientes (clase Cliente)
		producto.creaProducto(); // llamada al método para crear los productos (clase Producto)
		
		cliente.valCliente(); // llamada al método para la validez de cliente con num telef (clase Cliente)
		producto.muestraProducto(); // llamada al método para mostrar los productos (clase Producto)
		producto.infoProducto(); // llamada al método para cantidad y stock de un producto (clase Producto)




		PasarelaDePago pasarela = new PasarelaDePago();
		pasarela.elegirpago(pasarela, sc);

	}
}

