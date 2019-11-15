package ar.edu.unlam.pb2.puntosacumulados;

public class Usuario {

	private Integer id;
	private String nombreDeUsuario;
	private String email;
	private String password;
	private Double saldo;

	public Usuario(String nombreDeUsuario, String email, String password,Double saldo) {
		this.nombreDeUsuario = nombreDeUsuario;
		this.email = email;
		this.password = password;
		this.saldo = saldo;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
	
	

}
