package ar.edu.unlam;

public class ListaUsuarios {

	private Usuario[] lista;
	private Integer contador;

	public ListaUsuarios() {
		this.lista = new Usuario[50];
		this.contador = 0;
	}

	public void agregarUsuario(Usuario nuevo) {
		if (contador <= 50) {
			this.lista[contador] = nuevo;
			this.contador++;
		} else {
			System.out.println("No hay espacio para mas usuarios");
		}

	}

	public void eliminarUsuario(Usuario aEliminar) {
		for (int i = 0; i < this.lista.length; i++) {
			if (this.lista[i] == aEliminar) {
				for (int j = i; j < this.lista.length - 1; j++) {
					this.lista[j] = this.lista[j + 1];
					this.contador--;
				}
			}
		}
	}

	public void cambiarPassword(Usuario aModificar, String nuevaPassword) {
		for (int i = 0; i < this.lista.length; i++) {
			if (this.lista[i] == aModificar) {
				this.lista[i].setPassword(nuevaPassword);
			}
		}
	}

	public Usuario[] getLista() {
		return lista;
	}

}
