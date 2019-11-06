package ar.edu.unlam.pb2.puntosacumulados;

import javax.swing.JOptionPane;

public class IdNoValidoException extends Exception {

	public IdNoValidoException() {
		JOptionPane.showMessageDialog(null, "No se puede borrar ya que el ID ingresado no es válido");
	}
}
