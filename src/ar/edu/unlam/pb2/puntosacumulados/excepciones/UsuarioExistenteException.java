package ar.edu.unlam.pb2.puntosacumulados.excepciones;

import javax.swing.JOptionPane;

public class UsuarioExistenteException extends Exception {
	
	public UsuarioExistenteException() {
		JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente");
	}

}
