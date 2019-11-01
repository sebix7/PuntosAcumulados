/*package ar.edu.unlam.pb2.puntosacumulados;

public class ListaUsuarios {

	private Cliente[] lista;
	private Integer contador;

	public ListaUsuarios() {
		this.lista = new Cliente[50];
		this.contador = 0;
	}

	public void agregarUsuario(Cliente nuevo) {
		if (contador <= 50) {
			this.lista[contador] = nuevo;
			this.contador++;
		} else {
			System.out.println("No hay espacio para mas usuarios");
		}

	}

	public void eliminarUsuario(Cliente aEliminar) {
		for (int i = 0; i < this.lista.length; i++) {
			if (this.lista[i] == aEliminar) {
				for (int j = i; j < this.lista.length - 1; j++) {
					this.lista[j] = this.lista[j + 1];
					this.contador--;
				}
			}
		}
	}

	public void cambiarPassword(Cliente aModificar, String nuevaPassword) {
		for (int i = 0; i < this.lista.length; i++) {
			if (this.lista[i] == aModificar) {
				this.lista[i].setPassword(nuevaPassword);
			}
		}
	}

	public Cliente[] getLista() {
		return lista;
	}

}*/
