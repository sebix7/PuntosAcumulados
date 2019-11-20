package ar.edu.unlam.pb2.puntosacumulados;

public class Producto {

	private String descripcion;
	private Double precio;
	private Integer valorEnPuntos; // es el precio por 10, genera cantidad de puntos en base al precio.

	public Producto(String descripcion, Double precio) {
		this.descripcion = descripcion;
		this.precio = precio;
		
		this.valorEnPuntos = (int) (precio * 10);
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

	

	public Integer getValorEnPuntos() {
		return valorEnPuntos;
	}

	public void setValorEnPuntos(Integer valorEnPuntos) {
		this.valorEnPuntos = valorEnPuntos;
	}

}
