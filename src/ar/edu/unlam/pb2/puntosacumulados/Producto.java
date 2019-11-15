package ar.edu.unlam.pb2.puntosacumulados;

public class Producto {

	private String descripcion;
	private Double precio;
	private Integer idProducto;
	private Integer valorEnPuntos;

	public Producto(String descripcion, Double precio, Integer idProducto, Integer valorEnPuntos) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.idProducto = idProducto;
		this.valorEnPuntos = valorEnPuntos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getValorEnPuntos() {
		return valorEnPuntos;
	}

	public void setValorEnPuntos(Integer valorEnPuntos) {
		this.valorEnPuntos = valorEnPuntos;
	}
	
	

}
