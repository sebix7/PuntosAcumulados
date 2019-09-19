package ar.edu.unlam;

class Usuario {

	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private Integer puntos;

	public Usuario(String nombre, String apellido, String email, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.puntos = 0;
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
}