package ar.edu.unlam.pb2.puntosacumulados;

public class Usuario {

	private String nombreDeUsuario;
	private String email;
	private String password;

	public Usuario(String nombreDeUsuario, String email, String password) {
		super();
		this.nombreDeUsuario = nombreDeUsuario;
		this.email = email;
		this.password = password;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
