/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp3_s7_grupo20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exp3_S7_Grupo20 {

	static String nombreTeatro = "Teatro Moro";
	static int anioBoleta = 2024;

	static int valorGeneral = 5000;
	static int valorVIP = 7000;
	static int valorPlatea = 6000;
	static Scanner scanner = new Scanner(System.in);

	// Clase para grabar datos de boleta e imprimir el resultado en pantalla.
	public static class Boleta {

		int precio;
		String tipoEntrada;
		int cantidad;
		String descuentoAplicado;
		double precioFinalEntrada;

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}

		public String getTipoEntrada() {
			return tipoEntrada;
		}

		public void setTipoEntrada(String tipoEntrada) {
			this.tipoEntrada = tipoEntrada;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public String getDescuentoAplicado() {
			return descuentoAplicado;
		}

		public void setDescuentoAplicado(String descuentoAplicado) {
			this.descuentoAplicado = descuentoAplicado;
		}

		public double getPrecioFinalEntrada() {
			return precioFinalEntrada;
		}

		public void setPrecioFinalEntrada(double precioFinalEntrada) {
			this.precioFinalEntrada = precioFinalEntrada;
		}

	};

	private static Boleta calcularPrecioEntrada(String opcionTipoEntrada, Boleta boleta) {

		// Capturar por pantalla el tipo Cliente
		System.out.print("****************************************\n");
		System.out.print("Tipos de clientes disponibles\n ");
		System.out.print("1 : ESTUDIANTE\n ");
		System.out.print("2 : GENERAL\n ");
		System.out.print("3 : TERCERA EDAD\n ");
		System.out.print("****************************************\n");
		System.out.print("Ingrese el tipo de cliente: ");

		String opcionTipoCliente = scanner.nextLine();

		if (opcionTipoEntrada.equals("1")) {
			boleta.setTipoEntrada("General");
			boleta.setPrecio(valorGeneral);

			boleta = calcularPrecioFinal(valorGeneral, opcionTipoCliente, boleta);

		} else if (opcionTipoEntrada.equals("2")) {
			boleta.setTipoEntrada("VIP");
			boleta.setPrecio(valorVIP);

			boleta = calcularPrecioFinal(valorVIP, opcionTipoCliente, boleta);

		} else if (opcionTipoEntrada.equals("3")) {
			boleta.setTipoEntrada("Platea");
			boleta.setPrecio(valorPlatea);
			boleta = calcularPrecioFinal(valorPlatea, opcionTipoCliente, boleta);
		}

		return boleta;

	}

	private static Boleta calcularPrecioFinal(int valorTipoEntrada, String opcionTipoCliente, Boleta boleta) {
		double valorFinalEntrada = 0.0;

		if (opcionTipoCliente.equals("1")) {

			valorFinalEntrada = valorTipoEntrada * 0.90;
			boleta.setDescuentoAplicado("10%");

		} else if (opcionTipoCliente.equals("2")) {
			boleta.setDescuentoAplicado("0%");
			valorFinalEntrada = valorTipoEntrada;

		} else if (opcionTipoCliente.equals("3")) {
			boleta.setDescuentoAplicado("15%");
			valorFinalEntrada = valorTipoEntrada * 0.85;
		}

		System.out.println("Valor final de la entrada: " + valorFinalEntrada);
		boleta.setPrecioFinalEntrada(valorFinalEntrada);
		return boleta;
	}

	private static String menu() {
		String opcion;
		System.out.print("****************************************\n");
		System.out.println("Ingrese su opcion del menu:\n");
		opcion = scanner.nextLine();

		return opcion;

	}

	private static boolean salir() {
		System.out.print("****************************************\n");
		System.out.println("Gracias por  asistir a  " + nombreTeatro);
		System.out.print("****************************************\n");
		System.exit(0);
		return true;
	}

	private static Boleta comprarEntradas(int entradasDisponibles, Boleta boleta) {

		String opcionTipoEntrada = null;

		if (entradasDisponibles != 0) {
			System.out.print("****************************************\n");
			System.out.print("Tipos de entradas disponibles\n ");
			System.out.print("1 : GENERAL\n ");
			System.out.print("2 : VIP\n ");
			System.out.print("3 : PLATEA \n ");
			System.out.print("****************************************\n");
			// capturar por pantalla el tipo de entrada
			System.out.print("Ingrese el tipo de entrada ");
			opcionTipoEntrada = scanner.nextLine();
			System.out.println("opcion de entrada--> " + opcionTipoEntrada);

			boleta = calcularPrecioEntrada(opcionTipoEntrada, boleta);

			entradasDisponibles--;

			// Imprime Boleta
			System.out.print("---------------------------------------\n");
			System.out.print("Ubicacion          : " + boleta.getTipoEntrada() + "\n");
			System.out.print("Costo Base         : " + boleta.getPrecio() + "\n");
			System.out.print("Descuento Aplicado : " + boleta.getDescuentoAplicado() + "\n");
			System.out.print("Costo Final        : " + boleta.getPrecioFinalEntrada() + "\n");
			System.out.print("---------------------------------------\n");
			System.out.print("Gracias por su visita al Teatro Moro\n");
			System.out.print("---------------------------------------\n");

		} else {
			System.out.println("No hay entradas disponibles");
		}
		return boleta;
	}

	public static void main(String[] args) {
	
		int entradasDisponibles = 1;

		List<Boleta> listaBoletas = new ArrayList();

		boolean salir = false;

		while (!salir) {
			Boleta boleta = new Boleta();

			System.out.print("****************************************\n");
			System.out.println("Bienvenido a " + nombreTeatro);
			System.out.print("****************************************\n");
			System.out.println("");
			System.out.println("(1) Comprar entradas ");
			System.out.println("(2) Ver entradas vendidas ");
			System.out.println("(3) Salir");
			System.out.print("****************************************\n");
			System.out.print("****************************************\n");

			String opcion = menu();

			switch (opcion) {
				case "1":
					System.out.print("opcion 1\n");
					boleta = comprarEntradas(entradasDisponibles, boleta);
					listaBoletas.add(boleta);
					break;

				case "2":
					System.out.print("opcion 2\n");
					obtenerEntradasVendidas(listaBoletas);
					break;

				case "3":
					System.out.print("opcion 3\n");
					salir = salir();
					break;
				default:
					System.out.print("Ingrese una opcion\n");
			}
		}

	}

	private static void obtenerEntradasVendidas(List<Boleta> listaBoletas) {
		int i;
		if (listaBoletas.isEmpty()) {
			System.out.println("");
			System.out.println("No se han vendido boletas.");
			System.out.println("");
		} else {

			for (i = 0; i != listaBoletas.size(); i++) {

				Boleta boleta = listaBoletas.get(i);

				if (boleta != null) {
					System.out.print("---------------------------------------\n");
					System.out.print("Ubicacion          : " + boleta.getTipoEntrada() + "\n");
					System.out.print("Costo Base         : " + boleta.getPrecio() + "\n");
					System.out.print("Descuento Aplicado : " + boleta.getDescuentoAplicado() + "\n");
					System.out.print("Costo Final        : " + boleta.getPrecioFinalEntrada() + "\n");
					System.out.print("---------------------------------------\n");

				} else {

					System.out.println("Error al desplegar boletas");
				}

			}
			System.out.println("Cantidad de entradas vendidas: " + listaBoletas.size());

		}
	}
}
