package ar.edu.unlam;

import java.util.ArrayList;

public class Perfumeria {

	private ArrayList<Venta> ventas = new ArrayList<Venta>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Producto> productos = new ArrayList<Producto>();

	public Perfumeria() {

	}

	public ArrayList<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Venta> ventas) {
		this.ventas = ventas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public String mostrarListaDeClientes() {
		for (Cliente cliente : clientes) {
			return cliente.toString();
		}
		return null;
	}
}
