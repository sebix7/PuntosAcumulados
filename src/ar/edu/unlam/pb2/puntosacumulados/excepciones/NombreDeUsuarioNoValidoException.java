package ar.edu.unlam.pb2.puntosacumulados.excepciones;

import javax.swing.JOptionPane;

public class NombreDeUsuarioNoValidoException extends Exception {

	public NombreDeUsuarioNoValidoException() {
		JOptionPane.showMessageDialog(null, "Usuario inexistente.");
	}
}
