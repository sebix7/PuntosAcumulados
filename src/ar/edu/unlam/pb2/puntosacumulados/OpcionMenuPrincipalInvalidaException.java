package ar.edu.unlam.pb2.puntosacumulados;

import javax.swing.JOptionPane;

public class OpcionMenuPrincipalInvalidaException extends Exception {

	public OpcionMenuPrincipalInvalidaException() {
		JOptionPane.showMessageDialog(null, "Error. Elija una opci�n del 1 al 4.");
	}
}
