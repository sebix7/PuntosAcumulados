package ar.edu.unlam.pb2.puntosacumulados;

public class Compra {
	private Integer nroCompra;
	private Integer cantidadPuntos;
	private Producto producto;
	private Cliente cliente;
	
	
	public Compra(Producto producto) {
		super();
		this.producto = producto;
	}


	public Integer getNroCompra() {
		return nroCompra;
	}


	public void setNroCompra(Integer nroCompra) {
		this.nroCompra = nroCompra;
	}


	public Integer getCantidadPuntos() {
		return cantidadPuntos;
	}


	public void setCantidadPuntos(Integer cantidadPuntos) {
		this.cantidadPuntos = cantidadPuntos;
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
	
	
	
	
	
}
