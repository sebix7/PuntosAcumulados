package ar.edu.unlam.pb2.puntosacumulados;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.*;

public class Sistema {

	private static Sistema instancia;
	private Usuario usuarioLogueado;

	private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	private ArrayList<Compra> ventas = new ArrayList<Compra>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Encargado> encargados = new ArrayList<Encargado>();
	private ArrayList<Producto> productos = new ArrayList<Producto>();

	// Constructor default
	public Sistema() {
	}

	// REGISTRO
	public Boolean registrarCliente(Cliente cliente)
			throws CorreoExistenteException, UsuarioExistenteException, NullException {
		Boolean exito = false;
		if (cliente.getApellido() == null || cliente.getNombre() == null
				|| cliente.getUsuarioCliente().getEmail() == null || cliente.getUsuarioCliente().getPassword() == null
				|| cliente.getUsuarioCliente().getNombreDeUsuario() == null) {
			throw new NullException();
		} else if (this.listaUsuarios.size() > 0) {
			for (Usuario usuarioEncontrado : this.listaUsuarios) {
				if (usuarioEncontrado.getEmail().equals(cliente.getUsuarioCliente().getEmail())) {
					throw new CorreoExistenteException();
				} else if (usuarioEncontrado.getNombreDeUsuario()
						.equals(cliente.getUsuarioCliente().getNombreDeUsuario())) {
					throw new UsuarioExistenteException();
				} else {
					this.clientes.add(cliente);
					this.listaUsuarios.add(cliente.getUsuarioCliente());
					exito = true;
					break;
				}
			}
		} else {
			this.clientes.add(cliente);
			this.listaUsuarios.add(cliente.getUsuarioCliente());
			exito = true;
		}
		return exito;
	}

	// ELIMINAR USUARIO
	public Boolean eliminarUsuario(String email) throws IdNoValidoException {
		Boolean exito = false;
		Iterator<Cliente> it = this.clientes.iterator();
		while (it.hasNext()) {
			Cliente cliente = it.next();
			if (cliente.getUsuarioCliente().getEmail().equals(email)) {
				it.remove();
				exito = true;
			} else {
				throw new IdNoValidoException();
			}
		}
		return exito;
	}

	// INICIAR SESION
	public Boolean iniciarSesion(String nombreDeUsuario, String password) throws DatosDeUsuarioNoValidosException {
		Boolean exito = false;
		if (this.listaUsuarios.size() > 0) {
			for (Usuario usuarioIngresado : this.listaUsuarios) {
				if (usuarioIngresado.getNombreDeUsuario().equals(nombreDeUsuario)
						&& usuarioIngresado.getPassword().equals(password)) {
					exito = true;
					JOptionPane.showMessageDialog(null, "Bienvenido de nuevo al sistema");
					break;
				}
			}
		}
		
		if (exito == false) {
			throw new DatosDeUsuarioNoValidosException();
		}
		return exito;
	}

	// MENU PRINCIPAL - POR AHORA NO FUE MODIFICADO
	public Integer menuPrincipal() throws OpcionInvalidaException {
		Integer seleccion;
		seleccion = Integer.parseInt(JOptionPane.showInputDialog(
				"1. Registrarse \n2. Iniciar sesion \n3. �Has olvidado tu contrase�a? \n4. Ver lista de clientes \n5. Salir"));
		if (seleccion >= 1 && seleccion <= 5) {
			return seleccion;
		} else {
			throw new OpcionInvalidaException();
		}
	}

	// SUBMENU - POR AHORA NO FUE MODIFICADO
	public Integer submenu() throws OpcionInvalidaException {
		Integer seleccion;
		seleccion = Integer.parseInt(JOptionPane.showInputDialog(
				"�Qu� desea hacer? \n1. Realizar una compra \n2. Ver Perfil \n3. Darse de Baja \n4. Cerrar Sesion"));
		if (seleccion >= 1 && seleccion <= 4) {
			return seleccion;
		} else {
			throw new OpcionInvalidaException();
		}
	}

	// RECUPERAR CONTRASE�A
	public Boolean recuperarContrase�a(String nombreDeUsuario, String password)
			throws NombreDeUsuarioNoValidoException {
		Boolean exito = false;
		if (this.listaUsuarios.size() > 0) {
			for (Usuario usuario : this.listaUsuarios) {
				if (usuario.getNombreDeUsuario().equals(nombreDeUsuario)) {
					usuario.setPassword(password);
					JOptionPane.showMessageDialog(null,
							"�Operacion exitosa! \nUsuario: " + nombreDeUsuario + " \nPassword: " + password);
					exito = true;
				}
			}
		}

		if (exito == false) {
			throw new NombreDeUsuarioNoValidoException();
		}
		return exito;
	}

	// MOSTRAR LISTA DE CLIENTES
	public void mostrarClientes() throws SinClientesException {
		if (clientes.size() > 0) {
			for (Cliente cliente : clientes) {
				System.out.println(cliente.toString());
			}
		} else {
			throw new SinClientesException();
		}
	}

	// GETTER SETTER

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public ArrayList<Compra> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Compra> ventas) {
		this.ventas = ventas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Encargado> getEncargados() {
		return encargados;
	}

	public void setEncargados(ArrayList<Encargado> encargados) {
		this.encargados = encargados;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	

	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}

}
