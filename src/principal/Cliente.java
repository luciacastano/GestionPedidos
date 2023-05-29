package principal;

import java.sql.Date;
import java.util.Scanner;

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
	 * Método realizarPedido()
	 * se encargará de que, al realizar un pedido, se añada al historial del cliente
	 * @param pedido
	 */
	public void realizarPedido(Pedido pedido) {
		this.historial = this.historial + pedido.getCodigoPedido();
	}

	
	// creamos las variables a utilizar en los métodos posteriores
	String telefono1;
	String telefono2;
	String telefono3;
	
	/**
	 * Método creaCliente()
	 * for que nos va a permitir escribir los datos de clientes de manera más óptima 
	 */
	public void creaCliente() {
		Scanner sc = new Scanner(System.in);

		System.out.println("#####MENU INICIAL#####" + "\nVamos a crear 3 clientes"
				+ "\n¡ADVERTENCIA! no pueden haber dos clientes con el mismo numero de telefono");

		// creamos primer cliente
		System.out.println("\n##Primer cliente##");
		System.out.print("Nombre: ");
		String nombre1 = sc.nextLine();
		System.out.print("Apellidos: ");
		String apellido1 = sc.nextLine();
		System.out.print("Telefono: ");
		telefono1 = sc.nextLine();
		System.out.print("Direccion: ");
		String direccion1 = sc.nextLine();

		TratamientoFicheros.EscribeFicheroCliente(nombre1, apellido1, telefono1, direccion1);

		// creamos segundo cliente
		System.out.println("\n##Segundo cliente##");
		System.out.print("Nombre: ");
		String nombre2 = sc.nextLine();
		System.out.print("Apellidos: ");
		String apellido2 = sc.nextLine();
		System.out.print("Telefono: ");
		telefono2 = sc.nextLine();
		System.out.print("Direccion: ");
		String direccion2 = sc.nextLine();

		TratamientoFicheros.EscribeFicheroCliente(nombre2, apellido2, telefono2, direccion2);

		// creamos tercer cliente
		System.out.println("\n##Tercer cliente##");
		System.out.print("Nombre: ");
		String nombre3 = sc.nextLine();
		System.out.print("Apellidos: ");
		String apellido3 = sc.nextLine();
		System.out.print("Telefono: ");
		telefono3 = sc.nextLine();
		System.out.print("Direccion: ");
		String direccion3 = sc.nextLine();

		TratamientoFicheros.EscribeFicheroCliente(nombre3, apellido3, telefono3, direccion3);
	}
	
	
	/**
	 * Método valCliente()
	 * va a decir si un cliente es o no existente
	 */
	public void valCliente() {
		creaCliente(); // Llamamos al método para obtener los teléfonos

        Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese un numero de telefono: ");
        String telefono = sc.nextLine();

        if (telefono.equals(telefono1)) {
            System.out.println("Bienvenido cliente1:");
            // cliente1 = true;  // No se menciona qué son las variables cliente1, cliente2 y cliente3
        } else if (telefono.equals(telefono2)) {
            System.out.println("Bienvenido cliente2:");
            // cliente2 = true;
        } else if (telefono.equals(telefono3)) {
            System.out.println("Bienvenido cliente3:");
            // cliente3 = true;
        } else {
			System.out.println("El cliente no existe");
            // El número de teléfono no coincide con ninguno de los clientes creados
        }
	}
}
