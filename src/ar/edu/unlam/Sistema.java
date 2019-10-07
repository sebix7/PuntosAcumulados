package ar.edu.unlam;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class Sistema {

	private Perfumeria perfumeria;
	private Boolean sesionAbierta;

	public Sistema(Perfumeria perfumeria) {
		this.perfumeria = perfumeria;
		sesionAbierta = false;
	}

	public Perfumeria getPerfumeria() {
		return perfumeria;
	}

	public Boolean registro(Cliente nuevo) {
		Integer errorDeValidacion1 = 0;
		Integer errorDeValidacion2 = 0;
		Boolean registroExitoso = false;
		if (perfumeria.getClientes().size() == 0) {
			perfumeria.getClientes().add(nuevo);
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
			for (Cliente cliente : perfumeria.getClientes()) {
				if (cliente.getNombreDeUsuario().equals(nuevo.getNombreDeUsuario())) {
					errorDeValidacion1++;
					break;
				}
			}

			for (Cliente cliente : perfumeria.getClientes()) {
				if (cliente.getEmail().equals(nuevo.getEmail())) {
					errorDeValidacion2++;
					break;
				}
			}

			if (errorDeValidacion1 == 0 && errorDeValidacion2 == 0) {
				perfumeria.getClientes().add(nuevo);
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
		Iterator it = perfumeria.getClientes().iterator();
		while (it.hasNext()) {
			Cliente cliente = (Cliente) it.next();
			if (cliente.getEmail().equals(email)) {
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

}
