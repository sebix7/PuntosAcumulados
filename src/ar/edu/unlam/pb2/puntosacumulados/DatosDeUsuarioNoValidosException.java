package ar.edu.unlam.pb2.puntosacumulados;

import javax.swing.JOptionPane;

public class DatosDeUsuarioNoValidosException extends Exception {

	public DatosDeUsuarioNoValidosException() {
		JOptionPane.showMessageDialog(null, "Datos no validos");
	}
}
