package ar.edu.unlam.pb2.puntosacumulados;

import javax.swing.JOptionPane;

public class SesionCerradaException extends Exception {

	public SesionCerradaException() {
		JOptionPane.showMessageDialog(null, "Error. No se pudo continuar ya que la sesión está cerrada.");
	}
}
