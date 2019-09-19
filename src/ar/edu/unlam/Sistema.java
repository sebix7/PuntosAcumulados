package ar.edu.unlam;

public class Sistema {

	private ListaUsuarios usuarios;
	private ListaProductos productos;
	private Boolean sesionAbierta;

	public Sistema() {
		usuarios = new ListaUsuarios();
		productos = new ListaProductos();
		sesionAbierta = false;
	}

	public void registro(Usuario usuario) {
		usuarios.agregarUsuario(usuario);
		System.out.println("¡Bienvenido!");
	}

	public void darseDeBaja(Usuario usuario) {
		usuarios.eliminarUsuario(usuario);
		System.out.println("Bye, bye!");
	}

	public void iniciarSesion(String email, String password) {
		for (int i = 0; i < usuarios.getLista().length; i++) {
			if (usuarios.getLista()[i].getEmail() == email && usuarios.getLista()[i].getPassword() == password) {
				System.out.println("Sesión Iniciada");
				sesionAbierta = true;
				break;
			}
		}
	}

	public void cerrarSesion() {
		System.out.println("Sesión Cerrada");
		sesionAbierta = false;
	}

	public void menuPrincipal() {
		System.out.println("1. Registrarse");
		System.out.println("2. Iniciar sesion");
	}

	public void menuInterno() {
		System.out.println("¿Qué desea hacer?");
		System.out.println("1. Darse de Baja");
		System.out.println("2. Cerrar Sesion");
	}

}
