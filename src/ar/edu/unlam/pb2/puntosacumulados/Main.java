package ar.edu.unlam.pb2.puntosacumulados;

import javax.swing.JOptionPane;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.*;

public class Main {

	public static void main(String[] args) {

		Sistema miSistema = Sistema.getInstancia();
		String nombre = null, apellido = null, nombreDeUsuario = null, email = null, password = null;
		Integer opcion1 = 0, opcion2 = 0;
		Boolean ingresoPermitido = false, login = false, salir = false;
		Double saldo = 0.0;
		Integer puntos = 0;
		Cliente nuevoCliente = new Cliente(nombre, apellido, null, nombreDeUsuario, email, password, saldo, puntos);

		do {
			try {
				opcion1 = miSistema.menuPrincipal();
			} catch (OpcionInvalidaException e2) {
				e2.printStackTrace();
			}

			switch (opcion1) {
			// REGISTRARSE
			case 1:
				nuevoCliente.setNombre(JOptionPane.showInputDialog("Ingrese su nombre"));
				nuevoCliente.setApellido(JOptionPane.showInputDialog("Ingrese su apellido"));
				nuevoCliente.getUsuarioCliente()
						.setNombreDeUsuario(JOptionPane.showInputDialog("Ingrese nombre de usuario"));
				nuevoCliente.getUsuarioCliente().setEmail(JOptionPane.showInputDialog("Ingrese su email"));
				nuevoCliente.getUsuarioCliente().setPassword(JOptionPane.showInputDialog("Ingrese password"));
				nuevoCliente.getUsuarioCliente()
						.setSaldo((double) Integer.parseInt(JOptionPane.showInputDialog("Ingrese saldo")));
				nuevoCliente.setPuntos(Integer.parseInt(JOptionPane.showInputDialog("Ingrese puntos")));

				try {
					ingresoPermitido = miSistema.registrarCliente(nuevoCliente);
				} catch (UsuarioExistenteException e) {
					e.printStackTrace();
				} catch (CorreoExistenteException e) {
					e.printStackTrace();
				} catch (NullException e) {
					e.printStackTrace();
				}
				break;
			// INICIAR SESION
			case 2:
				nombreDeUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario");
				password = JOptionPane.showInputDialog("Ingrese su password");
				try {
					login = miSistema.iniciarSesion(nombreDeUsuario, password);
				} catch (DatosDeUsuarioNoValidosException e) {
					e.printStackTrace();
				}
				break;
			// OLVIDO CONTRASEŅA
			case 3:
				nombreDeUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario");
				password = JOptionPane.showInputDialog("Ingrese su nueva password");
				try {
					miSistema.recuperarContraseņa(nombreDeUsuario, password);
				} catch (NombreDeUsuarioNoValidoException e) {
					e.printStackTrace();
				}
				break;

			case 4:
				login = null;
				ingresoPermitido = null;
				break;
			}

			if (ingresoPermitido == true || login == true) {
				do {
					try {
						opcion2 = miSistema.submenu();
					} catch (OpcionInvalidaException e1) {
						e1.printStackTrace();
					}
					switch (opcion2) {
					case 1:
						try {
							salir = miSistema.comprar(nuevoCliente);
						} catch (OpcionInvalidaException e) {
							e.printStackTrace();
						} catch (SaldoInsuficienteException e) {
							e.printStackTrace();
						} catch (NombreDeUsuarioNoValidoException e) {
							e.printStackTrace();
						}
						break;

					case 2:
						miSistema.verPerfilUsuario(nuevoCliente);
						break;

					case 3:
						miSistema.eliminarUsuario(email);
						break;

					case 4:
						ingresoPermitido = false;
						login = false;
						salir = false;
						break;

					}
				} while (opcion2 == 2 || opcion2 == 1 || salir == true);
			}

		} while (opcion1 < 1 || opcion1 > 4 || opcion1 == 3 || opcion1 == 4 || opcion2 == 3 || opcion2 == 4
				|| login == false || ingresoPermitido == false);
	}

}
