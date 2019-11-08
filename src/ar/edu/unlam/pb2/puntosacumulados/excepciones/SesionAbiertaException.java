package ar.edu.unlam.pb2.puntosacumulados.excepciones;

import javax.swing.JOptionPane;

public class SesionAbiertaException extends Exception {

	public SesionAbiertaException() {
		JOptionPane.showMessageDialog(null, "Error. No se pudo continuar ya que la sesión está abierta.");
	}
}
