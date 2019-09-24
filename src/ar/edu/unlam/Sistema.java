package ar.edu.unlam;

import java.util.Iterator;

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
			System.out.println("¡Bienvenido!");
			registroExitoso = true;
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
				System.out.println("¡Bienvenido!");
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

	public Boolean iniciarSesion(String email, String password) {
		for (Cliente cliente : perfumeria.getClientes()) {
			if (cliente.getEmail().equals(email) && cliente.getPassword().equals(password)) {
				sesionAbierta = true;
				break;
			}
		}

		if (sesionAbierta == true) {
			System.out.println("Inicio de sesion exitoso");
		} else {
			System.out.println("Datos no validos");
		}

		return sesionAbierta;
	}

	public void cerrarSesion() {
		System.out.println("Sesión Cerrada");
		sesionAbierta = false;
	}

	public void menuPrincipal() {
		System.out.println("1. Registrarse");
		System.out.println("2. Iniciar sesion");
		System.out.println("3. ¿Has olvidado tu contraseña?");
		System.out.println("4. Ver lista de clientes");
	}

	public void menuSecundario() {
		System.out.println("¿Qué desea hacer?");
		System.out.println("1. Darse de Baja");
		System.out.println("2. Cerrar Sesion");
	}

}
