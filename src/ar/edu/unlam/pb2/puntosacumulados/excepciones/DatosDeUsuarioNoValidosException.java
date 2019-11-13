package ar.edu.unlam.pb2.puntosacumulados.excepciones;

import javax.swing.JOptionPane;

public class DatosDeUsuarioNoValidosException extends Exception {

	public DatosDeUsuarioNoValidosException() {
		JOptionPane.showMessageDialog(null, "Nombre de usuario y/o password inválido.");
	}
}
