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

	public Boolean registro(Cliente nuevo) {
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
				if (cliente.getUsuarioCliente().getEmail().equals(nuevo.getUsuarioCliente().getEmail())) {
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
				System.out.println("�Bienvenido!");
				registroExitoso = true;
			} else {
				if (errorDeValidacion1 == 1) {
					System.out.println("Nombre de usuario ya existente");
				} else {
					if (errorDeValidacion2 == 1) {
						System.out.println("Ya existe un usuario para ese correo");
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

	public void iniciarSesion(String email, String password) {
		/*
		 * Iterator it = perfumeria.getClientes().iterator(); while (it.hasNext()) {
		 * Cliente cliente = (Cliente) it.next(); if (cliente.getEmail().equals(email)
		 * && cliente.getPassword().equals(password)) { sesionAbierta = true; } }
		 */
	}

	public void cerrarSesion() {
		JOptionPane.showMessageDialog(null, "Sesi�n Cerrada");
		sesionAbierta = false;
	}

	public Integer menuPrincipal() {
		Integer seleccion;
		seleccion = Integer.parseInt(JOptionPane.showInputDialog("1. Registrarse \n2. Iniciar sesion \n3. �Has olvidado tu contrase�a? \n4. Ver lista de clientes "));
		return seleccion;
	}

	public Integer menuInterno() {
		Integer seleccion;
		seleccion = Integer.parseInt(JOptionPane.showInputDialog("�Qu� desea hacer? \n1. Darse de Baja \n2. Cerrar Sesion"));
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
