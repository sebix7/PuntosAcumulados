package ar.edu.unlam;

class Cliente {

	private String nombre;
	private String apellido;
	private String nombreDeUsuario;
	private String email;
	private String password;
	private Integer puntos;

	public Cliente(String nombre, String apellido, String nombreDeUsuario, String email, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreDeUsuario = nombreDeUsuario;
		this.email = email;
		this.password = password;
		this.puntos = 0;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", nombreDeUsuario=" + nombreDeUsuario
				+ ", email=" + email + ", password=" + password + ", puntos=" + puntos + "]";
	}

}