package ar.edu.unlam.pb2.puntosacumulados;

public class Producto {

	private String descripcion;
	private Double precio;
	private Integer idProducto;
	private Integer puntosDelProducto;

	public Producto(String descripcion, Double precio, Integer idProducto, Integer puntosDelProducto) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.idProducto = idProducto;
		this.puntosDelProducto = puntosDelProducto;
	}

}
