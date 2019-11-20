package ar.edu.unlam.pb2.puntosacumulados.excepciones;

import javax.swing.JOptionPane;

public class NullException extends Exception {

	public NullException() {
		JOptionPane.showMessageDialog(null, "Por favor, completa correctamente el formulario.");
	}
}
