package ar.edu.unlam.pb2.puntosacumulados;

import java.time.LocalDate;

public class Encargado extends Persona {
	
	private Usuario usuarioEncargado;

	public Encargado(String nombre, String apellido, Integer edad) {
		super(nombre, apellido, edad);
		this.usuarioEncargado = usuarioEncargado;
	}

	public Usuario getUsuarioEncargado() {
		return usuarioEncargado;
	}

	public void setUsuarioEncargado(Usuario usuarioEncargado) {
		this.usuarioEncargado = usuarioEncargado;
	}


}
