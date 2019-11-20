package ar.edu.unlam.pb2.puntosacumulados;

public class Usuario {

	private Integer id;
	private String nombreDeUsuario;
	private String email;
	private String password;
	private Double saldo;

	public Usuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
		this.saldo = 50.0;
	}
	
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

	// dos usuarios son iguales si tienen el mismo mail o el mismo usuario
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nombreDeUsuario == null) ? 0 : nombreDeUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombreDeUsuario == null) {
			if (other.nombreDeUsuario != null)
				return false;
		} else if (!nombreDeUsuario.equals(other.nombreDeUsuario))
			return false;
		return true;
	}
	
	
	
	

}
