package ar.edu.unlam.pb2.puntosacumulados;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class Sistema {

	private Local local;
	private Boolean sesionAbierta;

	public Sistema(Local local) {
		this.local = local;
		sesionAbierta = false;
	}

	public Boolean registro(Cliente nuevo) throws UsuarioExistenteException, CorreoExistenteException {
		Integer errorDeValidacion1 = 0;
		Integer errorDeValidacion2 = 0;
		Boolean registroExitoso = false;
		if (local.getClientes().size() == 0) {
			local.getClientes().add(nuevo);
			JOptionPane.showMessageDialog(null, "Se ha registrado satisfactoriamente");
			registroExitoso = true;
		} else {
			/*
			 * for (Cliente cliente : perfumeria.getClientes()) { if
			 * (cliente.getNombreDeUsuario().equals(nuevo.getNombreDeUsuario())) {
			 * System.out.println("Nombre de usuario ya existente");
			 * 
			 * } else { if (cliente.getEmail().equals(nuevo.getEmail())) {
			 * System.out.println("Ya existe un usuario para ese correo"); } else {
			 * perfumeria.getClientes().add(nuevo); System.out.println("�Bienvenido!");
			 * registroExitoso = true; } } }
			 */
			for (Cliente cliente : local.getClientes()) {
				if (cliente.getUsuarioCliente().getNombreDeUsuario()
						.equals(nuevo.getUsuarioCliente().getNombreDeUsuario())) {
					errorDeValidacion1++;
					break;
				}
			}

			for (Cliente cliente : local.getClientes()) {
				if (cliente.getUsuarioCliente().getEmail().equals(nuevo.getUsuarioCliente().getEmail())) {
					errorDeValidacion2++;
					break;
				}
			}

			if (errorDeValidacion1 == 0 && errorDeValidacion2 == 0) {
				local.getClientes().add(nuevo);
				JOptionPane.showMessageDialog(null, "Se ha registrado satisfactoriamente");
				registroExitoso = true;
			} else {
				if (errorDeValidacion1 == 1) {
					throw new UsuarioExistenteException();
				} else {
					if (errorDeValidacion2 == 1) {
						throw new CorreoExistenteException();
					}
				}
			}

		}
		return registroExitoso;
	}

	public void darseDeBaja(String email) {
		Iterator it = local.getClientes().iterator();
		while (it.hasNext()) {
			Cliente cliente = (Cliente) it.next();
			if (cliente.getUsuarioCliente().getEmail().equals(email)) {
				it.remove();
			}
		}
	}

	public Boolean iniciarSesion(String email, String password) throws DatosDeUsuarioInexistenteException {
		if (local.getClientes().size()>0) {
			for (Cliente cliente : local.getClientes()) {
				if (cliente.getUsuarioCliente().getEmail().equals(email) && cliente.getUsuarioCliente().getPassword().equals(password)) {
					sesionAbierta = true;
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
					break;
				}
			}
		}
		
		if (local.getClientes().size()==0 || sesionAbierta==false) {
			throw new DatosDeUsuarioInexistenteException();
		}
		
		return sesionAbierta;
	}

	public Boolean cerrarSesion() {
		JOptionPane.showMessageDialog(null, "Sesi�n Cerrada");
		return sesionAbierta = false;
	}

	public Integer menuPrincipal() throws OpcionMenuPrincipalInvalidaException {
		Integer seleccion;
		seleccion = Integer.parseInt(JOptionPane.showInputDialog(
				"1. Registrarse \n2. Iniciar sesion \n3. �Has olvidado tu contrase�a? \n4. Ver lista de clientes \n5. Salir"));
		if (seleccion >= 1 && seleccion <= 5) {
			return seleccion;
		} else {
			throw new OpcionMenuPrincipalInvalidaException();
		}
	}

	public Integer menuInterno() {
		Integer seleccion;
		seleccion = Integer
				.parseInt(JOptionPane.showInputDialog("�Qu� desea hacer? \n1. Darse de Baja \n2. Cerrar Sesion"));
		return seleccion;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Boolean getSesionAbierta() {
		return sesionAbierta;
	}

	public void setSesionAbierta(Boolean sesionAbierta) {
		this.sesionAbierta = sesionAbierta;
	}

}
