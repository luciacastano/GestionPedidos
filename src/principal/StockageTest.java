package principal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StockageTest {

	// método rellenarStock
	@Test
	public void testRellenarStock() {
		Stockage stockage = new Stockage();
		Producto producto = new Producto();

		stockage.rellenarStock(producto);

		// Verificar que el stock se haya llenado correctamente
		for (int i = 0; i < stockage.stock1.length; i++) {
			assertEquals(1, stockage.stock1[i]);
		}
	}


	// método mostrarStock
	@Test
	public void testMostrarStock() {
		Stockage stockage = new Stockage();
		Producto producto = new Producto();

		// Simular un stock lleno
		for (int i = 0; i < stockage.stock1.length; i++) {
			stockage.stock1[i] = 1;
		}

		int cantidad = stockage.mostrarStock(producto);

		// Verificar que la cantidad sea la esperada
		assertEquals(stockage.stock1.length, cantidad);
	}


	// método realizarPedido
	@Test
	public void testRealizarPedido() {
		Stockage stockage = new Stockage();
		Producto producto = new Producto();

		// Simular un stock lleno
		for (int i = 0; i < stockage.stock1.length; i++) {
			stockage.stock1[i] = 1;
		}

		int cantidadInicial = stockage.mostrarStock(producto);

		// Realizar un pedido de 10 unidades
		stockage.realizarPedido(10);

		int cantidadFinal = stockage.mostrarStock(producto);

		// Comprobación de que sale el mismo resultado en ambas (30):
		// System.out.println("cantidadInicial: " + cantidadInicial);
		// System.out.println("cantidadFinal: " + cantidadFinal);

		// Verificar que la cantidad se haya actualizado correctamente
		assertEquals(cantidadInicial - 10, cantidadFinal);
	}
}
