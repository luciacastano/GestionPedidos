package principal;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PasarelaDePago {

	// Atributos
	private double importe;
	String codigoPago;
		
	// Constructor
	public PasarelaDePago() {
		this.importe = 0;
		this.codigoPago = String.valueOf((new Date()).getTime());
		}

	// Metodo para adquirir el codigo del pago
	public void CodigoPago(String codigoPago1) {
		codigoPago = String.valueOf((new Date()).getTime());
		codigoPago1 = codigoPago;
		System.out.println(codigoPago1);
		}

	// Metodo para el pago en efectivo
	public void pagoTarjeta(Scanner sc) {
		try {
			System.out.println("Seleccion de pago con tarjeta");
			System.out.println("Inserte el precio a pagar");
			double pago2 = sc.nextDouble();

			Exceptions.validarImportePago(pago2);

			if (pago2 >= importe) {
				System.out.println("Numeros de tarjeta en su correcto orden");
				String numerotar1 = sc.nextLine();
				numerotar1 = sc.nextLine();

				String numerotar = numerotar1.replaceAll("\\s", "");
				System.out.println(numerotar);
				Exceptions.validarTarjeta(numerotar);

				System.out.println("Pago realizado. Codigo del mismo: " + codigoPago);
				importe = 0;
				codigoPago = String.valueOf((new Date()).getTime());
			} else {
				System.out.println("Cantidad igual o mayor a la del ticket." + "\nPruebe de nuevo");
			}
		} catch (Exceptions.ImportePagoException e) {
			System.out.println(e.getMessage());

		} catch (InputMismatchException e) {
			System.out.println("Valor inválido. Ingrese un número válido.");

		} catch (Exceptions.TarjetaInvalidaException e) {
			System.out.println(e.getMessage());
			}
		}

		public void pagoEfectivo(Scanner sc) {
			try {
				System.out.println("Importe total: ");
				double total = sc.nextDouble();

				System.out.println("Cantidad a pagar en efectivo:");
				double pago = sc.nextDouble();

				Exceptions.validarImportePago(total);

				if (pago >= total) {
					double vueltas = pago - total;

					if (vueltas > 0) {
						System.out.println("Pago realizado. Codigo del mismo: " + generarCodigoPago());
						System.out.println("Seleccion de pago en efectivo");

						System.out.println("Se devuelven: ");
						double[] valores = { 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01 };
						int[] cambio = new int[12];

						for (int i = 0; i < valores.length; i++) {
							while (vueltas >= valores[i]) {
								vueltas -= valores[i];
								cambio[i]++;
							}
						}

						String[] nombres = { "Billetes de 50", "Billetes de 20", "Billetes de 10", "Billetes de 5",
								"Monedas de 2", "Monedas de 1", "Monedas de 0.5", "Monedas de 0.2", "Monedas de 0.1",
								"Monedas de 0.05", "Monedas de 0.02", "Monedas de 0.01" };

						for (int i = 0; i < cambio.length; i++) {
							if (cambio[i] > 0) {
								System.out.println(cambio[i] + " " + nombres[i]);
							}
						}
					} else {
						System.out.println("No requiere cambio. Pago exacto.");
					}
				} else {
					System.out.println("Cantidad ingresada menor al importe a pagar. Ingrese cantidad valida.");
				}
			} catch (Exceptions.ImportePagoException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Valor no valido. Ingrese un numero valido.");
			}
		}

		// metodo para que elijan que tipo de pago quieren
		public void elegirpago(PasarelaDePago pago, Scanner sc) {
			System.out.println("\nForma de pagar: " + "\n1. Efectivo" + "\n2. Tarjeta" + "\n3. Pago a cuenta");
			int decision2 = sc.nextInt();

			if (decision2 == 1) {
				pago.pagoEfectivo(sc);
			} else if (decision2 == 2) {
				pago.pagoTarjeta(sc);
			} else if (decision2 == 3) {
				pago.pagoCuenta(sc);
			}
		}

		public void pagoCuenta(Scanner sc) {
			try {
				System.out.println("Seleccion de pago a cuenta");
				System.out.println("Numero de cuenta:");
				String numeroCuenta = sc.nextLine();
				numeroCuenta = sc.nextLine();

				Exceptions.validarNumeroCuenta(numeroCuenta);

				System.out.println("Numero de telefono:");
				int telefono = sc.nextInt();

				Exceptions.validarTelefono(telefono);

				System.out.println("Pago realizado. Codigo del mismo: " + generarCodigoPago());
				importe = 0;
				codigoPago = String.valueOf((new Date()).getTime());

			} catch (Exceptions.NumeroCuentaInvalidoException e) {
				System.out.println(e.getMessage());

			} catch (InputMismatchException e) {
				System.out.println("Valor no valido. Ingrese numero valido.");

			} catch (Exceptions.TelefonoInvalidoException e) {
				System.out.println(e.getMessage());
			}
		}

		private String generarCodigoPago() {
			return String.valueOf(new Date().getTime());
		}
}
