package ar.edu.unlam.pb2.puntosacumulados;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class Sistema {

	private Local local;
	private Boolean sesionAbierta;
	private Boolean menuPrincipalDisponible;

	public Sistema(Local local) {
		this.local = local;
		this.sesionAbierta = false;
	}

	public Boolean registro(Cliente nuevo)
			throws UsuarioExistenteException, CorreoExistenteException, SesionAbiertaException {
		Boolean registroExitoso = false;
		if (this.sesionAbierta == false) {
			Integer errorDeValidacion1 = 0;
			Integer errorDeValidacion2 = 0;
			if (local.getClientes().size() == 0) {
				local.getClientes().add(nuevo);
				JOptionPane.showMessageDialog(null, "Se ha registrado satisfactoriamente");
				registroExitoso = true;
				this.sesionAbierta = true;
			} else {
				/*
				 * for (Cliente cliente : perfumeria.getClientes()) { if
				 * (cliente.getNombreDeUsuario().equals(nuevo.getNombreDeUsuario())) {
				 * System.out.println("Nombre de usuario ya existente");
				 * 
				 * } else { if (cliente.getEmail().equals(nuevo.getEmail())) {
				 * System.out.println("Ya existe un usuario para ese correo"); } else {
				 * perfumeria.getClientes().add(nuevo); System.out.println("¡Bienvenido!");
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
					this.sesionAbierta = true;
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
		} else {
			throw new SesionAbiertaException();
		}
		return registroExitoso;
	}

	public void darseDeBaja(String email) throws SesionCerradaException {
		if (this.sesionAbierta == true) {
			Iterator it = local.getClientes().iterator();
			while (it.hasNext()) {
				Cliente cliente = (Cliente) it.next();
				if (cliente.getUsuarioCliente().getEmail().equals(email)) {
					it.remove();
				}
			}
		} else {
			throw new SesionCerradaException();
		}
	}

	public Boolean iniciarSesion(String email, String password)
			throws DatosDeUsuarioNoValidosException, SesionAbiertaException {
		if (this.sesionAbierta == false) {
			if (local.getClientes().size() > 0) {
				for (Cliente cliente : local.getClientes()) {
					if (cliente.getUsuarioCliente().getEmail().equals(email)
							&& cliente.getUsuarioCliente().getPassword().equals(password)) {
						this.sesionAbierta = true;
						JOptionPane.showMessageDialog(null, "Bienvenido de nuevo al sistema");
						break;
					}
				}
			} else {
				if (local.getClientes().size() == 0) {
					throw new DatosDeUsuarioNoValidosException();
				}
			}
		} else {
			throw new SesionAbiertaException();
		}
		return this.sesionAbierta;
	}

	public Boolean cerrarSesion() throws SesionCerradaException {
		if (this.sesionAbierta == true) {
			JOptionPane.showMessageDialog(null, "Sesión Cerrada");
			return this.sesionAbierta = false;
		} else {
			throw new SesionCerradaException();
		}
	}

	public Integer menuPrincipal() throws OpcionInvalidaException, SesionAbiertaException {
		if (this.sesionAbierta == false) {
			Integer seleccion;
			seleccion = Integer.parseInt(JOptionPane.showInputDialog(
					"1. Registrarse \n2. Iniciar sesion \n3. ¿Has olvidado tu contraseña? \n4. Ver lista de clientes \n5. Salir"));
			if (seleccion >= 1 && seleccion <= 5) {
				return seleccion;
			} else {
				throw new OpcionInvalidaException();
			}
		} else {
			throw new SesionAbiertaException();
		}
	}

	public Integer submenu() throws OpcionInvalidaException, SesionCerradaException {
		if (this.sesionAbierta == true) {
			Integer seleccion;
			seleccion = Integer
					.parseInt(JOptionPane.showInputDialog("¿Qué desea hacer? \n1. Darse de Baja \n2. Cerrar Sesion"));
			if (seleccion >= 1 && seleccion <= 2) {
				return seleccion;
			} else {
				throw new OpcionInvalidaException();
			}
		} else {
			throw new SesionCerradaException();
		}
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
