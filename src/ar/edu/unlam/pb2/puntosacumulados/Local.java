package ar.edu.unlam.pb2.puntosacumulados;

import java.util.ArrayList;
import java.util.List;

public class Local {
	private String nombreLocal;
	private List<Producto> productosDisponiblesParaComprar = new ArrayList<Producto>();
	
	public Local(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

	public List<Producto> getProductosDisponiblesParaComprar() {
		return productosDisponiblesParaComprar;
	}

	public void setProductosDisponiblesParaComprar(List<Producto> productosDisponiblesParaComprar) {
		this.productosDisponiblesParaComprar = productosDisponiblesParaComprar;
	}

	public String getNombreLocal() {
		return nombreLocal;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}
	
	


}