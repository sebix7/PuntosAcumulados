package ar.edu.unlam;

import java.util.Scanner;

import org.junit.Test;

public class Main {

	public static void main(String[] args) {

		Perfumeria miP = new Perfumeria();
		Sistema miS = new Sistema(miP);
		String nombre, apellido, nombreDeUsuario, email, password;
		Integer opcion1, opcion2 = 0;
		Boolean ingresoPermitido = false;

		Scanner teclado = new Scanner(System.in);
		do {
			miS.menuPrincipal();
			opcion1 = teclado.nextInt();
			switch (opcion1) {
			case 1:
				do {
					System.out.println("Ingrese su nombre");
					nombre = teclado.next();
					System.out.println("Ingrese su apellido");
					apellido = teclado.next();
					System.out.println("Ingrese su nombre de usuario");
					nombreDeUsuario = teclado.next();
					System.out.println("Ingrese su email");
					email = teclado.next();
					System.out.println("Ingrese su password");
					password = teclado.next();
					Cliente nuevo = new Cliente(nombre, apellido, nombreDeUsuario, email, password);
					ingresoPermitido = miS.registro(nuevo);
				} while (ingresoPermitido == false);
				miS.menuInterno();
				opcion2 = teclado.nextInt();
				switch (opcion2) {
				case 1:
					miS.darseDeBaja(email);
					break;
				case 2:
					miS.cerrarSesion();
					System.out.println("");
					ingresoPermitido = false;
					break;
				}
				break;
			case 2:
				System.out.println("Ingrese su email");
				email = teclado.next();
				System.out.println("Ingrese su password");
				password = teclado.next();
				ingresoPermitido = miS.iniciarSesion(email, password); // El metodo iniciarSesion tiene que devolver un true
				break;
			case 3:

				break;
			case 4:
				System.out.println("Cantidad de clientes registrados: " + miS.getPerfumeria().getClientes().size());
				System.out.println(miS.getPerfumeria().mostrarListaDeClientes());
				break;
			}
		} while (opcion1 == 4 || opcion2 == 1 || opcion2 == 2);

	}

}
