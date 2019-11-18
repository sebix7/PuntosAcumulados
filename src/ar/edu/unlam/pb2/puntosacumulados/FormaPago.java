package ar.edu.unlam.pb2.puntosacumulados;

public enum FormaPago {
	
	efectivo(1),puntos(2);

	private Integer seleccionDeMetodoDePago;

	private FormaPago(Integer seleccionDeMetodoDePago) {
		this.seleccionDeMetodoDePago = seleccionDeMetodoDePago;
	}
	
}
