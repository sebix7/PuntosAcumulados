package ar.edu.unlam.pb2.puntosacumulados;

public class Producto {

	private Integer idProducto;
	private String descripcion;
	private Double precio;
	private Integer valorEnPuntos;

	public Producto(Integer idProducto, String descripcion, Double precio) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.idProducto = idProducto;
		this.valorEnPuntos = (int) (precio * 100);
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
