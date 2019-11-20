package ar.edu.unlam.pb2.puntosacumulados;

import java.time.LocalDate;

class Cliente extends Persona {

	private Usuario usuarioCliente;
	private Integer puntos;

	public Cliente(String nombre, String apellido, Integer edad, String nombreDeUsuario, String email, String password,
			Double saldo, Integer puntos) {
		super(nombre, apellido, edad);
		usuarioCliente = new Usuario(nombreDeUsuario, email, password, saldo);
		this.puntos = puntos;
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
		return "Cliente [nombre=" + this.getNombre() + ", apellido=" + this.getApellido() + ", edad=" + this.getEdad()
				+ ", nombreDeUsuario=" + this.getUsuarioCliente().getNombreDeUsuario() + ", email="
				+ this.getUsuarioCliente().getEmail() + ", password=" + this.getUsuarioCliente().getPassword()
				+ ", puntos=" + this.getPuntos() + "]";
	}

}