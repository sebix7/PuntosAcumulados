package ar.edu.unlam.pb2.puntosacumulados;

import java.util.Scanner;

import javax.swing.JOptionPane;

import org.junit.Test;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.*;

public class Main {

	public static void main(String[] args) throws OpcionInvalidaException, UsuarioExistenteException,
			CorreoExistenteException, DatosDeUsuarioNoValidosException, NombreDeUsuarioNoValidoException,
			IdNoValidoException, SinClientesException, NullException {

		Local miLocal = new Local();
		Sistema miSistema = new Sistema(miLocal);
		String nombre, apellido, nombreDeUsuario, email, password, email1 = " ", password1 = " ";
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
				email = JOptionPane.showInputDialog("Ingrese su email");
				password = JOptionPane.showInputDialog("Ingrese su password");
				try {
					login = miSistema.iniciarSesion(email1, password1);
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
					try {
						miSistema.eliminarUsuario(1);
					} catch (IdNoValidoException e1) {
						e1.printStackTrace();
					}
					break;
				case 2:
					ingresoPermitido = false;
					break;
				}
			}

		} while (opcion1 < 1 || opcion1 > 5 || opcion1 == 3 || opcion1 == 4 || opcion2 == 2 || login == false
				|| ingresoPermitido == false);
	}

}
