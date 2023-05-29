package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TratamientoFicheros {

	/**
	 * creamos tres metodos, con los nombres de cada uno de nuestros ficheros de
	 * lectura y escritura: 1. LeerFichero 2. FileScanner 3. EscribeFichero
	 */

	/**
	 * metodo 1; LeerFichero
	 */
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
		b.close();
	}

	public static void main(String[] args) throws IOException {
		String ruta = "c:/Users/Lucía Castaño/Desktop/GestionPedidosFicheros/productos.txt";
		// en el proyecto, poner las rutas fuera del método, es decir, ponerlas como
		// atributo global
	}


	/**
	 * metodo 2; FileScanner
	 */
	public static void FileScanner() {
		String ruta = "c:/Users/Lucía Castaño/Desktop/lectura.txt";
		File f = new File(ruta);
		System.out.println("La ruta del fichero es: " + f.getAbsolutePath());
		Scanner s;
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				Scanner sl = new Scanner(linea);
				sl.useDelimiter("\\s*,\\s*");
				System.out.println(sl.next());
				System.out.println(sl.next());
				System.out.println(sl.next());
				System.out.println(sl.next());
				System.out.println(sl.next());
			}
			s.close();
		} catch (FileNotFoundException e) {
			// PrintWriter pw = null;
			e.printStackTrace();
			// e.printStackTrace(pw);

		}
	}


	/**
	 * metodo 3; EscribeFichero
	 */
	public static void EscribeFicheroCliente(String nombre, String apellido, String telefono, String direccion) {
		String ruta = "c:/Users/Lucía Castaño/Desktop/GestionPedidosFicheros/clientes.txt";
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			// Añadir flag a true para no machacar contenido del fichero de escritura
			fichero = new FileWriter(ruta, true);
			pw = new PrintWriter(fichero);

			pw.println("Nombre: " + nombre);
			pw.println("Apellidos: " + apellido);
			pw.println("Telefono: " + telefono);
			pw.println("Direccion: " + direccion);
			pw.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * método 3 de nujevo, adaptado al almacenaje de los productos en un fichero
	 * 
	 * @param nombre
	 * @param precio
	 */
	public static void EscribeFicheroProducto(String nombre, double precio) {
		String ruta = "c:/Users/Lucía Castaño/Desktop/GestionPedidosFicheros/productos.txt";
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			// Añadir flag a true para no machacar contenido del fichero de escritura
			fichero = new FileWriter(ruta, true);
			pw = new PrintWriter(fichero);

			pw.println("Nombre: " + nombre);
			pw.println("Precio: " + precio);
			pw.println();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
