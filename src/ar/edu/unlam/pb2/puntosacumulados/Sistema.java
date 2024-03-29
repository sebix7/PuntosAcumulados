package ar.edu.unlam.pb2.puntosacumulados;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import ar.edu.unlam.pb2.puntosacumulados.excepciones.*;

public class Sistema {

	private static Local local;
	private static Sistema instancia;
	private Usuario usuarioLogueado;
	private Compra compra;
	private static Producto producto;
	private Cliente cliente;
	private List<Usuario> listaUsuarios = new ArrayList<>();
	private List<Compra> compras = new ArrayList<Compra>();
	private Set<Cliente> clientes = new HashSet<Cliente>();
	private List<Producto> productos = new ArrayList<Producto>();
	private List<Integer> numeroCompra = new LinkedList<Integer>();

	// CONSTRUCTOR
	public Sistema(Local local) {
		this.local = local;
		this.compra = new Compra(producto);
		this.cliente = new Cliente(null, null, null, null, null, null, null, null);
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
	public Boolean eliminarUsuario(String email) {
		Boolean exito = false;
		Iterator<Cliente> it = this.clientes.iterator();
		while (it.hasNext()) {
			Cliente cliente = it.next();
			if (cliente.getUsuarioCliente().getEmail().equals(email)) {
				it.remove();
				exito = true;
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

	// MENU PRINCIPAL
	public Integer menuPrincipal() throws OpcionInvalidaException {
		Integer seleccion;
		seleccion = Integer.parseInt(JOptionPane
				.showInputDialog("1. Registrarse \n2. Iniciar sesion \n3. �Has olvidado tu contrase�a? \n4. Salir"));
		if (seleccion >= 1 && seleccion <= 4) {
			return seleccion;
		} else {
			throw new OpcionInvalidaException();
		}
	}

	// SUBMENU
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

	// CREAR NUMERO DE ORDEN
	public Integer generarNumeroCompra() {
		numeroCompra.add(0);
		return numeroCompra.size();
	}

	// METODO COMPRAR
	public Boolean comprar(Cliente cliente)
			throws OpcionInvalidaException, SaldoInsuficienteException, NombreDeUsuarioNoValidoException {
		Boolean salir = false;
		;
		Integer cantidadPuntos = 0;
		Producto productoAComprar;
		Integer aux;
		productoAComprar = this.eleccionProducto();
		if (productoAComprar == null) {
			salir = true;
		} else {
			aux = this.eleccionMetodoDePago();
			if (aux == 1) {
				for (Cliente i : clientes) {
					if (i.getUsuarioCliente().getNombreDeUsuario()
							.equals(cliente.getUsuarioCliente().getNombreDeUsuario())) {
						if (i.getUsuarioCliente().getSaldo() >= productoAComprar.getPrecio()) {
							this.compra.setNroCompra(generarNumeroCompra());
							this.productos.add(productoAComprar);
							this.compra.setCantidadPuntos(productoAComprar.getValorEnPuntos());
							compras.add(this.compra);
							cliente.getUsuarioCliente()
									.setSaldo(cliente.getUsuarioCliente().getSaldo() - productoAComprar.getPrecio());
							JOptionPane.showMessageDialog(null, "�Compra exitosa!");

							// recorro la lista de compras y acumulo los puntos.
							for (Compra c : compras) {
								cantidadPuntos += c.getCantidadPuntos();
							}
							i.setPuntos(cantidadPuntos);
						} else {
							throw new SaldoInsuficienteException();
						}
					} else {
						throw new NombreDeUsuarioNoValidoException();
					}
				}
			} else if (aux == 2) {
				for (Cliente i : clientes) {
					if (i.getUsuarioCliente().getNombreDeUsuario()
							.equals(cliente.getUsuarioCliente().getNombreDeUsuario())) {
						if (i.getPuntos() >= productoAComprar.getValorEnPuntos()) {
							this.compra.setNroCompra(generarNumeroCompra());
							this.productos.add(productoAComprar);
							compras.add(this.compra);
							i.setPuntos(i.getPuntos() - productoAComprar.getValorEnPuntos());
							JOptionPane.showMessageDialog(null, "�Compra exitosa!");
						} else {
							throw new SaldoInsuficienteException();
						}
					}
				}
			} else
				throw new OpcionInvalidaException();
		}
		return salir;
	}

	// ELECCION DE PRODUCTO A COMPRAR
	private static Producto eleccionProducto() {
		Integer seleccionProducto;
		producto = null;
		seleccionProducto = Integer.parseInt(JOptionPane.showInputDialog(
				"�Qu� producto desea comprar? \n1. Perfume ($90 o 900 puntos) \n2. Cosmetico ($80 u 800 puntos) \n3. Jab�n Liquido ($70 o 700 puntos) \n4. Shampoo Importado ($260 o 2600 puntos) \n5. Cancelar"));
		switch (seleccionProducto) {
		case 1:
			Producto perfume = new Producto("perfume", 90.0);
			producto = perfume;
			producto.setPrecio(90.0);
			break;

		case 2:
			Producto cosmetico = new Producto("cosmetico", 80.0);
			producto = cosmetico;
			producto.setPrecio(80.0);
			break;

		case 3:

			Producto jabon_liquido = new Producto("jabon liquido", 70.0);
			producto = jabon_liquido;
			producto.setPrecio(70.0);
			break;

		case 4:
			Producto shampoo = new Producto("shampoo", 260.0);
			producto = shampoo;
			producto.setPrecio(260.0);
			break;

		case 5:
			break;
		}
		return producto;

	}

	// ELECCION DE METODO DE PAGO
	private static Integer eleccionMetodoDePago() throws OpcionInvalidaException {
		Integer seleccionMetodoPago;
		seleccionMetodoPago = Integer
				.parseInt(JOptionPane.showInputDialog("�Elija un metodo de pago \n1. Efectivo \n2. Puntos"));
		return seleccionMetodoPago;
	}

	// VER PERFIL
	public void verPerfilUsuario(Cliente cliente) {
		for (Cliente c : clientes) {
			if (c.getUsuarioCliente().getNombreDeUsuario().equals(cliente.getUsuarioCliente().getNombreDeUsuario())) {
				JOptionPane.showMessageDialog(null,
						"Nombre: " + c.getNombre() + "\nApellido: " + c.getApellido() + "\nUsuario: "
								+ c.getUsuarioCliente().getNombreDeUsuario() + "\nTotal puntos: " + c.getPuntos()
								+ "\nTotal saldo: $" + c.getUsuarioCliente().getSaldo());
			}
		}
	}

	// GETTER SETTER

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> ventas) {
		this.compras = ventas;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Integer> getNumeroCompra() {
		return numeroCompra;
	}

	public void setNumeroCompra(List<Integer> numeroCompra) {
		this.numeroCompra = numeroCompra;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema(local);
		}
		return instancia;
	}

}
