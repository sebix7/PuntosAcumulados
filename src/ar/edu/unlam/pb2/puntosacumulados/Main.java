package ar.edu.unlam.pb2.puntosacumulados;

import java.util.Scanner;

import javax.swing.JOptionPane;

import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.*;

public class Main {

	public static void main(String[] args) throws OpcionInvalidaException, UsuarioExistenteException,
			CorreoExistenteException, DatosDeUsuarioNoValidosException, NombreDeUsuarioNoValidoException,
			IdNoValidoException, SinClientesException, NullException {

		Sistema miSistema = Sistema.getInstancia();
		String nombre, apellido, nombreDeUsuario = null, email = null, password;
		Integer opcion1 = 0, opcion2 = 0;
		Boolean ingresoPermitido = false, login = false, recuperacionExitosa = false;

		Scanner teclado = new Scanner(System.in);
		do {
			try {
				opcion1 = miSistema.menuPrincipal();
			} catch (OpcionInvalidaException e2) {
				e2.printStackTrace();
			}

			switch (opcion1) {
			case 1:
				nombre = JOptionPane.showInputDialog("Ingrese su nombre");
				apellido = JOptionPane.showInputDialog("Ingrese su apellido");
				nombreDeUsuario = JOptionPane.showInputDialog("Ingrese nombre de usuario");
				email = JOptionPane.showInputDialog("Ingrese su email");
				password = JOptionPane.showInputDialog("Ingrese password");
				Cliente nuevo = new Cliente(nombre, apellido, null, nombreDeUsuario, email, password); // null es
																										// localDate
				try {
					ingresoPermitido = miSistema.registrarCliente(nuevo);
				} catch (UsuarioExistenteException e) {
					e.printStackTrace();
				} catch (CorreoExistenteException e) {
					e.printStackTrace();
				} catch (NullException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				nombreDeUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario");
				password = JOptionPane.showInputDialog("Ingrese su password");
				try {
					login = miSistema.iniciarSesion(nombreDeUsuario, password);
				} catch (DatosDeUsuarioNoValidosException e) {
					e.printStackTrace();
				}
				break;

			case 3:
				nombreDeUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario");
				password = JOptionPane.showInputDialog("Ingrese su nueva password");
				try {
					miSistema.recuperarContraseña(nombreDeUsuario, password);
				} catch (NombreDeUsuarioNoValidoException e) {
					e.printStackTrace();
				}
				break;

			case 4:
				try {
					miSistema.mostrarClientes();
				} catch (SinClientesException e) {
					e.printStackTrace();
				}
				break;

			case 5:
				login = null;
				ingresoPermitido = null;
				break;
			}

			if (ingresoPermitido == true || login == true) {
				try {
					opcion2 = miSistema.submenu();
				} catch (OpcionInvalidaException e1) {
					e1.printStackTrace();
				}
				switch (opcion2) {
				case 1:
					break;

				case 2:
					break;

				case 3:
					try {
						miSistema.eliminarUsuario(email);
					} catch (IdNoValidoException e1) {
						e1.printStackTrace();
					}
					break;

				case 4:
					ingresoPermitido = false;
					login = false;
					break;

				}
			}

		} while (opcion1 < 1 || opcion1 > 5 || opcion1 == 3 || opcion1 == 4 || opcion2 == 3 || login == false
				|| ingresoPermitido == false);
	}

}
