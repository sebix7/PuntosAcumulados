package ar.edu.unlam.pb2.puntosacumulados.excepciones;

import javax.swing.JOptionPane;

public class DatosDeUsuarioNoValidosException extends Exception {

	public DatosDeUsuarioNoValidosException() {
		JOptionPane.showMessageDialog(null, "Usuario y/o password inválido.");
	}
}
