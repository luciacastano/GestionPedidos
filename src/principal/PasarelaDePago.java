package principal;

import java.util.Date;
import java.util.Scanner;

public class PasarelaDePago {

	/**
	 * Atributos declarados a utilizar
	 */
	double importe;
	String codigoPago;
	
	
	/**
	 * Constructor vacío
	 */
	public PasarelaDePago() {
		
	}
	
	
	/**
	 * Constructor con parámetros
	 * 
	 * @param importe
	 * @param codigoPago
	 */
	public PasarelaDePago(double importe) {
		this.importe = importe;
		this.codigoPago = this.generarCodigoPago();
	}


	/**
	 * Getters and Setters
	 */
	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago(String codigoPago) {
		this.codigoPago = codigoPago;
	}


	/**
	 * Primer método de pago, efectivo()
	 * 
	 * @param efectivo1
	 */
	public void efectivopago(Double efectivo1) {
		this.importe = efectivo1;
		this.codigoPago = this.generarCodigoPago();

		Scanner sc = new Scanner(System.in);
		System.out.println("Manera de pago: efectivo");

		double cantidad = efectivo1;
		System.out.println("Total de " + cantidad + "€");
		System.out.println("Necesitas:");

		if (cantidad >= 50) {
			int i = 0;
			while (cantidad >= 50) {

				cantidad = cantidad - 50;
				i++;
			}
			System.out.println(i + " billetes de 50€");
		}

		if (cantidad <= 50 && cantidad >= 20) {
			int v = 0;
			while (cantidad >= 20) {

				cantidad = cantidad - 20;
				v++;
			}
			System.out.println(v + " billetes de 20€");
		}

		if (cantidad <= 20 && cantidad >= 10) {
			int d = 0;
			while (cantidad >= 10) {

				cantidad = cantidad - 10;
				d++;
			}
			System.out.println(d + " billetes de 10€");
		}

		if (cantidad <= 10 && cantidad >= 5) {
			int e = 0;
			while (cantidad >= 5) {

				cantidad = cantidad - 5;
				e++;
			}
			System.out.println(e + " billetes de 5€");
		}

		if (cantidad <= 5 && cantidad >= 2) {
			int r = 0;
			while (cantidad >= 2) {

				cantidad = cantidad - 2;
				r++;
			}
			System.out.println(r + " monedas de 2€");
		}

		if (cantidad <= 2 && cantidad >= 1) {
			int t = 0;
			while (cantidad >= 1) {

				cantidad = cantidad - 1;
				t++;
			}
			System.out.println(t + " monedas de 1€");
		}

		if (cantidad <= 1 && cantidad >= 0.5) {
			int q = 0;
			while (cantidad >= 0.5) {

				cantidad = (float) (cantidad - 0.5);
				q++;
			}
			System.out.println(q + " monedas de 0.50€");
		}

		if (cantidad <= 0.5 && cantidad >= 0.2) {
			int y = 0;
			while (cantidad >= 0.2) {

				cantidad = (float) (cantidad - 0.2);
				y++;
			}
			System.out.println(y + " monedas de 0.20€");
		}

		if (cantidad <= 0.2 && cantidad >= 0.1) {
			int u = 0;
			while (cantidad >= 0.1) {

				cantidad = (float) (cantidad - 0.1);
				u++;
			}
			System.out.println(u + " monedas de 0.10€");
		}

		if (cantidad <= 0.1 && cantidad >= 0.05) {
			int p = 0;
			while (cantidad >= 0.05) {

				cantidad = (float) (cantidad - 0.05);
				p++;
			}
			System.out.println(p + " monedas de 0.05€");
		}

		if (cantidad <= 0.05 && cantidad >= 0.02) {
			int o = 0;
			while (cantidad >= 0.02) {

				cantidad = (float) (cantidad - 0.02);
				o++;
			}
			System.out.println(o + " monedas de 0.02€");
		}

		if (cantidad <= 0.02 && cantidad >= 0.01) {
			int l = 0;
			while (cantidad >= 0.01) {

				cantidad = (float) (cantidad - 0.01);
				l++;
			}
			System.out.println(l + " monedas de 0.01€");

		}
	}


	/**
	 * Segundo método de pago, trajeta()
	 * 
	 * @param numeroTarjeta
	 */
	public void tarjeta(String numeroTarjeta) {

		this.importe = 0.0;
		this.codigoPago = this.generarCodigoPago();
		System.out.println("Manera de pago: tarjeta");

		System.out.println("Escriba el numero de su tarjeta");
		Scanner sc = new Scanner(System.in);
		String tarjeta = sc.nextLine();
		char metPago = tarjeta.charAt(0);

		switch (metPago) {
		case '3': // Visa/MasterCard -->16 dígitos separados de 4 en 4
			System.out.println("Tarjeta American Express");
			if (metPago == '3') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 16) {
					String dis1 = cadenaString.substring(0, 4);
					String dis2 = cadenaString.substring(4, 8);
					String dis3 = cadenaString.substring(8, 12);
					String dis4 = cadenaString.substring(12, 16);

					System.out.println("El numero de su tarjeta es " + dis1 + " " + dis2 + " " + dis3 + " " + dis4);
				} else {
					System.out.println("Numero de tarjeta no valido");
				}
			} else {
				System.out.println("Numero de tarjeta no valido");
			}
			break;

		case '4':
			System.out.println("Tarjeta Visa");
			if (metPago == '4') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 16) {
					String dis1 = cadenaString.substring(0, 4);
					String dis2 = cadenaString.substring(4, 8);
					String dis3 = cadenaString.substring(8, 12);
					String dis4 = cadenaString.substring(12, 16);

					System.out.println("El numero de su tarjeta es " + dis1 + " " + dis2 + " " + dis3 + " " + dis4);
				} else {
					System.out.println("Numero de tarjeta no valido");
				}
			} else {
				System.out.println("Numero de tarjeta no valido");
			}
			break;

		case '5': // American Express --> 15 dígitos y separados por 4, 6 y 5
			System.out.println("Tarjeta Mastercard");
			if (metPago == '5') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 15) {
					String dis1 = cadenaString.substring(0, 4);
					String dis2 = cadenaString.substring(4, 10);
					String dis3 = cadenaString.substring(10, 15);

					System.out.println("El numero de su tarjeta es " + dis1 + " " + dis2 + " " + dis3);
				} else {
					System.out.println("Numero de tarjeta no valido");
				}
			} else {
				System.out.println("Numero de tarjeta no valido");
			}
			break;

		default:
			System.out.println("Tarjeta no  valida");
		}
	}


	/**
	 * Tercer método de pago, cuenta()
	 * 
	 * @param numeroCuenta
	 */
	public void cuenta(String numeroCuenta) {
		this.importe = 0.0;
		this.codigoPago = this.generarCodigoPago();

	}


	/**
	 * Método que va a generar el codigo del pedido que se le añadirá al historial
	 * del cliente al realizarlo
	 * 
	 * @return
	 */
	public String generarCodigoPago() {
		return String.valueOf(new Date().getTime());

	}
}
