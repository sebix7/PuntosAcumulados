package ar.edu.unlam;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Sistema miS = new Sistema();
		String nombre, apellido, email, password;
		Integer opcion1, opcion2 = 0;

		Scanner teclado = new Scanner(System.in);

		do {
			miS.menuPrincipal();
			opcion1 = teclado.nextInt();
			switch (opcion1) {
			case 1:
				System.out.println("Ingrese su nombre");
				nombre = teclado.next();
				System.out.println("Ingrese su apellido");
				apellido = teclado.next();
				System.out.println("Ingrese su email");
				email = teclado.next();
				System.out.println("Ingrese su password");
				password = teclado.next();
				Usuario nuevo = new Usuario(nombre, apellido, email, password);
				miS.registro(nuevo);
				miS.menuInterno();
				opcion2 = teclado.nextInt();
				switch (opcion2) {
				case 1:

				case 2:
					miS.cerrarSesion();
					System.out.println("");
					break;
				}
				break;
			case 2:
				System.out.println("Ingrese su email");
				email = teclado.next();
				System.out.println("Ingrese su password");
				password = teclado.next();
				miS.iniciarSesion(email, password);
			}
		} while (opcion2 == 2);
	}

}
