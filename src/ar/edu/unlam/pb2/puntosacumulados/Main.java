package ar.edu.unlam.pb2.puntosacumulados;

import java.util.Scanner;

import javax.swing.JOptionPane;

import org.junit.Test;

public class Main {

	public static void main(String[] args) {

		Local miPrograma = new Local();
		Sistema miSistema = new Sistema(miPrograma);
		String nombre, apellido, nombreDeUsuario, email, password;
		Integer opcion1 = 0, opcion2 = 0;
		Boolean ingresoPermitido = false;

		Scanner teclado = new Scanner(System.in);
		do {
			try {
				opcion1 = miSistema.menuPrincipal();
			} catch (OpcionInvalidaException e) {
				e.printStackTrace();
			}

			switch (opcion1) {
			case 1:
				do {
					nombre = JOptionPane.showInputDialog("Ingrese su nombre");
					apellido = JOptionPane.showInputDialog("Ingrese su apellido");
					nombreDeUsuario = JOptionPane.showInputDialog("Ingrese nombre de usuario");
					email = JOptionPane.showInputDialog("Ingrese su email");
					password = JOptionPane.showInputDialog("Ingrese password");
					Cliente nuevo = new Cliente(nombre, apellido, null, nombreDeUsuario, email, password); // null es localDate
					try {
						ingresoPermitido = miSistema.registro(nuevo);
					} catch (UsuarioExistenteException e) {
						e.printStackTrace();
					} catch (CorreoExistenteException e) {
						e.printStackTrace();
					}
				} while (ingresoPermitido == false);

				try {
					opcion2 = miSistema.submenu();
				} catch (OpcionInvalidaException e1) {
					e1.printStackTrace();
				}
				switch (opcion2) {
				case 1:
					miSistema.darseDeBaja(email);
					break;
				case 2:
					miSistema.cerrarSesion();
					System.out.println("");
					ingresoPermitido = false;
					break;
				}
				break;
			case 2:
				Boolean aux = true;
				do {
				email = JOptionPane.showInputDialog("Ingrese su email");
				password = JOptionPane.showInputDialog("Ingrese su password");
				try {
					aux = miSistema.iniciarSesion(email, password);
				} catch (DatosDeUsuarioNoValidosException e) {
					e.printStackTrace();
				}
				} while (aux == false);
				break;
			case 3:

				break;
			case 4:
				System.out.println("Cantidad de clientes registrados: " + miSistema.getLocal().getClientes().size());
				System.out.println(miSistema.getLocal().mostrarListaDeClientes());
				break;
			}
		} while (opcion1 == 4 || opcion2 == 1 || opcion2 == 2 || opcion1 < 1 || opcion1 > 5);

	}

}
