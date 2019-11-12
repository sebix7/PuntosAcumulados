package ar.edu.unlam.pb2.puntosacumulados;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.*;

public class Sistema {

	private String email;
	private String password;
	private Integer id;

	private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	private ArrayList<Compra> ventas = new ArrayList<Compra>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Encargado> encargados = new ArrayList<Encargado>();
	private ArrayList<Producto> productos = new ArrayList<Producto>();

	// Constructor default
	public Sistema() {

	}

	// Constructor
	public Sistema(String email, String password, Integer id, ArrayList<Usuario> listaUsuarios,
			ArrayList<Compra> ventas, ArrayList<Cliente> clientes, ArrayList<Encargado> encargados,
			ArrayList<Producto> productos) {
		super();
		this.email = email;
		this.password = password;
		this.id = id;
		this.listaUsuarios = listaUsuarios;
		this.ventas = ventas;
		this.clientes = clientes;
		this.encargados = encargados;
		this.productos = productos;
	}

	// REGISTRO
	public Boolean registrarCliente(Cliente cliente) throws CorreoExistenteException, UsuarioExistenteException {
		Boolean exito = false;
		if (this.listaUsuarios.size() > 0) {
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
	public Boolean eliminarUsuario(Integer id) throws IdNoValidoException {
		Boolean exito = false;
		Iterator<Usuario> it = this.listaUsuarios.iterator();
		while (it.hasNext()) {
			Usuario usuario = it.next();
			if (usuario.getId().equals(id)) {
				it.remove();
				exito = true;
			} else {
				throw new IdNoValidoException();
			}
		}
		return exito;
	}

	// INICIAR SESION
	public Boolean iniciarSesion(String email, String password) throws DatosDeUsuarioNoValidosException {
		Boolean exito = false;

		if (this.listaUsuarios.size() > 0) {
			for (Usuario usuarioIngresado : this.listaUsuarios) {
				if (usuarioIngresado.getEmail().equals(email) && usuarioIngresado.getPassword().equals(password)) {
					exito = true;
					JOptionPane.showMessageDialog(null, "Bienvenido de nuevo al sistema");
					break;
				} else {
					throw new DatosDeUsuarioNoValidosException();
				}
			}
		} else {
			throw new DatosDeUsuarioNoValidosException();
		}
		return exito;
	}

	// MENU PRINCIPAL - POR AHORA NO FUE MODIFICADO
	public Integer menuPrincipal() throws OpcionInvalidaException {
		Integer seleccion;
		seleccion = Integer.parseInt(JOptionPane.showInputDialog(
				"1. Registrarse \n2. Iniciar sesion \n3. ¿Has olvidado tu contraseña? \n4. Ver lista de clientes \n5. Salir"));
		if (seleccion >= 1 && seleccion <= 5) {
			return seleccion;
		} else {
			throw new OpcionInvalidaException();
		}
	}

	// SUBMENU - POR AHORA NO FUE MODIFICADO
	public Integer submenu() throws OpcionInvalidaException {
		Integer seleccion;
		seleccion = Integer
				.parseInt(JOptionPane.showInputDialog("¿Qué desea hacer? \n1. Darse de Baja \n2. Cerrar Sesion"));
		if (seleccion >= 1 && seleccion <= 2) {
			return seleccion;
		} else {
			throw new OpcionInvalidaException();
		}
	}

	// RECUPERAR CONTRASEÑA
	public Boolean recuperarContraseña(String nombreDeUsuario, String password)
			throws NombreDeUsuarioNoValidoException {
		Boolean exito = false;
		if (this.listaUsuarios.size() > 0) {
			for (Usuario usuario : this.listaUsuarios) {
				if (usuario.getNombreDeUsuario().equals(nombreDeUsuario)) {
					usuario.setPassword(password);
					JOptionPane.showMessageDialog(null,
							"¡Operacion exitosa! \nUsuario: " + nombreDeUsuario + " \nPassword: " + password);
					exito = true;
				} else {
					throw new NombreDeUsuarioNoValidoException();
				}
			}
		} else {
			throw new NombreDeUsuarioNoValidoException();
		}
		return exito;
	}

	// MOSTRAR LISTA DE CLIENTES
	public void mostrarClientes() {
		for (Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}
	}

	// GETTER SETTER
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

}
