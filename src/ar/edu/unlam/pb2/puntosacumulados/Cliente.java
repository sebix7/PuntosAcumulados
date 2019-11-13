package ar.edu.unlam.pb2.puntosacumulados;

import java.time.LocalDate;

class Cliente extends Persona {
	
	private Usuario usuarioCliente;
	private Integer puntos;

	public Cliente(String nombre, String apellido, LocalDate edad, String nombreDeUsuario, String email, String password) {
		super(nombre, apellido, edad);
		usuarioCliente = new Usuario(nombreDeUsuario, email, password);
		this.puntos = 0;
	}	
	
	@Override
	public void calcularEdad() {
		// puse este metodo de prueba, habria que elegir uno correcto
		
	}
	
	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Usuario getUsuarioCliente() {
		return usuarioCliente;
	}

	public void setUsuarioCliente(Usuario usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

	@Override
	public String toString() {
		return "Cliente [nombreDeUsuario=" + usuarioCliente.getNombreDeUsuario() + ", puntos=" + puntos + "]";
	}

}