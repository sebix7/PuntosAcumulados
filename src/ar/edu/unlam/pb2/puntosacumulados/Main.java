package ar.edu.unlam.pb2.puntosacumulados;

import javax.swing.JOptionPane;


import ar.edu.unlam.pb2.puntosacumulados.excepciones.*;

public class Main {

	public static void main(String[] args) throws OpcionInvalidaException, UsuarioExistenteException,
			CorreoExistenteException, DatosDeUsuarioNoValidosException, NombreDeUsuarioNoValidoException,
			IdNoValidoException, SinClientesException, NullException, SaldoInsuficienteException {

		Sistema miSistema = Sistema.getInstancia();
		String nombre = null, apellido = null, nombreDeUsuario = null, email = null, password = null;
		Integer opcion1 = 0, opcion2 = 0;
		Boolean ingresoPermitido = false, login = false, recuperacionExitosa = false;
		Double saldo = 0.0;
		Cliente nuevoCliente = new Cliente(nombre, apellido, null, nombreDeUsuario, email, password, saldo);
		Producto nuevoProducto = new Producto(101, "descripcion", 100.0);
		// Cliente nuevoCliente = new Cliente(nombre, apellido, null, nombreDeUsuario,
		// email, password, saldo); // null es
		// localDate
		
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
				nuevoCliente.getUsuarioCliente().setNombreDeUsuario(JOptionPane.showInputDialog("Ingrese nombre de usuario"));
				nuevoCliente.getUsuarioCliente().setEmail(JOptionPane.showInputDialog("Ingrese su email"));
				nuevoCliente.getUsuarioCliente().setPassword(JOptionPane.showInputDialog("Ingrese password"));
				
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
			// OLVIDO CONTRASEÑA
			case 3:
				nombreDeUsuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario");
				password = JOptionPane.showInputDialog("Ingrese su nueva password");
				try {
					miSistema.recuperarContraseña(nombreDeUsuario, password);
				} catch (NombreDeUsuarioNoValidoException e) {
					e.printStackTrace();
				}
				break;
			// MOSTRAR LISTA CLIENTES
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
					miSistema.nuevaCompra(nuevoCliente.getUsuarioCliente(), nuevoProducto,1 );
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
					break;

				}
			}

		} while (opcion1 < 1 || opcion1 > 5 || opcion1 == 3 || opcion1 == 4 || opcion2 == 3 || login == false
				|| ingresoPermitido == false);
	}

}
