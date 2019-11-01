package ar.edu.unlam.pb2.puntosacumulados;

import javax.swing.JOptionPane;

public class DatosDeUsuarioInexistenteException extends Exception {

	public DatosDeUsuarioInexistenteException() {
		JOptionPane.showMessageDialog(null, "Usuario inexistente");
	}
}
