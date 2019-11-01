package ar.edu.unlam.pb2.puntosacumulados;

import javax.swing.JOptionPane;

public class OpcionInvalidaException extends Exception {

	public OpcionInvalidaException() {
		JOptionPane.showMessageDialog(null, "Error. Inténtelo de nuevo.");
	}
}
