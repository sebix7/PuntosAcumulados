package ar.edu.unlam.pb2.puntosacumulados.excepciones;

import javax.swing.JOptionPane;

public class CorreoExistenteException extends Exception {

	public CorreoExistenteException() {
		JOptionPane.showMessageDialog(null, "Email ya registrado");
	}
}
